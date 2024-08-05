package element;

/**
 * Fire element
 * @author jbacal
 *
 */
public class Fire extends Element {
	
	private static Fire fire;
	
	public Fire () {
		this.setType(ElementType.FIRE);
	}
	
	public static Element getElement() {
		if (fire == null) {
			fire = new Fire ();
		}
		return fire;
	}
	
}
