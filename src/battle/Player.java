package battle;

import java.util.List;
import java.util.Scanner;

import element.Element;
import bender.Avatar;
import bending.Bending;
import bending.moves.MoveType;
import bending.moves.Moves;

/**
 * Concrete class for {@link Fighter}
 * Handles user input for game control
 * @author jbacal
 *
 */
public class Player extends Fighter {

	private int playerNumber;
	private static int playerCounter = 1;
	
	{
		playerNumber = playerCounter++;
		System.out.println("======| Player " + playerNumber);
	}

	public void decide(List<Playable> players) {
		super.decide(players);
		Scanner scanner = new Scanner(System.in);
		Moves move;
		System.out.println();
//		System.out.println("========| PLAYER "+" |========");
		System.out.println("======| Player " + playerNumber + "'s Turn");
		System.out.println("Name: " + this.getBender());
		System.out.printf("HP:   %.2f\n", this.getHP());
		System.out.println("BP:   " + this.getBender().getBendingPoints());
		System.out.println(((this.getBender() instanceof Avatar) 
						? ((Avatar) this.getBender()).getPrimaryBending()
								+ " is greatly boosted"
						: ""));
		
		move = selectMove(scanner);
		
		if (move != null) {
			if (move.getType() == MoveType.ATTACK) {
				Playable enemy = selectTarget(move, players, scanner);
				DamageCalculator.calculateAndDoDamage(this, enemy);
			}
		}
		
		System.out.println("======| TURN COMPLETE |======\n");
	}

	public Moves selectMove (Scanner scanner) {
		List<Moves> moves = getAvailableMoves();
		int choice;
		Moves move = null;
		boolean isAvatar = false;
		Element primaryElement = null;
		if (this.getBender() instanceof Avatar) {
			isAvatar = true;
			primaryElement = ((Avatar) this.getBender()).getPrimaryBending()
					.getElement();
		}
		if (moves.size() > 0) {
			
			System.out.println("Available moves:");
			for (int i = 0; i < moves.size(); i++) {
				Moves m = moves.get(i);
				System.out.print("  [" + (i + 1) + "] "
						+ m + " | " + m.getDescription() + "\n"
						+ String.format("%1$" + (((i + 1) / 10) + 4) + "s", "")
						+ "| BP: " + m.getBendingPoints());
				String info;
				switch (m.getType()) {
				case ATTACK:
					info = " | Damage: " + m.getAttack();
					break;
				case DEFENSE:
					info = " | Defense: " + m.getDefense();
					break;
				default:
					info = "";
				}
				if (isAvatar) {
					if (m.getElement().equals(primaryElement)) {
						info += " | BOOSTED";
					}
				}
				System.out.println(info);
			}
			System.out.print("  Select your move: ");
			try {
				choice = scanner.nextInt();
				move = moves.get(choice - 1);
			} catch (Exception e) {
				move = moves.get(random.nextInt(moves.size()));
			}
			this.setMove(move);
			if (move.getType() != MoveType.DEFENSE) {
				this.getBender().deductBendingPoints(move.getBendingPoints());				
			}
		} else {
			System.out.println("You don't have enough bending points");
			System.out.println("Press enter to continue");
			try {
	            System.in.read();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		return move;
	}
	
	public Playable selectTarget (Moves move, 
			List<Playable> players, Scanner scanner) {
		int choice;
		List<Playable> enemies = getEnemies(players);
		Playable enemy;
		System.out.println("Enemies:");
		for (int i = 0; i < enemies.size(); i++) {
			Playable e = enemies.get(i);
			System.out.println("  [" + (i + 1) + "] " + e
					+ " " + e.getBender().getBending() + "\n"
					+ String.format("%1$" + (((i + 1) / 10) + 4) + "s", "")
					+ "| Team " + e.getTeam()
					+ " | HP: " + String.format("%.2f", e.getHP()));
		}
		System.out.print("  Select your target: ");
		try {
			choice = scanner.nextInt();
			enemy = enemies.get(choice - 1);
		} catch (Exception e) {
			enemy = enemies.get(random.nextInt(enemies.size()));
		}
		System.out.println();
		return enemy;
	}

	/**
	 * @return the playerNumber
	 */
	public int getPlayerNumber() {
		return playerNumber;
	}

}
