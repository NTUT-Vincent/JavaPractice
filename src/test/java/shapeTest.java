import org.junit.jupiter.api.*;

public class shapeTest{
    double epsilon = 0.00001;

    @Test
    public void circleTest(){
        Circle a = new Circle(2);
        Assertions.assertEquals(2*2*Math.PI, a.area());
        Assertions.assertEquals(4 * Math.PI, a.perimeter());
        Shape c;
        c = new Circle(4);
        Assertions.assertEquals(4*4*Math.PI, c.area());
        Assertions.assertEquals(8 * Math.PI, c.perimeter());
    }

    @Test
    public void polygonTest(){
        double[] v1 = {2, 3};
        double[] v2 = {0, 2};
        double[] v3 = {3, 0};
        double[] v4 = {0, 0};
        double[] v5 = {3, 2};
        Vector x = new Vector(v1, 2);
        Vector y = new Vector(v2, 2);
        Vector z = new Vector(v3, 2);
        Vector u = new Vector(v4, 2);
        Vector v = new Vector(v5, 2);
        Vector[] arr = {x, y, z, u, v};
        Polygon a = new Polygon(arr);
        Assertions.assertEquals(7.5, a.area(), epsilon);
        Assertions.assertEquals(7 + Math.sqrt(5) + Math.sqrt(2), a.perimeter(), epsilon);
    }

    @Test
    public void shapeArray(){
        double a[] = {0, 0};
        double b[] = {2, 2};
        double c[] = {1, 3};
        // double d[] = {0, 2};
        // double e[] = {2, 0};
        // double f[] = {3, 1};
        Vector u = new Vector(a, 2);
        Vector v = new Vector(b, 2);
        Vector w = new Vector(c, 2);
        // Vector x = new Vector(d, 2);
        // Vector y = new Vector(e, 2);
        // Vector z = new Vector(f, 2);
        Vector arr1[] = {u, v, w};
        // Vector arr2[] = {u, v, w, x};
        // Vector arr3[] = {u, v, w, x, y};
        // Vector arr4[] = {u, v, w, x, y, z};
        Shape s[] = {new Circle(2), new Circle(4), new Polygon(arr1)};
        Assertions.assertEquals(16 * Math.PI, s[1].area());
        Assertions.assertEquals(2, s[2].area(), epsilon);
    }

}
