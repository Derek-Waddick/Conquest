package Main;

import javax.swing.*;
import java.awt.*;
import java.util.Formatter;
import java.util.Scanner;

public class SavesPanel extends JPanel {
	
	private Game parentFrame;
	
	public SavesPanel(Game parentFrame) {
		this.parentFrame = parentFrame;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Select Save");
		
		String saves[] = {"save1", "test2"};
		JComboBox savesBox = new JComboBox(saves);
		JButton loadButton = new JButton("Load Save");
		
		GameSave loader = new GameSave();
		
		loadButton.addActionListener(e -> {
			//Load the selected save
			//System.out.println("loadButton");
			//System.out.println(savesBox.getSelectedItem());
			loader.loadSave(savesBox.getSelectedItem().toString());
		});
		
		panel.add(label);
		panel.add(savesBox);
		panel.add(loadButton);
		
		frame.add(panel);
		
		//add(Box.createVerticalGlue());
		add(panel);
	}
}
