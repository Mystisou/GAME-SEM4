package game.engine.dataloader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import game.engine.cards.*;
import game.engine.cells.*;
import game.engine.*;
import game.engine.monsters.*;
import game.engine.exceptions.*;

public class DataLoader {
	
	 private static String CARDS_FILE_NAME = "cards.csv";
	 private static String CELLS_FILE_NAME = "cells.csv";
	 private static String MONSTERS_FILE_NAME = "monsters.csv";
	 
	 public static ArrayList<Card> readCards() throws IOException {
		 ArrayList<Card> cards = new ArrayList<Card>();
		 BufferedReader bufferedReader = new BufferedReader(new FileReader(CARDS_FILE_NAME));
		 
		 String line;
		 while((line = bufferedReader.readLine()) != null) {
			 String [] data = line.split(",");
			 
			 try {
				 String type = data[0];
	             String name = data[1];
	             String description = data[2];
	             int rarity = Integer.parseInt(data[3]);
	             
	             switch(type) {
	             	case "SWAPPER": 
	             		cards.add(new SwapperCard(name, description, rarity));
	             		break;
	             
	             	case "STARTOVER": 
	             		boolean lucky = Boolean.parseBoolean(data[4]);
	             		cards.add(new StartOverCard(name, description, rarity, lucky));
	             		break;
	            
	             	case "ENERGYSTEAL":
	             		int energy = Integer.parseInt(data[4]);
	                    cards.add(new EnergyStealCard(name, description, rarity, energy));
	                    break; 
	             
	             	case "SHIELD":
	             			cards.add(new ShieldCard(name, description, rarity));
	             			break;
	             
	             	case "CONFUSION":
	                    int duration = Integer.parseInt(data[4]);
	                    cards.add(new ConfusionCard(name, description, rarity, duration));
	                    break;
	             
	             	default : throw new InvalidCSVFormat(line);
	             	}
			 	}
	             
	             catch(Exception exception) {
	            	 throw new InvalidCSVFormat(line);
	             }
			 }
			 bufferedReader.close();
			 return cards;
		 }
	 
	 public static ArrayList<Cell> readCells() throws IOException {
		 ArrayList<Cell> cells = new ArrayList<Cell>();
		 BufferedReader bufferedReader = new BufferedReader(new FileReader(CELLS_FILE_NAME));
		 
		 String line;
		 while((line = bufferedReader.readLine()) != null) {
			 String [] data = line.split(",");
			 
			 try {
				 String name = data[0];
				 
				 if(data.length == 3) {
					 Role role = Role.valueOf(data[1]);
		             int energy = Integer.parseInt(data[2]);
		             cells.add(new DoorCell(name, role, energy));
				 }
				 else if (data.length == 2){
					 int effect = Integer.parseInt(data[1]);
		             if (effect > 0)
		            	 cells.add(new ConveyorBelt(name, effect));
		             else
		            	 cells.add(new ContaminationSock(name, effect));
				 }
				 else {
					 throw new InvalidCSVFormat(line);
				 }
			 }
			 
			 catch(Exception exception) {
				 throw new InvalidCSVFormat(line);
			 }
		 }
		 
		 bufferedReader.close();
		 return cells;
	}
	
	 public static ArrayList<Monster> readMonsters() throws IOException {
		 ArrayList<Monster> monsters = new ArrayList<>();
		 BufferedReader bufferedReader = new BufferedReader(new FileReader(MONSTERS_FILE_NAME));
		 
		 String line;
		 while((line = bufferedReader.readLine()) != null) {
			 String [] data = line.split(",");
			 
			 try {
				 String type = data[0];
		         String name = data[1];
		         String description = data[2];
		         Role role = Role.valueOf(data[3]);
		         int energy = Integer.parseInt(data[4]);
		         
		         switch(type) {
		         	case "DYNAMO":
	                    monsters.add(new Dynamo(name, description, role, energy));
	                    break;
	                    
		         	case "DASHER":
	                    monsters.add(new Dasher(name, description, role, energy));
	                    break;
	                    
		         	case "SCHEMER":
	                    monsters.add(new Schemer(name, description, role, energy));
	                    break;
	                    
		         	case "MULTITASKER":
	                    monsters.add(new MultiTasker(name, description, role, energy));
	                    break;
	                    
	                default: throw new InvalidCSVFormat(line);
		         }
			 }
			 
			 catch(Exception exception) {
				 throw new InvalidCSVFormat(line);
			 }
		 }
		 
		 bufferedReader.close();
		 return monsters;
	 }
	 
}
