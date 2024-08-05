package bender;

import element.Earth;
import bending.EarthBending;

/**
 * {@link Bender} of {@link Earth}
 * @author jbacal
 *
 */
public class EarthBender extends Bender <EarthBending> {

	public EarthBender () {
		this.addBending(new EarthBending());
		this.setAgility(10);
	}

}
