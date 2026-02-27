package game.engine.monsters;
import game.engine.Role;

public class Multitasker extends Monster {
	
	
    private int normalSpeedTurns;
    
    public Multitasker(String name, String description, Role role, int energy) {
        super(name, description, role, energy);
        this.normalSpeedTurns = 0;
    }
    
    public int getNormalSpeedTurns() {
        return normalSpeedTurns;
    }

    public void setNormalSpeedTurns(int normalSpeedTurns) {
        this.normalSpeedTurns = normalSpeedTurns;
    }
        
}
