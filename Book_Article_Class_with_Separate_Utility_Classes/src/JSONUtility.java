import java.lang.reflect.Field;
import java.util.List;

public class JSONUtility {

    public static String toJSON(Object obj) {
        //{"title": "Harry Potter", "author": "J.K. Rowling", "yearPublished": 1997, "numberOfBooks": 3}
        Class<?> cl = obj.getClass();
        Field[] fields = cl.getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder("{");
        for(int i=0; i< fields.length;i++){
            fields[i].setAccessible(true);
            try {
                stringBuilder.append("\"").append(fields[i].getName()).append("\": \"").append(fields[i].get(obj)).append("\"");
                if (i<fields.length-1){
                    stringBuilder.append(", ");
                }
            }catch (Exception e){
                System.out.println("error");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();

    }

}