package com.stallingsnet;

import java.awt.*;
import java.util.Arrays;
import java.util.Date;                  // Added to bring in the package Date (analogous to namespaces in C#
import java.util.DoubleSummaryStatistics;
// In order to use another package in the package you're already inside of (com.stallingsnet)
                                        // You use the import keyword instead of re-using package

public class Main {

    public static void main(String[] args) {
	// Integer Variable Declaration
        int myAge = 36;         // By using a comma, multiple variables can be declared/instantiated
                               // on the SAME line in Java.. However not recommended.
        myAge = 32;               // reassign variable after it's initialization
        int herAge = myAge;      // variables can be assigned to other variables, value type is copied in this instance
        System.out.println(myAge);

        // Java uses two categories of types: Primitives and Non-Primitive (References)
        // Primitives store by value. References store by Reference i.e. complex objects

        /* PRIMITIVE TYPES */
        /* See:  https://www.geeksforgeeks.org/data-types-in-java/  */
        /* Byte, Short, Int, Long, Float, Double, Char, Boolean */
        // For large integers you can make the source code more readable by separating groups of 3 digits with an underscore
        int bigNum = 328_902_484;
        // For Long's you have to add a suffix L to end of number.. Similar to F suffixed for C# floats
        long futureNetWorth = 2_268_400_300L;
        // Floats Same as C#
        float price = 10.99F;
        // Characters: Same as in C#, Surround with single quotes
        char letter = 'D';
        // Boolean
        boolean isBrilliant = true;

        /* REFERENCE TYPES */
        // Similar to C#. Memory must be allocated (new keyword) explicitly at time of object instantiation
        Date now = new Date();
        // After instantiating your object. You can access the base classes members via the dot (.) operator
        System.out.println(now);

        Point point1 = new Point(1, 1);         // When you assign a reference type to a variable, what you're
        Point point2 = point1;                        // actually doing is storing the value of the location in memory of the
        point2.x = 3;                                 // object. (i.e. 10x8..some hexdec shit). So the variable 'points' to the object instead
                                                      // of actually holding it's values like a primitive variable will

        System.out.println(point2);
        System.out.println(point1);

        /* STRINGS */
        /* Strings are reference types in Java (not primitives like in Javascript) */
        String message = "Hey what's up" + "!!?";            // Shorthand for (String message = new String("Hey what's up"); Regular concatenation + can be used.
        Character answer = message.charAt(2);                // Because String is a reference type, you have a ton of methods that
        System.out.println(answer);                          // come available with the class
        System.out.println("Length of message:" + message.length());       // many useful methods on the String class
        String replaced = message.replace("!", "*");    // replace method taking two params (old char and new)
        String escaped = new String("C:\\Windows\\Filename\\File(\"name\")");       // Escape sequence similar to most to escape characters
        System.out.println("replaced string: " + replaced);

        /* ARRAYS */
        /* Seemingly arrays in Java work almost exactly like C# */
        // Declaring a new array. declare type of array (integers in example below).
        // use open close brackets for array, allocate new memory for ref type with new keyword
        // repeat type of new array being created. insert number of elements in new array brackets.
        // As in C# Arrays are immutable

        int[] numbers = new int[5];             // instantiates new 5-element integer array
        numbers[0] = 10;
        numbers[1] = 15;
        numbers[2] = 20;                        // ex assigning elements after creation
        numbers[3] = 30;                        // leaving out last member will be initialized to a zero by runtime

        int[] numbersNew = { 5, 18, 29, 30, 45 };       // Modern syntax to assign array elements at creation
        System.out.println(numbers);                    // Trying to print an array like this is going to return a
        Arrays.sort(numbersNew);                        // string representation of the memory address of the array,
                                                        // [e.g. 8adSD@70] and not the elements as expected

        System.out.println("Array 1: " + Arrays.toString(numbers));             // This will return the string representation of the array like expected.
        System.out.println("Array 2: " + Arrays.toString(numbersNew));

        /* MULTI-DIMENSIONAL ARRAYS */

        int[][] numberMatrix = new int[2][3];                                               // Initializes an empty array with 2 Rows and 3 Columns
        numberMatrix[0][2] = 86;                                                            // Sets element at row 1, column 3
        System.out.println("Multi-Dim Array: " + Arrays.deepToString(numberMatrix));        // For multi-dimension arrays you use Deep-ToString to deep-copy-output the elements
        int[][] modernMatrix = { { 1, 2, 3 }, { 10, 20, 30 } };                             // Modern syntax to set elements of multi-dim arr at initialization

        /* Constants */
        /* 'Final' keyword - Convention is to use all uppercase letters for name */
        float pi = 3.142F;                  // Regular declaration that can later be changed
        final float CONSTPI = 3.141F;       // Locked constant with 'final' keyword
        pi = 33;                            // pi now is 33
        //CONSTPI = 99;                     // Will not compile

        /* ARITHMETIC OPERATORS */
        /* Basically same as C# and Others */
        // Specific formats and precision can be obtained by casting the operands shown below
        double answer2 = (double)10 / (double)3;
        System.out.println("casted division answer: " + answer2);
        // Increment & Decrement operators same as other langs
        answer2++ ;
        // NOTE: When inc/dec the right side of assignment .. prefix or postfix matter.
        int x = 1;
        int y = ++x;        // Yields 2 because value of x is inc'd before copy to Y
        //int y = x++;      // Yields 1 because value of x is copied before inc'ing
        System.out.println("Incremented answer: " + answer2);
        // Compound assignment operator: += or -= or /= or *= , etc
        int z = 1;
        z += 3;                 // 4

        /* CASTING */
        // IMPLICIT CASTING: Compiler makes use of an anonymous variable
        // to copy the smaller/up-castable value into to then do whatever is required
        // with the larger down-castable value. Take the example directly below. short upcast to int
        short g = 1;            // Flow of Implicit casting: byte > short > int > long > float > double
        int h = 3;              // No chance of data loss in implicit casting
        int i = h + g;          // 1 is stored in anonymous variable of type int to then be added to int h
        /* EXPLICIT CASTING: ("down-casting") Converting a type with less information capacity to one that has a larger capacity */
        // Must use parenthesis with type casting to. Compiler can't do it implicitly
        // Example below double < int
        double j = 42.11;
        int k = 14;
        // int answer3 = j + k; (won't compile)       // If you want to return an integer from arithmetic with a double involved.
        int answer3 = (int)j + k;                     // You must explicitly cast the double
        System.out.println("Casted Answer3: " + answer3);           // Compiler rounds down value of double when explicitly directed to cast

        /* EXOTIC CASTING */
        /* Java provides special 'wrapper' classes to cast incompatible types like string to int. */
        // Using Integer wrapper to convert string to integer
        // Especially useful when having to convert json numbers that arrive as strings to integers
        String jsonNum = "487";
        int dq = Integer.parseInt(jsonNum);
        System.out.println("Integer-casted string \"487\" :" + dq);
        String jsonNumDec = "53.11";
        double castedJson = Double.parseDouble(jsonNumDec);
        System.out.println("Casted json decimal \"53.11\" : " + castedJson );

        /* JAVA MATH CLASS */
        int mathd1 = Math.round(1.5F);          // 2
        System.out.println("Math.Round of 1.5 to int: " + mathd1);
        int resultCeil = (int)Math.ceil(4.18);                                 //5     // Ceiling (ceil) returns the SMALLEST integer that is GREATER than or equal to the input double number
        System.out.println("int-casted result of math.ceil: " + resultCeil);       // In this example to have result of int we must cast the right side to int (expects double)
        int resultFloor = (int)Math.floor(4.18);                                //4     // Floor (floor) returns the smallest integer that LESS than or equal to the input double. must also cast right side
        System.out.println("int-casted result of math.floor: " + resultFloor);
        int greaterOfVals = Math.max(14,88);                                    //88    // Returns the greater of the two input values. Multiple overloads for diff primitive types
        System.out.println("Greater of 14, 88 (math.max): " + greaterOfVals);
        // Also of course Math.min() with many overloads for the smallest of two values input
        double randomResult = Math.random();            // Returns a random number between 0 and 1, similar to javascript save for strong typing
        // You can string methods
        int randomMain = (int)Math.round(Math.random() * 100);        // Returns a rounded number between 1 and 100 after casting for int
        System.out.println("Rounded Random: " + randomMain);
    }
}
