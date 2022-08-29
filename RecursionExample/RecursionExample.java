

/**
 * Examples of recursive methods / routines including calculating the 'power' of a number, a binary search and a 'mystery' method.
 */
public class RecursionExample
{
    // an array of numbers to use in a binary search example
    public int[] numbers = {3,12,18,19,23,26,27,33,35,37};

    /**
     * Default constructor
     */
    public RecursionExample()
    { 
    }   
    
    /**
     * The main() method
     */
    public static void main(String []args)
    {
        // create instance of recursion example object
        RecursionExample test = new RecursionExample();
        
        // call mystery method
        System.out.println("Result of calling mystery method with a value of 3: " + test.doSomethingRecursive(3));
        
        // display value of 2 cubed (e.g. 2 to the power of 3) with a non-recursive method
        System.out.println("Result of 3 to the power of 4 (not recursively) is: " + test.nonRecursivePower(3, 4));
        
        // display value of 2 cubed (e.g. 2 to the power of 3) with a recursive method
        System.out.println("Result of 3 to the power of 4 (recursively) is: " + test.recursivePower(3, 4));
        
        // display number of times that the character 'e' appears in the string "Hello there" st2rt3ng from the beginning of the string (position zero)
        System.out.println("The letter 'e' appears in the string 'Hello there' " + test.getCharCount('e', "Hello there", 0) + " times.");
        
        // display whether the number '23' appears in an array of numbers held by this class
        System.out.println("The number '23' appears in the array of numbers? : " + test.binarySearch(23, 0, test.getLength()-1));
        
        // display whether the number '17' appears in an array of numbers held by this class
        System.out.println("The number '17' appears in the array of numbers? : " + test.binarySearch(17, 0, test.getLength()-1));
        
    }  
    
    /**
     * Get length of array which contains numbers
     * 
     * @return The length of the 'numbers' array
     */
    public int getLength()
    {
        return numbers.length;
    }

    /**
     * A mystery method - can you figure out what it does?
     */
    public int doSomethingRecursive(int x)
    {
        if (x > 0)
        {
            return (x * (doSomethingRecursive(x - 1)));
        }
        return 1;
    }

    /**
     * Calculate the 'power' of a number, e.g. 'x' to the power of 'n'. Example, 2 to the power of 3 is 2 cubed.
     * 
     * @param x The number to calculate the power of
     * @param n The power to raise it to
     * 
     * @return The result of the power calculation
     */
    public int nonRecursivePower(int x, int n)
    {   
        int result = 1; // if the 'power' / n is '0' the result will be 1

        // for each level of power to raise the number by
        for (int i = 0; i <n; i++)
        {
            // incrementally increase the value of the result by multiplying it by the the number provided 
            result = result * x;
        }

        // return the result
        return(result);
    }

    /**
     * Calcuate the 'power' of a number using a recursive algorithm, e.g. 'x' to the power of 'n'. Example, 2 to the power of 3 is 2 cubed.
     * 
     * @param x The number to calculate the power of
     * @param n The power to raise it to
     * 
     * @return The (interim) result of the power calculation
     */
    public int recursivePower(int x, int n)
    {   
        // if we haven't yet recursed enough times through the power to raise the number by
        if (n > 0)
        { 
            // return the result of multiplying the number with the result of calling the same method again recursively
            int temp = recursivePower(x, n - 1);
            return x * temp;
            
            // return x * recursivePower(x, n - 1);
        }

        // the last step of the recursive process, return a value of 1 
        return 1;
    }

    /**
     * Return the number of occurrences that a given 'char' appears in a given String using a recursive algorithm
     * 
     * @param target The target char to look for
     * @param aString The string to look in
     * @param index The current position reached in the string so far
     * 
     * @return The number of occurrences of the given char in the given string
     */
    public int getCharCount(char target, String aString, int index)
    {
        // if the index position is still within the bounds of the string
        if ((aString.length()) > index) 
        {
            // if the char at the current position in the string is the same as the target char
            if ((aString.charAt(index)) == target)
            {  
                // add 1 to the count of occurrences found:
                // return the result of adding 1 to the count of occurrences found in the remainder of the string
                return 1 + getCharCount(target, aString, ++index);
            }
            else
            {   
                // add zero to the count of occurrences found:
                // return the count of occurrences found in the remainder of the string
                return getCharCount(target, aString, ++index); 
            }
        }

        // end of string reached, no more chars to check, add zero to the count of occurrences (by returning a result of zero)
        return 0;

    }

    /**
     * Search for a given number within an array of numbers using a recursive binary search algorithm
     * 
     * @param searchNum The number to search for
     * @param min The lower bound of index positions in the array to look within
     * @param max The upper bound of index positions in the array to look within
     * 
     * @return True if the number is found, otherwise false
     */
    public boolean binarySearch(int searchNum, int min, int max)
    {
        // used to store the midpoint of index positions in the array to look within
        int middle;
        
        // if the lower bound to look within is still less than the upper bound
        if (min < max) 
        {
            // calculate the mid point between the current lower and upper bound
            middle = (min + max) / 2;
            
            // if the number being sought has a value greater than the number which is at the midpoint of positions to look within
            if (searchNum > numbers[middle])
            {
                // repeat the search on the upper half of the positions currently being examined 
                return binarySearch(searchNum, ++middle, max);
            }
            else
            {                
                // repeat the search on the upper half of the positions currently being examined 
                return binarySearch(searchNum, min, middle);
            }
        }

        // we reach this point when the lower bound of the positions to look within is no longer less than the upper bound,
        // there is only one final position to check
        
        // if the number being sought has a value greater which is equal to the number which is at the last remaining position to check
        if (numbers[min] == searchNum)  
            return true;
        else
            return false;
    }
}
