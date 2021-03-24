package models;

import models.DominoTable;
import models.DominoTile;

public class DominoPlayer
{
	public final static int ERROR_CODE = -1;
	
	private String nickname;
	private DominoTile[] tiles;
	private int tilesInHands;
	private DominoTable table;
	
	public DominoPlayer(String nickname, int size, DominoTable table)
	{
		this.setNickname(nickname);
		tiles = new DominoTile[size];
		this.setDominoTable(table);
	}
	
	public void setNickname(String nickname)
	{
		if(nickname != null && !nickname.isEmpty())
		{
			this.nickname = nickname;
		}
		else
		{
			throw new IllegalArgumentException("");
		}
	}
	
	public String getNickname()
	{
		return this.nickname;
	}
	
	private void setDominoTable(DominoTable dominoTable)
	{
		if(dominoTable != null)
		{
			this.table = dominoTable;
		}
	}
	
	public DominoTable getTable()
	{
		return this.table;
	}
	
	public int getTileIndex(DominoTile tile)
	{
		for(int i = 0; i < this.tilesInHands; i++)
		{
			if(this.tiles[i].equals(tile))
			{
				return i;
			}
		}
		
		return ERROR_CODE;
	}
	
	public void addTileAtLeft(DominoTile tile)
	{
		int index = this.getTileIndex(tile); 
		if(index != ERROR_CODE)
		{
			if(table.addLeft(tile))
			{
				removeTileAt(index);
			}
		}
	}
	
	public void addTileAtRight(DominoTile tile)
	{
		int index = this.getTileIndex(tile); 
		if(index != ERROR_CODE)
		{
			if(table.addRight(tile))
			{
				removeTileAt(index);
			}
		}
	}
	
	private void removeTileAt(int index)
	{
		if(index >= this.tilesInHands)
		{
			throw new RuntimeException("Invalid index");
		}
		
		for(int i = index; i < this.tilesInHands - 1; i++)
		{
			this.tiles[i] = this.tiles[i + 1];
		}
		
		this.tiles[this.tilesInHands - 1] = null;
		this.tilesInHands--;
	}
}
