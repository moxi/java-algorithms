package sorting;

import java.util.Arrays;

// Based on http://www.algorithmist.com/index.php/Quicksort
public class QuickSort {

    public static void main(String... args) {
      int[] input = new int[] {5,2,4,6,1,3};
      new QuickSort().quickSort(input);
      System.out.println( Arrays.toString(input) );
    }

    public void quickSort(int[] input) {
      quickSort(input, 0, input.length - 1);
    }

    private void quickSort(int[] A, int begin, int end) {
      if(begin < end ) {
        int index = partition(A, begin, end);
        quickSort(A, begin, index - 1);
        quickSort(A, index, end);
      }
    }

    private int partition(int[] A, int begin, int end) {
      int pivot = choosePivot(A, begin, end);
      int i = begin, j = end;

      while (i <= j)  {
        while (A[i] < pivot) {
          ++i;
        }

        while (A[j] > pivot) {
          --j;
        }
        if(i <= j) {
          swap(A, i, j);
          ++i;
          --j;
        }
      }
      return i;

    }

    private void swap(int[] A, int from, int to ) {
      int temp = A[from];
      A[from] = A[to];
      A[to] = temp;
    }

    private int choosePivot(int[] A, int begin, int end) {
      return A[begin + (end - begin) / 2]; // This can be improved
    }

}
