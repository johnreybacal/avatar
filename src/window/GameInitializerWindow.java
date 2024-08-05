package window;

import exception.NoFightersException;
import exception.NoOpposingFigtersException;
import game.CharacterCreator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import net.miginfocom.swing.MigLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import battle.AI;
import battle.BattleSimulation;
import battle.Playable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Set;

public class GameInitializerWindow {

	private JFrame frame;

	private Set<Playable> players;
	private JCheckBox chckbxAssignAiEvenly;
	/**
	 * Create the application.
	 */
	public GameInitializerWindow(Set<Playable> players) {
		initialize();
		this.players = players;
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel lblGameInitializer = new JLabel("Game Initializer");
		JLabel lblNumberOfTeams = new JLabel("Number of Teams");
		final JSpinner spinnerNumberOfTeams = new JSpinner();
		JLabel lblNumberOfPlayers = new JLabel("Number of Players");
		final JSpinner spinnerNumberOfPlayers = new JSpinner();
		JLabel lblNumberOfAis = new JLabel("Number of AIs");
		final JSpinner spinnerNumberOfAI = new JSpinner();
		chckbxAssignAiEvenly = new JCheckBox("Assign AI evenly across teams");
		JPanel panel_1 = new JPanel();
		JButton btnNewButton = new JButton("Commence Battle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commenceBattle(
						Integer.parseInt(
								spinnerNumberOfTeams.getValue().toString()),
						Integer.parseInt(
								spinnerNumberOfPlayers.getValue().toString()), 
						Integer.parseInt(
								spinnerNumberOfAI.getValue().toString()));
			}
		});

		frame.setTitle("Bending Battle Simulation");
		frame.setResizable(false);
		frame.setBounds(100, 100, 435, 280);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setBorder(null);
		panel.setBackground(new Color(240, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{40, 0, 67, 47, 46, 0};
		gbl_panel.rowHeights = new int[]{62, 20, 20, 20, 23, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblGameInitializer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblGameInitializer = new GridBagConstraints();
		gbc_lblGameInitializer.fill = GridBagConstraints.BOTH;
		gbc_lblGameInitializer.insets = new Insets(0, 0, 5, 5);
		gbc_lblGameInitializer.gridwidth = 2;
		gbc_lblGameInitializer.gridx = 1;
		gbc_lblGameInitializer.gridy = 0;
		panel.add(lblGameInitializer, gbc_lblGameInitializer);
		
		GridBagConstraints gbc_lblNumberOfTeams = new GridBagConstraints();
		gbc_lblNumberOfTeams.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNumberOfTeams.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfTeams.gridx = 1;
		gbc_lblNumberOfTeams.gridy = 2;
		panel.add(lblNumberOfTeams, gbc_lblNumberOfTeams);
			
		spinnerNumberOfTeams.setModel(new SpinnerNumberModel(2, 2, 10, 1));
		GridBagConstraints gbc_spinnerNumberOfTeams = new GridBagConstraints();
		gbc_spinnerNumberOfTeams.anchor = GridBagConstraints.NORTH;
		gbc_spinnerNumberOfTeams.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerNumberOfTeams.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerNumberOfTeams.gridx = 3;
		gbc_spinnerNumberOfTeams.gridy = 2;
		panel.add(spinnerNumberOfTeams, gbc_spinnerNumberOfTeams);
		lblNumberOfTeams.setLabelFor(spinnerNumberOfTeams);
		
		lblNumberOfPlayers.setLabelFor(lblNumberOfPlayers);
		GridBagConstraints gbc_lblNumberOfPlayers = new GridBagConstraints();
		gbc_lblNumberOfPlayers.anchor = GridBagConstraints.EAST;
		gbc_lblNumberOfPlayers.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfPlayers.gridx = 1;
		gbc_lblNumberOfPlayers.gridy = 3;
		panel.add(lblNumberOfPlayers, gbc_lblNumberOfPlayers);
		
		spinnerNumberOfPlayers.setModel(new SpinnerNumberModel(0, 0, 4, 1));
		GridBagConstraints gbc_spinnerNumberOfPlayers = new GridBagConstraints();
		gbc_spinnerNumberOfPlayers.anchor = GridBagConstraints.NORTH;
		gbc_spinnerNumberOfPlayers.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerNumberOfPlayers.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerNumberOfPlayers.gridx = 3;
		gbc_spinnerNumberOfPlayers.gridy = 3;
		panel.add(spinnerNumberOfPlayers, gbc_spinnerNumberOfPlayers);
		
		GridBagConstraints gbc_lblNumberOfAis = new GridBagConstraints();
		gbc_lblNumberOfAis.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNumberOfAis.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfAis.gridx = 1;
		gbc_lblNumberOfAis.gridy = 4;
		panel.add(lblNumberOfAis, gbc_lblNumberOfAis);
		
		spinnerNumberOfAI.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				numberOfAIValueChanged(
						Integer.parseInt(
								spinnerNumberOfAI.getValue().toString()),
						chckbxAssignAiEvenly);
			}
		});
		spinnerNumberOfAI.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		GridBagConstraints gbc_spinnerNumberOfAI = new GridBagConstraints();
		gbc_spinnerNumberOfAI.anchor = GridBagConstraints.NORTH;
		gbc_spinnerNumberOfAI.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerNumberOfAI.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerNumberOfAI.gridx = 3;
		gbc_spinnerNumberOfAI.gridy = 4;
		panel.add(spinnerNumberOfAI, gbc_spinnerNumberOfAI);
		
		chckbxAssignAiEvenly.setEnabled(false);
		chckbxAssignAiEvenly.setBackground(new Color(240, 255, 255));
		chckbxAssignAiEvenly.setSelected(true);
		GridBagConstraints gbc_chckbxAssignAiEvenly = new GridBagConstraints();
		gbc_chckbxAssignAiEvenly.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxAssignAiEvenly.anchor = GridBagConstraints.NORTHEAST;
		gbc_chckbxAssignAiEvenly.gridwidth = 3;
		gbc_chckbxAssignAiEvenly.gridx = 1;
		gbc_chckbxAssignAiEvenly.gridy = 5;
		panel.add(chckbxAssignAiEvenly, gbc_chckbxAssignAiEvenly);
		
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(0, 139, 139));
		frame.getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_1.add(btnNewButton);
	}
	
	private void numberOfAIValueChanged (int value, JCheckBox checkBoxAICount) {
		checkBoxAICount.setEnabled(value > 0);
	}
	
	private void commenceBattle (int teamCount, int playerCount, int aiCount) {
		if (playerCount + aiCount > 1) {
			CharacterCreator cc = new CharacterCreator();
			cc.setTeamCount(teamCount);
			
			int team = 1;
			int playersInTeam = 0;
			boolean assignAIEvenly = getChckbxAssignAiEvenly().isSelected();
			for (int i = 0; i < aiCount; i++) {
				if (assignAIEvenly) {
					if (team > teamCount) {
						team = 1;
						playersInTeam++;
					}
					if (numberOfPlayersInTeam(team) <= playersInTeam) {
						players.add(cc.generateCharacter(new AI(), team++));						
					} else {
						team++;
					}
				} else {
					players.add(cc.generateCharacter(new AI()));
				}
			}
			
			if (playerCount > 0) {
				frame.setVisible(false);
				CharacterCreatorWindow ccw = 
						new CharacterCreatorWindow(
								teamCount,
								playerCount, 
								players,
								cc);
				players = ccw.getPlayers();
			} else {
				BattleSimulation bs = new BattleSimulation(players);				
				try {
					bs.simulate();
				} catch (NoFightersException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoOpposingFigtersException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			JOptionPane.showMessageDialog(
					getFrame(), 
					"Please add more Players or AI",
					"Insufficient Players", 
					JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public Set<Playable> getPlayers () {
		return this.players;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	protected JCheckBox getChckbxAssignAiEvenly() {
		return chckbxAssignAiEvenly;
	}
	
	private int numberOfPlayersInTeam (int team) {
		int count = 0;
		for (Playable p : players) {
			if (p.getTeam() == team) {
				count++;
			}
		}
		return count;
	}
	
}
