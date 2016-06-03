/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prypolinomio;

/**
 *
 * @author PC
 */
public class ClsPolinomio {
    //DEFINICION DE VARIABLES
    private int _grado;
    private float [] _a;
    
    //DEFINICION DE CONSTRUCTORES 
   public ClsPolinomio(){
    _grado= 2;
    _a = new float [_grado];
    }
    
    public ClsPolinomio (int grado){
    _grado = grado ;
    _a = new float [_grado+1];
    }
    
    public ClsPolinomio (int grado , float [] coef){
    _grado = grado ;
    _a=coef;
    }
    
    public ClsPolinomio(ClsPolinomio t){
    _grado=t._grado;
    _a=t._a;
    }
    
    //METODOS SET Y GET
    public void grado(int valor){
    _grado=valor;
    }
    
    public int grado(){
    return _grado;
    }
    
    public void a(float [] coef){
    _a=coef;
    }
    
    public float [] a(){
    return _a;
    }
    
    public void a(int i , float valor){
    _a[i]=valor;
    }
    
    public float a(int i){
    return _a[i];
    }
    
    //HORNER
    public double horner(float x){
        double valor = _a[_grado-1] + _a[_grado]*x;
        for(int i = _grado-2;i>=0;i--){
            valor = _a[i] + valor*x;
        }
        return valor;
    }
    
    
    public double horner2(float x){
        double valor = _a[_grado-1] + _a[_grado]*x;
        for(int i = _grado-2;i>=0;i--){
            valor = _a[i] + valor*x;
        }
        return valor;
    }
    
    //INTEGRACION METODO DE LOS RECTANGULOS IZQUIERDOS
    public double deltaX(float a,float b,float n){
        return (b-a)/n;
    }

    public double sumatoriaMIRI(float a,float b,int n){
       double valor=0.0;
       for(int i=0;i<n;i++){
       valor+= horner2((float)(a+i*deltaX(a,b,n)));  
       }
      return valor;
    }

    public double MIRI(float a,float b,int n){
        return deltaX(a,b,n)*sumatoriaMIRI(a,b,n);
    }
    
    //INTEGRACION METODO DE LOS RECTANGULOS DERECHOS
    public double sumatoriaMIRD(float a,float b ,int n){
       double valor=0.0;
       for(int i=1;i<=n;i++){
       valor+= horner((float)(a+i*deltaX(a,b,n)));
        }
       return valor;
    }
    
    public double MIRD(float a,float b,int n){
        return deltaX(a,b,n)*sumatoriaMIRD(a,b,n);
    }
    
    public String ver(){
        return "x^"+_grado+"="+_a;
    }
    
    //INTEGRACIÓN POR TRAPECIOS
    public double deltaXsimpson (float a,float b,float n){
        return (b-a)/3*n;
    }
    
}
