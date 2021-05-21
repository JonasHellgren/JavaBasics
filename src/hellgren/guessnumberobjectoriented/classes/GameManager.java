package hellgren.guessnumberobjectoriented.classes;
/**
 * This class is a container for game status and gamerules. It constructs and updates games.
 */


public class GameManager {
    public Gamestatus status;
    public GameRules rules;

    public GameManager(Ruletype ruletype)  {   //constructor, creating rules and status

        if (ruletype.equals(Ruletype.Simple))
        { SimpleGameRules.Builder builder=new SimpleGameRules.Builder();
        builder.minnr(0).maxnr(10).ruleTypetext(Ruletype.Simple);  //utilize builder creation pattern
        rules= new SimpleGameRules(builder);}
        else
        { AdvancedGameRules.Builder builder=new AdvancedGameRules.Builder();
        builder.maxnr(100).ruleTypetext(Ruletype.Advanced);  //utilize builder creation pattern, min default (0) used
        rules= new AdvancedGameRules(builder); }

        int correctnr = (int) (Math.random()*rules.getMaxnr());
        status=new Gamestatus(correctnr);
    }

    //This functions updates status according to player input
    public void updateStatus(String input)  {
        status.setNofguesses(status.getNofguesses()+1);
        status.setLastguess(Integer.parseInt(input));
    }
}
