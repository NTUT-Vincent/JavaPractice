import java.util.Comparator;

public class MyComparator implements Comparator<Vector>{
    Vector _basic = new Vector();
    Vector _cend = new Vector();
    public MyComparator(Vector basic, Vector cend){
        this._basic.assign(basic);
        this._cend.assign(cend);
    }
    
    @Override
    public int compare(Vector o1, Vector o2) {
        if(VectorCalculate.angle(this._basic, o1.sub(this._cend)) < VectorCalculate.angle(this._basic, o2.sub(this._cend))) { 
            return -1;
        }else if(VectorCalculate.angle(this._basic, o1.sub(this._cend)) > VectorCalculate.angle(this._basic, o2.sub(this._cend))) {
            return 1;
        }else {
            return 0;
        }
    }
}