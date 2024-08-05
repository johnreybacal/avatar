package bender;

import element.Fire;
import bending.FireBending;

/**
 * {@link Bender} of {@link Fire}
 * @author jbacal
 *
 */
public class FireBender extends Bender <FireBending> {

	public FireBender () {
		this.addBending(new FireBending());
		this.setAgility(20);
	}

}
