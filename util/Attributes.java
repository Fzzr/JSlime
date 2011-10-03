 package jslime.util;

public enum Attributes implements Stats {
	STRENGTH("STR", "Strength"), 
	DEXTERITY ("DEX", "Dexterity"), 
	VITALITY("VIT", "Vitality"), 
	INTELLIGENCE ("INT", "Intelligence"), 
	AGILITY ("AGI", "Agility"), 
	MENTALITY ("MEN", "Mentality");

	private String abbreviation;
	private String realName;
	
	private Attributes (String abbreviation, String name){
		this.abbreviation = abbreviation;
		this.realName = name;
	}//constructor
	
	public String getAbbrebviation() {
		return abbreviation;
	}//getAbbreviation
	
	public String getRealName() {
		return realName;
	}//getName
	
	public static Attributes identifyAttribute (int number) throws UnknownTypeException {
		switch (number){
			case 0: return STRENGTH;
			case 1: return DEXTERITY;
			case 2: return VITALITY;
			case 3: return INTELLIGENCE;
			case 4: return AGILITY;
			case 5: return MENTALITY;
			default:throw new UnknownTypeException ("Attribute " + number + " does not match any known attribute.");
		}
	}
	
	public static Attributes identifyAttribute(String name) throws UnknownTypeException {
		if (name.toLowerCase().equals("str") || name.toLowerCase().equals("strength"))
			return STRENGTH;
		if (name.toLowerCase().equals("dex") || name.toLowerCase().equals("dexterity"))
			return DEXTERITY;
		if (name.toLowerCase().equals("vit") || name.toLowerCase().equals("vitality"))
			return VITALITY;
		if (name.toLowerCase().equals("int") || name.toLowerCase().equals("intelligence"))
			return INTELLIGENCE;
		if (name.toLowerCase().equals("agi") || name.toLowerCase().equals("agility"))
			return AGILITY;
		if (name.toLowerCase().equals("men") || name.toLowerCase().equals("mentality"))
			return MENTALITY;
		else throw new UnknownTypeException("Attribute " + name + " does not match any known Attribute.");
	}//identifyAttribute(name or abbreviation)
}//Attributes
