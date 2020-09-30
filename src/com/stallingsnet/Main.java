package com.stallingsnet;

import java.util.Date;                  // Added to bring in the package Date (analogous to namespaces in C#
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
    }
}
