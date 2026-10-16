package module2.singelton;

public class method {

    private int a;
    private int b;

    // Sirf ek object create hoga
     private static  method instance ;

    private method(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public static method getInstance(int a ,int b) {
        if(instance == null){
            instance=new method(a,b);
        }
        return instance;
    }
}