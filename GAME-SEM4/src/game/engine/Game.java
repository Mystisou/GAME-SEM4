package game.engine;

import java.io.IOException;
import java.util.ArrayList;

import game.engine.dataloader.DataLoader;
import game.engine.monsters.Monster;

public class Game {
	
	private final Board board;
	private final ArrayList<Monster> allMonsters;
	private final Monster player;
	private final Monster opponent;
	private Monster current;
	
	public Game(Role playerRole) throws IOException{
		this.board = new Board(DataLoader.readCards());
		this.allMonsters = DataLoader.readMonsters();
		this.player = selectRandomMonsterByRole(playerRole);
		
		Role opponentRole;
		if(playerRole == Role.SCARER) 
			opponentRole = Role.LAUGHER ;
		else
			opponentRole = Role.SCARER  ;
		
		this.opponent = selectRandomMonsterByRole(opponentRole);
		this.current = this.player;
	}
	
	private Monster selectRandomMonsterByRole(Role role) {
	    ArrayList<Monster> Monsters_of_same_role = new ArrayList<Monster>();
	    
	    for (int i = 0; i < allMonsters.size(); i++){
	        Monster m = allMonsters.get(i);
	        if (m.getOriginalRole() == role)
	        	Monsters_of_same_role.add(m);	   
	    }
	    
	    int random_index = (int) (Math.random()*Monsters_of_same_role.size());
	    return Monsters_of_same_role.get(random_index);
	}
	
	
		public Board getBoard() {
			return board;
		}
		
		public ArrayList<Monster> getAllMonsters(){
			return allMonsters;
		}
		
		public Monster getPlayer() {
	        return player;
	    }

	    public Monster getOpponent() {
	        return opponent;
	    }

	    public Monster getCurrent() {
	        return current;
	    }
	    
	    public void setCurrent(Monster current) {
	        this.current = current;
	    }
	    
}

