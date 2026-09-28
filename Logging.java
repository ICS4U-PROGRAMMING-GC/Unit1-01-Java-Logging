import java.util.Scanner;

/**
 * Calculates log capacities for trucks.
 *
 * @author Carel Gumuyire
 * @version 1.0
 * @since 2026-09-28
 */
public final class Logging {

    /**
     * Private constructor to prevent creating objects of this class.
     */
    private Logging() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Main entry point of the program.
     *
     * @param args Command line arguments.
     */
    public static void main(final String[] args) {
        // Valid log length options in meters
        final double shortLog = 0.25;
        final double mediumLog = 0.5;
        final double longLog = 1.0;

        // Truck weight limits in kg
        final double weightPerMeter = 20.0;
        final double maxCapacity = 1100.0;

        final Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        // Keep asking until valid input is given
        while (!validInput) {
            System.out.print("Enter log length (0.25, 0.5, or 1): ");

            // Check if input is a number
            if (scanner.hasNextDouble()) {
                final double length = scanner.nextDouble();

                // Check if the number matches one of the valid log lengths
                if (length == shortLog || length == mediumLog
                        || length == longLog) {
                    // Calculate weight and total logs allowed
                    final double weightPerLog = length * weightPerMeter;
                    final int maxLogs = (int) (maxCapacity / weightPerLog);

                    System.out.println("A truck can carry " + maxLogs
                            + " logs of length " + length + " m.");
                    validInput = true;
                } else {
                    System.out.println("Invalid length. Log length must be "
                            + "0.25, 0.5, or 1.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }

        scanner.close();
    }
}
