package oop.classes.Domino.models;

import java.util.ArrayList;

public class DominoTable
{
	public final static int MAX_TILES_COUNT = 28;
	
	private ArrayList<DominoTile> tiles;
	private TableEventListener eventListener;
	
	public DominoTable()
	{
		this.tiles = new ArrayList<DominoTile>();
	}
	
	public void addTableEventListener(TableEventListener listener)
	{
		if(listener != null)
		{
			this.eventListener = listener;
		}
	}
	
	public boolean addLeft(DominoTile dominoTile)
	{
		if(dominoTile == null)
		{
			throw new RuntimeException("DominoTile is null");
		}
		
		if(this.tiles.size() > MAX_TILES_COUNT)
		{
			throw new RuntimeException("The table is full");
		}
		
		if(tiles.size() > 0)
		{
			if(tiles.get(0).getLeftValue() == dominoTile.getRightValue())
			{
				callOnTableChanged();
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
			callOnTableChanged();
			return true;
		}
	}
	
	private void callOnTableChanged()
	{
		if(this.eventListener != null)
		{
			this.eventListener.onTableChanged(this);	
		}
	}
	
	public boolean addRight(DominoTile dominoTile)
	{
		if(dominoTile == null)
		{
			throw new RuntimeException("DominoTile is null");
		}
		
		if(this.tiles.size() > MAX_TILES_COUNT)
		{
			throw new RuntimeException("The table is full");
		}
		
		if(tiles.size() > 0)
		{
			if(tiles.get(tiles.size() - 1).getRightValue() == dominoTile.getLeftValue())
			{
				tiles.add(dominoTile);
				callOnTableChanged();
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
			callOnTableChanged();
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
	
	public ArrayList<DominoTile> getTiles()
	{
		return this.tiles;
	}
}
