package battle;

import java.util.List;

import bending.moves.MoveType;
import bending.moves.Moves;

/**
 * Concrete class for {@link Fighter}
 * Artificial Intelligence, relies mostly on random
 * @author jbacal
 *
 */
public class AI extends Fighter {

	public void decide (List<Playable> players) {
		super.decide(players);
		List<Moves> moves = getAvailableMoves();
		if (moves.size() > 0) {
			Moves move = moves.get(random.nextInt(moves.size()));
			this.setMove(move);
			if (move.getType() != MoveType.DEFENSE) {
				this.getBender().deductBendingPoints(move.getBendingPoints());
			}
			if (move.getType() == MoveType.ATTACK) {
				List<Playable> enemies = getEnemies(players);
				Playable enemy = enemies.get(random.nextInt(enemies.size()));
				DamageCalculator.calculateAndDoDamage(this, enemy);
			}			
		} else {
			System.out.println(this.getBender() + " seems to be exhausted");
		}
	}

}
