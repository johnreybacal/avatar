package battle;

import bender.Avatar;
import bending.Bending;
import bending.moves.MoveType;
import bending.moves.Moves;

import java.util.Random;

/**
 * Calculates the damage using multiple variables in the game
 * @author jbacal
 *
 */
public class DamageCalculator {

	private static Random random;
	
	public static void calculateAndDoDamage (
			Playable attacker, Playable target) {
		doDamage(target, calculateDamage(attacker, target));
	}
	
	public static double calculateDamage (Playable attacker, Playable target) {
		
		Moves attackerMove = attacker.getMove();
		Moves targetMove = target.getMove();
		attacker.setBothered();
		target.setBothered();
		double damage = attackerMove.getAttack();
		//amplify attack if avatar
		damage += nextDouble (damage / -5, 
				(attacker.getBender() instanceof Avatar) 
					? damage / 1.25 
					: damage / 4);
		
		//if attacker is avatar
		if (attacker.getBender() instanceof Avatar) {
			//if attack is avatar's primary bending
			Bending primaryBending = 
					((Avatar) attacker.getBender()).getPrimaryBending();
			if (attackerMove.getElement().equals(primaryBending.getElement())) {
				damage *= nextDouble(1.25, 2);
			}
		}
		System.out.println(attacker + " has used " + attackerMove 
				+ " against " + target);
		
		if (targetMove != null) {
			if (targetMove.getType() == MoveType.DEFENSE) {
				double defense = 0;
				if (target.getBender().getBendingPoints()
						>= targetMove.getBendingPoints()) {
					
					target.getBender().deductBendingPoints(
							targetMove.getBendingPoints());
					defense = targetMove.getDefense();
					//amplify defense if avatar
					defense	+= nextDouble(defense / -5, 
							(target.getBender() instanceof Avatar) 
								? defense / 1.5
								: defense / 4);
					
					//if target is avatar
					if (target.getBender() instanceof Avatar) {
						//if attack is avatar's primary bending
						Bending primaryBending = 
								((Avatar) target.getBender())
								.getPrimaryBending();
						if (targetMove.getElement()
								.equals(primaryBending.getElement())) {
							defense *= nextDouble(1.25, 2);
						}
					}
					
					System.out.println("\t" + target 
							+ " has used " + targetMove);
					
					if (targetMove.getGreatAgainst()
							.contains(attackerMove.getElement())) {
						//amplify defense, multiply by 1.5 to 3
						defense *= (1.5 + nextDouble(0, 1.5));
						System.out.println("\tThe attack is not very effective");
					} else if (targetMove.getWeakAgainst()
							.contains(attackerMove.getElement())) {
						//reduce defense, multiply by 0 to 0.50
						defense *= (0.25 + nextDouble(-0.25, 0.25));
						if (damage - defense > 0){
							System.out.println("\tThe attack is very effective");						
						}
					}
				}
				else {
					System.out.println("\t" + target.getBender()
							+ " seems to be exhausted");
				}
				damage -= defense;
				if (damage <= 0) {
					System.out.println("\tThe attack couldn't get through");
				}
			}
		}
		
		return damage;
		
	}
	
	public static void doDamage (Playable target, double damage) {
		if (damage > 0) {
			System.out.println("\t" + target.getBender() 
					+ "'s HP is decreased by " + String.format("%.2f", damage));
			target.decreaseHP(damage);			
			if (!target.isAlive()) {
				System.out.println("\t" +target + " has died");
			} else {
				System.out.println("\t" + target.getBender() + "'s HP is now "
						+ String.format("%.2f", target.getHP()));				
			}
		}
	}
	
	private static double nextDouble (double rangeMin, double rangeMax) {
		if (random == null) {
			random = new Random();
		}
		return rangeMin + (rangeMax - rangeMin) * random.nextDouble();
	}
	
}
