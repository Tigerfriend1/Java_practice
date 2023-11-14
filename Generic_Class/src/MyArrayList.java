public class MyArrayList<T> {
    // your code here
    private int capacity;
    private int endIndex=0;
    private Object[] elementData;

    public MyArrayList(int capacity) {
        //추가 확장은 없다고 가정.
        // your code here
        this.elementData = new Object[capacity];

    }

    public void add(T data) {
        // your code here
       this.elementData[endIndex]=data;
       endIndex++;

    }

    public T get(int index) {
        // your code here
        Object value = this.elementData[index];
        return (T) value;
    }

}