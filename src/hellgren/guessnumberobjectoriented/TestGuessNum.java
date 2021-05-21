package hellgren.guessnumberobjectoriented;

import hellgren.guessnumberobjectoriented.classes.AdvancedGameRules;
import hellgren.guessnumberobjectoriented.classes.Gamestatus;
import hellgren.guessnumberobjectoriented.classes.GuessReplyText;
import hellgren.guessnumberobjectoriented.classes.Ruletype;
import hellgren.guessnumberobjectoriented.classes.SimpleGameRules;
import org.junit.Assert;
import org.junit.Test;


public class TestGuessNum {
    Gamestatus status=new Gamestatus(6);  //Correct guess 6
    SimpleGameRules.Builder sgbuilder=new SimpleGameRules.Builder();
    AdvancedGameRules.Builder agbuilder=new AdvancedGameRules.Builder();
    SimpleGameRules simplerules;
    AdvancedGameRules advancedrules;


    SimpleGameRules SetupSimpleRules () {
        sgbuilder.minnr(0).maxnr(10).ruleTypetext(Ruletype.Simple);  //utilize builder creation pattern
        simplerules= new SimpleGameRules(sgbuilder);
        return simplerules;
    }

    AdvancedGameRules SetupAdvancedRules () {
        agbuilder.minnr(0).maxnr(100).ruleTypetext(Ruletype.Simple);  //utilize builder creation pattern
        advancedrules= new AdvancedGameRules(agbuilder);
        return advancedrules;
    }

    @Test
    public void GuessReplyToNoPlayerInput() {
        simplerules=SetupSimpleRules();
        Assert.assertEquals(simplerules.replyToPlayerLastInput(status), GuessReplyText.Wrong);
    }

    @Test
    public void Maxnris10SimpleGame() {
        simplerules=SetupSimpleRules();
        Assert.assertEquals(simplerules.getMaxnr(),10);
    }

    @Test
    public void Maxnris100AdvancedGame() {
        advancedrules=SetupAdvancedRules();
        Assert.assertEquals(advancedrules.getMaxnr(),100);
    }

    @Test
    public void Lastguess4Correctguess6SimpleGame() {
    status.setLastguess(4);
    simplerules=SetupSimpleRules();
    Assert.assertEquals(simplerules.replyToPlayerLastInput(status),GuessReplyText.Wrong); }

    @Test
    public void Lastguess4Correctguess6AdvancedGame() {
        status.setLastguess(4);
        advancedrules=SetupAdvancedRules();
        Assert.assertEquals(advancedrules.replyToPlayerLastInput(status),GuessReplyText.ToLow); }


}
