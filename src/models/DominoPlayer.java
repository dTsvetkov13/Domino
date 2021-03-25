package models;

import structures.LinkedList;

public class DominoPlayer
{
	public final static int ERROR_CODE = -1;
	
	private String nickname;
	private LinkedList<DominoTile> tiles;
	private DominoTable table;
	
	public DominoPlayer(String nickname, int size, DominoTable table)
	{
		this.setNickname(nickname);
		tiles = new LinkedList<DominoTile>();
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
		for(int i = 0; i < this.tiles.size(); i++)
		{
			if(this.tiles.get(i).equals(tile))
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
		if(index >= this.tiles.size())
		{
			throw new RuntimeException("Invalid index");
		}
		
		this.tiles.removeFrom(index);
	}
}
