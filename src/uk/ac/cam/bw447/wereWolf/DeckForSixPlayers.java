package uk.ac.cam.bw447.wereWolf;


import uk.ac.cam.bw447.wereWolf.cards.*;

import java.util.*;
import java.util.stream.Collectors;

public final class DeckForSixPlayers implements Deck{
    Card[] availableCards = new Card[]{
            new CpMn(),
            new CpMn(),
            new CpMn(),
            new CpMn(),
            new CpMn(),//5 民
            new YuYjJw(),
            new NyWu(),
            new LxRf(),
            new UbWz(),//预女猎守
            new LhRf(),//普通狼
            new YnLh(),//隐狼
            new DkZz(), //盗贼
    };


    @Override
    public int getCardNumber() {
        return 12;
    }

    @Override
    public int getPlayerNum() {
        return 6;
    }

    @Override
    public ArrangementForSixPlayers arrangeCard() {
        Map<Integer,Double> randomMap = new HashMap<>();
        for (int i=0;i<12;i++){
            randomMap.put(i,Math.random());
        }

        List<Card> cardList = randomMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).map((Integer n) -> availableCards[n]).collect(Collectors.toList());
        List<CardCouple> cardCouples = new LinkedList<>();
        for (int i=0;i<6;i++){
            cardCouples.add(new CardCouple(cardList.get(i),cardList.get(i+6)));
        }
        return new ArrangementForSixPlayers(cardCouples);
    }

}
