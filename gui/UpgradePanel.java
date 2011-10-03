package jslime.gui;

import java.awt.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class UpgradePanel extends JPanel {
	
	private JPanel imagePanel;
	
	public UpgradePanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		imagePanel = new JPanel();
		StatsUpgradePanel statsPanel = new StatsUpgradePanel();
		JTabbedPane boostPanel = new JTabbedPane (JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		StrengthBoostPanel strTab = new StrengthBoostPanel();
		boostPanel.addTab("Strength", strTab);
		DexterityBoostPanel dexTab = new DexterityBoostPanel();
		boostPanel.addTab("Dexterity", dexTab);
		VitalityBoostPanel vitTab = new VitalityBoostPanel();
		boostPanel.addTab("Vitality", vitTab);
		IntelligenceBoostPanel intTab = new IntelligenceBoostPanel();
		boostPanel.addTab("Intelligence", intTab);
		AgilityBoostPanel agiTab = new AgilityBoostPanel();
		boostPanel.addTab("Agility", agiTab);
		MentalityBoostPanel menTab = new MentalityBoostPanel();
		boostPanel.addTab("Mentality", menTab);
		WeaponUpgradePanel weaponPanel = new WeaponUpgradePanel();
		MagicUpgradePanel magicPanel = new MagicUpgradePanel();
		
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 150;
		c.ipady = 150;
		this.add(imagePanel, c);
		c.gridheight = 2;
		c.gridwidth = 1;
		c.gridy = 1;
		c.ipady = 25;
		this.add(statsPanel, c);
		c.gridheight = 1;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 0;
		c.ipadx = 150;
		c.ipady = 0;
		c.weightx = 0.5;
		this.add(boostPanel, c);
		c.gridy = 1;
		c.ipadx = 100;
		c.weightx = 0.0;
		this.add(weaponPanel, c);
		c.gridy = 2;
		this.add(magicPanel, c);
	}//constructor

}//UpgradePanel
