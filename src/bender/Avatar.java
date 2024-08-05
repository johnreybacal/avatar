package bender;

import bending.AirBending;
import bending.Bending;
import bending.EarthBending;
import bending.FireBending;
import bending.WaterBending;

/**
 * Avatar
 * @version 1
 * @author jbacal
 */
public class Avatar extends Bender <Bending> {

	private static Avatar avatar;
	
	private Bending primaryBending;
	
	private Avatar () {
		this.setAgility(20);
	}
	
	public static boolean exists () {
		return avatar != null;
	}
	
	public static Bender getAvatar () {
		if (avatar == null) {
			avatar = new Avatar();
			avatar.addBending(new WaterBending());
			avatar.addBending(new EarthBending());
			avatar.addBending(new FireBending());
			avatar.addBending(new AirBending());
		}
		return avatar;
	}

	public void addBending (Bending bending) {
		if (!checkDuplicateBending(bending)) {
			this.getBending().add(bending);
		}
	}
	
	public String toString () {
		return "Avatar " + super.toString();
	}

	/**
	 * @return the primaryBending
	 */
	public Bending getPrimaryBending() {
		return primaryBending;
	}

	/**
	 * @param primaryBending the primaryBending to set
	 */
	public void setPrimaryBending(Bending primaryBending) {
		this.primaryBending = primaryBending;
	}
}
