package game.engine;
import java.io.IOException;
import java.util.ArrayList;

import game.engine.dataloader.DataLoader;
import game.engine.monsters.Monster;
import game.engine.dataloader.*;

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
			opponentRole = Role.LAUGHER;
		else
			opponentRole = Role.SCARER;
		
		this.opponent = selectRandomMonsterByRole(opponentRole);
		this.current = this.player;
	}
	
	private Monster selectRandomMonsterByRole(Role role) {
	    ArrayList<Monster> matchingMonsters = new ArrayList<Monster>();
	    
	    for (int i = 0; i < allMonsters.size(); i++) {
	        Monster m = allMonsters.get(i);
	        if (m.getOriginalRole() == role) {
	            matchingMonsters.add(m);
	        }
	    }
	    
	    int randomIndex = (int) (Math.random() * matchingMonsters.size());
	    return matchingMonsters.get(randomIndex);
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

