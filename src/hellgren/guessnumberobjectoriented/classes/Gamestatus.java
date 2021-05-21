package hellgren.guessnumberobjectoriented.classes;

public class Gamestatus {
    private int correctGuess;  //The randomly generated correct guess
    private int nofguesses;  //The number of guesses
    private int lastguess;  //The last guess, i.e. user input

    public Gamestatus(int correctGuesses) {
        this.nofguesses = 0; this.lastguess = -1;  this.correctGuess = correctGuesses;    }
    public void setNofguesses(int nofguesses) {     this.nofguesses = nofguesses;    }
    public void setLastguess(int lastguess) {       this.lastguess = lastguess;     }
    public int getNofguesses() {      return nofguesses;    }
    public int getLastguess() {    return lastguess;   }
    public int getCorrectGuesses() {     return correctGuess;    }
}
