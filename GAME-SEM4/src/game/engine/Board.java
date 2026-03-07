package game.engine;

import game.engine.monsters.Monster;
import game.engine.cells.Cell;
import game.engine.cards.Card; 
import java.util.ArrayList;  // 34an el arraylist

public class Board {
	
	 private final Cell [][] boardCells ;
	 private static ArrayList<Monster> stationedMonsters;  // read w write 
	 private static ArrayList<Card> originalCards ;// can't do final to be able to assign in constructor
	 public static ArrayList<Card> cards ;                // read w write brdo
	 
	 public Board(ArrayList<Card> readCards){
		 boardCells = new Cell[Constants.BOARD_ROWS][Constants.BOARD_COLS];
		 stationedMonsters = new ArrayList<>();
		 cards =  new ArrayList<>();
		 originalCards = readCards ;
	 }
	 
	  public Cell[][] getBoardCells() {
	        return boardCells;
	  }
	  
	  
	  public static ArrayList<Monster> getStationedMonsters() {
	        return stationedMonsters;
	  }

	  public static void setStationedMonsters(ArrayList<Monster> monsters) {
	        stationedMonsters = monsters;
	  }

	  
	  public static ArrayList<Card> getOriginalCards() {
	        return originalCards;
	  }

	  
	  public static ArrayList<Card> getCards() {
	        return cards;
	  }

	   public static void setCards(ArrayList<Card> newCards) {
	        cards = newCards;
	   }
}
