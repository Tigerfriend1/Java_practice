import java.util.ArrayList;
import java.util.List;

public class NumberRepository {
    private List<Number> data = new ArrayList<>();
    private static NumberRepository instance = new NumberRepository();

    public static NumberRepository getInstance() {
        return instance;
    }

    //implement addAll() method
    public void addAll(List<? extends Number> list){
        //this.data.addAll(list);
        for(Number i : list){
            this.data.add(i);
        }
    }

    public String toString(){
        return data.toString();
    }
}