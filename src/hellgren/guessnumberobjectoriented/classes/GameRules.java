package hellgren.guessnumberobjectoriented.classes;

public interface GameRules {  //This interface class is the template for game rule classes
    int getMinnr();   //method def required later
    int getMaxnr();   //method def required later
    Ruletype GetRuleType();  ///method def required later
    GuessReplyText replyToPlayerLastInput(Gamestatus status);  //method def required later

    default public String GetRuleTypeMessage() {  //define default method
        return GetRuleType()+" rules choosen."+" Min nr is "+ getMinnr() +", max nr is "+ getMaxnr() +".";}

    class Builder {  //define builder class
        private int minnr=0;  //0 is default
        private int maxnr=100;  //100 is default
        private Ruletype ruleTypetext= Ruletype.Simple; //Simple is default

        public Builder() {}  //Builder constructor
        public Builder minnr(int minnr) {this.minnr=minnr; return this;}
        public Builder maxnr(int maxnr) {this.maxnr=maxnr; return this;}
        public Builder ruleTypetext(Ruletype ruleTypetext) {this.ruleTypetext=ruleTypetext; return this; }
        public int getMinnr() {return this.minnr;}
        public int getMaxnr() { return this.maxnr;   }
        public Ruletype getRuleTypetext() {  return this.ruleTypetext;     }
    }

}
