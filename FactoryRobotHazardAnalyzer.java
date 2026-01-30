import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    // UC5: Validation + calculation in one method
    public static double calculateHazardRisk(double armPrecision,
                                             int workerDensity,
                                             String machineryState) {

        double machineRiskFactor;

        // Validation logic
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be 0.0 - 1.0");
            return -1;
        }

        if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be 1 - 20");
            return -1;
        }

        if (machineryState.equals("Worn")) {
            machineRiskFactor = 1.3;
        } else if (machineryState.equals("Faulty")) {
            machineRiskFactor = 2.0;
        } else if (machineryState.equals("Critical")) {
            machineRiskFactor = 3.0;
        } else {
            System.out.println("Error: Unsupported machinery state");
            return -1;
        }

        // Hazard risk calculation
        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }

    public static void main(String[] args) {

        // UC1: Static message
        System.out.println("Factory Robot Hazard Analyzer");

        Scanner scanner = new Scanner(System.in);

        // UC2: Input
        System.out.println("Enter Arm Precision:");
        double armPrecision = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter Worker Density:");
        int workerDensity = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Machinery State:");
        String machineryState = scanner.nextLine();

        // UC5: Method call
        double risk = calculateHazardRisk(
                armPrecision, workerDensity, machineryState);

        if (risk != -1) {
            System.out.println("Hazard Risk Score: " + risk);
        }

        scanner.close();
    }
}
