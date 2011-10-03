package jslime;

public class Player extends Unit {
    private int[] flags = new int[10];

    public Player () {
        super (100);
        for (int i = 0; i < 10; i++)
        	flags[i] = 0;
    }//constructor
    
}//Player
