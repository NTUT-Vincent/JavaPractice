public class Circle extends Shape{
    private double _r;
    
    public Circle(double radius){
        this._r = radius;
    }

    public double area(){
        return (Math.pow(this._r, 2) * Math.PI);
    }

    public double perimeter(){
        return 2 * _r * Math.PI;
    }

}