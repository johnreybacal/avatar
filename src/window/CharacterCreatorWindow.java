package window;

import exception.NoFightersException;
import exception.NoOpposingFigtersException;
import game.CharacterCreator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

import battle.BattleSimulation;
import battle.Playable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Enumeration;
import java.util.Random;
import java.util.Set;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class CharacterCreatorWindow {

	private JFrame frame;
	private JTextField textFieldName;
	
	private int playerCounter = 0;
	private int playerCount;
	
	private Set<Playable> players;
	private JTree tree;
	private JLabel lblPlayer;

	/**
	 * Create the application.
	 */
	public CharacterCreatorWindow(int teamCount, int playerCount,
			Set<Playable> players, CharacterCreator cc) {
		this.players = players;
		this.playerCount = playerCount;
		initialize(teamCount, playerCount, cc);
		initializeTree();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int teamCount, int playerCount, final CharacterCreator cc) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 637, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 255));
		frame.getContentPane().add(panel_1, BorderLayout.EAST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 257, 0, 37, 0};
		gbl_panel_1.rowHeights = new int[]{18, 0, 30, 0, 0, 0, 0, 0, 0, 0, 42, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblInputPlayerDetails = new JLabel("Input player details");
		lblInputPlayerDetails.setHorizontalAlignment(SwingConstants.LEFT);
		lblInputPlayerDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblInputPlayerDetails = new GridBagConstraints();
		gbc_lblInputPlayerDetails.insets = new Insets(0, 0, 5, 5);
		gbc_lblInputPlayerDetails.gridx = 3;
		gbc_lblInputPlayerDetails.gridy = 1;
		panel_1.add(lblInputPlayerDetails, gbc_lblInputPlayerDetails);
		
		lblPlayer = new JLabel("Player #1");
		GridBagConstraints gbc_lblPlayer = new GridBagConstraints();
		gbc_lblPlayer.anchor = GridBagConstraints.WEST;
		gbc_lblPlayer.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer.gridx = 3;
		gbc_lblPlayer.gridy = 2;
		panel_1.add(lblPlayer, gbc_lblPlayer);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 3;
		panel_1.add(lblName, gbc_lblName);
		
		textFieldName = new JTextField();
		GridBagConstraints gbc_textFieldName = new GridBagConstraints();
		gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldName.gridx = 3;
		gbc_textFieldName.gridy = 3;
		panel_1.add(textFieldName, gbc_textFieldName);
		textFieldName.setColumns(10);
		
		final JCheckBox chckbxRandomName = new JCheckBox("Random Name");
		chckbxRandomName.setBackground(new Color(240, 255, 255));
		GridBagConstraints gbc_chckbxRandomName = new GridBagConstraints();
		gbc_chckbxRandomName.anchor = GridBagConstraints.WEST;
		gbc_chckbxRandomName.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxRandomName.gridx = 3;
		gbc_chckbxRandomName.gridy = 4;
		panel_1.add(chckbxRandomName, gbc_chckbxRandomName);
		
		JLabel lblBending = new JLabel("Bending");
		GridBagConstraints gbc_lblBending = new GridBagConstraints();
		gbc_lblBending.insets = new Insets(0, 0, 5, 5);
		gbc_lblBending.gridx = 1;
		gbc_lblBending.gridy = 5;
		panel_1.add(lblBending, gbc_lblBending);
		
		final JComboBox comboBoxBending = new JComboBox();
		comboBoxBending.setModel(new DefaultComboBoxModel(new String[] {"Water Bending", "Earth Bending", "Fire Bending", "Air Bending"}));
		GridBagConstraints gbc_comboBoxBending = new GridBagConstraints();
		gbc_comboBoxBending.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxBending.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxBending.gridx = 3;
		gbc_comboBoxBending.gridy = 5;
		panel_1.add(comboBoxBending, gbc_comboBoxBending);
		
		final JCheckBox chckbxRandomBending = new JCheckBox("Random Bending");
		chckbxRandomBending.setBackground(new Color(240, 255, 255));
		GridBagConstraints gbc_chckbxRandomBending = new GridBagConstraints();
		gbc_chckbxRandomBending.anchor = GridBagConstraints.WEST;
		gbc_chckbxRandomBending.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxRandomBending.gridx = 3;
		gbc_chckbxRandomBending.gridy = 6;
		panel_1.add(chckbxRandomBending, gbc_chckbxRandomBending);
		
		final JCheckBox chckbxAvatar = new JCheckBox("Avatar (Hover for more info)");
		chckbxAvatar.setToolTipText("Only one player can be the Avatar. Can bend all elements. Greatly boosts selected bending");
		chckbxAvatar.setBackground(new Color(240, 255, 255));
		GridBagConstraints gbc_chckbxAvatar = new GridBagConstraints();
		gbc_chckbxAvatar.anchor = GridBagConstraints.WEST;
		gbc_chckbxAvatar.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAvatar.gridx = 3;
		gbc_chckbxAvatar.gridy = 7;
		panel_1.add(chckbxAvatar, gbc_chckbxAvatar);
		
		JLabel lblTeam = new JLabel("Team");
		GridBagConstraints gbc_lblTeam = new GridBagConstraints();
		gbc_lblTeam.anchor = GridBagConstraints.WEST;
		gbc_lblTeam.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeam.gridx = 1;
		gbc_lblTeam.gridy = 8;
		panel_1.add(lblTeam, gbc_lblTeam);
		
		final JSpinner spinnerTeam = new JSpinner();
		spinnerTeam.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		GridBagConstraints gbc_spinnerTeam = new GridBagConstraints();
		gbc_spinnerTeam.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerTeam.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerTeam.gridx = 3;
		gbc_spinnerTeam.gridy = 8;
		panel_1.add(spinnerTeam, gbc_spinnerTeam);
		
		final JCheckBox chckbxRandomTeam = new JCheckBox("Random team");
		chckbxRandomTeam.setBackground(new Color(240, 255, 255));
		GridBagConstraints gbc_chckbxRandomTeam = new GridBagConstraints();
		gbc_chckbxRandomTeam.anchor = GridBagConstraints.WEST;
		gbc_chckbxRandomTeam.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxRandomTeam.gridx = 3;
		gbc_chckbxRandomTeam.gridy = 9;
		panel_1.add(chckbxRandomTeam, gbc_chckbxRandomTeam);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitButtonClicked(
						textFieldName.getText(),
						chckbxRandomName.isSelected(),
						comboBoxBending.getSelectedIndex(),
						chckbxRandomBending.isSelected(),
						chckbxAvatar,
						Integer.parseInt(spinnerTeam.getValue().toString()),
						chckbxRandomTeam.isSelected(),
						cc
						);
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmit.gridx = 3;
		gbc_btnSubmit.gridy = 10;
		panel_1.add(btnSubmit, gbc_btnSubmit);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		DefaultMutableTreeNode fightersTreeNode = new DefaultMutableTreeNode();
		DefaultTreeModel treeModel = new DefaultTreeModel(fightersTreeNode);
		
		for (int i = 0; i < teamCount; i++) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode("Team " + (i + 1));
			fightersTreeNode.add(node);
		}
		panel.setLayout(null);
		
		tree = new JTree();
		tree.setBounds(0, 0, 204, 338);
		
		tree.setModel(treeModel);
		panel.add(tree);
	}
	
	private void submitButtonClicked (String name, boolean randomName, 
			int bending, boolean randomBending, JCheckBox avatarCheckBox, 
			int team, boolean randomTeam, CharacterCreator cc) {
		
		boolean isValid = true;
		
		if (randomName) {
			name = cc.generateName();
		} else {
			if (name.trim().isEmpty()) {
				JOptionPane.showMessageDialog(
						frame, 
						"Please input a name or check the random name",
						"Invalid Player",
						JOptionPane.WARNING_MESSAGE);
				isValid = false;
			}
		}
		
		if (isValid) {			
			boolean isAvatar = avatarCheckBox.isSelected();
			if (randomBending) {
				bending = new Random().nextInt(4);
			}
			if (randomTeam) {
				team = cc.generateTeam();
			}
			if (isAvatar) {
				avatarCheckBox.setSelected(false);
				avatarCheckBox.setEnabled(false);
				avatarCheckBox.setVisible(false);
			}
			Playable player = cc.createCharacter(name, bending, isAvatar, team);
			this.players.add(player);
			
			DefaultTreeModel treeModel = (DefaultTreeModel) getTree().getModel();
			DefaultMutableTreeNode fightersTreeNode = 
					(DefaultMutableTreeNode) treeModel.getRoot();
			
			Enumeration en = fightersTreeNode.depthFirstEnumeration();
			while (en.hasMoreElements()) {
				try {
					DefaultMutableTreeNode node =
							(DefaultMutableTreeNode) en.nextElement();
					if (node.getUserObject().toString()
							.equals("Team " + player.getTeam())) {
						DefaultMutableTreeNode nodeFighter = 
								new DefaultMutableTreeNode(
										player.toString() + " [Player " 
										+ (playerCounter + 1) + "]");
						node.add(nodeFighter);
					}
				} catch (Exception e) {
					break;
				}
			}
			
			treeModel.reload(fightersTreeNode);
			
			playerCounter++;
			
			getLblPlayer().setText("Player #" + (playerCounter + 1));
			
			if (playerCounter == playerCount) {
				frame.setVisible(false);
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
		}
	}
	
	private void initializeTree () {
		DefaultTreeModel treeModel = (DefaultTreeModel) getTree().getModel();
		DefaultMutableTreeNode fightersTreeNode = 
				(DefaultMutableTreeNode) treeModel.getRoot();
		
		Enumeration en = fightersTreeNode.depthFirstEnumeration();
		while (en.hasMoreElements()) {
			try {
				DefaultMutableTreeNode node =
						(DefaultMutableTreeNode) en.nextElement();
				for (Playable player : players) {
					if (node.getUserObject().toString()
							.equals("Team " + player.getTeam())) {
						DefaultMutableTreeNode nodeFighter = 
								new DefaultMutableTreeNode(player.toString());
						node.add(nodeFighter);
					}
				}
			} catch (Exception e) {
				break;
			}
		}
		
		treeModel.reload(fightersTreeNode);
	}
	
	public Set<Playable> getPlayers () {
		return this.players;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public JTree getTree() {
		return tree;
	}
	public JLabel getLblPlayer() {
		return lblPlayer;
	}
}
