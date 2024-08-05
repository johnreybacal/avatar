package battle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import exception.NoFightersException;
import exception.NoOpposingFigtersException;
import bender.Avatar;
import bending.moves.MoveType;

/**
 * Simulate the battle
 */
public class BattleSimulation {

	private static int INITIAL_TIME_LAPSE = 100;
	
	private List<Playable> players;
	
	public BattleSimulation (Set<Playable> players) {
		setPlayers(players);
	}
	
	public void simulate () 
			throws NoFightersException, NoOpposingFigtersException {
		if (this.players.isEmpty()) {
			throw new NoFightersException();
		}
		if (oneTeamLeft()) {
			throw new NoOpposingFigtersException();
		}
		boolean battleOver = false;
		int timeLapse = INITIAL_TIME_LAPSE;
		Set<Playable> dead = new HashSet<Playable>();
		Set<Playable> players = new HashSet<Playable>();
		
		System.out.println("\n=====| COMMENCE BATTLE |=====");
		do {
			System.out.println("...");
			timeLapse = nextTimeLapse(timeLapse);
			players = checkTurn(timeLapse);
			for (Playable p : players) {
				if (p.isAlive()) {					
					dead.clear();
					p.decide(this.players);
					
					if (p.getMove().getType() != MoveType.DEFENSE) {
						promptEnterKey();
					}
					
					if (p instanceof Player) {
						clearScreen();
					}
					
					for (Playable pd : this.players) {
						if (!pd.isAlive()) {
							dead.add(pd);
						}
					}
				}
			}
			for (Playable defeated : dead) {
				this.players.remove(defeated);
			}
			if(timeLapse == 0){
				timeLapse = INITIAL_TIME_LAPSE;
			}
			
			battleOver = oneTeamLeft();
		} while (!battleOver);
		
		System.out.println("\n=============================");
		System.out.print("Victory goes to ");
		boolean first = true;
		int counter = 1;
		for (Playable p : this.players) {
			if (first) {
				System.out.println("Team " + p.getTeam());
				first = false;
			}
			System.out.println("| " + counter + ".\t" + p 
					+ ((p instanceof Player) 
					? " [Player " + ((Player) p).getPlayerNumber() + "]" 
					: ""));
			counter++;
		}
		System.out.println("=============================");
	}
	
	public void promptEnterKey(){
	   System.out.println("Press \"ENTER\" to continue...");
	   Scanner scanner = new Scanner(System.in);
	   try {
		   scanner.nextLine();   
	   } catch (Exception e) {
	   }
	}
	
	private void setPlayers (Set<Playable> players) {
		boolean hasAvatar = false;
		Set<Playable> duplicateAvatar = new HashSet<Playable>();
		
		for (Playable p : players) {
			if (hasAvatar) {
				//remove duplicate reference
				if (p.getBender() instanceof Avatar) {
					duplicateAvatar.add(p);
				}
			}
			if (!hasAvatar && p.getBender() instanceof Avatar) {
				hasAvatar = true;
			}
		}
		players.removeAll(duplicateAvatar);
		this.players = new ArrayList<Playable>(players);
		
		Collections.sort(this.players);
		boolean first = true;
		int team = -1;
		int counter = 1;
		for (Playable p : this.players) {
			if (first) {
				team = p.getTeam();
				first = false;
				System.out.println("Team " + team);
			}
			else {
				if (team != p.getTeam()) {
					team = p.getTeam();
					System.out.println("Team " + team);
					counter = 1;
				}
			}
			System.out.println("| " + counter + ".\t" + p
					+ ((p instanceof Player) 
					? " [Player " + ((Player) p).getPlayerNumber() + "]" 
					: ""));
			counter++;
		}
	}
	
	private boolean oneTeamLeft () {
		int teams = 0;
		int team = 0;
		for (Playable player : this.players) {
			if (teams == 0) { //first loop
				team = player.getTeam();
				teams++;
			} else {
				if (team != player.getTeam()) { //check if team is different
					teams++;
				}
				if (teams > 1) {
					break;
				}
			}
		}
		
		return teams == 1;
	}
	
	private Set<Playable> checkTurn (final int timeLapse) {
		Set<Playable> players = new HashSet<Playable>();
		for (Playable player : this.players) {
			if (player.getMoveIndex() == timeLapse) {
				player.nextMoveIndex();
				players.add(player);
			}
		}
		return players;
	}
	
	private int nextTimeLapse (int timeLapse) {
		int next = 0;
		int moveIndex;
		for (Playable p : this.players) {
			moveIndex = p.getMoveIndex();
			if (moveIndex > next && moveIndex < timeLapse) {
				next = moveIndex;
			}
		}
		return next;
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
