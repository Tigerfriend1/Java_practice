public class FloatTypeData extends SpecificTypeData<Float> {
    // your code here
    public FloatTypeData(Float data) {
        super(data);
    }

    @Override
    public void addData(Float data) {
        this.data+=data;

    }

}