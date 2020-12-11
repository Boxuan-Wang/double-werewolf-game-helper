package uk.ac.cam.bw447.wereWolf;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrangementForSixPlayers implements Arrangement{

    List<CardCouple> arrangement;

    ArrangementForSixPlayers(List<CardCouple> list){
        this.arrangement = list;
    }

    @Override
    public boolean checkLegal(){
        boolean NoPoliceAndWolfIllegal = true;
        boolean foundGolden = false;
        for (CardCouple cp : arrangement){
            if (cp.isGolden()){
                foundGolden = true;
            }
            if (cp.isBothWolfAndPolice()){
                NoPoliceAndWolfIllegal = false;
                break;
            }
        }
        return NoPoliceAndWolfIllegal && foundGolden;
    }

    @Override
    public String toString() {
        List<String> listOfName = arrangement.stream().map(CardCouple::getName).collect(Collectors.toList());
        List<String> listOfIndexedName = new LinkedList<>();
        //listOfIndexedName.add("\t\t\t第一身份\t\t第二身份\n");
        for (int i=0;i<listOfName.size();i++){
            listOfIndexedName.add(String.format("%d号： %s", i+1, listOfName.get(i)));
        }
        return String.join("\n",listOfIndexedName);
    }
}
