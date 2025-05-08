package Main;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.*;

public class GameSave {
	
	public void newSave(String save, String difficulty, int pHealth, int pPoints, int eHealth, int ePoints) {
		try (Formatter output = new Formatter("saves.txt")) {
			Scanner reader = new Scanner("saves.txt");
			while (reader.hasNextLine()) {
				reader.nextLine();
			}
			reader.close();
			output.format("%s %s %d %d %d %d\n", save, difficulty, pHealth, pPoints, eHealth, ePoints);
			output.close();
		}
		catch (FileNotFoundException e) {e.printStackTrace(); }
	}
	public void loadSave(String save) {
		//load selected game save
		try {
			File file = new File("saves.txt");
			Scanner fileReader = new Scanner(file);
			String saveName = fileReader.next();
			//System.out.println("before if " + saveName);
			if (saveName.equals(save)) {
				String diff = fileReader.next();
				int pHP = fileReader.nextInt();
				int pP = fileReader.nextInt();
				int eHP = fileReader.nextInt();
				int eP = fileReader.nextInt();
				//Load a new game with the saved data
				Game game = new Game();
				game.setDifficulty(diff);
				StatsPanel stats = new StatsPanel(0);
				stats.setPlayerHealth(pHP);
				stats.setEnemyHealth(eHP);
				stats.setPlayerPoints(pP);
				stats.setEnemyPoints(eP);
				game.getCircleGamePanel().getStatsPanel();
				game.showCard(Game.CARD_GAME_PANEL);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public String savesArray() {
		//returns String array of save names
		return "not implemented yet";
	}
}
