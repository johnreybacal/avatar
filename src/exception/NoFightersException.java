package exception;

import battle.Playable;
import battle.BattleSimulation;;

/**
 * Thrown when {@link BattleSimulation} is started without any {@link Playable}  
 * @author jbacal
 *
 */
public class NoFightersException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoFightersException () {
		this("No fighter have entered the arena");
	}

	public NoFightersException (String message) {
		super(message);
	}
	
}
