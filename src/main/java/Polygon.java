
public class Polygon extends Shape{
    Vector[] _v;
    
    public Polygon(Vector[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[0].dim() != arr[i].dim()){
                throw new IllegalArgumentException("Different dimention!");
            }
        }
        this._v = VectorCalculate.vectorSort(arr);
    }

    public double area(){
        return VectorCalculate.area(this._v);
    }

    public double perimeter(){
        double n = 0;
        for(int i = 1; i < this._v.length; i++){
            n += VectorCalculate.distance(this._v[i-1], this._v[i]);
        }
        n += VectorCalculate.distance(this._v[0], this._v[this._v.length-1]);
        return n;
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < _v.length-1; i++){
            s += _v[i].toString() + ", ";
        }
        s += _v[_v.length-1].toString();
        return s;
    }
}