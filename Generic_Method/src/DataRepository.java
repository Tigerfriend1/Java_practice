import java.util.ArrayList;
import java.util.List;

public class DataRepository {

    private List<Object> data = new ArrayList<>();



    private static DataRepository instance = new DataRepository();



    public static DataRepository getInstance() {

        return instance;

    }



    public void add(Object data) {

        this.data.add(data);

    }



    public <T> List<T> getData(Class<T> templateClass) {
        List<T> newData = new ArrayList<>();
        for(Object d : data){ //Object으로 받아도 실제, instance타입은 data에 저장된 타입임.
            if(templateClass.isInstance(d)) {
                newData.add(templateClass.cast(d));
                //newData.add((T) d);

            }
        }
        return newData;
    }

}