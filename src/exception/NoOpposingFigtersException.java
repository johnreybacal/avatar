package exception;

import battle.BattleSimulation;
import battle.Playable;


/**
 * Thrown when {@link BattleSimulation} is started without any {@link Playable}
 * in opposing sides  
 * @author jbacal
 *
 */
public class NoOpposingFigtersException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoOpposingFigtersException () {
		this("No opposing fighters");
	}
	
	public NoOpposingFigtersException (String message) {
		super(message);
	}
	
}
