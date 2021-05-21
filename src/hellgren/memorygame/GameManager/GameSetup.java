package hellgren.memorygame.GameManager;

import hellgren.memorygame.DataTypes.Card;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class GameSetup {
    private SortedSet<Card> cardsUsed = new TreeSet<>();	//The cards used, subset of cardTypes according to play field size
    private int nRows=2;	//	Number of rows of play field
    private int nCols=3;	//	Number of columns of play field

    GameSetup () {setCardsUsed();};  //constructor

    public void setCardsUsed() throws RuntimeException {
        //This method creates set cardsUsed of type enum Card

        if (nRows * nCols % 2  != 0)  //set exception?
            throw new RuntimeException("Incorrect combination of nRows and nCols");

        SortedSet<Card> allct = new TreeSet<>();  //Gross set of cards
        Collections.addAll(allct, Card.values());

        for (int i = 0; i < nRows * nCols / 2; i++) {
            Card card = allct.first();        cardsUsed.add(card);
            allct.remove(card);  //remove from set so not added again to cardsUsed
        }
    }

    public int getnRows() {  return nRows;   }
    public int getnCols() {  return nCols;   }
    public SortedSet<Card> getCardsUsed() {     return cardsUsed; }
}



