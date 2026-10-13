package module1.Exception;

class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }
}
public class customisedException {
    public static void main(String[] args) {
        try {
            int age=19;
            if(age<18){
                System.out.println("Mature");
            }
            else {
                throw new InvalidAgeException(
                        "Age Must be smaller than 18"
                );
            }
        }
        catch(InvalidAgeException e){
            System.out.println(e);
        }
    }
}
