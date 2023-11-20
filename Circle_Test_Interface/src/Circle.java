public class Circle implements MyComparable {
    private int x, y, radius ;
    public Circle(int x, int y, int radius) {
        this.x = x ; this.y = y ; this.radius = radius ;
    }
    public int compareTo(Object other)
    {
        if (!(other instanceof Circle)) return -2 ;
        Circle otherCircle = (Circle) other ;
        int returnValue = 0 ;
        if ( radius < otherCircle.radius ) returnValue =
                -1 ;
        if ( radius == otherCircle.radius ) returnValue = 0 ;
        if ( radius > otherCircle.radius ) returnValue = 1 ;
        return returnValue ;
    }
    public boolean equal(Object other)
    {
        if (!(other instanceof Circle)) return false ;
        Circle otherCircle = (Circle) other ;
        return x == otherCircle.x && y == otherCircle.y
                && radius == otherCircle.radius ;
    }

    //Circle{x=0, y=0, radius=10} has the same size as Circle{x=0, y=0, radius=10}
    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }
}