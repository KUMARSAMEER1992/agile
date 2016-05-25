package environment;

import lifeform.LifeForm;

/**
 * This class consists members and functions related to Environment.
 * @author : Sameer Kumar Kotra
 */
public class Environment
{

	/**
	 * Array of Cell to store multiple Cells.
	 */
	private Cell cells[][];

	/**
	 * Create an instance of Environment which has the given number of rows and
	 * Columns to store Cells.
	 * @param row: Number of rows
	 * @param col :Number of columns.
	 */
	public Environment(int row, int col)
	{
		cells = new Cell[row][col];
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				cells[i][j] = new Cell();
			}
		}
	}

	/**
	 * Returns the Life form at cells[row][col].
	 * @return the LifeForm at specified location.
	 */
	public LifeForm getLifeForm(int row, int col)
	{
		if (row < cells.length && col < cells[row].length)
		{
			return cells[row][col].getLifeForm();
		}
		else
		{
			return null;
		}
	}

	/**
	 * Adds the LifeForm to the Cell at cells[row][col]. Will not add if the row
	 * and column are invalid or if LifeForm already in the Cell.
	 * @param row: Row at which LifieForm to be added.
	 * @param col: column at which LifieForm to be added.
	 * @param entity: LifeForm object to be store in the Cell.
	 * @return true if added, false otherwise.
	 */
	public boolean addLifeForm(int row, int col, LifeForm entity)
	{
		if (row < cells.length && col < cells[row].length)
		{
			return cells[row][col].addLifeForm(entity);
		}
		else
		{
			return false;
		}
	}

	/**
	 * Removes the LifeForm at the cells[row][col].
	 * @return LifeForm removed, null if none is present.
	 */
	public LifeForm removeLifeForm(int row, int col)
	{
		if (row < cells.length && col < cells[row].length)
		{
			return (cells[row][col].removeLifeForm());
		}
		else
		{
			return null;
		}
	}
}
