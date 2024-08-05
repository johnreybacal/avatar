package element;

/**
 * Earth element
 * @author jbacal
 *
 */
public class Earth extends Element {
	
	private static Earth earth;
	
	public Earth () {
		this.setType(ElementType.EARTH);
	}
	
	public static Element getElement() {
		if (earth == null) {
			earth = new Earth ();
		}
		return earth;
	}
	
}
