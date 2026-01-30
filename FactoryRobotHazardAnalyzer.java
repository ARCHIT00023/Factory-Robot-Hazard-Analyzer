import java.util.Scanner;

// UC6: Custom Exception
class RobotSafetyException extends Exception {

    public RobotSafetyException(String message) {
        super(message);
        System.out.println(message); // Exception prints message itself
    }
}

public class FactoryRobotHazardAnalyzer {

    // UC7: Machinery state → risk factor mapping
    private static double getMachineRiskFactor(String machineryState)
            throws RobotSafetyException {

        if (machineryState.equals("Worn")) {
            return 1.3;
        } else if (machineryState.equals("Faulty")) {
            return 2.0;
        } else if (machineryState.equals("Critical")) {
            return 3.0;
        } else {
            throw new RobotSafetyException(
                    "Error: Unsupported machinery state");
        }
    }

    // UC6 + UC7: Validation + calculation
    public static double calculateHazardRisk(double armPrecision,
                                             int workerDensity,
                                             String machineryState)
            throws RobotSafetyException {

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException(
                    "Error: Arm precision must be 0.0-1.0");
        }

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException(
                    "Error: Worker density must be 1-20");
        }

        // UC7: Structured risk mapping
        double machineRiskFactor =
                getMachineRiskFactor(machineryState);

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }

    public static void main(String[] args) {

        System.out.println("Factory Robot Hazard Analyzer");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter Arm Precision:");
            double armPrecision = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Enter Worker Density:");
            int workerDensity = scanner.nextInt();
            scanner.nextLine();

            System.out.println(
