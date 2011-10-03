package jslime.spells;

import jslime.*;
import jslime.util.Attributes;

public abstract class BuffSpell extends AbstractSpell {
	private Attributes attribute;
	private int baseDuration;
	
	public abstract void cast(Unit target);
}//BuffSpell
