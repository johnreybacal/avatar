package bending.moves;

/**
 * Type of move
 * @author jbacal
 *
 */
public enum MoveType {

	ATTACK("Attack"),
	DEFENSE("Defense"),
	PASSIVE("Passive");
	
	private String name;
	
	MoveType (String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String toString () {
		return name;
	}
}
