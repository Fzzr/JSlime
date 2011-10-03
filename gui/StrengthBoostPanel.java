package jslime.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import jslime.JSlime;
import jslime.util.Attributes;
import jslime.Unit.Boost.BoostNotFoundException;

@SuppressWarnings("serial")
class StrengthBoostPanel extends JPanel implements ActionListener {
	
	private JButton meleeBoost;
	private JButton rangedBoost;
	private JButton slashingBoost;
	private JButton bashingBoost;
	private JButton piercingBoost;
	private JButton swordBoost;
	private JButton chackramBoost;
	private JButton spearBoost;
	private JButton maulBoost;
	private JButton slingBoost;
	private JButton gunBoost;
	private JButton weaponsBoost;
	
	public StrengthBoostPanel (){
		super(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		meleeBoost = new JButton ("Melee");
		rangedBoost= new JButton ("Ranged");
		slashingBoost = new JButton ("Slashing");
		bashingBoost = new JButton ("Bashing");
		piercingBoost = new JButton ("Piercing");
		swordBoost = new JButton ("Sword");
		maulBoost = new JButton ("Maul");
		spearBoost = new JButton ("Spear");
		chackramBoost = new JButton ("Chackram");
		slingBoost = new JButton ("Sling");
		gunBoost = new JButton ("Gun");
		weaponsBoost = new JButton ("Weapon Points");
		
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(1, 1, 0, 0);
		this.add(slashingBoost, c);
		c.gridy = 2;
		this.add(bashingBoost, c);
		c.gridy = 3;
		this.add(piercingBoost, c);
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		this.add (meleeBoost, c);
		c.gridx = 2;
		this.add (rangedBoost, c);
		c.gridx = 1;
		c.gridy = 1;
		this.add (swordBoost, c);
		c.gridy = 2;
		this.add(maulBoost, c);
		c.gridy = 3;
		this.add(spearBoost, c);
		c.gridx = 2;
		c.gridy = 1;
		this.add(chackramBoost, c);
		c.gridy = 2;
		this.add(slingBoost, c);
		c.gridy = 3;
		this.add(gunBoost, c);
		c.gridx = 0;
		c.gridy = 0;
		this.add(weaponsBoost, c);
		//updateButtons();
	}//constructor
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() ==  meleeBoost) {
			updateButtons();
		} else if (e.getSource() ==  rangedBoost) {
			updateButtons();
		} else if (e.getSource() ==  slashingBoost) {
			updateButtons();
		} else if (e.getSource() ==  bashingBoost) {
			updateButtons();
		} else if (e.getSource() ==  piercingBoost) {
			updateButtons();
		} else if (e.getSource() ==  swordBoost) {
			updateButtons();
		} else if (e.getSource() ==  maulBoost) {
			updateButtons();
		} else if (e.getSource() ==  spearBoost) {
			updateButtons();
		} else if (e.getSource() ==  chackramBoost) {
			updateButtons();
		} else if (e.getSource() ==  slingBoost) {
			updateButtons();
		} else if (e.getSource() ==  gunBoost) {
			updateButtons();
		} else if (e.getSource() ==  weaponsBoost) {
			updateButtons();
		}
	}//actionPerformed
	
	public void updateButtons (){
		try {
			if (JSlime.player.getBoost(Attributes.STRENGTH, 0) == 0){
				meleeBoost.setToolTipText("Click here for a permanent 1% damage bonus with melee weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 0) == 1) {
				meleeBoost.setToolTipText("Click here for a further 1% damage bonus with melee weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 0) == 2) {
				meleeBoost.setToolTipText("Click here for a final 1% damage bonus with melee weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 0) == 3) {
				meleeBoost.setToolTipText("Melee weapon boost maximized.");
				meleeBoost.setEnabled(false);
			}
			if (JSlime.player.getBoost(Attributes.STRENGTH, 1) == 0){
				rangedBoost.setToolTipText("Click here for a permanent 1% damage bonus with ranged weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 1) == 1) {
				rangedBoost.setToolTipText("Click here for a further 1% damage bonus with ranged weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 1) == 2) {
				rangedBoost.setToolTipText("Click here for a final 1% damage bonus with ranged weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 1) == 3) {
				rangedBoost.setToolTipText("Ranged weapon boost maximized.");
				rangedBoost.setEnabled(false);
			}
			if (JSlime.player.getBoost(Attributes.STRENGTH, 2) == 0){
				slashingBoost.setToolTipText("Click here for a permanent 2% damage bonus with slashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 2) == 1) {
				slashingBoost.setToolTipText("Click here for a further 2% damage bonus with slashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 2) == 2) {
				slashingBoost.setToolTipText("Click here for a final 2% damage bonus with slashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 2) == 3) {
				slashingBoost.setToolTipText("Slashing weapon boost maximized.");
				slashingBoost.setEnabled(false);
			}
			if (JSlime.player.getBoost(Attributes.STRENGTH, 3) == 0){
				bashingBoost.setToolTipText("Click here for a permanent 2% damage bonus with bashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 3) == 1) {
				bashingBoost.setToolTipText("Click here for a further 2% damage bonus with bashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 3) == 2) {
				bashingBoost.setToolTipText("Click here for a final 2% damage bonus with bashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 3) == 3) {
				bashingBoost.setToolTipText("Bashing weapon boost maximized.");
				bashingBoost.setEnabled(false);
			}
			if (JSlime.player.getBoost(Attributes.STRENGTH, 4) == 0){
				piercingBoost.setToolTipText("Click here for a permanent 2% damage bonus with piercing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 4) == 1) {
				piercingBoost.setToolTipText("Click here for a further 2% damage bonus with piercing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 4) == 2) {
				piercingBoost.setToolTipText("Click here for a final 2% damage bonus with piercing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 4) == 3) {
				piercingBoost.setToolTipText("Piercing weapon boost maximized.");
				piercingBoost.setEnabled(false);
			}
			if (JSlime.player.getBoost(Attributes.STRENGTH, 5) == 0){
				swordBoost.setToolTipText("Click here for a permanent 3% damage bonus with melee slashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 5) == 1) {
				swordBoost.setToolTipText("Click here for a further 3% damage bonus with melee slashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 5) == 2) {
				swordBoost.setToolTipText("Click here for a final 3% damage bonus with melee slashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 5) == 3) {
				swordBoost.setToolTipText("Sword boost maximized.");
				swordBoost.setEnabled(false);
			}
			if (JSlime.player.getBoost(Attributes.STRENGTH, 6) == 0){
				maulBoost.setToolTipText("Click here for a permanent 3% damage bonus with melee bashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 6) == 1) {
				maulBoost.setToolTipText("Click here for a further 3% damage bonus with melee bashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 6) == 2) {
				maulBoost.setToolTipText("Click here for a final 3% damage bonus with melee bashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 6) == 3) {
				maulBoost.setToolTipText("Maul boost maximized.");
				maulBoost.setEnabled(false);
			}
			if (JSlime.player.getBoost(Attributes.STRENGTH, 7) == 0){
				spearBoost.setToolTipText("Click here for a permanent 3% damage bonus with melee piercing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 7) == 1) {
				spearBoost.setToolTipText("Click here for a further 3% damage bonus with melee piercing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 7) == 2) {
				spearBoost.setToolTipText("Click here for a final 3% damage bonus with melee piercing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 7) == 3) {
				spearBoost.setToolTipText("Spear boost maximized.");
				spearBoost.setEnabled(false);
			}
			if (JSlime.player.getBoost(Attributes.STRENGTH, 8) == 0){
				chackramBoost.setToolTipText("Click here for a permanent 3% damage bonus with ranged slashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 8) == 1) {
				chackramBoost.setToolTipText("Click here for a further 3% damage bonus with ranged slashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 8) == 2) {
				chackramBoost.setToolTipText("Click here for a final 3% damage bonus with ranged slashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 8) == 3) {
				chackramBoost.setToolTipText("Chackram boost maximized.");
				chackramBoost.setEnabled(false);
			}
			if (JSlime.player.getBoost(Attributes.STRENGTH, 9) == 0){
				slingBoost.setToolTipText("Click here for a permanent 3% damage bonus with ranged bashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 9) == 1) {
				slingBoost.setToolTipText("Click here for a further 3% damage bonus with ranged bashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 9) == 2) {
				slingBoost.setToolTipText("Click here for a final 3% damage bonus with ranged bashing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 9) == 3) {
				slingBoost.setToolTipText("Sling boost maximized.");
				slingBoost.setEnabled(false);
			}
			if (JSlime.player.getBoost(Attributes.STRENGTH, 10) == 0){
				gunBoost.setToolTipText("Click here for a permanent 3% damage bonus with ranged piercing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 10) == 1) {
				gunBoost.setToolTipText("Click here for a further 3% damage bonus with ranged piercing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 10) == 2) {
				gunBoost.setToolTipText("Click here for a final 3% damage bonus with ranged piercing weapons.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 10) == 3) {
				gunBoost.setToolTipText("Gun boost maximized.");
				gunBoost.setEnabled(false);
			}
			if (JSlime.player.getBoost(Attributes.STRENGTH, 11) == 0) {
				weaponsBoost.setToolTipText("Click here for two bonus points to spend on weapon specialization.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 11) == 1) {
				weaponsBoost.setToolTipText("Click here for a further two bonus weapon specialization points.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 11) == 2) {
				weaponsBoost.setToolTipText("Click here for a third set of two bonus weapon specialization points.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 11) == 3) {
				weaponsBoost.setToolTipText("Click here for a fourth set of two bonus weapon specialization points.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 11) == 4) {
				weaponsBoost.setToolTipText("Click here for a final two bonus weapon specialization points.");
			} else if (JSlime.player.getBoost(Attributes.STRENGTH, 11) == 5) {
				weaponsBoost.setToolTipText("Weapon specialization point boost maximized.");
			}
		} catch (BoostNotFoundException e) {
			System.err.println(e.getMessage());
		}
		if (!JSlime.player.boostAvailable(Attributes.STRENGTH)) {
			 meleeBoost.setEnabled(false);
			 rangedBoost.setEnabled(false);
			 slashingBoost.setEnabled(false);
			 bashingBoost.setEnabled(false);
			 piercingBoost.setEnabled(false);
			 swordBoost.setEnabled(false);
			 chackramBoost.setEnabled(false);
			 spearBoost.setEnabled(false);
			 maulBoost.setEnabled(false);
			 slingBoost.setEnabled(false);
			 gunBoost.setEnabled(false);
			 weaponsBoost.setEnabled(false);
			 meleeBoost.setToolTipText("No strength boosts currently available! Please return when your strength stat breaks a multiple of ten.");
			 rangedBoost.setToolTipText("No strength boosts currently available! Please return when your strength stat breaks a multiple of ten.");
			 slashingBoost.setToolTipText("No strength boosts currently available! Please return when your strength stat breaks a multiple of ten.");
			 bashingBoost.setToolTipText("No strength boosts currently available! Please return when your strength stat breaks a multiple of ten.");
			 piercingBoost.setToolTipText("No strength boosts currently available! Please return when your strength stat breaks a multiple of ten.");
			 swordBoost.setToolTipText("No strength boosts currently available! Please return when your strength stat breaks a multiple of ten.");
			 chackramBoost.setToolTipText("No strength boosts currently available! Please return when your strength stat breaks a multiple of ten.");
			 spearBoost.setToolTipText("No strength boosts currently available! Please return when your strength stat breaks a multiple of ten.");
			 maulBoost.setToolTipText("No strength boosts currently available! Please return when your strength stat breaks a multiple of ten.");
			 slingBoost.setToolTipText("No strength boosts currently available! Please return when your strength stat breaks a multiple of ten.");
			 gunBoost.setToolTipText("No strength boosts currently available! Please return when your strength stat breaks a multiple of ten.");
			 weaponsBoost.setToolTipText("No strength boosts currently available! Please return when your strength stat breaks a multiple of ten.");
		}
	}//updateButtons
}//StrengthBoostPanel
