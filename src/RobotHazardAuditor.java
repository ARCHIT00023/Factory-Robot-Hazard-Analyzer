public class RobotHazardAuditor {

    // UC7: Machinery state risk mapping
    private double getMachineRiskFactor(String machineryState)
            throws RobotSafetyException {

        switch (machineryState) {
            case "Worn":
                return 1.3;
            case "Faulty":
                return 2.0;
            case "Critical":
                return 3.0;
            default:
                throw new RobotSafetyException(
                        "Error: Unsupported machinery state");
        }
    }

    // UC8: Validation + calculation
    public double calculateHazardRisk(double armPrecision,
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

        double machineRiskFactor =
                getMachineRiskFactor(machineryState);

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }
}
