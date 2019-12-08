import org.junit.jupiter.api.*;

public class polygonTest{
    double epsilon = 0.00001;
    
    @Test
    public void angle(){
        double[] v1 = {0, 1};
        double[] v2 = {1, 1};
        double[] v3 = {1, 0};
        Vector x = new Vector(v1, 2);
        Vector y = new Vector(v2, 2);
        Vector z = new Vector(v3, 2);
        Assertions.assertEquals(7.0/4*Math.PI, VectorCalculate.angle(x, y));
        Assertions.assertEquals(1.0/4*Math.PI, VectorCalculate.angle(z, y));

    }

    @Test
    public void polygonArea(){
        double[] data1 = {0, 0};
        double[] data2 = {2, 0};
        double[] data3 = {0, 2};
        double[] data4 = {1, 3};
        double[] data5 = {2, 2};
        Vector a = new Vector(data1, 2);
        Vector b = new Vector(data2, 2);
        Vector c = new Vector(data3, 2);
        Vector d = new Vector(data4, 2);
        Vector e = new Vector(data5, 2);
        Vector[] arr = {a, b, c, d, e};
        Assertions.assertEquals(5, VectorCalculate.area(arr), epsilon);

    }

    @Test
    public void polygonException(){
        double[] data1 = {0, 0, 3};
        double[] data2 = {2, 0};
        double[] data3 = {0, 2};
        double[] data4 = {1, 3};
        double[] data5 = {2, 2};
        Vector a = new Vector(data1, 3);
        Vector b = new Vector(data2, 2);
        Vector c = new Vector(data3, 2);
        Vector d = new Vector(data4, 2);
        Vector e = new Vector(data5, 2);
        Vector[] arr = {a, b, c, d, e};
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            new Polygon(arr);
        });
    }

    @Test
    public void sortVector(){
        double data1[] = {0, 0};
        double data2[] = {2, 0};
        double data3[] = {0, 2};
        double data4[] = {1, 3};
        double data5[] = {2, 2};
        Vector a = new Vector(data1, 2);
        Vector b = new Vector(data2, 2);
        Vector c = new Vector(data3, 2);
        Vector d = new Vector(data4, 2);
        Vector e = new Vector(data5, 2);
        Vector[] arr = {a, b, c, d, e};
        arr = VectorCalculate.vectorSort(arr);
        Assertions.assertEquals(0, arr[0].at(1));
        Assertions.assertEquals(0, arr[0].at(2));
        Assertions.assertEquals(2, arr[1].at(1));
        Assertions.assertEquals(0, arr[1].at(2));
        Assertions.assertEquals(2, arr[2].at(1));
        Assertions.assertEquals(2, arr[2].at(2));
        Assertions.assertEquals(1, arr[3].at(1));
        Assertions.assertEquals(3, arr[3].at(2));
        Assertions.assertEquals(0, arr[4].at(1));
        Assertions.assertEquals(2, arr[4].at(2));
    }

    @Test
    public void polygonOutPutTest(){
        double data1[] = {0, 0};
        double data2[] = {2, 0};
        double data3[] = {0, 2};
        double data4[] = {1, 3};
        double data5[] = {2, 2};
        Vector a = new Vector(data1, 2);
        Vector b = new Vector(data2, 2);
        Vector c = new Vector(data3, 2);
        Vector d = new Vector(data4, 2);
        Vector e = new Vector(data5, 2);
        Vector[] arr = {a, b, c, d, e};
        Polygon p = new Polygon(arr);
        Assertions.assertEquals("(0.0, 0.0), (2.0, 0.0), (2.0, 2.0), (1.0, 3.0), (0.0, 2.0)", p.toString());
    }
}