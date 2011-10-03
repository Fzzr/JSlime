package jslime.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel implements ActionListener {
	
	private JButton start;
	private JButton load;
	private JButton save;
	private JButton options;
	private JButton extras;
	private JButton quit;
	
	public MenuPanel () {
		super (new GridLayout(6, 1));
		start = new JButton("Start");
		load = new JButton("Load");
		save = new JButton("Save");
		options = new JButton ("Options");
		extras = new JButton ("Extras");
		quit = new JButton ("Quit");
		start.addActionListener(this);
		load.addActionListener(this);
		save.addActionListener(this);
		options.addActionListener(this);
		extras.addActionListener(this);
		quit.addActionListener(this);
		this.add(start);
		this.add(load);
		this.add(save);
		this.add(options);
		this.add(extras);
		this.add(quit);
	}//constructor
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			
		}
		if (e.getSource() == load) {
			
		}
		if (e.getSource() == save) {
			
		}
		if (e.getSource() == options) {
			
		}
		if (e.getSource() == extras) {
			
		}
		if (e.getSource() == quit) {
			//prompt for save
			System.exit(0);
		}
	}//actionPerformed

}//MenuPanel
