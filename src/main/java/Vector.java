public class Vector{

    private double[] _v;
    private int _dim;

    private void copy(double[] v, int dimention){
        this._dim = dimention;
        this._v = new double[_dim];
        for(int i = 0; i < _dim; i++){
            this._v[i] = v[i];
        }
    }

    //constructor
    public Vector(double[] v, int dim){
        copy(v, dim);
    }
    //default constructor
    public Vector(){
        _dim = 2;
        this._v = new double[_dim];
        for(int i = 0; i < _dim; i++){
            this._v[i] = 0;
        }
    }

    //copy constructor
    public Vector(Vector u){
        // System.out.println("Copy constructor called.");
        _dim = u.dim();
        _v = new double[u.dim()];
        for(int i = 0; i < u.dim(); i++){
            _v[i] = u.at(i+1);
        }

    }

    public boolean isZero(){
        boolean result = true;
        for(int i = 0; i < _dim; i++){
            if(_v[i] != 0){
                result = false;
            }
        }
        return result;
    }
   
    public int dim(){
        return this._dim;
    }

    public double at(int i){
        return this._v[i-1];
    }

    public Vector add(Vector a){
        if(this._dim != a.dim()){
            throw new IndexOutOfBoundsException("Different dimention, can't add!");
        }
        for(int i = 0; i < a.dim(); i++){
            this._v[i] += a.at(i+1);
        }

        return this;
    }

    public Vector subtruct(Vector a){
        if(this._dim != a.dim()){
            throw new IndexOutOfBoundsException("Different dimention, can't add!");
        }
        for(int i = 0; i < a.dim(); i++){
            this._v[i] -= a.at(i+1);
        }

        return this;
    }

    public double length(){
        double sum = 0;
        for(int i = 0; i < this._dim; i++){
            sum += Math.pow(_v[i], 2);
        }
        return Math.sqrt(sum);
    }

    public Vector assign(Vector u){
        this.copy(u._v, u.dim());
        return this;
    }

    public Vector divid(double a){
        for(int i = 0; i < _dim; i++){
            this._v[i] /= a;
        }
        return this;
    }

    public Vector sub(Vector a){
        Vector u = new Vector(this._v, this._dim);
        u.subtruct(a);
        return u;
    }

    public String toString(){
        String s = "(";
        for(int i = 0; i < _dim-1; i++){
            s += Double.toString(_v[i]);
            s += ", ";
        }
        s +=  Double.toString(_v[_dim-1]);
        s +=  ")";
        return s;

    }

}