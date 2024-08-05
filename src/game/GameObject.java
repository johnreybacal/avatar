package game;

/**
 * Parent for all class in the game
 * wraps a name to an object
 * @author jbacal
 *
 */
public abstract class GameObject {

	private String name;

	/**
	 * Set the name of this GameObject
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Return the name of this GameObject
	 */
	public String toString() {
		return name;
	}
}
