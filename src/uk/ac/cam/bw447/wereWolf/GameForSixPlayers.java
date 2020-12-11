package uk.ac.cam.bw447.wereWolf;

public class GameForSixPlayers  {

    static public Arrangement start() {
        Deck deck = new DeckForSixPlayers();
        return deck.arrangeCard();
    }
}
