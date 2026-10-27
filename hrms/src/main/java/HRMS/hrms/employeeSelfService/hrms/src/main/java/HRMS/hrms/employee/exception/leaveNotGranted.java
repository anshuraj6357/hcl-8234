package HRMS.hrms.employee.exception;

public class leaveNotGranted extends RuntimeException {
    public leaveNotGranted(String message) {
        super(message);
    }
}
