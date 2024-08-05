package bending;

import java.util.HashSet;
import java.util.Set;

import bending.moves.Moves;
import element.Element;
import game.GameObject;

/**
 * Generic Bending
 * @author jbacal
 *
 */
public abstract class Bending extends GameObject {
	
	protected Set<Moves> moves;

	private int talent;
	private Element element;

	protected Bending () {
		moves = new HashSet<Moves> ();
	}
	
	/**
	 * @return the talent
	 */
	public int getTalent() {
		return talent;
	}

	/**
	 * @param talent the talent to set
	 */
	protected void setTalent(int talent) {
		this.talent = talent;
	}

	/**
	 * @return the element
	 */
	public Element getElement() {
		return element;
	}
	
	/**
	 * @return moves
	 */
	public Set<Moves> getMoves () {
		return moves;
	}

	/**
	 * @param element the element to set
	 */
	protected void setElement(Element element) {
		this.element = element;
		this.setName(this.element + " Bending");
	}

	
}
