package jslime.util;

public enum Weapons implements Stats {
	SWORD ("Sword"), 
	MAUL ("Maul"), 
	LANCE ("Lance"), 
	CHAKRAM ("Chakram"), 
	SLING ("Sling"), 
	GUN ("Gun");
	
	private String realName;
	
	private Weapons(String realName){
		this.realName = realName;
	}//constructor
	
	public String getRealName(){
		return realName;
	}//getName
	
	public static Weapons identifyWeapon (int number) throws UnknownTypeException {
		switch (number){
			case 0: return SWORD;
			case 1: return MAUL;
			case 2: return LANCE;
			case 3: return CHAKRAM;
			case 4: return SLING;
			case 5: return GUN;
			default:throw new UnknownTypeException ("Weapon " + number + " does not match any known weapon.");
		}
	}//identifyElement (number)

	public static Weapons identifyWeapon(String name) throws UnknownTypeException {
		if (name.toLowerCase().equals("sword"))
			return SWORD;
		else if (name.toLowerCase().equals("maul"))
			return MAUL;
		else if (name.toLowerCase().equals("lance"))
			return LANCE;
		else if (name.toLowerCase().equals("chakram"))
			return CHAKRAM;
		else if (name.toLowerCase().equals("sling"))
			return SLING;
		else if (name.toLowerCase().equals("gun"))
			return GUN;
		else
			throw new UnknownTypeException("Weapon " + name + " does not match any known Weapon.");
	}//identifyWeapon (name)
}//Weapons
