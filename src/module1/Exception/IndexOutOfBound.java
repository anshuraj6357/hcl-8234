package module1.Exception;

import java.util.ArrayList;

public class IndexOutOfBound {
    public static void main(String[] args) throws IndexOutOfBoundsException,NullPointerException{
        try {
            ArrayList<Integer> list=new ArrayList<>();
            list.add(1);
            list.add(2);
            int p=3/0;
            int a=list.get(1);
            System.out.println(a);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        catch(ArithmeticException e){
            System.out.println(e);
        }
        catch (NullPointerException e){
            System.out.println(e);
        }
        finally{
            System.out.println("finally");
        }
    }
}
