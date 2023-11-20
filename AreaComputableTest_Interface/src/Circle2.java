public class Circle2 implements MyComparable, AreaComputable {
    private int x, y ;
    private int radius ;
    public Circle2(int x, int y, int radius) {
        this.x = x ; this.y = y ; this.radius = radius ;
    }
    public float getArea() { return (float) Math.PI * radius * radius ; }
    public int compareTo(Object other) {
        if(!(other instanceof Circle2)) return -2;
        return radius-((Circle2) other).radius;
    }
    public boolean equal(Object other) {
        if(!(other instanceof Circle2)) return false;
        Circle2 circle2 = (Circle2) other;
        return x==circle2.x && y==circle2.y && radius==circle2.radius;
    }
    public String toString() {
        return String.format("Circle2{x=%d, y=%d, radius=%d}",x,y,radius);
    }
}