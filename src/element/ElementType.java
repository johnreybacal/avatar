package element;

/**
 * Type of element
 * @author jbacal
 *
 */
public enum ElementType {
	
	WATER("Water"),
	EARTH("Earth"),
	FIRE("Fire"),
	AIR("Air");
	
	private String name;
	
	ElementType (String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String toString () {
		return name;
	}
}
