package game;

import battle.BattleSimulation;
import battle.Playable;
import battle.AI;
import battle.Player;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import window.GameInitializerWindow;
import exception.NoFightersException;
import exception.NoOpposingFigtersException;

/**
 * Entry point of the game
 * @author jbacal
 *
 */
public class Main implements Runnable {
	
	public static void main (String[] args) {
		
		Thread thread = new Thread(new Main());
		thread.start();
	}
	
	public void run () {
		Set<Playable> players = new HashSet<Playable>();
		GameInitializerWindow init = new GameInitializerWindow(players);
	}
	
	public void runCLI () {
		
		CharacterCreator cc = new CharacterCreator();
		Set<Playable> players = new HashSet<Playable>();
		
		clearScreen();
		
		System.out.println("+-------------------------------------+");
		System.out.println("|             WELCOME TO              |");
		System.out.println("|      BENDING BATTLE SIMULATION      |");
		System.out.println("+-------------------------------------+");
		System.out.println("Press \"ENTER\" to start...");
		
		try {
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();   
			initialize(cc, players);
		} catch (Exception e) {
			System.out.println("Initialization failed");
			return;
		}
		BattleSimulation bs = new BattleSimulation(players);
		try {
			bs.simulate();
		} catch (NoFightersException e) { 
			System.out.println("No fighter has entered the arena");
		} catch (NoOpposingFigtersException e) {
			System.out.println("No opposing fighters");
		} catch (Exception e) {
			System.out.println("Oh no");
			System.out.println(e);
		}
	}
	
	/**
	 * Series of handled inputs for initialization
	 * @param cc
	 * @param players
	 * @throws Exception
	 */
	public void initialize (CharacterCreator cc, Set<Playable> players)
			throws Exception {
		Scanner scanner = new Scanner(System.in);
		int teamCount;
		int playerCount;
		int aiCount;
		int aiAssignment;
		String input;
		
		System.out.print("Enter number of teams: ");
		input = scanner.nextLine();
		try {
			teamCount = Integer.parseInt(input);
			if (teamCount <= 1) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid number of teams");
			throw new Exception();
		}
		cc.setTeamCount(teamCount);
		
		System.out.print("Enter number of players: ");
		input = scanner.nextLine();
		try {
			playerCount = Integer.parseInt(input);
			if (playerCount < 0) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid number of players");
			throw new Exception();
		}
		
		for (int i = 0; i < playerCount; i++) {
			players.add(cc.createCharacter(new Player()));
		}
		
		System.out.print("Enter number of AI: ");
		input = scanner.nextLine();
		try {
			aiCount = Integer.parseInt(input);
			if (aiCount < 0) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid number of AIs");
			throw new Exception();
		}
		
		if (aiCount > 0) {
			
			System.out.print("Assign AI evenly accross teams?"
					+ "\n[1] Yes\n[2] Random\nInput: ");
			input = scanner.nextLine();
			try {
				aiAssignment = Integer.parseInt(input);
				if (aiAssignment < 1 || aiAssignment > 2) {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input");
				throw new Exception();
			}
			
			int team = 1;
			int playersInTeam = 0;
			for (int i = 0; i <= aiCount; i++) {
				if (aiAssignment == 1) {
					if (team > teamCount) {
						team = 1;
						playersInTeam++;
					}
					if (numberOfPlayersInTeam(players, team) <= playersInTeam) {
						players.add(cc.generateCharacter(new AI(), team++));						
					} else {
						team++;
					}
				} else {
					players.add(cc.generateCharacter(new AI()));
				}
			}
		}
	}
	
	public int numberOfPlayersInTeam (Set<Playable> players, int team) {
		int count = 0;
		for (Playable p : players) {
			if (p.getTeam() == team) {
				count++;
			}
		}
		return count;
	}
	
	private void clearScreen () {
		try
	    {
	        final String os = System.getProperty("os.name");
	        
	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
	
}
