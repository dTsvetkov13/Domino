package tests;

import models.DominoTable;
import models.DominoTile;

public class DominoTableTest
{

	public static void main(String[] args)
	{
		DominoTable dominoTable = new DominoTable();
		
		dominoTable.addLeft(new DominoTile(2, 2));
		dominoTable.addLeft(new DominoTile(6, 2));
		dominoTable.addLeft(new DominoTile(2, 6));
		dominoTable.addRight(new DominoTile(2, 2));
		dominoTable.addRight(new DominoTile(2, 4));
		
		dominoTable.print();
	}

}
