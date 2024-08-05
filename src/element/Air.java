package element;

/**
 * Air element
 * @author jbacal
 *
 */
public class Air extends Element {
	
	private static Air air;
	
	public Air () {
		this.setType(ElementType.AIR);
	}
	
	public static Element getElement() {
		if (air == null) {
			air = new Air ();
		}
		return air;
	}
	
}
