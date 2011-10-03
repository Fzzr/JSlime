package jslime.gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import jslime.util.Attributes;
import jslime.util.UnknownTypeException;

@SuppressWarnings("serial")
public class StatsPanel extends JPanel {
	private JProgressBar hpBar;
	private JLabel hpLabel;
	private JProgressBar mpBar;
	private JLabel mpLabel;
	private JProgressBar xpBar;
	private JLabel xpLabel;
	private JLabel [] stats;
	
	public StatsPanel () {
		super(new GridLayout(1, 2));

		JPanel stuffPanel = new JPanel(new GridLayout(6, 1));
		JPanel hpPanel = new JPanel(new GridBagLayout());
		hpBar = new JProgressBar();
		hpBar.setMinimum(0);
		hpBar.setMaximum(100);
		hpBar.setValue(66);
		hpBar.setIndeterminate(false);
		hpLabel = new JLabel (" HP");
		hpPanel.add(hpBar);
		hpPanel.add(hpLabel);
		stuffPanel.add(hpPanel);
		stuffPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
		JPanel mpPanel = new JPanel(new GridBagLayout());
		mpBar = new JProgressBar();
		mpLabel = new JLabel(" MP");
		mpPanel.add(mpBar);
		mpPanel.add(mpLabel);
		stuffPanel.add(mpPanel);
		JPanel xpPanel = new JPanel(new GridBagLayout());
		xpBar = new JProgressBar();
		xpLabel = new JLabel(" XP");
		xpPanel.add(xpBar);
		xpPanel.add(xpLabel);
		stuffPanel.add(xpPanel);
		JPanel statsPanel = new JPanel(new GridLayout(6, 1));
		stats = new JLabel[6];
		try {
			for (int i = 0; i < stats.length; i++) {
				stats[i] = new JLabel(Attributes.identifyAttribute(i).getRealName());
			}
		} catch (UnknownTypeException e) {
			System.err.println(e.getMessage());
		}
		for (JLabel stat: stats){
			JPanel statPanel = new JPanel();
			statPanel.add(stat);
			statsPanel.add(statPanel);
		}
		
		this.add(stuffPanel);
		this.add(statsPanel);
	}//constructor
}//StatsPanel
