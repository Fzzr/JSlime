package jslime.util;

public enum Elements implements Stats {
	LUNA("Luna"), FIRE("Fire"), EARTH ("Earth"), DARK ("Dark"), ICE ("Ice"), WIND ("Wind"), LIGHT ("Light");
	
	private String realName;
	
	private Elements (String realName){
		this.realName = realName;
	}//constructor
	
	public String getRealName(){
		return realName;
	}//getName
	
	public static Elements identifyElement (int number) throws UnknownTypeException {
		switch (number){
			case 0: return LUNA;
			case 1: return FIRE;
			case 2: return EARTH;
			case 3: return DARK;
			case 4: return ICE;
			case 5: return WIND;
			case 6: return LIGHT;
			default:throw new UnknownTypeException ("Element " + number + " does not match any known element.");
		}
	}//identifyElement (number)
	
	public static Elements identifyElement (String name) throws UnknownTypeException{
		if (name.toLowerCase().equals("luna"))
			return LUNA;
		else if (name.toLowerCase().equals("fire"))
			return FIRE;
		else if (name.toLowerCase().equals("earth"))
			return EARTH;
		else if (name.toLowerCase().equals("dark"))
			return DARK;
		else if (name.toLowerCase().equals("ice"))
			return ICE;
		else if (name.toLowerCase().equals("wind"))
			return WIND;
		else if (name.toLowerCase().equals("light"))
			return LIGHT;
		else 
			throw new UnknownTypeException ("Element " + name + " does not match any known element.");
	}//identifyElement (name)
}//Elements
