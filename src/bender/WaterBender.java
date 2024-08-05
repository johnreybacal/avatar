package bender;

import element.Water;
import bending.WaterBending;

/**
 * {@link Bender} of {@link Water}
 * @author jbacal
 *
 */
public class WaterBender extends Bender <WaterBending> {

	public WaterBender () {
		this.addBending(new WaterBending());
		this.setAgility(15);
	}

}
