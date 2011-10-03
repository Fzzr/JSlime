package jslime.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class WeaponUpgradePanel extends JPanel implements ActionListener {

	private JButton swordUp;
	private JButton maulUp;
	private JButton lanceUp;
	private JButton chakramUp;
	private JButton slingUp;
	private JButton gunUp;
	private JButton swordDown;
	private JButton maulDown;
	private JButton lanceDown;
	private JButton chakramDown;
	private JButton slingDown;
	private JButton gunDown;
	
	public WeaponUpgradePanel() {
		super (new GridBagLayout());
		
		/*
		 * short localSword = JSlime.player.getWeapon()[Util.SWORD];
		 * short localMaul = JSlime.player.getWeapon()[Util.MAUL];
		 * short localLance = JSlime.player.getWeapon()[Util.LANCE];
		 * short localChakram = JSlime.player.getWeapon()[Util.CHAKRAM];
		 * short localSling = JSlime.player.getWeapon()[Util.SLING];
		 * short localGun = JSlime.player.getWeapon()[Util.GUN];
		 */
		GridBagConstraints c =  new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		JLabel swordLabel = new JLabel ("Sword");
		JPanel swordPanel = new JPanel (new GridBagLayout());
		swordPanel.add(swordLabel, c);
		JLabel maulLabel = new JLabel ("Maul");
		JPanel maulPanel = new JPanel (new GridBagLayout());
		maulPanel.add(maulLabel, c);
		JLabel lanceLabel = new JLabel ("Lance");
		JPanel lancePanel = new JPanel (new GridBagLayout());
		lancePanel.add(lanceLabel, c);
		JLabel chakramLabel = new JLabel ("Chakram");
		JPanel chakramPanel = new JPanel (new GridBagLayout());
		chakramPanel.add(chakramLabel, c);
		JLabel slingLabel = new JLabel ("Sling");
		JPanel slingPanel = new JPanel (new GridBagLayout());
		slingPanel.add(slingLabel, c);
		JLabel gunLabel = new JLabel ("Gun");
		JPanel gunPanel = new JPanel (new GridBagLayout());
		gunPanel.add(gunLabel, c);
		c.anchor = GridBagConstraints.BASELINE_LEADING;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.gridx = 2;
		c.gridy = 0;
		c.insets = new Insets(1, 2, 1, 2);
		this.add(swordPanel, c);
		c.gridy = 1;
		this.add(maulPanel, c);
		c.gridy = 2;
		this.add(lancePanel, c);
		c.anchor = GridBagConstraints.BASELINE_TRAILING;
		c.gridx = 4;
		c.gridy = 0;
		this.add(chakramPanel, c);
		c.gridy = 1;
		this.add(slingPanel, c);
		c.gridy = 2;
		this.add(gunPanel, c);
		
		swordUp = new JButton ("+");
		maulUp = new JButton ("+");
		lanceUp = new JButton ("+");
		chakramUp = new JButton ("+");
		slingUp = new JButton ("+");
		gunUp = new JButton ("+");
		swordDown = new JButton ("-");
		maulDown = new JButton ("-");
		lanceDown = new JButton ("-");
		chakramDown = new JButton ("-");
		slingDown = new JButton ("-");
		gunDown = new JButton ("-");
		
	}//constructor
	
	public void updatePanel (){
		
	}//updatePanel
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == swordUp) {
			updatePanel();
		} else if (e.getSource() == maulUp) {
			updatePanel();
		} else if (e.getSource() == lanceUp) {
			updatePanel();
		} else if (e.getSource() == chakramUp) {
			updatePanel();
		} else if (e.getSource() == slingUp) {
			updatePanel();
		} else if (e.getSource() == gunUp) {
			updatePanel();
		} else if (e.getSource() == swordDown) {
			updatePanel();
		} else if (e.getSource() == maulDown) {
			updatePanel();
		} else if (e.getSource() == lanceDown) {
			updatePanel();
		} else if (e.getSource() == chakramDown) {
			updatePanel();
		} else if (e.getSource() == slingDown) {
			updatePanel();
		} else if (e.getSource() == gunDown) {
			updatePanel();
		}
	}//actionPerformed

}//WeaponUpgradePanel
