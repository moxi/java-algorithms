package sorting;

import java.util.Arrays;

/**
* Based on https://en.wikipedia.org/wiki/Merge_sort#Top-down_implementation_using_lists
*/
public class MergeSort {

  public static void main(String... args) {
    int[] input = new int[] {5,2,4,6,1,3};
    System.out.println( Arrays.toString(mergeSort(input)) );
  }

  public static int[] mergeSort(int[] input) {
    if (input.length <= 1) { return input; }
    int length = input.length;
    int middle = length / 2;

    int[] left = new int[middle];
    int[] right = new int[length - middle];

    for (int i = 0; i < middle; ++i) {
      left[i] = input[i];
    }
    for (int i=0, j = middle; j < length; ++i, ++j) {
      right[i] = input[j];
    }

    left = mergeSort(left);
    right = mergeSort(right);

    return merge(left, right);
  }

  public static int[] merge(int[] left, int[] right) {
    int[] sortedArray = new int[left.length + right.length];
    int i = 0, j = 0;
    while(i + j < sortedArray.length) {
      if(i < left.length && j < right.length && left[i] <= right[j]) {
        sortedArray[i+j] = left[i];
        ++i;
        continue;
      } else if (j < right.length) {
        sortedArray[i+j] = right[j];
        ++j;
        continue;
      }
      if(i < left.length ) {
        sortedArray[i+j] = left[i];
        ++i;
      } else if (j < right.length) {
        sortedArray[i+j] = right[j];
        ++j;
      }
    }
    return sortedArray;
  }

}
