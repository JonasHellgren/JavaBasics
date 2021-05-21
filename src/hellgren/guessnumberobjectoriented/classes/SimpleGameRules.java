package hellgren.guessnumberobjectoriented.classes;

public class SimpleGameRules implements GameRules {
    final private int minnr;  //internal variable
    final private int maxnr;  //internal variable
    final private Ruletype ruletype;  //internal variable

    public  int getMinnr() {return minnr;}
    public int getMaxnr() {return maxnr;}
    public Ruletype GetRuleType() { return ruletype; }

    public SimpleGameRules(Builder builder)   //constructor
    {this.minnr=builder.getMinnr();
        this.maxnr=builder.getMaxnr();
        this.ruletype =builder.getRuleTypetext();  };

    public GuessReplyText replyToPlayerLastInput(Gamestatus status) {
        GuessReplyText replytxt;
        if (status.getLastguess()==status.getCorrectGuesses())
            replytxt=GuessReplyText.Correct;
        else
            replytxt=GuessReplyText.Wrong;

        return replytxt;
    }
}
