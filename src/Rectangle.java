public class Rectangle {
    private double width;
    private double height;
    private int id;
    private static int id_Gen = 1;

    public Rectangle(){
        width = 1.0;
        height = 1.0;
        id = id_Gen++;
    }
    public Rectangle(double width, double height){
        this();
        setHeight(height);
        setWidth(width);

    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException();
        }
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException();
        }
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double area() {
        return width * height;
    }
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", id=" + id +
                '}';
    }
}
