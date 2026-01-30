import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        // UC1: Display Static Hazard Message
        System.out.println("Factory Robot Hazard Analyzer");

        // UC2: Accept Robot Hazard Inputs
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Arm Precision:");
        double armPrecision = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.println("Enter Worker Density:");
        int workerDensity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Enter Machinery State:");
        String machineryState = scanner.nextLine();

        // Echo inputs
        System.out.println("\n--- Input Summary ---");
        System.out.println("Arm Precision: " + armPrecision);
        System.out.println("Worker Density: " + workerDensity);
        System.out.println("Machinery State: " + machineryState);

        scanner.close();
    }
}
