public class IntTypeData extends SpecificTypeData<Integer> {
    // your code here
    public IntTypeData(Integer data) {
        super(data);
    }

    @Override
    public void addData(Integer data) {
        this.data+=data;

    }


}