package bending;

import bender.WaterBender;
import bending.moves.MoveType;
import bending.moves.Moves;
import element.Earth;
import element.Fire;
import element.Water;

/**
 * WaterBending, the bending of {@link WaterBender}, 
 * uses the {@link Water} Element
 * @author jbacal
 *
 */
public class WaterBending extends Bending {
	
	private static final Moves splash;
	private static final Moves tsunami;
	private static final Moves waterBarrier;
	
	static {
		splash = new Moves("Splash", MoveType.ATTACK, 
				Water.getElement(), 2, "Get wet");
		tsunami = new Moves("Tsunami", MoveType.ATTACK, 
				Water.getElement(), 5, "GET WET");
		waterBarrier = new Moves("Water barrier", MoveType.DEFENSE, 
				Water.getElement(), 1, "Great protection against fire");
		
		splash.setAttack(1.75);
		tsunami.setAttack(5);
		
		waterBarrier.setDefense(2);
		waterBarrier.addGreatAgainst(Fire.getElement());
		waterBarrier.addWeakAgainst(Earth.getElement());
	}
	
	public WaterBending () {
		this.setElement(Water.getElement());
		this.moves.add(splash);
		this.moves.add(tsunami);
		this.moves.add(waterBarrier);
	}
	
}
