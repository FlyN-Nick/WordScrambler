import java.util.Scanner;
import java.util.Random;
import java.util.*;
public class Scrambler extends Parser
{
    ArrayList<String> originalWords = new ArrayList<String>();
    ArrayList<String> scrambledWords = new ArrayList<String>();
    boolean firstTime = true;
    Random rand = new Random();
    //https://www.geeksforgeeks.org/randomly-select-items-from-a-list-in-java/
    public Scrambler()
    {
        startGame();
    }
    public void startGame()
    {
       originalWords = getInput();
       randomizeWordOrder();
    }
    public void randomizeWordOrder() // this function randomizes the word order of the words inputed
    {
        ArrayList<Integer> possibleNumbers = new ArrayList<Integer>();
        ArrayList<Integer> randomizedNumbers = new ArrayList<Integer>();
        for (int a = 0; a < originalWords.toArray().length; a++)
        {
            possibleNumbers.add(a);
        }
        Random random = new Random();
        //System.out.println("original possible numbers: " + possibleNumbers);
        /*for (int cd = 0; cd < possibleNumbers.toArray().length; cd++)*/while(possibleNumbers.toArray().length !=0)
        {
            int randomIndex = random.nextInt(possibleNumbers.toArray().length);
            randomizedNumbers.add(possibleNumbers.get(randomIndex));
            // currently the issue is with removing the random Index
            possibleNumbers.remove(randomIndex);
            //System.out.println("random number: " + randomIndex + "possibleNumbers: " + possibleNumbers);
        }
        //System.out.println(randomizedNumbers);
        ArrayList<String> stringWithRandomizedWordOrder = new ArrayList<String>();
        int arrayLength = randomizedNumbers.toArray().length;
        for (int bc = 0; bc < arrayLength; bc++)
        {
            stringWithRandomizedWordOrder.add(originalWords.get(randomizedNumbers.get(bc)));
        }
        originalWords = stringWithRandomizedWordOrder;
        scrambleWords(stringWithRandomizedWordOrder);
    }
    public void scrambleWords(ArrayList<String> theString) // will scramble each of the words
    {
        ArrayList<String> completelyRandomizedString = new ArrayList<String>();
        Random random = new Random();
        for (int index = 0; index < theString.toArray().length; index++)
        {
            String word = theString.get(index);
            char[] wordArray = word.toCharArray();
            String randomizedWord = new String();
            ArrayList<Integer> possibleNumbers = new ArrayList<Integer>();
            ArrayList<Integer> randomizedNumbers = new ArrayList<Integer>();
            for (int a = 0; a < wordArray.length; a++)
            {
                possibleNumbers.add(a);
            }
            while(possibleNumbers.toArray().length != 0)
            {
                int randomIndex = random.nextInt(possibleNumbers.toArray().length);
                randomizedNumbers.add(possibleNumbers.get(randomIndex));
                possibleNumbers.remove(randomIndex);
            }
            int arrayLength = randomizedNumbers.toArray().length;
            for (int ac = 0; ac < arrayLength; ac++)
            {
                randomizedWord += wordArray[randomizedNumbers.get(ac)];
            }
            completelyRandomizedString.add(randomizedWord);
        }
        guessingTime(completelyRandomizedString);
    }
    public void guessingTime(ArrayList<String> theString)
    {
        System.out.println("Here is the scrambled string:" + theString);
        System.out.println("Time to descramble. Good luck!");
        ArrayList<String> words = getInput();
        if(words == originalWords)
        {
            System.out.println("Nice job unscrambling!");
        }
        else
        {
            System.out.println("Not quite, the actual unscramble was " +  originalWords + "." + "\nYou thought the unscramble was       " + words + ".");
        }
    }
    public ArrayList<String> getInput() 
    {
        if (firstTime)
        {
            firstTime = false;
            System.out.println("Welcome to the word scrambler game. \nHere, you will input a sentence, and the word order and letter order within words will be randomized. \nSomeone else will then have to descramble to sentence. \nHave fun!");
        }
        ArrayList<String> words = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.nextLine();
        Scanner tokenizer = new Scanner(input);
        while( tokenizer.hasNext() ) {
            words.add(tokenizer.next());
        }
        return(words);
    }
    public ArrayList<String> parser(String input)
    {
        ArrayList<String> words = new ArrayList<String>();
        Scanner tokenizer = new Scanner(input);
        while( tokenizer.hasNext() ) 
        {
            words.add(tokenizer.next());
        }
        return(words);
    }
}
