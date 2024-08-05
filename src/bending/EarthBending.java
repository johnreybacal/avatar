package bending;

import bender.EarthBender;
import bending.moves.MoveType;
import bending.moves.Moves;
import element.Air;
import element.Earth;
import element.Fire;
import element.Water;

/**
 * EarthBending, the bending of {@link EarthBender}, uses the {@link Earth} Element
 * @author jbacal
 *
 */
public class EarthBending extends Bending {

	private static final Moves rockShoot;
	private static final Moves boulder;
	private static final Moves rockWall;
	
	static {
		rockShoot = new Moves("Rock shoot", MoveType.ATTACK, 
				Earth.getElement(), 2, "Shoot a rock at an enemy");
		boulder = new Moves("Boulder", MoveType.ATTACK, 
				Earth.getElement(), 4, "Throw a boulder");
		rockWall = new Moves("Rock wall", MoveType.DEFENSE,
				Earth.getElement(), 2, "A great defense against other element");
		
		rockShoot.setAttack(2.5);
		boulder.setAttack(5);
		
		rockWall.setDefense(3.75);
		rockWall.addGreatAgainst(Water.getElement());
		rockWall.addGreatAgainst(Fire.getElement());
		rockWall.addGreatAgainst(Air.getElement());
	}
	
	public EarthBending () {
		this.setElement(Earth.getElement());
		this.moves.add(rockShoot);
		this.moves.add(rockWall);
		this.moves.add(boulder);
	}
	
}
