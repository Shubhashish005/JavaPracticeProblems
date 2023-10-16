package netcracker;

/*

Find max possible difference between any 2 numbers in a given array
Example input: {8, 3, -1, 10, 5, -6}
Expected output: 16
 */
public class ProblemImplementation {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 3, -1, 10, 5, -6};
        if (arr.length == 0)
            return;

        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            else if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println(max - min);


    }
}
