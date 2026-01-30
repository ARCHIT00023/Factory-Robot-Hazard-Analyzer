import java.util.Scanner;

// UC6: Custom Exception
class RobotSafetyException extends Exception {

    public RobotSafetyException(String message) {
        super(message);
        System.out.println(message); // Exception displays message itself
    }
}

public class FactoryRobotHazardAnalyzer {

    // UC6: Validation + calculation using exceptions
    public static double calculateHazardRisk(double armPrecision,
                                             int workerDensity,
                                             String machineryState)
            throws RobotSafetyException {

        double machineRiskFactor;

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException(
                    "Error: Arm precision must be 0.0-1.0");
        }

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException(
                    "Error: Worker density must be 1-20");
        }

        if (machineryState.equals("Worn")) {
            machineRiskFactor = 1.3;
        } else if (machineryState.equals("Faulty")) {
            machineRiskFactor = 2.0;
        } else if (machineryState.equals("Critical")) {
            machineRiskFactor = 3.0;
        } else {
            throw new RobotSafetyException(
                    "Error: Unsupported machinery state");
        }

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

            System.out.println("Enter Machinery State:");
            String machineryState = scanner.nextLine();

            double risk = calculateHazardRisk(
                    armPrecision, workerDensity, machineryState);

            System.out.println("Hazard Risk Score: " + risk);

        } catch (RobotSafetyException e) {
            // Message already printed by exception
        } finally {
            scanner.close();
        }
    }
}
