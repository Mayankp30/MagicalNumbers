import java.util.*;

public class MagicNumber {

    public static boolean check = false;

    public static boolean checkPropertyZero(StringBuilder numberArray) {
        int sum=0;
        if(Integer.valueOf(numberArray.toString()) == 0) {
            return false;
        }
        for(int i=0; i<numberArray.length(); i++) {
            int digit = Character.getNumericValue(numberArray.charAt(i));
            for(int j=0;j<numberArray.length(); j++) {
                if(i != j) {
                    sum += Character.getNumericValue(numberArray.charAt(j));
                }
            }
            if (digit == sum) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPropertyOne(StringBuilder numberArray) {
        int number = Integer.valueOf(numberArray.toString());
        int sum = 0;
        if(number == 1) {
            return false;
        }
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        if(sum+number > number) {
            return true;
        }
        return false;
    }

    public static boolean checkPropertyTwo(StringBuilder numberArray) {
        int sumOfOddDigits = 0;
        for(int i=0; i<numberArray.length(); i++) {
            if(Character.getNumericValue(numberArray.charAt(i)) % 2 == 1) {
                sumOfOddDigits += 1;
            }
            if(sumOfOddDigits == 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPropertyThree(StringBuilder numberArray) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<numberArray.length();i++) {
            if(set.add(String.valueOf(numberArray.charAt(i))) == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPropertyFour(StringBuilder numberArray) {
        if(numberArray.length() < 4) {
            return false;
        }
        return (Character.getNumericValue(numberArray.charAt(3)) % 2 == 0);
    }

    public static boolean checkPropertyFive(StringBuilder numberArray) {
        int productOfDigits=1;
        for(int i=0;i<numberArray.length();i++){
            productOfDigits*=i;
        }
        if(productOfDigits%5==0){
            return false;
        }
        return true;
    }

    public static boolean checkPropertySix(StringBuilder numberArray) {
        int noOfOddDigits = 0;
        for(int i=0;i<numberArray.length();i++) {
            if(Character.getNumericValue(numberArray.charAt(i)) % 2 == 1) {
                noOfOddDigits+=1;
            } else {
                noOfOddDigits=0;
            }

            if(noOfOddDigits == 3) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPropertySeven(StringBuilder numberArray) {
        int number = Integer.valueOf(numberArray.toString());
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static boolean checkPropertyEight(StringBuilder numberArray) {
        int noOfEvenDigits = 0;
        for(int i=0;i<numberArray.length();i++) {
            if(Character.getNumericValue(numberArray.charAt(i)) % 2 == 0) {
                noOfEvenDigits+=1;
            } else {
                noOfEvenDigits=0;
            }

            if(noOfEvenDigits == 3) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPropertyNine(StringBuilder numberArray) {
        int productOfOdd=1;
        for(int i=0 ;i<numberArray.length();i++){
            if(Character.getNumericValue(numberArray.charAt(i)) % 2 == 1) {
                productOfOdd *= Character.getNumericValue(numberArray.charAt(i));
            }
        }
        long tst = (long)(Math.sqrt(productOfOdd) + 0.5);
        return tst*tst == productOfOdd;
    }

    public static void main(String[] args) {
        for (int j = 1000; j < 10000; j++) {
            check = checkMagicNumber(j);
            if(check == true) {
                System.out.println("The number is magical!!" + j);
               // System.exit(0); // Comment this line if you want to check all the magic Numbers between 100 and 1000!!!
            }
            check = false;
        }
    }

    public static boolean checkMagicNumber(int number) {
        StringBuilder numberArray = new StringBuilder();
        numberArray.append(number);
        for (int i = 0; i < numberArray.length(); i++) {
            switch (Character.getNumericValue(numberArray.charAt(i))) {
                case 0:
                    check = MagicNumber.checkPropertyZero(numberArray);
                    break;
                case 1:
                    check = MagicNumber.checkPropertyOne(numberArray);
                    break;
                case 2:
                    check = MagicNumber.checkPropertyTwo(numberArray);
                    break;
                case 3:
                    check = MagicNumber.checkPropertyThree(numberArray);
                    break;
                case 4:
                    check = MagicNumber.checkPropertyFour(numberArray);
                    break;
                case 5:
                    check = MagicNumber.checkPropertyFive(numberArray);
                    break;
                case 6:
                    check = MagicNumber.checkPropertySix(numberArray);
                    break;
                case 7:
                    check = MagicNumber.checkPropertySeven(numberArray);
                    break;
                case 8:
                    check = MagicNumber.checkPropertyEight(numberArray);
                    break;
                case 9:
                    check = MagicNumber.checkPropertyNine(numberArray);
                    break;
                default:
                    System.out.println("Only numbers accepted as input");
                    break;
            }
            if (check == false) {
                return false;
            }
        }
        return check;
    }

}
