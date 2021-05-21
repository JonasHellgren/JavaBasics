package hellgren.memorygame.HMI;


import hellgren.memorygame.DataTypes.CardPos;
import hellgren.memorygame.GameManager.GameSetup;
import hellgren.memorygame.GameManager.GameStatus;

interface HMI {
    //definitions of following methods required later
    Boolean readnewgamePlayer();
    void informPlayerSetup(GameSetup setup);
    void showPlayfield(GameStatus status, GameSetup setup);
    Boolean nonfeasCardpos(CardPos pos, GameSetup setup);
}
