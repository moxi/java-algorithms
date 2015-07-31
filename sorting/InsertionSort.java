package sorting;

import java.util.Arrays;

public class InsertionSort {

  public static void main(String[] args) {
    int[] input = new int[] {5,2,4,6,1,3};

    System.out.println( Arrays.toString(insertionSort(input)) );
  }

  public static int[] insertionSort(int[] input) {

    if( input == null || input.length < 2 ) { return input; }

    int length = input.length;
    for (int j = 1; j < length; ++j) {
      if (input[j] < input[j-1]) {
        for (int i = j; i > 0; --i) {
          if(input[i] > input[i-1]) {
            break;
          } else {
            int temp = input[i];
            input[i] = input[i-1];
            input[i-1] = temp;
          }

        }
      }
    }


    return input;
  }

}
