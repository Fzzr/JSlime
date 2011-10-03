package jslime.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
class MagicUpgradePanel extends JPanel implements ActionListener {
	
	private int localFire;
	private int localWind;
	private int localDark;
	private int localIce;
	private int localEarth;
	private int localLight;
	private int localLuna;
	
	private JButton fireUp;
	private JButton windUp;
	private JButton darkUp;
	private JButton iceUp;
	private JButton earthUp;
	private JButton lightUp;
	private JButton lunaUp;
	private JButton fireDown;
	private JButton windDown;
	private JButton darkDown;
	private JButton iceDown;
	private JButton earthDown;
	private JButton lightDown;
	private JButton lunaDown;
	
	public MagicUpgradePanel () {
		super (new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		 fireUp = new JButton("+");
		 windUp = new JButton("+");
		 darkUp = new JButton("+");
		 iceUp = new JButton("+");
		 earthUp = new JButton("+");
		 lightUp = new JButton("+");
		 lunaUp = new JButton("+");
		 fireDown = new JButton("-");
		 windDown = new JButton("-");
		 darkDown = new JButton("-");
		 iceDown = new JButton("-");
		 earthDown = new JButton("-");
		 lightDown = new JButton("-");
		 lunaDown = new JButton("-");
		
		JLabel fireLabel = new JLabel ("Fire");
		JPanel firePanel = new JPanel (new GridBagLayout());
		firePanel.add(fireLabel, c);
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.gridx = 2;
		c.gridy = 0;
		c.insets = new Insets(1, 2, 1, 2);
		this.add(firePanel);
		
		JLabel windLabel = new JLabel ("Wind");
		JPanel windPanel = new JPanel (new GridBagLayout());
		windPanel.add(windLabel, c);
		c.anchor = GridBagConstraints.BASELINE_LEADING;
		c.gridy = 1;
		this.add(windPanel);
		
		JLabel darkLabel = new JLabel ("Dark");
		JPanel darkPanel = new JPanel (new GridBagLayout());
		darkPanel.add(darkLabel, c);
		c.anchor = GridBagConstraints.LAST_LINE_START;
		c.gridy = 2;
		this.add(darkPanel);
		
		JLabel iceLabel = new JLabel ("Ice");
		JPanel icePanel = new JPanel (new GridBagLayout());
		icePanel.add(iceLabel, c);
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		c.gridx = 4;
		c.gridy = 0;
		this.add(icePanel);
		
		JLabel earthLabel = new JLabel ("Earth");
		JPanel earthPanel = new JPanel (new GridBagLayout());
		earthPanel.add(earthLabel, c);
		c.anchor = GridBagConstraints.BASELINE_TRAILING;
		c.gridy = 1;
		this.add(earthPanel);
		
		JLabel lightLabel = new JLabel ("Light");
		JPanel lightPanel = new JPanel (new GridBagLayout());
		lightPanel.add(lightLabel, c);
		c.anchor = GridBagConstraints.LAST_LINE_END;
		c.gridy = 2;;
		this.add(lightPanel);
		
		JLabel lunaLabel = new JLabel ("Luna");
		JPanel lunaPanel = new JPanel (new GridBagLayout());
		lunaPanel.add(lunaLabel, c);
		c.anchor = GridBagConstraints.BASELINE;
		this.add(lunaPanel);
	}//constructor
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fireUp) {
			localFire++;
		} else if (e.getSource() == windUp ) {
			localWind++;
		} else if (e.getSource() == darkUp) {
			localDark++;
		} else if (e.getSource() == iceUp) {
			localIce++;
		} else if (e.getSource() == earthUp) {
			localEarth++;
		} else if (e.getSource() == lightUp) {
			localLight++;
		} else if (e.getSource() == lunaUp) {
			localLuna++;
		} else if (e.getSource() == fireDown) {
			localFire--;
		} else if (e.getSource() == windDown) {
			localWind--;
		} else if (e.getSource() == darkDown) {
			localDark--;
		} else if (e.getSource() == iceDown) {
			localIce--;
		} else if (e.getSource() == earthDown) {
			localEarth--;
		} else if (e.getSource() == lightDown) {
			localLight--;
		} else if (e.getSource() == lunaDown ) {
			localLuna--;
		}
	}//actionPerformed

}//MagicUpgradePanel
