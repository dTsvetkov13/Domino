package oop.classes.Domino.models;

import java.util.ArrayList;

public class DominoTable
{
	private ArrayList<DominoTile> tiles;
	
	public DominoTable()
	{
		this.tiles = new ArrayList<DominoTile>();
	}
	
	public boolean addLeft(DominoTile dominoTile)
	{
		if(dominoTile == null)
		{
			throw new RuntimeException("DominoTile is null");
		}
		
		if(tiles.size() > 0)
		{
			if(tiles.get(0).getLeftValue() == dominoTile.getRightValue())
			{
				tiles.add(0, dominoTile);
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			tiles.add(dominoTile);
			return true;
		}
	}
	
	public boolean addRight(DominoTile dominoTile)
	{
		if(dominoTile == null)
		{
			throw new RuntimeException("DominoTile is null");
		}
		
		if(tiles.size() > 0)
		{
			if(tiles.get(tiles.size() - 1).getRightValue() == dominoTile.getLeftValue())
			{
				tiles.add(dominoTile);
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			tiles.add(dominoTile);
			return true;
		}
	}
	
	public void print()
	{
		for(int i = 0; i < tiles.size(); i++)
		{
			System.out.println(tiles.get(i).toString());
		}
	}
}
