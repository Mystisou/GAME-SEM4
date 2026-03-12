package game.engine.cells;
<<<<<<< Updated upstream
import game.engine.Role;
=======

import game.engine.Role;
import game.engine.interfaces.CanisterModifier;
import game.engine.monsters.Monster;
>>>>>>> Stashed changes

public class DoorCell extends Cell{
	
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
<<<<<<< Updated upstream
=======

	public void modifyEnergy(Monster monster) {

	}
>>>>>>> Stashed changes
}
