package bending;

import bending.moves.MoveType;
import bending.moves.Moves;
import element.Air;
import element.Fire;
import element.Water;
import bender.AirBender;

/**
 * AirBending, the bending of {@link AirBender}, uses the {@link Air} Element
 * @author jbacal
 *
 */
public class AirBending extends Bending {

	private static final Moves gust;
	private static final Moves windCut;
	private static final Moves windWall;
	
	static {
		gust = new Moves("Gust", MoveType.ATTACK, 
				Air.getElement(), 2, "Make a harmful gust");
		windCut = new Moves("Wind cut", MoveType.ATTACK, 
				Air.getElement(), 4, "Sharp wind that can cut");
		windWall = new Moves("Wind wall", MoveType.DEFENSE,
				Air.getElement(), 1, "A wall of wind, great against fire and "
						+ "water");
		
		gust.setAttack(1.69);
		windCut.setAttack(4.86);
		
		windWall.setDefense(1.90);
		windWall.addGreatAgainst(Fire.getElement());
		windWall.addGreatAgainst(Water.getElement());
	}
	
	public AirBending () {
		this.setElement(Air.getElement());
		this.moves.add(gust);
		this.moves.add(windWall);
		this.moves.add(windCut);
	}
	
}
