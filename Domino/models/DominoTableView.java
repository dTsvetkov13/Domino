package oop.classes.Domino.models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.TextArea;

import javax.swing.JComponent;
import javax.swing.JTextArea;

public class DominoTableView extends JComponent
{
	public static final int SPACE_BETWEEN_TILES = 10;
	
	private DominoTable table;
	
	public DominoTableView()
	{
		table = new DominoTable();
	}
	
	public DominoTableView(DominoTable table)
	{	
		if(table != null)
		{
			this.table = table;
		}
		else
		{
			throw new IllegalArgumentException("");
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		Rectangle rect = new Rectangle(0, 0, 100, 100);
		
		var tiles = this.table.getTiles();
		
		for(int i = 0; i < tiles.size(); i++)
		{
			rect.x = (i * (rect.width + SPACE_BETWEEN_TILES));
			drawTile(this.table.getTiles().get(i), rect, g);
		}
	}
	
	@Override
	public void repaint()
	{
		if(this.getGraphics() != null)
		{
			this.paintComponent(this.getGraphics());
		}
	}
	
	private void drawTile(DominoTile dominoTile, Rectangle rect, Graphics g)
	{
		g.setColor(Color.BLACK);
		
		Rectangle rect1 = new Rectangle(rect.x, rect.y, rect.width / 2,
										rect.height);
		Rectangle rect2 = new Rectangle(rect.x + rect1.width, rect.y, rect.width / 2,
				rect.height);
		
		g.drawRect(rect1.x, rect1.y, rect1.width, rect1.height);
		g.drawRect(rect2.x, rect2.y, rect2.width, rect2.height);
		
		drawNumberDots(dominoTile.getLeftValue(), rect1, g);
		drawNumberDots(dominoTile.getRightValue(), rect2, g);
	}
	
	private void drawNumberDots(int number, Rectangle rect, Graphics g)
	{
		boolean[][] dots = DominoTile.getDotsOf(number);
		Rectangle tempRect = new Rectangle(rect.x, rect.y);
		tempRect.height = rect.height / dots.length;
		tempRect.width = rect.width / dots[0].length;
		
		for(int i = 0; i < dots.length; i++)
		{
			for(int j = 0; j < dots[i].length; j++)
			{
				if(dots[i][j])
				{
					tempRect.x = rect.x + j * tempRect.width;
					tempRect.y = rect.y + i * tempRect.height;
					drawDotAt(tempRect, g);
				}
			}
		}
	}
	
	private void drawDotAt(Rectangle rect, Graphics g)
	{
		g.drawOval(rect.x, rect.y, rect.width, rect.height);
		g.fillOval(rect.x, rect.y, rect.width, rect.height);
	}
}