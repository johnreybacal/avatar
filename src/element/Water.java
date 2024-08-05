package element;

/**
 * Water element
 * @author jbacal
 *
 */
public class Water extends Element {
	
	private static Water water;
	
	private Water () {
		this.setType(ElementType.WATER);
	}

	public static Element getElement() {
		if (water == null) {
			water = new Water ();
		}
		return water;
	}
	
}
