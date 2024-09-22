package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {
    
    /*
     * You are hosting a rainbow zombie conga dance party! Zombies are not very
     * smart(maybe that's why they crave brains) and need your help to direct
     * them through the choreography.
     * 
     * Each method is a dance move you will need to implement.
     * 
     * When you think you've gotten your zombies trained well enough you can
     * start the party by running the main method in RainbowZombieDanceParty and
     * typing how many rounds you want in the console to see if they followed
     * your choreography correctly.
     * 
     * Note: The party will always start with a rainbow brains and every 5
     * rounds the head and tail of the dance line will be removed.
     */

    private LinkedList<Zombie> congaLine;
    private ZombieHatColor[] zombieHats;

    public RainbowZombieCongaLine() {

        congaLine = new LinkedList<Zombie>();
        zombieHats = ZombieHatColor.values();

    }

    // Make the passed in zombie the first Zombie in the conga line!
    public void engine(Zombie dancer) {
    	Node<Zombie> next = new Node<Zombie>(dancer);
    	next.setNext(congaLine.getHead());
    	congaLine.setHead(next);
    }

    // Make the passed in zombie the last Zombie in the conga line!
    public void caboose(Zombie dancer) {
    	congaLine.add(dancer);
    }

    // Place the zombie at the designated position in the conga line!
    public void jumpInTheLine(Zombie dancer, int position) {
    	Node<Zombie> injection = new Node<Zombie>(dancer);
    	injection.setNext(congaLine.getHead());
    	//set inj to point next to head
    	//for int i loop runs amount of times equal to position
    	//i=0 no run
    	for(int i = position;i>0;i--) {
    		injection.setPrev(injection.getNext());
    		injection.setNext(injection.getNext().getNext());
    	}
    	//in the loop: point next to the current pointnext's next
    	//now clean it up
    	injection.getPrev().setNext(injection);
    	injection.getNext().setPrev(injection);
    
    }

    /*
     * Remove all zombies with the same hat color as the passed in zombie from
     * the conga line!
     */
    public void everyoneOut(Zombie dancer) {
    	Node<Zombie> checkee = congaLine.getHead();
    	for(int i = 0; i<congaLine.size();i++) {
    		if(dancer.getZombieHatColor()==checkee.getValue().getZombieHatColor()) {
    			congaLine.remove(i);
    		}
    		checkee=checkee.getNext();
    	}
    }

    /*
     * Remove the first zombie with the same hat color as the passed in zombie
     * from the conga line!
     */
    public void youAreDone(Zombie dancer) {
    	Node<Zombie> checkee = congaLine.getHead();
    	boolean done = false;
    	int i = 0;
    	while(!done) {
    		if(dancer.getZombieHatColor()==checkee.getValue().getZombieHatColor()) {
    			congaLine.remove(i);
    			done=true;
    		} else {
    			i++;
    			checkee=checkee.getNext();
    		}
    	}
    }

    /*
     * Make two more zombies with the same hat color as the passed in zombie and
     * add one to the front, one to the end and one in the middle.
     */
    public void brains(Zombie dancer) {
    	jumpInTheLine(dancer,congaLine.size()/2);
    	engine(dancer);
    	caboose(dancer);
    }

    /*
     * Add the passed in zombie to the front and then add one zombie of each hat
     * color to the end of the line.
     */
    public void rainbowBrains(Zombie dancer) {
    	engine(dancer);
    	Zombie[] pack = new Zombie[7];
    	int i = 0;
    	for (ZombieHatColor z: ZombieHatColor.values()) {
    		pack[i]=new Zombie(z);
    		i++;
    	}
    	for(Zombie z: pack) {
    		caboose(z);
    	}
    }

    public LinkedList<Zombie> getCongaLine() {
        return congaLine;
    }
}
