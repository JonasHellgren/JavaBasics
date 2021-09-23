package codinghomework.rock_paper_scissor;

public class Game extends GameItems {
    private final Player player;
    private final Computer computer;
    private CHOICES playerChoice;
    private CHOICES computerChoice;
    private RESULT result;

    public Game() {
        player=new Player();
        computer=new Computer();

    }

    public void play() {
        playerChoice=player.getChoice();
        computerChoice=computer.getChoice();
        result=getResult();
        displayResults();
    }

    public RESULT getResult() {

        if (playerChoice==computerChoice)
            return RESULT.TIE;

        return switch (playerChoice) {
            case ROCK -> (computerChoice == CHOICES.SCISSOR ? RESULT.WIN : RESULT.LOSE);
            case PAPER -> (computerChoice == CHOICES.ROCK ? RESULT.WIN : RESULT.LOSE);
            case SCISSOR -> (computerChoice == CHOICES.PAPER ? RESULT.WIN : RESULT.LOSE);
        };

    }

    public void displayResults() {

        switch (result) {
            case WIN -> System.out.println(playerChoice + " beats " + computerChoice + ". Player wins.");
            case LOSE -> System.out.println(playerChoice + " loses to " + computerChoice + ". Computer wins.");
            case TIE -> System.out.println(playerChoice + " equals to " + computerChoice + ". It is a tie.");
        }
    }





}
