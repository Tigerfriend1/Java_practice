public class Rectangle implements AreaComputable, MyComparable{
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public float getArea() {
        return (float) width*height;
    }

    @Override
    public int compareTo(Object other) {
        if(!(other instanceof Rectangle)) return -2;
        return (int) (getArea()-((Rectangle)other).getArea());
    }

    @Override
    public boolean equal(Object other) {
        if(!(other instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) other;
        return width==rectangle.width && height==rectangle.height;
    }

    @Override
    public String toString() {
        return String.format("Rectangle{" +
                "Width:" + width +
                ", Height:" + height +
                '}');
    }
}
