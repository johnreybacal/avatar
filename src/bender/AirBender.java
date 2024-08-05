package bender;

import element.Air;
import bending.AirBending;

/**
 * {@link Bender} of {@link Air}
 * @author jbacal
 *
 */
public class AirBender extends Bender <AirBending> {

	public AirBender () {
		this.addBending(new AirBending());
		this.setAgility(25);
	}

}
