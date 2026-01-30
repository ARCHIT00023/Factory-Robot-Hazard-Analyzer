import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        System.out.println("Factory Robot Hazard Analyzer");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter Arm Precision (0.0 - 1.0):");
            double armPrecision = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Enter Worker Density (1 - 20):");
            int workerDensity = scanner.nextInt();
            scanner.nextLine();

            System.out.println(
                    "Enter Machinery State (Worn/Faulty/Critical):");
            String machineryState = scanner.nextLine();

            RobotHazardAuditor auditor =
                    new RobotHazardAuditor();

            double risk = auditor.calculateHazardRisk(
                    armPrecision, workerDensity, machineryState);

            System.out.println("Robot Hazard Risk Score: " + risk);

        } catch (RobotSafetyException e) {
            // Message already printed
        } finally {
            scanner.close();
        }
    }
}
