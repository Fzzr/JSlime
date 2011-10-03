package jslime.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import jslime.util.Elements;
import jslime.util.Weapons;

@SuppressWarnings("serial")
public class BattlePanel extends JPanel implements ActionListener {
	
	private JButton attack;
	private JButton magic;
	private JButton defend;
	private JButton run;
	private JComboBox weapons;
	private JComboBox spells;

	public BattlePanel () {
		super (new GridLayout(3, 2));
		
		attack = new JButton ("Attack");
		magic = new JButton ("Magic");
		defend = new JButton ("Defend");
		run = new JButton ("Run");
		JPanel weaponPanel = new JPanel();
		String [] weaponArray = new String[Weapons.values().length];
		for (Weapons w: Weapons.values()) {
			weaponArray[w.ordinal()] = w.getRealName();
		}
		weapons = new JComboBox(weaponArray);
		weaponPanel.add(weapons);
		JPanel spellPanel = new JPanel();
		String [] spellArray = new String[Elements.values().length];
		for (Elements e: Elements.values()) {
			spellArray[e.ordinal()] = e.getRealName();
		}
		spells = new JComboBox(spellArray);
		spellPanel.add(spells);
		this.add(attack);
		this.add(magic);
		this.add(defend);
		this.add(run);
		this.add(weaponPanel);
		this.add(spellPanel);
	}//constructor
	
	public void actionPerformed (ActionEvent e) {
		
	}//actionPerformed
}//BattlePanel