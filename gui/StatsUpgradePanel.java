package jslime.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import jslime.JSlime;
import jslime.util.Attributes;

@SuppressWarnings("serial")
class StatsUpgradePanel extends JPanel implements ActionListener {
	
	private JButton strButtonUp;
	private JButton dexButtonUp;
	private JButton vitButtonUp;
	private JButton intButtonUp;
	private JButton agiButtonUp;
	private JButton menButtonUp;
	private JButton strButtonDown;
	private JButton dexButtonDown;
	private JButton vitButtonDown;
	private JButton intButtonDown;
	private JButton agiButtonDown;
	private JButton menButtonDown;
	private JLabel strLabel;
	private JLabel dexLabel;
	private JLabel vitLabel;
	private JLabel intLabel;
	private JLabel agiLabel;
	private JLabel menLabel;
	private int localStr;
	private int localDex;
	private int localVit;
	private int localInt;
	private int localAgi;
	private int localMen;
	
	public StatsUpgradePanel () {
		super(new GridBagLayout());
		strButtonUp = new JButton("+");
		dexButtonUp = new JButton("+");
		vitButtonUp = new JButton("+");
		intButtonUp = new JButton("+");
		agiButtonUp = new JButton("+");
		menButtonUp = new JButton("+");
		strButtonDown = new JButton("-");
		dexButtonDown = new JButton("-");
		vitButtonDown = new JButton("-");
		intButtonDown = new JButton("-");
		agiButtonDown = new JButton("-");
		menButtonDown = new JButton("-");
		
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.BASELINE_TRAILING;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 0, 0, 6);
		this.add (new JLabel ("Strength"), c);
		c.gridy = 1;
		this.add (new JLabel ("Dexterity"), c);
		c.gridy = 2;
		this.add (new JLabel ("Vitality"), c);
		c.gridy = 3;
		this.add (new JLabel ("Intelligence"), c);
		c.gridy = 4;
		this.add (new JLabel ("Agility"), c);
		c.gridy = 5;
		this.add (new JLabel("Mentality"), c);
		c.anchor = GridBagConstraints.BASELINE;
		c.gridx = 1;
		c.gridy = 0;
		c.ipadx = 1;
		c.ipady = 0;
		c.insets = new Insets(0, 1, 1, 1);
		this.add(strButtonDown, c);
		c.gridy = 1;
		this.add(dexButtonDown, c);
		c.gridy = 2;
		this.add(vitButtonDown, c);
		c.gridy = 3;
		this.add(intButtonDown, c);
		c.gridy = 4;
		this.add(agiButtonDown, c);
		c.gridy = 5;
		this.add(menButtonDown, c);
		c.gridx = 2;
		c.gridy = 0;
		this.add(strButtonUp, c);
		c.gridy = 1;
		this.add(dexButtonUp, c);
		c.gridy = 2;
		this.add(vitButtonUp, c);
		c.gridy = 3;
		this.add(intButtonUp, c);
		c.gridy = 4;
		this.add(agiButtonUp, c);
		c.gridy = 5;
		this.add(menButtonUp, c);
		
		Dimension d = new Dimension(18, 18);
		strButtonUp.setPreferredSize(d);
		dexButtonUp.setPreferredSize(d);
		vitButtonUp.setPreferredSize(d);
		intButtonUp.setPreferredSize(d);
		agiButtonUp.setPreferredSize(d);
		menButtonUp.setPreferredSize(d);
		strButtonDown.setPreferredSize(d);
		dexButtonDown.setPreferredSize(d);
		vitButtonDown.setPreferredSize(d);
		intButtonDown.setPreferredSize(d);
		agiButtonDown.setPreferredSize(d);
		menButtonDown.setPreferredSize(d);
		
		//getStats();
		
		//this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.black, Color.blue));
	}//constructor
	
	public void getStats(){
		localStr = JSlime.player.getNormalStat(Attributes.STRENGTH);
		localDex = JSlime.player.getNormalStat(Attributes.DEXTERITY);
		localVit = JSlime.player.getNormalStat(Attributes.VITALITY);
		localInt = JSlime.player.getNormalStat(Attributes.INTELLIGENCE);
		localAgi = JSlime.player.getNormalStat(Attributes.AGILITY);
		localMen = JSlime.player.getNormalStat(Attributes.MENTALITY);
	}//getStats
	
	public void updateComponents () {
		
	}//updateComponents
	
	public void confirmStats() {
		
	}//confirmStats
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == strButtonUp) {
			localStr++;
		} else if (e.getSource() == dexButtonUp) {
			localDex++;
		} else if (e.getSource() == vitButtonUp) {
			localVit++;
		} else if (e.getSource() == intButtonUp) {
			localInt++;
		} else if (e.getSource() == agiButtonUp) {
			localAgi++;
		} else if (e.getSource() == menButtonUp) {
			localMen++;
		} else if (e.getSource() == strButtonDown) {
			localStr--;
		} else if (e.getSource() == dexButtonDown) {
			localDex--;
		} else if (e.getSource() == vitButtonDown) {
			localVit--;
		} else if (e.getSource() == intButtonDown) {
			localInt--;
		} else if (e.getSource() == agiButtonDown) {
			localAgi--;
		} else if (e.getSource() == menButtonDown) {
			localMen--;
		}
	}//actionPerformed

}//StatUpgradePanel