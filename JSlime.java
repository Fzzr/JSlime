package jslime;

import java.util.Random;
import java.awt.*;
import javax.swing.*;
import jslime.gui.*;

/**
 * Program Name: JSlime
 * Author: Ben Milman, based on code and ideas by Samuel Weber
 * Date: June 15, 2010 (start)
 * Written and Compiled in Netbeans on Mac OS X.
 * Description: Java GUI port of Slime by Samuel Weber
 */
@SuppressWarnings("serial")
public class JSlime extends JFrame{
	
	private static final JSlime JSLIMESINGLETON = new JSlime();
	
	public static Random rng; //loaded new on launch. RNG state-saving functionality not provided.
	public static Player player; //the player character object
	
	private BattlePanel battlePanel; //the bottom panel with the battle controls
	private MenuPanel menuPanel; //the right side panel
	private StatsPanel statsPanel; //the bottom panel with the player's hp, mp, xp, and attributes
	private JPanel otherPane; //contains the battlePanel and statsPanel
	private JPanel mainPane; //contains the displayPane and otherPane to separate them from the menuPanel
	private JPanel displayPane; //the large panel in the upper left with variable contents
	private JPanel superPane; //contains all other panels in order to add them to the ContentPane
	
	//the following are for use by the displayPane's CardLayout
	final static String UPGRADE_SCREEN_ACCESS = "UPGRADE";
	final static String TITLE_SCREEN_ACCESS = "TITLE";
	final static String BATTLE_SCREEN_ACCESS = "BATTLE";
	final static String MAP_SCREEN_ACCESS = "MAP";
	final static String STORY_SCREEN_ACCESS = "STORY";
	
	private JSlime () {
		super("JSlime");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(900, 600);
		
		superPane = new JPanel(new BorderLayout());
		superPane.setBorder(BorderFactory.createEmptyBorder(6, 7, 4, 7));
		mainPane = new JPanel(new BorderLayout());
		otherPane = new JPanel (new GridLayout());
		statsPanel = new StatsPanel();
		otherPane.add(statsPanel);
		battlePanel = new BattlePanel();
		otherPane.add(battlePanel);
		mainPane.add(otherPane, BorderLayout.PAGE_END);
		displayPane = new JPanel(new CardLayout());
		displayPane.add(new UpgradePanel(), UPGRADE_SCREEN_ACCESS);
		mainPane.add(displayPane, BorderLayout.CENTER);
		menuPanel = new MenuPanel();
		superPane.add(menuPanel, BorderLayout.LINE_END);
		superPane.add(mainPane, BorderLayout.CENTER);
		this.getContentPane().add(superPane);
		
		rng = new Random();
	}//constructor
	
	public static JSlime getJSlime() {
        return JSLIMESINGLETON;
    }
	
	public static void main(String[] args) {
		//player = new Player();
		JSlime slime = new JSlime();
		slime.setVisible(true);
	}//main

}//JSlime
