import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtility {

    public static List<String> getAttributes(Object obj) {
        List<String> attr = new ArrayList<>();

        Class<?> cl = obj.getClass(); //book or article
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields){
            attr.add(field.getName());
        }
        return attr;

    }
    public static boolean getCheckEquality(Object obj1, Object obj2){
        Class<?> cl1 = obj1.getClass();
        Class<?> cl2 = obj2.getClass();
        if(!cl1.equals(cl2)){
            return true;
        }
        Field[] fields1 = cl1.getDeclaredFields();
        //Field[] fields2 = cl2.getDeclaredFields();
        for(Field field : fields1){
            field.setAccessible(true);
            try {
                if (!field.get(obj1).equals(field.get(obj2))){
                    return false;
                }
            }catch (Exception e){
                System.out.println("Error");
            }

        }
        return true;
    }

}