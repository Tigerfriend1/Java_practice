class Rectangle {
    private Point p1;
    private Point p2;

    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void moveBy(int x, int y) {
        p1.setX(p1.getX() + x);
        p1.setY(p1.getY() + y);
        p2.setX(p2.getX() + x);
        p2.setY(p2.getY() + y);
    }

    public void moveBy(int position) {
        p1.setX(p1.getX() + position);
        p1.setY(p1.getY() + position);
        p2.setX(p2.getX() + position);
        p2.setY(p2.getY() + position);
    }

    @Override
    public String toString() {
        return "Rectangle[(" + p1.getX()+", "+p1.getY() + "), (" + p2.getX()+", "+p2.getY() + ")]";
    }
}