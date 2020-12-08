package oop.classes.Domino.tests;

import java.awt.Color;

import javax.swing.JFrame;

import oop.classes.Domino.models.DominoTable;
import oop.classes.Domino.models.DominoTableView;
import oop.classes.Domino.models.DominoTile;

public class DominoTableViewTest
{
	public final static int WINDOW_WIDTH = 500;
	public final static int WINDOW_HEIGHT = 600;
	public final static double TABLE_WIDTH_PERCENTAGES = 82.5;
	public final static double TABLE_HEIGHT_PERCENTAGES = 82.5;
	
	public static void main(String[] args) throws InterruptedException
	{
		JFrame window = new JFrame();
		window.setBounds(50, 50, WINDOW_WIDTH, WINDOW_HEIGHT);
		window.setLayout(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		DominoTable dominoTable = new DominoTable();
		dominoTable.addLeft(new DominoTile(3, 4));
		dominoTable.addLeft(new DominoTile(6, 3));
		dominoTable.addLeft(new DominoTile(1, 6));
		
		var table = new DominoTableView(dominoTable);
		table.setBounds(50, 50, (int)TABLE_WIDTH_PERCENTAGES * WINDOW_WIDTH / 100,
						(int)TABLE_HEIGHT_PERCENTAGES * WINDOW_HEIGHT / 100);
		table.setVisible(true);
		
		window.add(table);
		
		for(int i = 0; i < 10; i++)
		{
			Thread.sleep(1000);
			table.repaint();
		}
	}
}
