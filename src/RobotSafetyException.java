public class RobotSafetyException extends Exception {

    public RobotSafetyException(String message) {
        super(message);
        System.out.println(message); // Exception prints its own message
    }
}
