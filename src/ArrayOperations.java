import java.util.Random;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        int[] dataPoints = new int[100];
        Random random = new Random();

        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = random.nextInt(100) + 1;
        }

        System.out.print("Array values: ");
        for (int value : dataPoints) {
            System.out.printf("%d | ", value);
        }
        System.out.println();

        int sum = 0;
        for (int value : dataPoints) {
            sum += value;
        }
        double average = (double) sum / dataPoints.length;

        System.out.printf("The sum of the random array dataPoints is: %d%n", sum);

        System.out.printf("The average of the random array dataPoints is: %.2f%n", average);

        Scanner scanner = new Scanner(System.in);
        int userValue;
        do {
            userValue = SafeInput.getRangedInt(scanner, "Enter a value between 1 and 100: ", 1, 100);
        } while (userValue < 1 || userValue > 100);

        int count = 0;
        for (int value : dataPoints) {
            if (value == userValue) {
                count++;
            }
        }

        System.out.printf("The value %d was found %d times in the array.%n", userValue, count);

        do {
            userValue = SafeInput.getRangedInt(scanner, "Enter another value between 1 and 100: ", 1, 100);
        } while (userValue < 1 || userValue > 100);

        int position = -1;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue) {
                position = i;
                break;
            }
        }

        if (position != -1) {
            System.out.printf("The value %d was found at array index %d.%n", userValue, position);


        } else {


            System.out.printf("The value %d was not found in the array.%n", userValue);
        }

        int minValue = dataPoints[0];


        int maxValue = dataPoints[0];

        for (int value : dataPoints) {
            if (value < minValue) {
                minValue = value;
            }
            if (value > maxValue) {
                maxValue = value;
            }
        }

        System.out.printf("Minimum value in the array: %d%n", minValue);


        System.out.printf("Maximum value in the array: %d%n", maxValue);

        System.out.printf("Average of dataPoints is: %.2f%n", getAverage(dataPoints));
    }

    public static double getAverage(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.length;
    }
}