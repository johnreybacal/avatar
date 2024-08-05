package element;

import game.GameObject;

/**
 * Generic element
 * @author jbacal
 *
 */
public abstract class Element extends GameObject {
	
	private ElementType type;
	
	/**
	 * @return the type
	 */
	public ElementType getType () {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	protected void setType (ElementType type) {
		this.type = type;
		this.setName(this.type.toString());
	}

}
