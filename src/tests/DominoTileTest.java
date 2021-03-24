package tests;

import models.DominoTile;

public class DominoTileTest
{

	public static void main(String[] args)
	{
		DominoTile dominoTile = new DominoTile(6, 6);
		System.out.println(dominoTile.toString());
		var dots = dominoTile.getDotsOf(dominoTile.getLeftValue());
		for(int i = 0; i < dots.length; i++)
		{
			for(int j = 0; j < dots[i].length; j++)
			{
				if(dots[i][j])System.out.print("t ");
				else System.out.print("f ");
			}
			System.out.println();
		}
	}

}
