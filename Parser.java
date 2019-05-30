import java.util.Scanner;
import java.util.*;
public abstract class Parser
{
    public ArrayList<String> getInput() 
    {
        ArrayList<String> words = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.nextLine();
        Scanner tokenizer = new Scanner(input);
        while( tokenizer.hasNext() ) {
            words.add(tokenizer.next());
            //System.out.println( tokenizer.next() );
        }
        System.out.println(words);
        return(words);
    }
}
