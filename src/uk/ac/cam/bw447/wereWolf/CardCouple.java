package uk.ac.cam.bw447.wereWolf;

import uk.ac.cam.bw447.wereWolf.cards.CpMn;
import uk.ac.cam.bw447.wereWolf.cards.DkZz;
import uk.ac.cam.bw447.wereWolf.cards.Lh;
import uk.ac.cam.bw447.wereWolf.cards.YuYjJw;

public class CardCouple implements Card{
    Card firstCard;
    Card secondCard;

    CardCouple(Card firstCard,Card secondCard){
        this.firstCard = firstCard;
        this.secondCard = secondCard;
    }


    @Override
    public String getName() {
        return String.format("\t%s\t\t%s %n",this.firstCard.getName(),this.secondCard.getName());
    }

    public boolean isBothWolfAndPolice(){
        return (firstCard instanceof YuYjJw && secondCard instanceof Lh) ||
                (firstCard instanceof Lh && secondCard instanceof YuYjJw);
    }

    public boolean isGolden(){
        return (firstCard instanceof CpMn && secondCard instanceof CpMn)||
                (firstCard instanceof CpMn && secondCard instanceof DkZz)||
                (firstCard instanceof DkZz && secondCard instanceof CpMn);
    }
}
