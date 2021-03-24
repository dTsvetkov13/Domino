package models;

import enums.LineType;

public class DominoTile
{
	public static final int MINIMAL_VALUE = 0;
	public static final int MAXIMUM_VALUE = 6;
	
	private int leftValue;
	private int rightValue;
	
	public DominoTile()
	{
	}
	
	public DominoTile(int leftValue, int rightValue)
	{
		setLeftValue(leftValue);
		setRightValue(rightValue);
	}
	
	private void setLeftValue(int value)
	{
		//TODO: better validation
		if(value < MINIMAL_VALUE || value > MAXIMUM_VALUE)
		{
			throw new RuntimeException("Invalid vaue");
		}
		
		this.leftValue = value;
	}
	
	private void setRightValue(int value)
	{
		//TODO: better validation
		if(value < MINIMAL_VALUE || value > MAXIMUM_VALUE)
		{
			throw new RuntimeException("Invalid vaue");
		}
		
		this.rightValue = value;
	}
	
	public int getLeftValue()
	{
		return this.leftValue;
	}
	
	public int getRightValue()
	{
		return this.rightValue;
	}
	
	public void swapValues()
	{
		int temp = leftValue;
		leftValue = rightValue;
		rightValue = temp;
	}
	
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("|");
		appendLineByValue(stringBuilder, this.leftValue / 2, LineType.Upper);
		stringBuilder.append("|");
		appendLineByValue(stringBuilder, this.rightValue / 2, LineType.Upper);
		stringBuilder.append("|");
		stringBuilder.append("\n");
		
		stringBuilder.append("|");
		appendLineByValue(stringBuilder,
						  this.leftValue == 6 ? 2 : this.leftValue % 2,
						  LineType.Middle);
		stringBuilder.append("|");
		appendLineByValue(stringBuilder,
				  this.rightValue == 6 ? 2 : this.rightValue % 2,
				  LineType.Middle);
		stringBuilder.append("|");
		stringBuilder.append("\n");
		stringBuilder.append("|");
		appendLineByValue(stringBuilder, this.leftValue / 2, LineType.Bottom);
		
		stringBuilder.append("|");
		appendLineByValue(stringBuilder, this.rightValue / 2, LineType.Bottom);
		stringBuilder.append("|");
		stringBuilder.append("\n");
		
		return stringBuilder.toString();
	}
	
	private static StringBuilder appendLineByValue(StringBuilder stringBuilder, int stars, LineType lineType)
	{
		if(stringBuilder == null)
		{
			throw new RuntimeException("StringBuilder is null");
		}
		
		if(lineType == null)
		{
			throw new RuntimeException("LineType is null");
		}
		
		if(stars > 2) stars = 2;
		if(stars == 1)
		{
			switch(lineType)
			{
				case Middle:
				{
					stringBuilder.append(" * ");
					break;
				}
				case Upper:
				{
					stringBuilder.append("  *");
					break;
				}
				case Bottom:
				{
					stringBuilder.append("*  ");
					break;
				}
			}
		}
		else if(stars == 2)
		{
			stringBuilder.append("* *");
		}
		else
		{
			stringBuilder.append("   ");
		}
		return stringBuilder; 
	}
	
	public static boolean[][] getDotsOf(int number)
	{
		StringBuilder stringBuilder = new StringBuilder();
		appendLineByValue(stringBuilder, number / 2, LineType.Upper);
		appendLineByValue(stringBuilder,
				  number == 6 ? 2 : number % 2,
				  LineType.Middle);
		appendLineByValue(stringBuilder, number / 2, LineType.Bottom);
		
		boolean[][] result = new boolean[3][3];
		
		char[] temp = stringBuilder.toString().toCharArray();
		int rowIndex = -1;
		int columnIndex = 0;
		
		for(int i = 0; i < temp.length; i++)
		{
			if(i % 3 == 0)
			{
				rowIndex++;
				columnIndex = 0;
			}
			result[rowIndex][columnIndex] = (temp[i] == '*');
			columnIndex++;
		}
		
		return result;
	}
	
	public boolean equals(DominoTile otherTile)
	{
		if(otherTile == null)
		{
			throw new RuntimeException("DominoTile is null");
		}
		
		if(this.getLeftValue() == otherTile.getLeftValue()
		   && this.getRightValue() == otherTile.getRightValue())
		{
			return true;
		}
		else if(this.getRightValue() == otherTile.getLeftValue()
				&& this.getLeftValue() == otherTile.getRightValue())
		{
			return true;
		}
		
		return false;
	}
}
