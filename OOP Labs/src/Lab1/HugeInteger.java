package Lab1;

/**
 * Public class name: HugeInteger
 * Last date modified: 9/26/2017
 */

public class HugeInteger {
    
    private static final int NUM_DIGITS = 40; //Maximum decimal values of digits
    private int digits[] = new int[NUM_DIGITS];
    private boolean positive; //Boolean value for Digits
    private int stringLength; //Length of Object's string
    private int booleanValue; //Truth table case scenario integer
    
    /**
     * Is a private method and not for the outside class to call. This method
     * interprets h1 and h2 as boolean values.
     * <p>
     * This method checks the boolean values of both h1 and h2 and returns the
     * respective boolean value from the truth table case scenario
     *
     * @param hi second Array
     * @return boolean value case of both h1 and h2
     */
    private int booleanValueCheck(HugeInteger hi) {
        
        if (this.positive && hi.positive) {
            return 1;
        } else if (this.positive) {
            return 2;
        } else if (hi.positive) {
            return 3;
        } else {
            return 4;
        }
    }
    
    
    /**
     * Is a public method and can be called by outside users. This method
     * interprets h1 or h2 as a string value.
     * <p>
     * This method converts an integer string to an array of digits.
     * <p>
     * It does not check the validity of the string.
     *
     * @param num integer string
     */
    public HugeInteger(String num) {
        
        /*Checks if the first character at num is "-", then provides a value
        to the positive instance variable*/
        if (String.valueOf(num.charAt(0)).equals("-")) {
            
            /*Replaces the char "-" for an empty value*/
            num = num.replace("-", "");
            this.positive = false;
        } else {
            this.positive = true;
        }
        
        /*Takes the num's length and stores it in a instance variable so that
        it can be accessed throughout the program.*/
        this.stringLength = num.length();
        int index = 0;
        
        for (int i = 0; i < NUM_DIGITS; i++) {
            if (i >= (NUM_DIGITS - this.stringLength)) {
                
                /*Parses character values to int values in order*/
                this.digits[i] =
                        Integer.parseInt(String.valueOf(num.charAt(index)));
                index++;
            }
        }
    }
    
    /**
     * Is a public method and can be called by outside users. This method
     * interprets array1 and array2 as two integers whose LSB digits are
     * at array1[NUM_DIGITS-1] and array2[NUM_DIGITS-1].
     * <p>
     * This method checks if h1 is equal to h2.
     *
     * @param hi Second Array
     * @return boolean value if h1 is equal to h2.
     */
    public boolean isEqualTo(HugeInteger hi) {
        
        /*Assigns the truth table value to the integer variable*/
        booleanValue = booleanValueCheck(hi);
        
        if (booleanValue == 2 || booleanValue == 3) {
            return false;
        }
        
        for (int i = 0; i < NUM_DIGITS; i++) {
            if (this.digits[i] != hi.digits[i]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Is a public method and can be called by outside users. This method
     * interprets array1 and array2 as two integers whose LSB digits are
     * at array1[NUM_DIGITS-1] and array2[NUM_DIGITS-1].
     * <p>
     * This method checks if h1 is greater than h2.
     *
     * @param hi Second Array.
     * @return boolean value if h1 is greater than h2.
     */
    public boolean isGreaterThan(HugeInteger hi) {
        
        /*Assigns the truth table value to the integer variable*/
        booleanValue = booleanValueCheck(hi);
        
        if (booleanValue == 2) {
            return true;
        } else if (booleanValue == 3) {
            return false;
        } else if (booleanValue == 1) {
            
            if (this.stringLength > hi.stringLength) {
                return true;
            } else if (this.stringLength < hi.stringLength) {
                return false;
            } else {
                for (int i = 0; i < NUM_DIGITS; i++) {
                    if (this.digits[i] > hi.digits[i]) {
                        return true;
                    } else if (this.digits[i] < hi.digits[i]) {
                        return false;
                    }
                }
            }
        } else {
            
            if (this.stringLength < hi.stringLength) {
                return true;
            } else if (this.stringLength > hi.stringLength) {
                return false;
            } else {
                for (int i = 0; i < NUM_DIGITS; i++) {
                    if (this.digits[i] > hi.digits[i]) {
                        return false;
                    } else if (this.digits[i] < hi.digits[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * Is a public method and can be called by outside users. This method
     * interprets array1 and array2 as two integers whose LSB digits are
     * at array1[NUM_DIGITS-1] and array2[NUM_DIGITS-1].
     * <p>
     * This method checks if h1 is not equal to h2.
     *
     * @param hi Second Array
     * @return boolean value if h1 is not equal to h2.
     */
    public boolean isNotEqualTo(HugeInteger hi) {
        return !isEqualTo(hi);
    }
    
    /**
     * Is a public method and can be called by outside users. This method
     * interprets array1 and array2 as two integers whose LSB digits are
     * at array1[NUM_DIGITS-1] and array2[NUM_DIGITS-1].
     * <p>
     * This method checks if h1 less than h2.
     *
     * @param hi Second Array
     * @return boolean value if h1 is less than h2.
     */
    public boolean isLessThan(HugeInteger hi) {
        return !isGreaterThan(hi) && !isEqualTo(hi);
    }
    
    /**
     * Is a public method and can be called by outside users. This method
     * interprets array1 and array2 as two integers whose LSB digits are
     * at array1[NUM_DIGITS-1] and array2[NUM_DIGITS-1].
     * <p>
     * This method checks if h1 is greater than or equal to h2.
     *
     * @param hi Second Array
     * @return boolean value if h1 is greater than or equal to h2.
     */
    public boolean isGreaterThanOrEqualTo(HugeInteger hi) {
        return isGreaterThan(hi) || isEqualTo(hi);
    }
    
    /**
     * Is a public method and can be called by outside users. This method
     * interprets array1 and array2 as two integers whose LSB digits are
     * at array1[NUM_DIGITS-1] and array2[NUM_DIGITS-1].
     * <p>
     * This method checks if h1 is less than or equal to h2.
     *
     * @param hi Second Array
     * @return boolean value if h1 is less than or equal to h2.
     */
    public boolean isLessThanOrEqualTo(HugeInteger hi) {
        return isLessThan(hi) || isEqualTo(hi);
    }
    
    /**
     * Is a public method and can be called by outside users. This methods
     * interprets array1 and array2 as two integers whose LSB digits are at
     * array1[NUM_DIGITS-1] and array2[NUM_DIGITS-1].
     * <p>
     * This method checks for the truth table conditions and then adds h2 to
     * h1 by using the addArrayDigits or subtractArrayDigits methods.
     *
     * @param hi Second Array.
     */
    public void add(HugeInteger hi) {
        
        /*Assigns the truth table value to the integer variable*/
        booleanValue = booleanValueCheck(hi);
        
        if (booleanValue == 1 || booleanValue == 4) {
            this.digits = addArrayDigits(this.digits, hi.digits);
        } else if ((booleanValue == 2)) {
            hi.negate();
            
            if (isGreaterThan(hi)) {
                this.digits = subtractArrayDigits(this.digits, hi.digits);
                
                hi.negate();
            } else {
                this.negate();
                
                this.digits = subtractArrayDigits(hi.digits, this.digits);
                
                hi.negate();
            }
        } else {
            this.negate();
            
            if (isLessThan(hi)) {
                this.digits = subtractArrayDigits(hi.digits, this.digits);
            } else {
                this.negate();
                
                this.digits = subtractArrayDigits(this.digits, hi.digits);
            }
        }
    }
    
    /**
     * Is a public method and can be called by outside users. This methods
     * interprets array1 and array2 as two integers whose LSB digits are at
     * array1[NUM_DIGITS-1] and array2[NUM_DIGITS-1].
     * <p>
     * This method checks for the truth table conditions and then subtracts
     * h2 to h1 by using the addArrayDigits or subtractArrayDigits methods.
     *
     * @param hi Second Array.
     */
    public void subtract(HugeInteger hi) {
        
        /*Assigns the truth table value to the integer variable*/
        booleanValue = booleanValueCheck(hi);
        
        if (booleanValue == 1) {
            if (isGreaterThan(hi)) {
                this.digits = subtractArrayDigits(this.digits, hi.digits);
            } else {
                this.digits = subtractArrayDigits(hi.digits, this.digits);
                
                this.negate();
            }
        } else if (booleanValue == 2) {
            this.digits = addArrayDigits(this.digits, hi.digits);
        } else if (booleanValue == 3) {
            this.digits = addArrayDigits(this.digits, hi.digits);
        } else {
            if (isGreaterThan(hi)) {
                this.digits = subtractArrayDigits(hi.digits, this.digits);
                
                this.negate();
            } else {
                this.digits = subtractArrayDigits(this.digits, hi.digits);
            }
        }
    }
    
    /**
     * Is a public method and can be called by outside users. This methods
     * interprets array1 and array2 as two integers whose LSB digits are at
     * array1[NUM_DIGITS-1] and array2[NUM_DIGITS-1].
     *
     * This method is incomplete, it should loop around the h2 int array in a
     * for loop calling the multiplyDigitsArray method and then store it in a
     * new int array to then set it equal to the h1 int array.
     *
     * @param hi Second Array
     */
    public void multiply(HugeInteger hi) {
    
        int[] sumTotal = new int[this.digits.length + hi.digits.length];
        int[] storeTempValue = new int[this.digits.length + hi.digits.length];
        int decimalPlace = 0;
    
        for (int i = NUM_DIGITS - 1; i >= 0; i--) {
            storeTempValue = multiplyDigitsArray(this.digits, hi.digits[i]);
        
        }
    }
    
    /**
     * This method flips the current sign of the Object.
     */
    public void negate() {
        this.positive = !this.positive;
    }
    
    /**
     * This method loops through the array, checking if the values inside it
     * are all zeros, then returns the boolean value.
     *
     * @return boolean value that checks if the values in the array are 0.
     */
    public boolean isZero() {
        for (int i = NUM_DIGITS - stringLength; i < NUM_DIGITS; i++) {
            if (this.digits[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * This method is public and can be called by outside users. This method
     * interprets the values of the Object array.
     *
     * This methods converts the int array to a string variable.
     *
     * @return conversion to an string array.
     */
    public String toString() {
        int index = 0;
        
        if (isZero()) {
            return "0";
        }
        String convert = "";
        
        if (!this.positive) {
            convert += "-";
        }
        
        for (int i = 0; i < NUM_DIGITS; i++) {
            if (this.digits[i] != 0) {
                index = i;
                break;
            }
        }
        
        for (int i = index; i < NUM_DIGITS; i++) {
            convert += this.digits[i];
        }
        return convert;
    }
    
    /**
     * Is a private method and not for outside users to call. This method
     * interprets array1 and array2 as two integers whose LSB digits are
     * at array1[NUM_DIGITS-1] and array2[NUM_DIGITS-1]. Without sign
     * information, array1 and array2 can only represent positive integers.
     * <p>
     * This methods adds array1 and array2, and store the result in another
     * integer array for return
     *
     * @param array1 first integer
     * @param array2 second integer
     * @return addition of array1 and array2
     */
    private static int[] addArrayDigits(int[] array1, int[] array2) {
        int[] resultArray = new int[NUM_DIGITS];
        int carryOver = 0;
        
        for (int i = NUM_DIGITS - 1; i >= 0; i--) {
            resultArray[i] = array1[i] + array2[i] + carryOver;
            
            if (resultArray[i] < 10) {
                carryOver = 0;
            } else {
                resultArray[i] -= 10;
                carryOver = 1;
            }
        }
        return resultArray;
    }
    
    /**
     * Is a private method and not for outside users to call. This method
     * interprets array1 and array2 as two integers whose LSB digits are
     * at array1[NUM_DIGITS-1] and array2[NUM_DIGITS-1]. Without sign
     * information, array1 and array2 can ony represent positive integers.
     * <p>
     * This method subtracts array2 from array1, and store the results in
     * another integer array for return.
     * <p>
     * The assumption is the integer in array1 is greater than the one in
     * array2
     *
     * @param array1 first integer.
     * @param array2 second integer
     * @return subtraction of array2 from array1
     */
    private static int[] subtractArrayDigits(int[] array1, int[] array2) {
        int[] resultArray = new int[NUM_DIGITS];
        int borrowsOver = 0;
        
        for (int i = NUM_DIGITS - 1; i >= 0; i--) {
            resultArray[i] = array1[i] - array2[i] + borrowsOver;
            
            if (array2[i] > array1[i]) {
                resultArray[i] += 10;
                borrowsOver = -1;
            } else {
                borrowsOver = 0;
            }
        }
        return resultArray;
    }
    
    /**
     * Is a private method and not for outside users to call. This method
     * interprets array1 as an integer whose LSB digits is at
     * array1[NUM_DIGITS-1]. Without sign
     * information, array1 and array2 can ony represent positive integers.
     * <p>
     * This method multiplies the values inside array1 and the indexValue of
     * array2.
     *
     * @param array1 First Array.
     * @param indexValue from the Second Array.
     * @return multiplication of Array1 and an indexValue of Array2
     */
    private static int[] multiplyDigitsArray(int[] array1, int indexValue) {
        int length = array1.length + 1;
        int[] resultant = new int[length];
        int carryOver = 0;
        int j = array1.length - 1;
        
        for (int i = length - 1; i >= 0; i--) {
            resultant[i] = (array1[j] * indexValue) + carryOver;
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
