import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class main
{

    public static int arraySize;
    public static final int MENU_EXIT = 0;
    public static final int MENU_MIN_MAX = 1;
    public static final int MENU_AVERAGE = 2;
    public static final int MENU_SUMS = 3;

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean isRunning = true;
        int input;

        // Taking a valid array size.
        System.out.print("Please enter the size of the array: ");

        while (true)
        {
            if (scanner.hasNextInt())
            {
                arraySize = scanner.nextInt();
                break;
            } else
            {
                System.out.print("Please enter an integer : ");
                scanner.next();
            }
        }

        int array[] = createArray(arraySize, random);
        // b) Display the menu options, get the user’s choice, and call the required
        // methods to print out the result. Until the user chooses to exit, you should
        // display the menu again.

        do
        {

            System.out.printf("Array: %s\n", Arrays.toString(array));
            System.out.printf(
                    "Actions:\n\t0: Exit\n\t1: Find minimum and maximum values\n\t2: Find the average and differences\n\t3: Calculate the sums of odd and even numbered indexes\nPick action: ");

            if (scanner.hasNextInt())
            {

                input = scanner.nextInt();

                switch (input)
                {
                case MENU_EXIT:
                    isRunning = false;
                    System.out.println("Good bye!");
                    break;
                case MENU_MIN_MAX:
                    System.out.printf("Max of array: %d\nMin of array: %d\n", arrayMax(array), arrayMin(array));
                    break;
                case MENU_AVERAGE:
                    // TBD
                    break;
                case MENU_SUMS:
                    sumOfIndexes(array);
                    break;
                default:
                    System.out.printf("\n%d is not a valid option.\n\n", input);
                    break;
                }

            } else
            {
                System.out.println("\nPlease enter a digit.\n");
                scanner.nextLine();
            }

        } while (isRunning);

        scanner.close();

    }

    /**
     * a) Given an array size, create an int array that contains random integers in
     * the range [0,100]. All the remaining functionality will operate on this
     * array.
     * 
     * @author Ömür Meriç Arıcı
     */
    public static int[] createArray(int size, Random random)
    {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
        {
            array[i] = random.nextInt(101);
        }
        return array;
    }

    /**
     * c) Find the array's minimum and maximum; these should be implemented as
     * different methods.
     * 
     * @author Fatih Ebrar İnan
     * 
     */
    private static int arrayMax(int[] arr)
    {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    private static int arrayMin(int[] arr)
    {
        Arrays.sort(arr);
        return arr[0];
    }

    /**
     * e)Find the sum of elements with odd- and even-numbered indexes. For example,
     * if the array is {1, 5, 8, 9, 10, 2, 6}, the sum of the odd indexes is 5 + 9 +
     * 2, and the sum of the even indexes is 1 + 8 + 10 + 6, assuming indexes start
     * at 0.
     * 
     * @author Emir Akar
     */
    public static void sumOfIndexes(int[] arr)
    {
        int evenSums = 0;
        int oddSums = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (i % 2 == 0)
                evenSums += arr[i];
            else
                oddSums += arr[i];
        }
        System.out.println(
                "The sum of the odd indexes is: " + oddSums + "\nThe sum of the even indexes is: " + evenSums + "\n");
    }
}