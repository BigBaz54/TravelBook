package eu.telecomnancy.travelBook;

import java.util.ArrayList;
import java.util.Collections;

public class DefaultShuffle implements ShuffleStrategy {
    public ArrayList<Card> shuffle(ArrayList<Card> deck) {
        Collections.shuffle(deck);
    System.out.println("DEFAULT");
        return deck;
    }
}

