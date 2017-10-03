package Lab1;

public class Test {
  public static void main(String[] args) {
  
    int[] testArr = {2,2,2,2};
    int multiply = 3;
    int[] resultant = multiplyDigitsArray(testArr, multiply);
    for (int i = 0; i < resultant.length; i++){
      System.out.print(resultant[i]);
    }
    
    
  }
  
  public static int[] multiplyDigitsArray (int[] arr1, int indexPosition) {
    int length = arr1.length + 1;
    int[] resultant = new int[length];
    int carryOver = 0;
    int j = arr1.length - 1;
  
    for (int i = length - 1; i >= 0; i--) {
      resultant[i] = (arr1[j] * indexPosition) + carryOver;
      carryOver = 0;
      if (resultant[i] > 9) {
        while (resultant[i] > 9) {
          resultant[i] -= 10;
          carryOver++;
        }
      }
      if (j == 0) {
        resultant[i - 1] = carryOver;
        break;
      }
      j--;
    }
    return resultant;
  }
}
