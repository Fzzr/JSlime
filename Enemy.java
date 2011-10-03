package jslime;

import jslime.Unit.Boost.BoostNotFoundException;
import jslime.util.*;

public class Enemy extends Unit {

	public Enemy () {
		super (100);
	} //default Enemy constructor

	public Enemy (int level) throws BoostNotFoundException{
		super (100);
		levelUp(level);
		try {
			distributeStats();
			distributeMagic();
			distributeBoosts();
			distributeWeapons();
			distributeMagic();
			fullHeal();
		} catch (InvalidStatsException e) {
			System.err.print(e.getMessage());
		}
	}//Enemy constructor for randomized enemy.
	
	/**
	 * Randomly distributes available stat points. May reallocate points already spent.
	 * @throws InvalidStatsException
	 */
	private void distributeStats() throws InvalidStatsException {
		short localStr;
		short localDex;
		short localVit;
		short localInt;
		short localAgi;
		short localMen;
		Attributes attribute;
		try {
			if (getNormalLevel() < 300) {
				localStr = 0;
				localDex = 0;
				localVit = 0;
				localInt = 0;
				localAgi = 0;
				localMen = 0;
				while (statPoints() > 0) {
					attribute = Attributes.identifyAttribute(JSlime.rng.nextInt(5));
					if (attribute == Attributes.STRENGTH && localStr < 100)
						localStr++;
					else if (attribute == Attributes.DEXTERITY && localDex < 100)
						localDex++;
					else if (attribute == Attributes.VITALITY && localVit < 100)
						localVit++;
					else if (attribute == Attributes.INTELLIGENCE && localInt < 100)
						localInt++;
					else if (attribute == Attributes.AGILITY && localAgi < 100)
						localAgi++;
					else if (attribute == Attributes.MENTALITY && localMen < 100)
						localMen++;
				}
				setNormalStat(Attributes.STRENGTH, localStr);
				setNormalStat(Attributes.DEXTERITY, localDex);
				setNormalStat(Attributes.VITALITY, localVit);
				setNormalStat(Attributes.INTELLIGENCE, localInt);
				setNormalStat(Attributes.AGILITY, localAgi);
				setNormalStat(Attributes.MENTALITY, localMen);
			} else if (getNormalLevel() < 600){
				localStr = 100;
				localDex = 100;
				localVit = 100;
				localInt = 100;
				localAgi = 100;
				localMen = 100;
				while (statPoints() < 0) {
					attribute = Attributes.identifyAttribute(JSlime.rng.nextInt(5));
					if (attribute == Attributes.STRENGTH && localStr > 0)
						localStr++;
					else if (attribute == Attributes.DEXTERITY && localDex > 0)
						localDex++;
					else if (attribute == Attributes.VITALITY && localVit  > 0)
						localVit++;
					else if (attribute == Attributes.INTELLIGENCE && localInt > 0)
						localInt++;
					else if (attribute == Attributes.AGILITY && localAgi > 0)
						localAgi++;
					else if (attribute == Attributes.MENTALITY && localMen > 0)
						localMen++;
				}
				setNormalStat(Attributes.STRENGTH, localStr);
				setNormalStat(Attributes.DEXTERITY, localDex);
				setNormalStat(Attributes.VITALITY, localVit);
				setNormalStat(Attributes.INTELLIGENCE, localInt);
				setNormalStat(Attributes.AGILITY, localAgi);
				setNormalStat(Attributes.MENTALITY, localMen);
			} else {
				setNormalStat(Attributes.STRENGTH, 100);
				setNormalStat(Attributes.DEXTERITY, 100);
				setNormalStat(Attributes.VITALITY, 100);
				setNormalStat(Attributes.INTELLIGENCE, 100);
				setNormalStat(Attributes.AGILITY, 100);
				setNormalStat(Attributes.MENTALITY, 100);
			}
			statCheck();
		} catch (UnknownTypeException e){
			System.err.print(e.getMessage());
		}
	}//distributeStats
	
	/**
	 * Randomly distributes available weapon points. May reallocate points already spent.
	 * @throws InvalidStatsException
	 */
	private void distributeWeapons() throws InvalidStatsException, BoostNotFoundException {
		Weapons weapon;
		try {
			if (weaponPoints() > 0 && weaponPoints() <= 30){
				while(weaponPoints() < 0){
					weapon = Weapons.identifyWeapon(JSlime.rng.nextInt(5));
					if (getWeapon(weapon) < 10){
						setWeapon(weapon, (getWeapon(weapon) + 1));
					}
				}
			} else {
				for (int i = 0; i < getWeapon(null); i++){
					setWeapon(Weapons.identifyWeapon(i), 10);
				}
				while (weaponPoints() > 0) {
					weapon = Weapons.identifyWeapon(JSlime.rng.nextInt(5));
					if (getWeapon(weapon) > 0)
						setWeapon(weapon, (getWeapon(weapon) - 1));
				}
			}
		} catch (UnknownTypeException e){
			System.err.print(e.getMessage());
		}
	}//distributeWeapons
	
	
	/**
	 * Randomly distributes available magic points. May reallocate points already spent.
	 * @throws InvalidStatsException
	 */
	private void distributeMagic() throws InvalidStatsException, BoostNotFoundException {
		Elements element;
		try {
			if (!isLuna())
				checkLuna();
			if (isLuna()) {
				if (spellPoints() > 0 && spellPoints() <=34 ){
					while (spellPoints() > 0) {
						element = Elements.identifyElement(JSlime.rng.nextInt(6));
						if (element == Elements.LUNA && getMagic(Elements.LUNA) < 14)
							setMagic(Elements.LUNA, (getMagic(Elements.LUNA) + 1));
						if (element != Elements.LUNA && getMagic(element) < 10)
							setMagic(element, (getMagic(element) + 1));
					}
				} else {
					setMagic(Elements.LUNA, 14);
					for (short i = 1; i < getMagic(null); i++){
						setMagic(Elements.identifyElement(i), 10);
					}
					while (spellPoints() < 0) {
						element = Elements.identifyElement(JSlime.rng.nextInt(6));
						if (element == Elements.LUNA && getMagic(Elements.LUNA) > 6)
							setMagic(Elements.LUNA, (getMagic(Elements.LUNA) - 1));
						if (element != Elements.LUNA && getMagic(element) > 0)
							setMagic(element, (getMagic(element) - 1));
					}
				}
			} else {
				if (spellPoints() > 0 && spellPoints() < 34) {
					while (spellPoints() > 0) {
						element = Elements.identifyElement(1 + JSlime.rng.nextInt(5));
						if (getMagic(element) < 10)
							setMagic(element, (getMagic(element) + 1));
					}
				} else {
					while (spellPoints() < 0) {	
						for (short i = 1; i < getMagic(null); i++){
							setMagic(Elements.identifyElement(i), 10);
						}
						element = Elements.identifyElement(1 + JSlime.rng.nextInt(5));
						if (getMagic(element) > 0)
							setMagic(element, (getMagic(element) - 1));
					}
				}
			}
		} catch (UnknownTypeException e) {
			System.err.print(e.getMessage());
		}
	}//distributeMagic
	
	/**
	 * Randomly Distributes available boosts.
	 */
	private void distributeBoosts() throws BoostNotFoundException{
		int x, y;
		
		while (boostAvailable(Attributes.STRENGTH)) {
			x = JSlime.rng.nextInt(numBoosts(Attributes.STRENGTH));
			for (short j = 0; j < numBoosts(Attributes.STRENGTH); j++) {
				if (x == j && getBoost(Attributes.STRENGTH, j) < 3) {
					incrementBoost(Attributes.STRENGTH, j);
				}
			}
		}
		while (boostAvailable(Attributes.DEXTERITY)) {
			x = JSlime.rng.nextInt(numBoosts(Attributes.DEXTERITY));
			for (int j = 1; j < numBoosts(Attributes.DEXTERITY); j++) {
				if (x == j && getBoost(Attributes.DEXTERITY, j) < 3) {
					incrementBoost(Attributes.DEXTERITY, j);
				}
			}
		}

		while (boostAvailable(Attributes.VITALITY)) {
			x = JSlime.rng.nextInt(5);
			for (short j = 0; j < 4 ; j++) {
				if (x == j && getBoost(Attributes.VITALITY, j) < 3) {
					incrementBoost(Attributes.VITALITY, j);
				}
			}
			//STUB!!
		}
		while (boostAvailable(Attributes.INTELLIGENCE)) {
			if (isLuna()) {
				x = (1 + JSlime.rng.nextInt(9));
				for (int j = 1; j < numBoosts(Attributes.INTELLIGENCE); j++) {
					if (x == j && getBoost(Attributes.INTELLIGENCE, 1) < 5) {
						incrementBoost(Attributes.INTELLIGENCE, j);
					}
				}
			} else {
				//x = Util.rng(1, 9);
				//Not yet ported
				/*for (int j = 1; j < (getBoosts(Attributes.INTELLIGENCE).length- 1); j++) {
					if (x == j && getBoost(Attributes.INTELLIGENCE, 1) < 5) {
						getBoosts(Attributes.INTELLIGENCE)[j] += 1;
					}
				}*/
			}
		}
		while (boostAvailable(Attributes.AGILITY)) {
			//x = Util.rng(1, 6);
			//Not yet ported
			/*for (int j = 1; j < numBoosts(Attributes.AGILITY); j++) {
				if (x == j && getBoost(Attributes.AGILITY, 1) < 5)
					getBoosts(Attributes.AGILITY)[1] += 1;
			}*/
		}

		while (boostAvailable(Attributes.MENTALITY)) {
			x = JSlime.rng.nextInt(7);
			for (int j = 0; j < 2; j++) {
				if (x == j && getBoost(Attributes.MENTALITY, j) < 5)
					incrementBoost(Attributes.MENTALITY, j);
			}
			for (int j = 2; j < 5; j++) {
				if (x == j && getBoost(Attributes.MENTALITY, j) < 3)
					incrementBoost(Attributes.MENTALITY, j);
			}
			for (int j = 5; j < 8; j++) {
				if (x == 5 && getBoost(Attributes.MENTALITY, j) == 0) {
					y = JSlime.rng.nextInt(1);
					incrementBoost(Attributes.MENTALITY, j);
				}
			}
		}
	}//distributeBoosts
	
}//Enemy