public class Circle2 implements MyComparable, AreaComputable {
    private int x, y ;
    private int radius ;
    public Circle2(int x, int y, int radius) {
        this.x = x ; this.y = y ; this.radius = radius ;
    }
    public float getArea() { return (float) Math.PI * radius * radius ; }
    public int compareTo(Object other) { … }
    public boolean equal(Object other) { … }
    public String toString() { … }
}