package com.example.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create Scanner object for input
        Scanner scnnr = new Scanner(System.in);

        // Create EXIT boolean
        boolean exit = false;

        // INTRO
        String intro = "This is a complexer calculator.";
        System.out.println(intro);
        System.out.print("  ");
        for (int i = 0; i < intro.length()-4; i++) {
            System.out.print("-");
        }
        System.out.println("  ");
        String intro2 = "Here, you can add, subtract, multiply, or divide using two numbers.";
        System.out.println(intro2);
        System.out.print("  ");
        for (int i = 0; i < intro2.length()-4; i++) {
            System.out.print("-");
        }
        System.out.println("  ");

        while(!exit)
        {

            // GET FIRST NUMBER
            System.out.print("Enter the first number: ");
            double firstNum = getDoubleInput();

            // GET OPERATOR
            System.out.print("Enter the operator that you would like to use ( +  ,  -  ,  *  ,  or   /  ): ");
            String operator = "";
            boolean tryAgain = false;
            do {
                try {
                    operator = scnnr.nextLine();
                    if ( ! (operator.equals("+") ||
                            operator.equals("-") ||
                            operator.equals("*") ||
                            operator.equals("/")
                    )) {
                        throw new Exception();
                    } else {
                        tryAgain = false;
                    }
                } catch (Exception e) {
                    System.out.print("You have not inputted a correct operator. Try again: ");
                    tryAgain = true;
                }
            } while (tryAgain);

            // GET SECOND NUMBER
            System.out.print("Enter the second number: ");
            double secondNum = getDoubleInput();

            // CALCULATE RESULT
            double result = 0;
            switch(operator) {
                case("+"):
                    result = firstNum + secondNum;
                    break;
                case("-"):
                    result = firstNum - secondNum;
                    break;
                case("*"):
                    result = firstNum * secondNum;
                    break;
                case("/"):
                    result = firstNum / secondNum;
                    break;
            }

            // DISPLAY RESULT
            System.out.println("\nThe result is " + result);

            // GO AGAIN
            System.out.print("Input any key[s] to do another calculation, or input 'Exit' to exit: ");
            String exitOrNo = scnnr.nextLine();
            if (exitOrNo.equals("Exit")) {
                exit = true; }

        }
    }

    static double getDoubleInput()
    {
        Scanner scnnr = new Scanner(System.in);
        double num = 0;
        boolean tryAgain = false;
        do {
            try {
                num = Double.parseDouble(scnnr.nextLine());
                tryAgain = false;
            } catch (NumberFormatException e) {
                System.out.print("You have not inputted a number. Try again: ");
                tryAgain = true;
            }
        } while (tryAgain);

        return num;
    }
}