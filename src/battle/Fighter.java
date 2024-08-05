package battle;

import bender.Avatar;
import bender.Bender;
import bending.Bending;
import bending.moves.Moves;
import element.Element;
import game.GameObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Abstract class for {@link Playable}
 * @author jbacal
 *
 */
public abstract class Fighter extends GameObject implements Playable{

	private static final int INITIAL_TIME_LAPSE = 100;
	private Bender bender;
	private Moves move;
	
	private double hp;	
	private int team;
	private int moveIndex;
	
	private boolean isUnbothered;
	
	protected Random random;
	
	public Fighter () {
		moveIndex = INITIAL_TIME_LAPSE;
		if (random == null) {
			random = new Random();
		}
	}
	

	public void setBender (Bender bender) {
		Element element;
		Random random = new Random();
		
		this.bender = bender;
		
		if (this.bender instanceof Avatar) {
			element = ((Avatar) this.bender).getPrimaryBending().getElement();
		} else {
			element = ((Bending) this.bender.getBending().get(0)).getElement();
		}
		
		switch (element.getType()) {
		case WATER:
			this.hp = random.nextInt(10) + 11;
			break;
		case EARTH:
			this.hp = random.nextInt(10) + 15;
			break;
		case FIRE:
			this.hp = random.nextInt(10) + 13;
			break;
		case AIR:
			this.hp = random.nextInt(10) + 12;
			break;
		}
		
		nextMoveIndex();
	}
	
	public Bender getBender () {
		return bender;
	}

	public int getMoveIndex() {
		return moveIndex;
	}

	public void nextMoveIndex () {
		moveIndex -= INITIAL_TIME_LAPSE 
				- (bender.getAgility() + (random.nextInt(20) - 10));
		if(moveIndex < 0){
			moveIndex = INITIAL_TIME_LAPSE + moveIndex;
		}
	}

	/**
	 * @return the team
	 */
	public int getTeam () {
		return team;	
	}

	/**
	 * @param team the team to set
	 */
	public void setTeam (int team) {
		this.team = team;
	}

	public boolean isAlive () {
		return hp > 0;
	}
	
	public double getHP () {
		return hp;
	}

	public void decreaseHP (double damage) {
		hp -= damage;
	}
	
	public String getDetails () {
		return bender + "::" + String.format("%.2f", this.hp)
				+ "::" + "Team " + team;
	}
	
	public String toString () {
		return bender.toString();
	}
	
	protected List<Playable> getEnemies (List<Playable> players) {
		List<Playable> enemies = new ArrayList<Playable>();
		for (Playable p : players) {
			if (p.getTeam() != this.team && p.isAlive()) {
				enemies.add(p);
			}
		}
		return enemies;
	}
	
	protected List<Moves> getAvailableMoves () {
		List<Moves> moves = new ArrayList<Moves>();
		for (Object b : this.bender.getBending()) {
			for (Moves m : ((Bending) b).getMoves()) {
				if (m.getBendingPoints() <= this.bender.getBendingPoints()) {
					moves.add(m);
				}
			}
		}
		return moves;
	}

	/**
	 * @return the move
	 */
	public Moves getMove() {
		return move;
	}

	/**
	 * @param move the move to set
	 */
	public void setMove(Moves move) {
		this.move = move;
	}

	public int compareTo(Playable f) {
		return Integer.valueOf(this.getTeam())
				.compareTo(Integer.valueOf(f.getTeam()));
	}

	/**
	 * @param isUnbothered the isUnbothered to set
	 */
	public void setUnbothered() {
		this.isUnbothered = true;
	}
	
	/**
	 * @param isUnbothered the isUnbothered to set
	 */
	public void setBothered() {
		this.isUnbothered = false;
	}
	
	public void decide (List<Playable> players) {
		bender.addBendingPoints(random.nextInt(3) + (isUnbothered ? 3 : 1));
		setUnbothered();
	}
	
}
