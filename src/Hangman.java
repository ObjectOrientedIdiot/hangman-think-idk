import java.util.ArrayList;

public class Hangman {

    String answer;
    char[] current;
    ArrayList<Character> guessedChars = new ArrayList<>();
    int guesses = 0;
    int guessLimit = 10;

    public void guess(char g){
        if(guessedChars.contains(g)){ //disallows duplicate guesses
            System.out.println("Duplicate guess");
            return;
        } else {
            guessedChars.add(g);
        }
        int cPos = answer.indexOf(g); //position of character
        if(cPos==-1){
            System.out.println("Wrong");
        } else {
            regGuess(g, -1);
        }
        guesses++;
        if(guesses >= guessLimit){
            //end game
        }
    }

    private void regGuess(char c, int start){//puts guessed char in current for display
        int currentPos = answer.indexOf(String.valueOf(c), start);
        if(currentPos != -1){
            current[currentPos] = c;
            regGuess(c, currentPos+1);
        }
    }

    public String toString(){
        return new String(current) + " / " + answer;
    }
    public Hangman(String word, int guessLimit){
        this.answer = word;
        this.current = new char[word.length()];
        this.guesses = 0;
        this.guessLimit = guessLimit;

        regGuess(' ', -1);
    }

}
