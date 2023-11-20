public class Rectangle implements MyComparable{
    private int width;
    private int height;
    private int area;


    public Rectangle(int width, int height) {
        this.width=width;
        this.height=height;
        this.area = width*height;
    }

    @Override
    public int compareTo(Object other) {
        if (!(other instanceof Rectangle)){
            return -2;
        }
        return area-((Rectangle) other).area;
    }

    @Override
    public boolean equal(Object other) {
        if (!(other instanceof Rectangle)){
            return false;
        }
        Rectangle rectangle = (Rectangle) other;
        return this.height==rectangle.height && this.width==rectangle.width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "area=" + area +
                '}';
    }
}
