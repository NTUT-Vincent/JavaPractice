import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.*;

public class vectorTest {
    double epsilon = 0.0000001;

    @Test
    public void createVector() {
        double[] v1 = { 1, 4 };
        Vector a = new Vector(v1, 2);
        Assertions.assertEquals(2, a.dim());
        Assertions.assertEquals(4, a.at(2), epsilon);
    }

    @Test
    public void isZeroTest(){
        double[] v1 = {0, 0};
        double[] v2 = {0, 2};
        Vector u = new Vector(v1, 2);
        Vector v = new Vector(v2, 2);
        Assertions.assertTrue(u.isZero());
        Assertions.assertFalse(v.isZero());
    }

    @Test
    public void dot() {
        double[] v1 = { 1, 4};
        double[] v2 = { 2, 3 };
        double[] v3 = {2, 2}; 
        Vector a = new Vector(v1, 2);
        Vector b = new Vector(v2, 2);
        Vector c = new Vector(v3, 2);
        Assertions.assertEquals(14, VectorCalculate.dot(a, b), epsilon);
        Assertions.assertEquals(10, VectorCalculate.dot(a, c), epsilon);
    
    }

    @Test
        public void dotException() {
            double[] v1 = {1, 3};
            double[] v2 = {2, 2, 3};
            Vector a = new Vector(v1,2);
            Vector b = new Vector(v2, 3);
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                VectorCalculate.dot(a,b);
              });
        }

    @Test
    public void copyConstructor(){
        double[] v1= {1, 3};
        double[] v2 = {2, 6, 1};
        Vector a = new Vector(v1, 2);
        Vector b = new Vector(v2, 3);
        Vector c = new Vector(a);
        a.assign(b);
        Assertions.assertEquals(1, c.at(1));
        Assertions.assertEquals(3, c.at(2));
        Assertions.assertEquals(3, c.at(2));
        Assertions.assertEquals(2, c.dim());

    }

    @Test
    public void defaultConstructor(){
        Vector a = new Vector();
        Assertions.assertEquals(0, a.at(1));
    }

    @Test
    public void add(){
        double[] v1 = {1, 2};
        double[] v2 = {2, 4};
        Vector a = new Vector(v1, 2);
        Vector b = new Vector(v2, 2);
        a.add(b);
        Assertions.assertEquals(3, a.at(1), epsilon);
        Assertions.assertEquals(6, a.at(2), epsilon);
        Assertions.assertEquals(2, a.dim());
    }

    @Test
    public void addException(){
        double[] v1 = {1, 2};
        double[] v2 = {2, 4, 4};
        Vector a = new Vector(v1, 2);
        Vector b = new Vector(v2, 3);
        Assertions.assertThrows(IndexOutOfBoundsException.class, ()->{
            a.add(b);
        });
    }
    
    @Test
    public void subtructException(){
        double[] v1 = {1, 2};
        double[] v2 = {2, 4, 4};
        Vector a = new Vector(v1, 2);
        Vector b = new Vector(v2, 3);
        Assertions.assertThrows(IndexOutOfBoundsException.class, ()->{
            a.subtruct(b);
        });
    }


    @Test
    public void subtruct(){
        double[] v1 = {1, 2};
        double[] v2 = {2, 4};
        Vector a = new Vector(v1, 2);
        Vector b = new Vector(v2, 2);
        b.subtruct(a);
        Assertions.assertEquals(1, b.at(1), epsilon);
        Assertions.assertEquals(2, b.at(2), epsilon);
    }

    @Test
    public void division(){
        double[] v1 = {4, 8};
        Vector u = new Vector(v1, 2);
        Vector v = new Vector(u.divid(2));
        Assertions.assertEquals(2, v.at(1));
        Assertions.assertEquals(4, v.at(2));
        Assertions.assertEquals(2, v.dim());
    }

    @Test
    public void vectorLength(){
        double[] v1 = {3, 4};
        Vector a = new Vector(v1, 2);
        Assertions.assertEquals(5, a.length(), epsilon);

        double[] v2 = {3, 3, 4};
        Vector b = new Vector(v2, 3);
        Assertions.assertEquals(Math.sqrt(34), b.length(), epsilon);
    }

    @Test
    public void copyAssignment(){
        double[] v1 = {2, 1};
        double[] v2 = {3, 4};
        double[] v3 = {5, 6, 7};
        Vector a = new Vector(v1, 2);
        Vector b = new Vector(v2, 2);
        Vector c = new Vector(v3, 3);
        a.assign(b);
        Assertions.assertEquals(3, a.at(1));
        Assertions.assertEquals(4, a.at(2));
        a.assign(c);
        Assertions.assertEquals(5, a.at(1));
        Assertions.assertEquals(6, a.at(2));
        Assertions.assertEquals(7, a.at(3));
        Assertions.assertEquals(3, a.dim());
    }

    @Test
    public void copyAssignment2(){
        double[] v1 = {2, 1};
        double[] v2 = {3, 4};
        double[] v3 = {5, 6, 7};
        Vector a = new Vector(v1, 2);
        Vector b = new Vector(v2, 2);
        Vector c = new Vector(v3, 3);
        a.assign(b.assign(c));
        Assertions.assertEquals(5, a.at(1));
        Assertions.assertEquals(6, a.at(2));
        Assertions.assertEquals(7, a.at(3));
        Assertions.assertEquals(3, a.dim());
    }

    @Test
    public void copyAssignmentAndAssighment(){
        double[] v1 = {1, 2};
        double[] v2 = {2, 4};
        Vector a = new Vector(v1, 2);
        Vector b = new Vector(v2, 2);
        Vector c = new Vector(a.assign(b));
        Assertions.assertEquals(2, c.at(1));
        Assertions.assertEquals(4, c.at(2));
        Assertions.assertEquals(2, c.dim());
        Assertions.assertEquals(Math.sqrt(20), c.length(), epsilon);
    }

    @Test
    public void distance(){
        double[] a = {1, 0, 2};
        double[] b = {1, 1, 3};
        Vector x = new Vector(a, 3);
        Vector y = new Vector(b, 3);
        Assertions.assertEquals(Math.sqrt(2), VectorCalculate.distance(x, y), epsilon);
    }


    @Test
    public void triangleArea(){
        double[] a = {1, 0};
        double[] b = {1, 1};
        double[] c = {0, 1};
        Vector x = new Vector(a, 2);
        Vector y = new Vector(b, 2);
        Vector z = new Vector(c, 2);
        Assertions.assertEquals(0.5, VectorCalculate.triangleArea(x, y, z), epsilon);
    }

    @Test
    public void centroid(){
        double[] a = {0, 0};
        double[] b = {2, 0};
        double[] c = {2, 2};
        double[] d = {1, 3};
        double[] e = {0, 2};
        Vector u = new Vector(a, 2);
        Vector v = new Vector(b, 2);
        Vector w = new Vector(c, 2);
        Vector x = new Vector(d, 2);
        Vector y = new Vector(e, 2);
        Vector[] l = {u, v, w, x, y};
        Vector cend = VectorCalculate.centroid(l);
        Assertions.assertEquals(7.0/5, cend.at(2), epsilon);
    }

    @Test
    public void subCallByValue(){
        double[] v1 = {1, 2};
        double[] v2 = {1, 1};
        Vector u = new Vector(v1, 2);
        Vector v = new Vector(v2, 2);
        VectorCalculate.angle(u.sub(v), v);
        Assertions.assertEquals(1, u.at(1));
    }

    @Test
    public void toStringTest(){
        double[] v1 = {1, 2};
        Vector u = new Vector(v1, 2);
        Assertions.assertEquals("(1.0, 2.0)", u.toString());
    }
}

