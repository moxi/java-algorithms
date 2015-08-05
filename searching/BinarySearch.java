package searching;

public class BinarySearch {

  public static final int NOT_FOUND = -1;

  public static void main(String[] args) {
    int[] input = new int[] {1,2,2,3,4,7,10,11,15,18};
    System.out.println("6==" + binarySearch(10, input));
    System.out.println("5==" + binarySearch(7, input));
    System.out.println("0==" + binarySearch(1, input));
    System.out.println("9==" + binarySearch(18, input));
    System.out.println("3==" + binarySearch(3, input));
    System.out.println("-1==" + binarySearch(40, input));
  }

  public static int binarySearch(int element, int[] input) {
    int begin = 0, end = input.length;
    return binarySearch(element, input, begin, end);
  }

  private static int binarySearch(int element, int[] input, int begin, int end) {
    int position = NOT_FOUND;
    if (element == input[begin]) { position =  begin; }
    else if (element == input[end - 1]) { position = end - 1; }
    else {
      int midPosition = begin + (end - begin) / 2 ;
      if(element > input[begin] && element <= input[midPosition - 1] ) {
        // left
        position = binarySearch(element, input, begin, midPosition);
      } else if (element >= input[midPosition] && element < input[end - 1]) {
        // right
        position = binarySearch(element, input, midPosition, end);
      }
    }
    return position;
  }

}
