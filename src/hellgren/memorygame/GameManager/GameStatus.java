package hellgren.memorygame.GameManager;


import hellgren.memorygame.DataTypes.Card;
import hellgren.memorygame.DataTypes.CardPos;

import java.util.*;

public class GameStatus {

    public Set<Card> foundCards = new HashSet<>();  //the set of cards founds by the player
    private int nofMoves=0;
    public List<Integer> keysofPlayerchosenPos =new ArrayList<>();  //hash numbers of chosen cards
    private Map<Integer, Card> playField = new HashMap<>();  // Creating HashMap for playfield

    public GameStatus () {};  //constructor

    public int getNofFoundCards() {     return foundCards.size();   }
    public List<Integer> getKeysofPlayerchosenPos() {   return keysofPlayerchosenPos;   }
    public int getNofMoves() {     return nofMoves;   }
    public Map<Integer, Card> getPlayField() {      return playField;   }
    public void setNofMoves(int nofMoves) {     this.nofMoves = nofMoves;     }
    public Card getCardAtPos(CardPos pos) { //returns the card at position pos
        Integer keypos=GameManager.getKeypos(pos); //call static function in super class
        return playField.get(keypos);
    }
}
