package jslime;

import jslime.Unit.Boost.BoostNotFoundException;
import jslime.util.*;
import jslime.Unit.Boost.*;

public abstract class Unit {

	private final int statLimit;
	
	private int level;
    
    private long currentHP;
    private long currentMP;
    private long xp;

    private int [] stats;

    private long hp;
    private long mp;

    private int normalLevel;

    private int [] normalStats;

    private Boost [] boosts; 
    //Str boosts: Damage dealt up: Specialized to ranged/melee or slash/bash/pierce, or to individual weapon for larger bonus. Also, additional weapon specialization points.
    //Dex boosts: Crit miss down, Crit hit up, hit up, crit miss null flag
    //Vit boosts: HP up, Phys def up, phys block up, Phys damage nullifier, Specialize Toughskin (Melee/Ranged), specialize Toughskin (slash/bash/pierce)
    //Int boosts: Damage dealt up (specific element), MP cost down
    //Agi boosts: Dodgerate up (melee/range/magic), first strike odds up, defence up (all), enemy crit miss odds up
    //Men boosts: HP up, magic def up, magic block up, magic damage nullifier, Elementalize (Start with one element, pick up a second, third goes lunar (high res to all))
    
    private int[] weapon;
    //melee slash (sword), melee bash (maul), melee peirce (lance), ranged slash (chakram), ranged bash (sling), ranged pierce (gun)
    private int[] magic;
    //luna, fire, earth, dark, ice, wind, light
       
    private boolean luna;
    
    public Unit (int statLimit) {
    	this.statLimit = statLimit;
    	boosts = new Boost [6];
    	boosts[Attributes.STRENGTH.ordinal()] = new Boost(Attributes.STRENGTH) {	
    		void setupBoosts(){
    			boosts = new boolean[12][];
    			for (int i = 0; i < 11; i++)
    				boosts[i] = new boolean[3];
    			boosts[11] = new boolean[5];
    		}
    		void incrementBoost(int boostNum) throws BoostNotFoundException, BoostFullException {
    			if (boostNum < boosts.length && boostNum >= 0) {
    				if (getBoost(boostNum) < boosts[boostNum].length) {
    					for (int i = 0; i < boosts[boostNum].length; i++){
    						if (!boosts[boostNum][i]) {
    							boosts[boostNum][i] = true;
    							break;
    						}
    					}
    				} else
    					throw new BoostFullException (boostNum);
    			} else 
    				throw new BoostNotFoundException(boostNum);
    		}
    	};
    	boosts[Attributes.DEXTERITY.ordinal()] = new Boost(Attributes.DEXTERITY){
    		void setupBoosts () {
    			boosts = new boolean[9][];
    			for (int i = 0; i < boosts.length; i++) {
    				boosts[i] = new boolean[3];
    			}
    		}
    		void incrementBoost(int boostNum) throws BoostNotFoundException, BoostFullException {
    			if (boostNum < 0 || boostNum > 9) {
    				throw new BoostNotFoundException (boostNum);
    			} else if (getBoost(boostNum) < boosts[boostNum].length) {
    				for (int i = 0; i < boosts[boostNum].length; i++) {
    					if (!boosts[boostNum][i]) {
    						boosts[boostNum][i] = true;
    						break;
    					}
    				}
    			} else
    				throw new BoostFullException (boostNum);
    		}
    	};
    	boosts[Attributes.VITALITY.ordinal()] = new Boost(Attributes.VITALITY) {
    		void setupBoosts () {
    			boosts = new boolean [6][];
    			boosts[0] = new boolean [5];
    			for (int i = 1; i < boosts.length;i++) 
    				boosts[i] = new boolean[3];
    		}
    		void incrementBoost(int boostNum) throws BoostNotFoundException, BoostFullException {
    			if (boostNum >= 0 && boostNum < 4) {
    				if (getBoost(boostNum) < boosts[boostNum].length) {
    					for (int i = 0; i < boosts[boostNum].length; i++) {
    						if (!boosts[boostNum][i]){
    							boosts[boostNum][i] = true;
    							break;
    						}
    					}
    				} else 
						throw new BoostFullException (boostNum);
    			} else if (boostNum == 4 || boostNum == 5) {
    				throw new BoostNotFoundException(attribute.getRealName() + " boost number " + boostNum + " requires that you specify a sub-boost to increment.");
    			} else 
    				throw new BoostNotFoundException(boostNum);
    		}
    		void incrementBoost (int boostNum, int subNum) throws BoostFullException, InvalidStatsException, BoostNotFoundException {
    			if (boostNum == 4) {
    				if (subNum == 0 || subNum == 1) {
    					if (!boosts[boostNum][subNum]) 
    						boosts[boostNum][subNum] = true;
    					else 
    						throw new BoostFullException (attribute.getRealName() + " boost " + boostNum + " part " + subNum + " is already full.");
    				} else if (subNum == 2) {
    					if (boosts[boostNum][0] && boosts[boostNum][1]) {
    						if (!boosts[boostNum][subNum]) 
    							boosts[boostNum][subNum] = true;
    						else 
    							throw new BoostFullException (boostNum);
    					} else 
    						throw new InvalidStatsException ("You cannot increment " + attribute.getRealName() + " boost " + boostNum + " part " + subNum + " until the other parts are full.");
    				} else
    					throw new BoostNotFoundException (attribute.getRealName() + " boost " + boostNum + " part " + subNum + " corresponds to no known boost.");
    			} else if (boostNum == 5) {
    				if (subNum >= 0 && subNum < boosts[boostNum].length) {
    					if (!boosts[boostNum][subNum]) 
    						boosts[boostNum][subNum] = true;
    					else 
    						throw new BoostFullException (attribute.getRealName() + " boost " + boostNum + " part " + subNum + " is already full.");
    				}else
    					throw new BoostNotFoundException (attribute.getRealName() + " boost " + boostNum + " part " + subNum + " corresponds to no known boost.");
    			} else if (boostNum >= 0 && boostNum < 4) 
    				throw new BoostNotFoundException(attribute.getRealName() + " boost number " + boostNum + " does not require you to specify a sub-boost to increment.");
    			else 
    				throw new BoostNotFoundException(boostNum);
    		}
    	};
    	boosts[Attributes.INTELLIGENCE.ordinal()] = new Boost(Attributes.INTELLIGENCE){
    		void setupBoosts() {
				boosts = new boolean[9][];
				for (int i = 0; i < 6; i++) 
					boosts[i] = new boolean[5];
				boosts[6] = new boolean[3];
				for (int i = 7; i < boosts.length; i++)
					boosts[i] = new boolean[5];
			}
    		void incrementBoost(int boostNum) throws BoostNotFoundException, BoostFullException, InvalidStatsException{
    			if (boostNum >= 0 && boostNum < 8) {
    				if (getBoost(boostNum) < boosts[boostNum].length)
    					for (int i = 0; i < boosts[boostNum].length; i++) {
    						if (!boosts[boostNum][i]) {
    							boosts[boostNum][i] = true;
    							break;
    						}
    				} else
						throw new BoostFullException (boostNum);
    			} else if (boostNum == 8) {
    				if (luna) {
    					if (getBoost(boostNum) < boosts[boostNum].length) {
    						for (int i = 0; i < boosts[boostNum].length; i++) {
    							if (!boosts[boostNum][i]) {
    								boosts[boostNum][i] = true;
    								break;
    							}
    						}
    					} else 
    						throw new BoostFullException (boostNum);
    				} else throw new InvalidStatsException ("You cannot take " + attribute.getRealName() + " boost " + boostNum + " until you unlock the secrets of Lunar magic.");
    			} else 
    				throw new BoostNotFoundException (boostNum);
    		}
    	};
    	boosts[Attributes.AGILITY.ordinal()] = new Boost(Attributes.AGILITY){
    		void setupBoosts() {
    			boosts = new boolean[6][];
    			for (int i = 0; i < boosts.length; i++)
    				boosts[i] = new boolean [5];
    		}
    		void incrementBoost(int boostNum) throws BoostNotFoundException, BoostFullException{
    			if (boostNum >= 0 && boostNum < boosts.length) {
    				if (getBoost(boostNum) < boosts[boostNum].length) {
    					for (int i = 0; i < boosts[boostNum].length; i++) {
    						if (!boosts[boostNum][i]) {
    							boosts[boostNum][i] = true;
    							break;
    						}
    					}
    				} else 
    					throw new BoostFullException (boostNum);
    			} else throw new BoostNotFoundException(boostNum);
    		}
    	};
    	boosts[Attributes.MENTALITY.ordinal()] = new Boost(Attributes.MENTALITY){
    		void setupBoosts() {
    			boosts = new boolean[9][];
    			for (int i = 0; i < 2; i++)
    				boosts[i] = new boolean[5];
    			for (int i = 2; i < 5; i++)
    				boosts[i] = new boolean[3];
    			for (int i = 5; i < 8; i++)
    				boosts [i] = new boolean[2];
    			boosts[8] = new boolean[1];
    		}
    		void incrementBoost(int boostNum) throws BoostNotFoundException, BoostFullException {
    			if (boostNum >= 0 && boostNum < 5) {
    				if (getBoost(boostNum) < boosts[boostNum].length) {
    					for (int i = 0; i < boosts[boostNum].length; i++) {
    						if (!boosts[boostNum][i]) {
    							boosts[boostNum][i] = true;
    							break;
    						}
    					}
    				} else 
    					throw new BoostFullException(boostNum);
    			} else if (boostNum >= 5 && boostNum < boosts.length)
    				throw new BoostNotFoundException (attribute.getRealName() + " boost number " + boostNum + " requires that you specify a sub-boost to increment.");
    			else 
    				throw new BoostNotFoundException (boostNum);
    		}
    		void incrementBoost(int boostNum, int subNum) throws BoostNotFoundException, BoostFullException, InvalidStatsException {
    			if (boostNum >= 0 && boostNum < 5) 
    				throw new BoostNotFoundException(attribute.getRealName() + " boost number " + boostNum + " does not require you to specify a sub-boost to increment.");
    			else if (boostNum <= 5 && boostNum < 8) {
    				if (subNum == 0 || subNum == 1) {
    					if (!boosts[boostNum][subNum]) {
    						if ((subNum == 0 && !boosts[boostNum][1]) || (subNum == 1 && !boosts[boostNum][0])) {
    							boosts[boostNum][subNum] = true;
    						} else 
    							throw new BoostFullException ("You may not elementalize in two opposing elements.");
    					} else 
    						throw new BoostFullException (boostNum);
    				} else 
    					throw new BoostNotFoundException (attribute.getRealName() + " boost " + boostNum + " part " + subNum + " corresponds to no known boost.");
    			} else if (boostNum == 8)
    				throw new InvalidStatsException (attribute.getRealName() + " boost " + boostNum +  "is not set by the user, but rather incremented automatically.");
    			else 
    				throw new BoostNotFoundException (boostNum);
    		}
    		int totalBoosts() {
    			int total = 0;
        		for (int i = 0; i < boosts.length; i++) {
    				for (int j = 0; j< boosts[i].length; j++){
    					if (boosts[i][j])
    						total++;	
    				}
    			}
        		if (boosts[7][0])
        			total --;
        		return total;
    		}
    	};
        stats = new int[6];
        normalStats = new int[6];
        weapon = new int[6];
        magic = new int[7];
    }//default Unit constructor
	
    public int getLevel() {
		return level;
	}//getLevel

	public void setLevel(int level) {
		this.level = level;
	}//setLevel

	public long getCurrentHP() {
		return currentHP;
	}//getCurrentHP

	public void setCurrentHP(long currentHP) {
		if (currentHP < 0) 
			this.currentHP = 0;
		else
			this.currentHP = currentHP;
	}//setCurrentHP

	public long getCurrentMP() {
		return currentMP;
	}//getCurrentMP

	public void setCurrentMP(long currentMP) {
		this.currentMP = currentMP;
	}//setCurrentMP

	public long getXP() {
		return xp;
	}//getXP

	public void setXP(long xp) {
		this.xp = xp;
	}//setXP

	public int getStats(Attributes attribute) {
		return stats[attribute.ordinal()];
	}//getStats

	public void setStats(Attributes attribute, int value) throws InvalidStatsException {
		if (value < 0) 
			throw new InvalidStatsException ("Cannot set " + attribute.getRealName() + " below 0.");
		else if (value > statLimit){
			throw new InvalidStatsException ("Cannot set " + attribute.getRealName() + " above " + statLimit + ".");
		} else 
			stats[attribute.ordinal()] = value;
	}//setStats

	public long getHP() {
		return hp;
	}//getHP

	public void setHP(long hp) {
		this.hp = hp;
	}//setHP

	public long getMP() {
		return mp;
	}//getMP

	public void setMP(long mp) {
		this.mp = mp;
	}//setMP

	public int getNormalLevel() {
		return normalLevel;
	}//getNormalLevel

	public void levelUp(int normalLevel) {
		this.normalLevel = normalLevel;
	}//levelUp

	public int getNormalStat(Attributes attribute) {
		return normalStats[attribute.ordinal()];
	}//getNormalStat

	public void setNormalStat(Attributes attribute, int value) throws InvalidStatsException {
		if (value > statLimit)
			throw new InvalidStatsException ("Cannot set " + attribute.getRealName() + " above " + statLimit + ".");
		else if (value < 0)
			throw new InvalidStatsException("Cannot set " + attribute.getRealName() + " below 0.");
		else 
			normalStats[attribute.ordinal()] = value;
	}//setNormalStat

	/**
	 * Returns the value of the passed weapon skill. If null is passed, returns the total number of weapons.
	 * @param weapon
	 * @return
	 */
	public int getWeapon(Weapons weapon) {
		if (weapon == null)
			return this.weapon.length;
		else
			return this.weapon[weapon.ordinal()];
	}//getWeapon
	
	/**
	 * Sets the passed weapon skill to the passed amount if valid.
	 * @param weapon - weapon to be set
	 * @param amount - amount to set weapon to
	 * @throws InvalidStatsException
	 */
	public void setWeapon(Weapons weapon, int amount) throws InvalidStatsException {
		String weaponName = weapon.getRealName();
		
		if (amount > 10)
			throw new InvalidStatsException("Cannot set " + weaponName + " above 10.");
		else if (amount < 0) 
			throw new InvalidStatsException("Cannot set " + weaponName + " below 0.");
		else
			this.weapon[weapon.ordinal()] = amount;
	}//setWeapon
	
	/**
	 * Returns the value of the magic skill for the passed element. If null is passed, returns the total number of elements.
	 * @param element
	 * @return
	 */
	public int getMagic(Elements element) {
		if (element == null)
			return magic.length;
		else
			return magic[element.ordinal()];
	}//getMagic
	
	/**
	 * Sets the magic skill for the passed element to the passed amount if valid.
	 * @param element
	 * @param amount
	 * @throws InvalidStatsException
	 */
	public void setMagic(Elements element, int amount) throws InvalidStatsException {
		String elementName = element.getRealName();
		int elementNumber = element.ordinal();
		
		checkLuna();
		if (element == Elements.LUNA){
			if (!luna)
				throw new InvalidStatsException ("Not enough skill with magic to use Luna.");
			else if (amount > 14) 
				throw new InvalidStatsException ("Cannot set Luna above 14.");
			else if (amount < 0)
				throw new InvalidStatsException ("Cannot set Luna below 0.");
			else
				magic[Elements.LUNA.ordinal()] = amount;
		} else {
			if (amount > 10)
				throw new InvalidStatsException ("Cannot set " + elementName + " above 10.");
			else if (amount < 0)
				throw new InvalidStatsException ("Cannot set " + elementName + " below 0.");
			else
				magic[elementNumber] = amount;
		}
	}//setMagic

	public boolean isLuna() {
		return luna;
	}//isLuna

	public void setLuna(boolean luna) {
		this.luna = luna;
	}//setLuna

	public void fullHeal() {
		hpCheck();
		mpCheck();
        currentHP = hp;
        currentMP = mp;
    }//fullHeal
    
    public boolean isDead() {
        return (currentHP <= 0)? true: false;
    }//isDead

	public int speed() throws BoostNotFoundException {
    	int s = -1;
		try {
    		s = (stats[Attributes.AGILITY.ordinal()] + 5 * boosts[Attributes.AGILITY.ordinal()].getBoost(4));
    	} catch (BoostNotFoundException e) {
    		throw (e);
    	}
    	return s;
    }//speed
    
    public double calcDamage(double damage) {
    	double defence = level * 100 * (4 * stats[Attributes.VITALITY.ordinal()] + stats[Attributes.MENTALITY.ordinal()] + stats[Attributes.AGILITY.ordinal()]);
        double total = damage - defence;
        return total;
    }//calcDamage
    
    public void statCheck() {
        level = normalLevel;
        stats[Attributes.STRENGTH.ordinal()] = normalStats[Attributes.STRENGTH.ordinal()];
        stats[Attributes.DEXTERITY.ordinal()] = normalStats[Attributes.DEXTERITY.ordinal()];
        stats[Attributes.VITALITY.ordinal()] = normalStats[Attributes.VITALITY.ordinal()];
        stats[Attributes.INTELLIGENCE.ordinal()] = normalStats[Attributes.INTELLIGENCE.ordinal()];
        stats[Attributes.AGILITY.ordinal()] = normalStats[Attributes.AGILITY.ordinal()];
        stats[Attributes.MENTALITY.ordinal()] = normalStats[Attributes.MENTALITY.ordinal()];
    } //statCheck

    public void hpCheck() {
    	try {
    		hp = level * ((stats[Attributes.VITALITY.ordinal()] * 500) + (stats[Attributes.MENTALITY.ordinal()] * 300) + (boosts[Attributes.VITALITY.ordinal()].getBoost(1) * 1000) + (boosts[Attributes.MENTALITY.ordinal()].getBoost(1) * 1000));
    	} catch (BoostNotFoundException e){
    		System.err.print(e.getMessage());
    	}
    }//hpCheck
    
    public void mpCheck() {
        try {
        	mp = level * ((stats[Attributes.INTELLIGENCE.ordinal()] * 15) + (stats[Attributes.MENTALITY.ordinal()]) + (boosts[Attributes.INTELLIGENCE.ordinal()].getBoost(10) * 25) + (boosts[Attributes.MENTALITY.ordinal()].getBoost(8) * 25));
        } catch (BoostNotFoundException e) {
        	System.err.print(e.getMessage());
        }
    }//mpCheck()
    
    public void checkLuna() {
    	try {
    		if (!luna && magic[Elements.FIRE.ordinal()] >= 7 && magic[Elements.EARTH.ordinal()] >= 7 && magic[Elements.DARK.ordinal()] >= 7 && magic[Elements.ICE.ordinal()] >= 7 && magic[Elements.WIND.ordinal()] >= 7 && magic[Elements.LIGHT.ordinal()] >= 7) {
    			luna = true;
    			magic[Elements.LUNA.ordinal()] = 6;
    		}else if (luna && (magic[Elements.FIRE.ordinal()] < 7 || magic[Elements.EARTH.ordinal()] < 7 || magic[Elements.DARK.ordinal()] < 7 || magic[Elements.ICE.ordinal()] <= 7 || magic[Elements.WIND.ordinal()] < 7 || magic[Elements.LIGHT.ordinal()] < 7)) {
    			luna  = false;
    			magic[Elements.LUNA.ordinal()] = 0;
    		}
    		if (boosts[Attributes.MENTALITY.ordinal()].getBoost(8) == 1)
    			;
    			//check elementalization
    	} catch (BoostNotFoundException e) {
    		System.err.println(e.getMessage());
    	}
    }//checkLuna

    public int statPoints() {
        return normalLevel - (normalStats[Attributes.STRENGTH.ordinal()] + normalStats[Attributes.DEXTERITY.ordinal()] + normalStats[Attributes.VITALITY.ordinal()] + normalStats[Attributes.INTELLIGENCE.ordinal()] + normalStats[Attributes.AGILITY.ordinal()] + normalStats[Attributes.MENTALITY.ordinal()]);
    }//statPoints
    
	public int weaponPoints() throws BoostNotFoundException {
    	int wp = -1;
		try {
    		wp = ((normalStats[Attributes.STRENGTH.ordinal()] + 1) / 2) - weapon[1] - weapon[2] - weapon[3] - weapon[4] - weapon[5] - weapon[6] + 2 * boosts[Attributes.STRENGTH.ordinal()].getBoost(11);
    	} catch (BoostNotFoundException e) {
    		throw (e);
    	} 
    	return wp;
    }//weaponPoints

	public int spellPoints() throws BoostNotFoundException{
    	int sp = 1;
		try {
    		checkLuna();
    		if (luna) {
    			sp = ((normalStats[Attributes.INTELLIGENCE.ordinal()] + 1) / 2) - magic[Elements.FIRE.ordinal()] - magic[Elements.EARTH.ordinal()] - magic[Elements.DARK.ordinal()] - magic[Elements.ICE.ordinal()] - magic[Elements.WIND.ordinal()] - magic[Elements.LIGHT.ordinal()] - magic[Elements.LUNA.ordinal()] + 6 + 2 * boosts[Attributes.INTELLIGENCE.ordinal()].getBoost(8);
    		} else
    			sp = ((normalStats[Attributes.INTELLIGENCE.ordinal()] + 1) / 2) - magic[Elements.FIRE.ordinal()] - magic[Elements.EARTH.ordinal()] - magic[Elements.DARK.ordinal()] - magic[Elements.ICE.ordinal()] - magic[Elements.WIND.ordinal()] - magic[Elements.LIGHT.ordinal()] - magic[Elements.LUNA.ordinal()] + 2 * boosts[Attributes.INTELLIGENCE.ordinal()].getBoost(8);
    	} catch (BoostNotFoundException e) {
    		throw (e);
    	}
    	return sp;
    }//spellPoints
    
    public boolean boostAvailable(Attributes attribute) {
    	return boosts[attribute.ordinal()].boostAvailable();
    }//boostAvailable
   
    public int numBoosts(Attributes attribute) {
	   return boosts[attribute.ordinal()].numBoosts();
    }//numBoosts

    public int getBoost(Attributes attribute, int boostNum) throws BoostNotFoundException {
    	int gb = -1;
    	try {
    		gb = boosts[attribute.ordinal()].getBoost(boostNum);
    	} catch (BoostNotFoundException e) {
    		throw (e);
    	}
    	return gb;
    }//getBoost
   
    public void incrementBoost(Attributes attribute, int boostNum){
    	try {
    		boosts[attribute.ordinal()].incrementBoost(boostNum);
    	} catch (BoostNotFoundException e) {
    		System.err.println(e.getMessage());
    	} catch (BoostFullException e) {
    		System.err.println(e.getMessage());
    	} catch (InvalidStatsException e){
    		System.err.println(e.getMessage());
    	}
    }//incrementBoost

    public void incrementBoost(Attributes attribute, int boostNum, int subnum){
    	try {
    		boosts[attribute.ordinal()].incrementBoost(boostNum, subnum);
    	} catch (BoostNotFoundException e) {
    		System.err.println(e.getMessage());
    	} catch (BoostFullException e) {
    		System.err.println(e.getMessage());
    	} catch (InvalidStatsException e){
    		System.err.println(e.getMessage());
    	}
    }//incrementBoost
   
    public abstract class Boost {
    	
    	protected final Attributes attribute;
    	
    	protected boolean [][] boosts;
    	
    	Boost (Attributes attribute) {
    		this.attribute = attribute;
    		setupBoosts();
    	}//constructor
    	
    	abstract void setupBoosts();
    	
    	abstract void incrementBoost (int boostNum) throws BoostNotFoundException, BoostFullException, InvalidStatsException;
    	
    	void incrementBoost(int boostNum, int subNum) throws BoostNotFoundException, BoostFullException, InvalidStatsException {
		   throw new BoostNotFoundException (attribute.getRealName() + " does not have any boosts with multiple growth options.");
    	}//incrementBoost
 
    	int numBoosts() {
    		return boosts.length;
    	}//numBoosts
    	
    	boolean boostAvailable() {
    		return (stats[attribute.ordinal()]/10 < totalBoosts())? true: false;
    	}//boostAvailable
	   
    	int totalBoosts(){
    		int total = 0;
    		for (int i = 0; i < boosts.length; i++) {
    			for (int j = 0; j< boosts[i].length; j++){
    				if (boosts[i][j])
    					total++;	
    			}
    		}
    		return total;
    	}//totalBoosts
    	
    	int getBoost (int boostNum) throws BoostNotFoundException {
    		try {
    			int total = 0;
    			for (int i = 0; i < boosts[boostNum].length; i++) {
				   if (boosts[boostNum][i])
					   total++;
    			}
    			return total;
    		} catch (IndexOutOfBoundsException e){
    			throw new BoostNotFoundException(boostNum);
    		}
    	}//getBoost()
    	
    	@SuppressWarnings("serial")
		public class BoostNotFoundException extends Exception {
    		BoostNotFoundException (int boostNum){
    			super(attribute.getRealName() + " has no boost number "+ boostNum + ".");
    		}

    		BoostNotFoundException(String message) {
    			super(message);
    		}
    	}//BoostNotFoundException
    	
    	@SuppressWarnings("serial")
    	public class BoostFullException extends Exception {
    		BoostFullException (int boostNum) {
    			super (attribute.getRealName()+ " boost" + boostNum + " is at the highest possible level.");
    		}
    		
    		BoostFullException (String message) {
    			super (message);
    		}
    	}//BoostFullException
    }//Boost

}//Unit