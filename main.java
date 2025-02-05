import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class main {

    public static final int ARRAY_SIZE = 100;
    public static final int MENU_EXIT = 0;
    public static final int MENU_MIN_MAX = 1;
    public static final int MENU_AVERAGE = 2;
    public static final int MENU_SUMS = 3;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int array[] = createArray(ARRAY_SIZE, random);

        boolean isRunning = true;
        int input;

        // b) Display the menu options, get the user’s choice, and call the required methods to print out the result. Until the user chooses to exit, you should display the menu again.
        
        do {

            System.out.printf("Array: %s\n", Arrays.toString(array));
            System.out.printf("Actions:\n\t0: Exit\n\t1: Find minimum and maximum values\n\t2: Find the average and differences\n\t3: Calculate the sums of odd and even numbers\nPick action: ");

            if (scanner.hasNextInt()) {

                input = scanner.nextInt();

                switch (input) {
                    case MENU_EXIT:
                        isRunning = false;
                        System.out.println("Good bye!");
                        break;
                    case MENU_MIN_MAX:
                        // TBD
                        break;
                    case MENU_AVERAGE:
                        // TBD
                        break;
                    case MENU_SUMS:
                        // TBD
                        break;
                    default:
                        System.out.printf("\n%d is not a valid option.\n\n", input);
                        break;
                }

            }
            else {
                System.out.println("\nPlease enter a digit.\n");
                scanner.nextLine();
            }

        } while (isRunning);

        scanner.close();

    } 
    
    /**
     * a) Given an array size, create an int array that contains random integers in the range [0,100]. 
     * All the remaining functionality will operate on this array.
     * @author Ömür Meriç Arıcı
     */
    public static int[] createArray(int size, Random random) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(101);
        }
        return array;
    }
}
