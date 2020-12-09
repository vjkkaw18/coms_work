package cs228hw1.stats;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StatisticsShell<T extends Number> implements Statistics<T>{

	private IParser<T> parser;
	private ArrayList<T> dataFile = new ArrayList<T>();
	private ArrayList<StatObject<T>> newStatObject = new ArrayList<StatObject<T>>();
	private ArrayList<T> newData = new ArrayList<T>();
	private ArrayList<ArrayList<Number>> result = new ArrayList<ArrayList<Number>>();


	public StatisticsShell(IParser<T> parse) {
		parser = parse;
	}

	public StatisticsShell() {
	}

	/**
	 * Reads the weather data (of the specified variety) in the specified file into the active data set.
	 * The data in the file is treated as type T. Missing values should be read as null.
	 * @param d The set of data to be read from the file.
	 * @param path The path of the file.
	 * @return Returns true if the file is successfully read and false otherwise.
	 * @throws FileNotFoundException 
	 */
	@Override
	public boolean ReadFile(String path, DATA d){
		int index = d.ordinal();  
		File file = new File(path);
		
		try 
		{
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine())
			{
				
				String line = scan.nextLine();
				String[] wholeLine = line.split("//s+"); 
				dataFile.add(parser.parse(wholeLine[index]));
			}
		}
		
		catch (FileNotFoundException e)
		{
			return false;
		}
		return true;
	}

	/**
	 * Adds a StatObject to this Statistics object to the end of the list of StatObjects currently in it.
	 * The data currently stored in this Statistics object will be assigned to the new StatObject.
	 */
	@Override
	public void AddStatObject(StatObject<T> so) {
		so.SetData(dataFile);
		newStatObject.add(so);
	}

	/**
	 * Adds a StatObject to this Statistics object to the end of the list of StatObjects currently in it.
	 * A subset of the data currently stored in this Statistics object will be assigned to the new StatObject.
	 * @param so The new StatObject to add.
	 * @param first The index of the first piece of data to add to the provided StatObject.
	 * @param last The index of the last piece of data to add to the provided StatObject.
	 */
	@Override
	public void AddStatObject(StatObject<T> so, int first, int last) {
		ArrayList<T> newDataFile = new ArrayList<T>();
		for (int i = first; i < last; i++)
		{
			if(dataFile.get(i) == null)
			{

			}
			else 
			{
				newDataFile.add(dataFile.get(i));
			}
		}
		so.SetData(dataFile);
		newStatObject.add(so);

	}

	/**
	 * Obtains the [i]th StatObject in this Statistics object.
	 * @param i The index to return.
	 * @return The specified StatObject or null if no such index exists.
	 */
	@Override
	public StatObject<T> GetStatObject(int i) {
		int sizeArray = newStatObject.size() - 1;
		if (i > sizeArray)
		{
			return null;
		}
		else 
		{
			return newStatObject.get(i);
		}
	}

	/**
	 * Removes a StatObject from this Statistics object.
	 * @param i The index to remove.
	 * @return Returns the StatObject removed or null if no such index exists.
	 */
	@Override
	public StatObject<T> RemoveStatObject(int i) {
		int sizeArray = newStatObject.size() - 1;
		if (i > sizeArray)
		{
			return null;
		}
		else 
		{
			return newStatObject.remove(i);
		}
	}

	/**
	 * Returns the number of StatObjects currently in this Statistics object.
	 */
	@Override
	public int Count() {
		
		return newStatObject.size();
	}

	/**
	 * Returns a list containing the current data set stored in this Statistics object used for new StatObjects.
	 * The returned list should not allow modification of any values inside this Statistics object.
	 */
	@Override
	public ArrayList<T> GetDataSet() {
		
		for (int i = 0; i < dataFile.size(); i++)
		{
			newData.add(dataFile.get(i));
		}
		
		return newData;
	}

	/**
	 * Performs each calculation in stored in this Statistics object in order.
	 * @return an ArrayList of results when GetResult is called in every StatObject in order.
	 */
	@Override
	public ArrayList<ArrayList<Number>> MapCar() {
		
		//return the getResult of the statObject
		for(int i = 0; i < newStatObject.size(); i++)
		{
			result.add(newStatObject.get(i).GetResult());
		}
		return result;
	}

}
