// import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class VectorCalculate{
    public static double dot(Vector a, Vector b){
        if(a.dim() != b.dim()){
            throw new IllegalArgumentException("Illegal Input");
        }
        double sum = 0;
        for(int i = 1; i <= a.dim(); i++){
            sum += a.at(i) * b.at(i);
        }
        return sum;
    }

    public static double distance(Vector u, Vector v){
        Vector a = new Vector(u);
        a.subtruct(v);
        return a.length();

    }

    public static double triangleArea(Vector u, Vector v, Vector w){
        double a = distance(u, v);
        double b = distance(v, w);
        double c = distance(w, u);
        double s = (1/2.0) * (a + b + c);
        return Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }

    public static Vector centroid(Vector[] vec){
        int dim = vec[0].dim();
        int sides = vec.length;
        double[] arr;
        arr = new double[dim];
        for(int i = 0; i < dim; i++){
            arr[i] = 0;
        }
        for(int i = 0; i < sides; i++){
            if(vec[i].dim() != dim){
                throw new IllegalArgumentException("Invalid input");
            }
        }

        Vector cend = new Vector(arr, dim);
        for(int i = 0; i < sides; i++){
            cend.add(vec[i]);
        }
        cend.divid(sides);
        return cend;

    }

    public static double angle(Vector u, Vector v){
        double det = (u.at(1)*v.at(2) - u.at(2)*v.at(1));
        double angle =  Math.atan2(det, dot(u, v));
        if(angle < 0){
            angle += 2*Math.PI;
        }
        return angle;
    }

    public static Vector[] vectorSort(Vector[] arr){
        /*用array來排序 */
        Vector[] a = new Vector[arr.length];
        for(int i = 0; i < a.length; i++){
            a[i] = arr[i];
        }
        // Vector cend = new Vector(centroid(arr));
        // Vector basic = new Vector(arr[0].sub(cend));
        Arrays.sort(a, (o1, o2)->{
            Vector cend = centroid(arr);
            Vector basis = arr[0].sub(cend);
            return (int)(angle(basis, o1.sub(cend)) - angle(basis, o2.sub(cend)));
        });
        return a;

        /*用list來排序 */
        // List<Vector> v = Arrays.asList(arr);
        // v.sort((o1, o2)->{
        //     Vector cend = centroid(arr);
        //     Vector basis = arr[0].sub(cend);
        //     return (int)(angle(basis, o1.sub(cend)) - angle(basis, o2.sub(cend)));
        // });
        // Vector[] result = new Vector[v.size()];
        // result = v.toArray(result);
        // return result;
    }

    public static double area(Vector[] arr){
        double area = 0;
        vectorSort(arr);
        for(int i = 1; i < (arr.length-1); i++){
            area += triangleArea(arr[0], arr[i], arr[i+1]);
        }
        return area;
    }


}
