package sorting;

import java.util.Arrays;

public class SelectionSort {

  public static void main(String[] args) {
    int[] input = new int[] {5,2,4,6,1,3};
    System.out.println( Arrays.toString(selectionSort(input)) );
  }

  public static int[] selectionSort(int[] input) {
    int length = input.length;
    int minimumValue = Integer.MAX_VALUE;

    for (int i = 0; i < length; ++i) {
        // find the minimumValue when j > i and swap it  with input[i] location
        for (int j =i; j < length; ++j) {
          if (input[j] <= minimumValue ) {
            minimumValue = input[j];
            input[j] = input[i];
            input[i] = minimumValue;
          }
        }
        minimumValue = Integer.MAX_VALUE;
    }
    return input;
  }

}
