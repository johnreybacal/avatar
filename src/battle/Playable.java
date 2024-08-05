package battle;

import java.util.List;

import bender.Bender;
import bending.moves.Moves;

/**
 * Interface for fighters
 * @author jbacal
 *
 */
public interface Playable extends Comparable<Playable>{
	
	/**
	 * Returns the bender of the {@link Playable} 
	 * @return
	 */
	public Bender getBender ();
	
	/**
	 * Returns the available moves of the bender depending on its bending points
	 * @return {@link Moves}
	 */
	public Moves getMove ();

	/**
	 * Set the bender of this Playable
	 * @param bender
	 */
	public void setBender (Bender bender);
	
	/**
	 * Set the team for this {@link Playable}  
	 * @param team
	 */
	public void setTeam (int team);
	
	/**
	 * Set the {@link Playable} current move
	 * @param move
	 */
	public void setMove (Moves move);
	
	/**
	 * Make {@link Playable} decide
	 * if {@link Playable} is of type {@link Player}
	 * move selection sceen is displayed
	 * if {@link Playable} is of type {@link AI}
	 * computer will decide  
	 * @param players
	 */
	public void decide (List<Playable> players);
	
	/**
	 * Calculate next move index
	 */
	public void nextMoveIndex ();
	
	/**
	 * Decrease damage to HP
	 * @param damage
	 */
	public void decreaseHP (double damage);
	
	/**
	 * Set the {@link Playable} bothered, making bending point charge less
	 */
	public void setBothered ();
	
	/**
	 * Check if {@link Playable} is still alive
	 * @return boolean
	 */
	public boolean isAlive ();
	
	/**
	 * Returns the next move index of the {@link Playable} 
	 * @return moveIndex
	 */
	public int getMoveIndex ();
	
	/**
	 * Returns the team of the {@link Playable} 
	 * @return team
	 */
	public int getTeam ();
	
	/**
	 * Returns the details of the {@link Playable} 
	 * @return String details
	 */
	public String getDetails ();
	
	/**
	 * Returns the {@link Playable} in string format
	 */
	public String toString ();
	
	/**
	 * Returns the HP of the {@link Playable} 
	 * @return HP
	 */
	public double getHP ();

}
