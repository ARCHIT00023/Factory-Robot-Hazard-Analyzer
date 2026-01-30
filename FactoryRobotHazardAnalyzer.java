import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    // UC3: Hazard calculation logic
    public static double calculateHazardRisk(double armPrecision,
                                             int workerDensity,
                                             double machineRiskFactor) {

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }

    public static void main(String[] args) {

        System.out.println("Factory Robot Hazard Analyzer");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Arm Precision:");
        double armPrecision = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter Worker Density:");
        int workerDensity = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Machinery State:");
        String machineryState = scanner.nextLine();

        double machineRiskFactor = 0.0;
        boolean isValid = true;

        // UC4: Validation using if-else
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be 0.0 - 1.0");
            isValid = false;
        } else if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be 1 - 20");
            isValid = false;
        } else if (machineryState.equals("Worn")) {
            machineRiskFactor = 1.3;
        } else if (machineryState.equals("Faulty")) {
            machineRiskFactor = 2.0;
        } else if (machineryState.equals("Critical")) {
            machineRiskFactor = 3.0;
        } else {
            System.out.println("Error: Unsupported machinery state");
            isValid = false;
        }

        // Calculate only if all inputs are valid
        if (isValid) {
            double risk = calculateHazardRisk(
                    armPrecision, workerDensity, machineRiskFactor);
            System.out.println("Hazard Risk Score: " + risk);
        }

        scanner.close();
    }
}
