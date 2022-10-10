package at.ac.fhcampuswien;

import sun.jvm.hotspot.gc.shared.Space;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static void oneMonthCalendar(int iNumberOfDays, int iFirstDay) {
        int iDayPrintedCounter = 0;
        int iCounter = 1;

        for (int i = 1; i < iFirstDay; i++) {
            System.out.print("   ");
            iDayPrintedCounter++;
        }

        while (iCounter <= iNumberOfDays) {
            System.out.printf("%2d ", iCounter);
            iCounter++;
            iDayPrintedCounter++;
            if (iDayPrintedCounter%7 == 0) {
                System.out.println("");
            }
        }
        if (iDayPrintedCounter%7 != 0) {
            System.out.println("");
        }
    }

    public static long[] lcg(long lSeed) {
        long[] lReturnArray = new long[10];
        long a = 1103515245;
        long m = (long) Math.pow(2, 31);
        long c = 12345;
        for (int i = 0; i < lReturnArray.length; i++) {
            if (i == 0) {
                lReturnArray[i] = (a * lSeed + c) % m;
            }else {
                lReturnArray[i] = (a * lReturnArray[i-1] + c) % m;
            }
        }
        return lReturnArray;
    }

    public static void guessingGame(int numberToGuess) {
        int iGuessesLeft = 10;
        Scanner scanner = new Scanner(System.in);
        if (numberToGuess < 0 || numberToGuess > 100) {
            return;
        }

        while (true) {
            System.out.print("Guess number " + (11 - iGuessesLeft) + ": ");
            int userinput = scanner.nextInt();
            if (iGuessesLeft == 1) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                return;
            }
            if (userinput == numberToGuess) {
                System.out.print("You won wisenheimer!");
                System.out.println("");
                return;
            }else if (userinput > numberToGuess) {
                System.out.println("The number AI picked is lower than your guess.");
            }else {
                System.out.println("The number AI picked is higher than your guess.");
            }
            iGuessesLeft--;
        }
    }
    public static int randomNumberBetweenOneAndHundred() {
        Random random = new Random();
        return random.nextInt(99)+1;
    }

    public static boolean swapArrays(int[] iArray1, int[] iArray2) {
        int temp = 0;
        if (iArray1.length != iArray2.length) {
            return false;
        }
        for (int i = 0; i < iArray1.length; i++) {
            temp = iArray1[i];
            iArray1[i] = iArray2[i];
            iArray2[i] = temp;
        }
        return true;
    }

    public static String camelCase(String sText) {
        char[] cTextArray = sText.toCharArray();
        String sReturnText = "";
        String sTempText = "";

        //all small
        for (int i = 0; i < cTextArray.length; i++) {
            if (cTextArray[i] >= 65 && cTextArray[i] <= 90) {
                cTextArray[i] = (char) ((int)cTextArray[i] + 32);
                sTempText = sTempText + cTextArray[i];
            }else if (cTextArray[i] >= 97 && cTextArray[i] <= 122) {
                sTempText = sTempText + cTextArray[i];
            }else if (cTextArray[i] == 32) {
                sTempText = sTempText + cTextArray[i];
            }
        }

        cTextArray = sTempText.toCharArray();

        System.out.println(sTempText);
        //camelcase
        boolean bSpaceFlag = false;
        cTextArray[0] = (char)(int)(cTextArray[0] - 32);
        for (int i = 0; i < cTextArray.length; i++) {
            if (cTextArray[i] == 32) {
                bSpaceFlag = true;
                continue;
            }else if (bSpaceFlag) {
                cTextArray[i] = (char)((int)cTextArray[i] - 32);
                bSpaceFlag = false;
            }
            sReturnText = sReturnText + cTextArray[i];
        }
        return sReturnText;
    }

    public static int checkDigit(int[] iCode) {
        int[] iWeightedArray = new int[iCode.length];
        int iSum = 0;
        int iMod = 0;
        int iCheckSum = 0;
        for (int i = 0; i < iCode.length; i++) {
            iWeightedArray[i] = iCode[i] * (i + 2);
        }

        for (int temp : iWeightedArray) {
            iSum = iSum + temp;
        }
        iMod = iSum % 11;
        iCheckSum = 11 - iMod;

        if (iCheckSum == 10) {
            iCheckSum = 0;
        }else if (iCheckSum == 11) {
            iCheckSum = 5;
        }
        return iCheckSum;
    }
    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
        //oneMonthCalendar(31, 3);
        //long[] lRandomNumbers = lcg(0);
        //guessingGame(randomNumberBetweenOneAndHundred());
        //System.out.println(camelCase("My Name Isnt Alice"));
    }
}