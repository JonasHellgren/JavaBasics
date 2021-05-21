package hellgren.guessnumberobjectoriented.classes;

public class AdvancedGameRules implements GameRules {
    final private int minnr;  //internal variable
    final private int maxnr;  //internal variable
    final private Ruletype ruletype;  //internal variable

    public  int getMinnr() {return minnr;}
    public int getMaxnr() {return maxnr;}
    public Ruletype GetRuleType() { return ruletype; }

    public AdvancedGameRules(Builder builder)   //constructor
    {
        this.minnr=builder.getMinnr();
        this.maxnr=builder.getMaxnr();
        this.ruletype =builder.getRuleTypetext();  };

    public GuessReplyText replyToPlayerLastInput(Gamestatus status) {
        GuessReplyText replytxt= GuessReplyText.Wrong;
        if (status.getLastguess()==status.getCorrectGuesses())
            replytxt= GuessReplyText.Correct;
        else if (status.getLastguess()<status.getCorrectGuesses())
            replytxt= GuessReplyText.ToLow;
        else if (status.getLastguess()>status.getCorrectGuesses())
            replytxt= GuessReplyText.ToHigh;

        return replytxt;
    }
}