package _01_Spies_On_A_Train;

import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
	LinkedList<TrainCar> train;
	String[] clues;
    String findIntel(LinkedList<TrainCar> train, String[] clues) {
    	this.train=train;
    	this.clues=clues;
for(String s:clues) {
	System.out.println(s);
}
HashMap<String, Boolean> susMap = new HashMap<String, Boolean>();
//if a passenger's action matches a clue, add them to list as false.
//if they come up again, set them to true.
//if they come up a third time, report them.


Node<TrainCar> currentCar = train.getHead();
while(currentCar!=null) {
String testimony = currentCar.getValue().questionPassenger();
String[] splitTest = testimony.split("I saw ");
String usefulPart=splitTest[1];
String passengerSeen = usefulPart.split(" ")[0];
String passengerAction;

passengerAction=usefulPart.substring(passengerSeen.length()+1, usefulPart.length()-1);

System.out.println(testimony);
System.out.println(passengerSeen);
System.out.println(passengerAction);

if(isSus(passengerAction)) {
	if(!susMap.containsKey(passengerSeen)) {
		susMap.put(passengerSeen, false);
	} else {
		if(!susMap.get(passengerSeen)) {
			susMap.replace(passengerSeen, true);
		} else {
			//this passenger has 3 strikes
			//get em boys
			return(passengerSeen);
		}
	}
}

currentCar=currentCar.getNext();
}
        return "";

    }
boolean isSus(String clue) {
	for(String s:clues) {
		if(s.equals(clue)) {
			return true;
		}
	}
	return false;
}
}
