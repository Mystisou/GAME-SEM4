package game.engine.cells;
import game.engine.interfaces.CanisterModifier;
import game.engine.monsters.Monster;

public class ContaminationSock extends TransportCell implements CanisterModifier {

    public ContaminationSock(String name, int effect) {
        super(name, -Math.abs(effect)); 
        //effect is always negative
    }
    
    public void modifyEnergy(Monster monster) {
    	monster.setPosition(monster.getPosition() - this.getEffect());
    	if(!monster.isShielded())
    		monster.setEnergy(monster.getEnergy() - 100);
    	else
    		monster.setShielded(false);
    }
}
