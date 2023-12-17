package edu.pnu.myspring.core;

import edu.pnu.myspring.annotations.*;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class MyApplicationContext {

    private Map<Class<?>, Object> beanRegistry = new HashMap<>();
    private List<Object> beansToAutowire = new ArrayList<>();
    private Map<Object, Method> postConstructMethodRegistry = new HashMap<>();
    private Map<Object, Method> preDestroyMethodRegistry = new HashMap<>();



    public MyApplicationContext(String basePackage) {
        scanAndRegisterBeans(basePackage); //bean을 등록하고 생성을 위임.
        processAutowiring(); //등록한 bean으로 필요한 경우 주입(넣어줌)
    }

    /**
     *
     * @param basePackage 패키지 경로 ex)com.pnu.demo
     * @MyRestController, @MyService, @MyRepository 어노테이션이 붙은 클래스를 찾아 bean으로 등록(registerBean())
     */
    private void scanAndRegisterBeans(String basePackage) {
        String path = basePackage.replace('.','/');
        URL resouce = Thread.currentThread().getContextClassLoader().getResource(path);

        if(resouce==null) return;

        //file을 찾음.
        File directory = new File(resouce.getFile());
        for(File file : Objects.requireNonNull(directory.listFiles())){ //com.pnu.demo에 있는 파일(디렉터리)
            if(file.isDirectory()){
                scanAndRegisterBeans(basePackage+'.'+file.getName());

            }
            else if(file.getName().endsWith(".class")){ //class파일이면 경로+이름만 따옴.
                String className = basePackage+'.'+file.getName().substring(0,file.getName().length()-6);

                try {
                    Class<?> clazz = Class.forName(className);
                    //어노테이션이 있는지 검사후 있으면 등록
                    if(clazz.isAnnotationPresent(MyRestController.class)||
                    clazz.isAnnotationPresent(MyService.class)||
                    clazz.isAnnotationPresent(MyRepository.class)){
                        registerBean(clazz);
                    }
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }





    }

    /**
     * @MyAutowired 어노테이션이 붙은 필드를 찾아서 생성해준다.
     * 등록된 bean을 필요할때 get으로 넣어주는 용도.
     */
    private void processAutowiring() {
        for(Object bean :beansToAutowire){
            for(Field field:bean.getClass().getDeclaredFields()){
                field.setAccessible(true);
                if(field.isAnnotationPresent(MyAutowired.class)){ //해당 필드에 필요한 객체를 넣어줘야함.
                    Object dependency = getBean(field.getType());
                    try {
                        field.set(bean,dependency);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }


    }

    /**
     *
     * @param beanClass bean클래스를 인스턴스하여 Map<Class<?>, Object> beanRegistry에 넣어준다.
     * @param <T>
     * 여기서 @PostConstruct, @PreDestroy 어노테이션이 붙은 클래스를 검사해서 map에 넣어둠.
     */
    public <T> void registerBean(Class<? extends T> beanClass) {
        try {
            T beanInstance = beanClass.getDeclaredConstructor().newInstance();

            for(Method method: beanClass.getDeclaredMethods()){
                method.setAccessible(true);
                if(method.isAnnotationPresent(PostConstruct.class)){
                    postConstructMethodRegistry.put(beanInstance,method);
                } else if (method.isAnnotationPresent(PreDestroy.class)) {
                    preDestroyMethodRegistry.put(beanInstance,method);
                }
            }

            beanRegistry.put(beanClass,beanInstance);
            if (postConstructMethodRegistry.containsKey(beanInstance)){
                postConstructMethodRegistry.get(beanInstance).invoke(beanInstance);
            }
            beansToAutowire.add(beanInstance);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }



    }

    public <T> T getBean(Class<T> type) {
        return type.cast(beanRegistry.get(type));

    }

    public void close() { //빈이 종료되기 전에 preDestroy를 해야함. 여기서 처리해준다.

        for(Map.Entry<Object,Method> entry : preDestroyMethodRegistry.entrySet()){
            try {
                entry.getValue().invoke(entry.getKey());
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        beanRegistry.clear();

    }

}

