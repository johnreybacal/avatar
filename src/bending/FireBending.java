package bending;

import bender.FireBender;
import bending.moves.MoveType;
import bending.moves.Moves;
import element.Air;
import element.Earth;
import element.Fire;
import element.Water;

/**
 * FireBending, the bending of {@link FireBender}, uses the {@link Fire} Element
 * @author jbacal
 *
 */
public class FireBending extends Bending {

	private static final Moves firePunch;
	private static final Moves flameKick;
	private static final Moves fireWall;
	
	static {
		firePunch = new Moves("Fire punch", MoveType.ATTACK, 
				Fire.getElement(), 2, "Fundamental attack");
		flameKick = new Moves("Flame Kick", MoveType.ATTACK, 
				Fire.getElement(), 4, "High attack");
		fireWall = new Moves("Fire wall", MoveType.DEFENSE, 
				Fire.getElement(), 1, "Computer security");
		
		firePunch.setAttack(3);
		flameKick.setAttack(6.25);
		
		fireWall.setDefense(1.96);
		fireWall.addWeakAgainst(Water.getElement());
		fireWall.addWeakAgainst(Earth.getElement());
		fireWall.addWeakAgainst(Air.getElement());
	}
	
	public FireBending () {
		this.setElement(Fire.getElement());
		this.moves.add(firePunch);
		this.moves.add(fireWall);
		this.moves.add(flameKick);
	}
	
}
