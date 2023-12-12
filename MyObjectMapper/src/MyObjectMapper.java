import javax.print.attribute.standard.JobKOctets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MyObjectMapper {

    private MyJsonParser parser;



    public MyObjectMapper() {

        this.parser = new MyJsonParser();

    }



    public <T> T readValue(String jsonString, Class<T> clazz) throws Exception {
        Map<String, Object> map = parser.parse(jsonString);
        Constructor<T> constructor = clazz.getDeclaredConstructor();
        T t = constructor.newInstance();

        for(Field field:clazz.getDeclaredFields()){
            if(map.containsKey(field.getName())){
                field.setAccessible(true);
                field.set(t,map.get(field.getName()));
            }
        }
        return t;
    }

        // implement your code using Java Reflection

    }

