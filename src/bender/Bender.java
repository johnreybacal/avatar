package bender;

import game.GameObject;

import java.util.ArrayList;
import java.util.List;

import bending.Bending;

/**
 * Generic Bender
 * @author jbacal
 *
 * @param <T> subclass of Bending
 */
public abstract class Bender <T extends Bending> extends GameObject {

	private int energyPoints;
	private int bendingPoints;
	
	private int agility;

	private List<T> bending;

	protected Bender () {
		this.bending = new ArrayList<T>();
	}
	
	/**
	 * @return the bending
	 */
	public List<T> getBending () {
		return bending;
	}
	
	/**
	 * add bending 
	 * @param bending
	 */
	public void addBending (T bending) {
		if (!checkDuplicateBending(bending)) {
			this.bending.add(bending);
		}
	}
	
	/**
	 * @return energyPoints
	 */
	public int getEnergyPoints () {
		return energyPoints;
	}
	
	/**
	 * Adds parameter to energyPoints
	 * @param value
	 */
	public void addEnergyPoints (int value) {
		energyPoints += value;
	}
	
	/**
	 * Deducts parameter to energyPoints
	 * @param value
	 */
	public void deductEnergyPoints (int value) {
		energyPoints -= value;
	}

	/**
	 * @return bendingPoints
	 */
	public int getBendingPoints () {
		return bendingPoints;
	}
	
	/**
	 * Set the bendingPoints
	 * @param value
	 */
	public void setBendingPoints (int value) {
		bendingPoints = value;
	}
	
	/**
	 * Adds parameter to bendingPoints
	 * @param value
	 */
	public void addBendingPoints (int value) {
		bendingPoints += value;
	}
	
	/**
	 * Deducts parameter to bendingPoints
	 * @param value
	 */
	public void deductBendingPoints (int value) {
		bendingPoints -= value;
	}
	
	/**
	 * set agility
	 * @param agility
	 */
	public void setAgility (int agility) {
		this.agility = agility;
	}
	
	/**
	 * @return agility of bender
	 */
	public int getAgility () {
		return agility;
	}
	
	/**
	 * @return details of the bender
	 */
	public String getDetails () {
		String bends = this.bending.toString(); 
		String details = this.toString();
		details += "\n | Talent: ";
		details += bends.substring(1, bends.length() - 1);
		details += "\n | Moves:  ";
		for (T b : this.bending) {
			String moves = ((Bending) b).getMoves().toString();
			details += moves.substring(1, moves.length() - 1);
			details += "\n           ";
		}

		return details;
	}
	
	/**
	 * check if bending to be inserted to list already exists
	 * @param bending
	 * @return
	 */
	protected boolean checkDuplicateBending (T bending) {
		boolean duplicate = false;
		for (T b : this.bending) {
			if (b.toString().equals(bending.toString())) {
				duplicate = true;
				break;
			}
		}
		return duplicate;
	}
}
