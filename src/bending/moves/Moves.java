package bending.moves;

import element.Element;
import game.GameObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Bending moves
 * @author jbacal
 *
 */
public class Moves extends GameObject {

	private double attack;
	private double defense;
	private int bendingPoints;
	private String description;
	private MoveType type;
	private Element element;
	private Set<Element> greatAgainst;
	private Set<Element> weakAgainst;
	
	public Moves (String name, MoveType type, Element element,
			int bendingPoints, String description) {
		this.type = type;
		this.setElement(element);
		this.setName(name);
		this.bendingPoints = bendingPoints;
		this.description = description;
		this.greatAgainst = new HashSet<Element>();
		this.weakAgainst = new HashSet<Element>();
	}
	
	public Moves (String name, MoveType type,
			Element element, int bendingPoints) {
		this(name, type, element, bendingPoints, "");
	}
	
	/**
	 * @return the type
	 */
	public MoveType getType() {
		return type;
	}

	/**
	 * @return the greatAgainst
	 */
	public Set<Element> getGreatAgainst() {
		return greatAgainst;
	}

	/**
	 * @param greatAgainst the greatAgainst to set
	 */
	public void addGreatAgainst(Element greatAgainst) {
		this.greatAgainst.add(greatAgainst);
	}

	/**
	 * @return the weakAgainst
	 */
	public Set<Element> getWeakAgainst() {
		return weakAgainst;
	}

	/**
	 * @param weakAgainst the weakAgainst to set
	 */
	public void addWeakAgainst(Element weakAgainst) {
		this.weakAgainst.add(weakAgainst);
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @return the bendingPoints
	 */
	public int getBendingPoints() {
		return bendingPoints;
	}

	/**
	 * @return the attack
	 */
	public double getAttack() {
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(double attack) {
		this.attack = attack;
	}

	/**
	 * @return the defense
	 */
	public double getDefense() {
		return defense;
	}

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(double defense) {
		this.defense = defense;
	}

	/**
	 * @return the element
	 */
	public Element getElement() {
		return element;
	}

	/**
	 * @param element the element to set
	 */
	protected void setElement(Element element) {
		this.element = element;
	}
}
