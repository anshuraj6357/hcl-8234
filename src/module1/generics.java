package module1;

public class generics {
    class Box<T>{
        T value;
        void setValue(T value){
            this.value=value;
        }
        T getValue(){
            return this.value;
        }
    }

    public static void main(String[] args) {
        generics outer=new generics();
        Box<Integer> b1=outer.new Box();
        b1.setValue(1);
        System.out.println(b1.getValue());
        Box<String> b2=outer.new Box();
        b2.setValue("hello");
        System.out.println(b2.getValue());
    }
}
