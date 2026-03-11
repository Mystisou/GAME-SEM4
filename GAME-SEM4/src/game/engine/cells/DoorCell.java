package game.engine.cells;
import java.util.ArrayList;
import java.util.Iterator;

import game.engine.Role;
import game.engine.interfaces.CanisterModifier;
import game.engine.monsters.Monster;
import game.engine.Board;

public class DoorCell extends Cell implements CanisterModifier{
	
	private final Role role;
	private final int energy;
	private boolean activated;
	
	public DoorCell(String name, Role role, int energy) {
		super(name);
		this.role = role;
		this.energy = energy;
		this.activated = false;
	}
	
	public Role getRole() {
		return role;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public boolean isActivated() {
		return activated;
	}
	
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
	// still unsolved
	public void modifyEnergy(Monster monster) {
      if(!this.isActivated()) {
		if(monster.getRole() == this.getRole()) {
		    ArrayList<Monster> matching = Board.getStationedMonsters();
			for(int i = 0; i < matching.size(); i++) {
				if(matching.get(i).getRole() == monster.getRole())
			        matching.get(i).setEnergy(matching.get(i).getEnergy() + this.energy);
			}
			//Board.setStationedMonsters(matching);
			this.setActivated(true);
		}
		else {
		    if(!monster.isShielded()) {
		    	ArrayList<Monster> matching = Board.getStationedMonsters();
			for(int i = 0; i < matching.size(); i++) {
				if(matching.get(i).getRole() == monster.getRole())
			        matching.get(i).setEnergy(matching.get(i).getEnergy() - this.energy);
			}
			//Board.setStationedMonsters(matching);
			this.setActivated(true);
			}
		}
	  }
	}
}
