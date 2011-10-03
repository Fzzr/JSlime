package jslime.util;

@SuppressWarnings("serial")
public class InvalidStatsException extends Exception {
	public InvalidStatsException (){
		super();
	}//default constructor
	public InvalidStatsException (String message) {
		super (message);
	}//message constructor
}//InvalidStatsException