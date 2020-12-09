package edu.iastate.cs228.hw5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner; 

/**
 * 
 * @author Vance Kaw
 *
 */

public class VideoStore 
{
	protected SplayTree<Video> inventory;     // all the videos at the store
	
	// ------------
	// Constructors 
	// ------------
	
    /**
     * Default constructor sets inventory to an empty tree. 
     */
    public VideoStore()
    {
    	// no need to implement. 
    }
    
    
	/**
	 * Constructor accepts a video file to create its inventory.  Refer to Section 3.2 of  
	 * the project description for details regarding the format of a video file. 
	 * 
	 * Calls setUpInventory(). 
	 * 
	 * @param videoFile  no format checking on the file
	 * @throws FileNotFoundException
	 */
    public VideoStore(String videoFile) throws FileNotFoundException  
    {
    	inventory = new SplayTree<>();
    	setUpInventory(videoFile);
    }
    
    
   /**
     * Accepts a video file to initialize the splay tree inventory.  To be efficient, 
     * add videos to the inventory by calling the addBST() method, which does not splay. 
     * 
     * Refer to Section 3.2 for the format of video file. 
     * 
     * @param  videoFile  correctly formated if exists
     * @throws FileNotFoundException 
     */
    public void setUpInventory(String videoFile) throws FileNotFoundException
    {
    	String srcPath = "src/edu/iastate/cs228/hw5/" + videoFile; 
		File file = new File(srcPath);
		Scanner fileScanner = new Scanner(file);
		
		while(fileScanner.hasNextLine())
		{
			String currentLine = fileScanner.nextLine();
			int index = currentLine.indexOf('(');
			
			if (index != -1)
			{
				String nameOfVideo = currentLine.substring(0, index).trim();
//				System.out.println(nameOfVideo); // FOR TESTING
				int number = Integer.parseInt(currentLine.substring(index + 1, currentLine.indexOf(')'))); 
//				System.out.println(value); // FOR TESTING
				Video v = new Video(nameOfVideo, number);
				inventory.addBST(v);
			}
			
			else 
			{
//				System.out.println(currentLine); // FOR TESTING
				Video v = new Video (currentLine);
				inventory.addBST(v);
			}
//			fileScanner.close();
		}
    }
	
    
    // ------------------
    // Inventory Addition
    // ------------------
    
    /**
     * Find a Video object by film title. 
     * 
     * @param film
     * @return
     */
	public Video findVideo(String film) 
	{
		Video v = new Video (film);
		
		if (inventory.contains(v))
		{
			return inventory.findElement(v);
		}

		return null;

	}


	/**
	 * Updates the splay tree inventory by adding a number of video copies of the film.  
	 * (Splaying is justified as new videos are more likely to be rented.) 
	 * 
	 * Calls the add() method of SplayTree to add the video object.  
	 * 
	 *     a) If true is returned, the film was not on the inventory before, and has been added.  
	 *     b) If false is returned, the film is already on the inventory. 
	 *     
	 * The root of the splay tree must store the corresponding Video object for the film. Update 
	 * the number of copies for the film.  
	 * 
	 * @param film  title of the film
	 * @param n     number of video copies 
	 */
	public void addVideo(String film, int n)  
	{
		Video v = new Video(film, n);
		if (!inventory.add(v))
		{
			inventory.root.data.addNumCopies(n);
		}
	}
	

	/**
	 * Add one video copy of the film. 
	 * 
	 * @param film  title of the film
	 */
	public void addVideo(String film)
	{
		Video v = inventory.findElement(new Video(film));
		v.addNumCopies(1);
	}
	

	/**
     * Update the splay trees inventory by adding videos.  Perform binary search additions by 
     * calling addBST() without splaying. 
     * 
     * The videoFile format is given in Section 3.2 of the project description. 
     * 
     * @param videoFile  correctly formated if exists 
     * @throws FileNotFoundException
     */
    public void bulkImport(String videoFile) throws FileNotFoundException 
    {
    	String srcPath = "src/edu/iastate/cs228/hw5/" + videoFile;
		File file = new File(srcPath);
		Scanner fileScanner = new Scanner(file);
		
		while (fileScanner.hasNextLine())
		{
			String nameOfVideo = parseFilmName(fileScanner.nextLine());
//			System.out.println(nameOfVideo); // FOR TESTING
			int number = parseNumCopies(fileScanner.nextLine());
//			System.out.println(number);  // FOR TESTING
			Video v = new Video(nameOfVideo, number);
			if (!this.inventory.addBST(v))
			{
				inventory.findElement(v).addNumCopies(number);
			}
		}
//		fileScanner.close();
    }

    
    // ----------------------------
    // Video Query, Rental & Return 
    // ----------------------------
    
	/**
	 * Search the splay tree inventory to determine if a video is available. 
	 * 
	 * @param  film
	 * @return true if available
	 */
	public boolean available(String film)
	{
		boolean isAvailable = false;
		Video v = new Video(film);
		
		if (inventory.findElement(v) != null)
		{
			isAvailable = true;
		}
		
		else 
		{
			isAvailable = false;
		}
		
		return isAvailable; 
	}

	
	
	/**
     * Update inventory. 
     * 
     * Search if the film is in inventory by calling findElement(new Video(film, 1)). 
     * 
     * If the film is not in inventory, prints the sb "Film <film> is not 
     * in inventory", where <film> shall be replaced with the string that is the value 
     * of the parameter film.  If the film is in inventory with no copy left, prints
     * the sb "Film <film> has been rented out".
     * 
     * If there is at least one available copy but n is greater than the number of 
     * such copies, rent all available copies. In this case, no AllCopiesRentedOutException
     * is thrown.  
     * 
     * @param film   
     * @param n 
     * @throws IllegalArgumentException      if n <= 0 or film == null or film.isEmpty()
	 * @throws FilmNotInInventoryException   if film is not in the inventory
	 * @throws AllCopiesRentedOutException   if there is zero available copy for the film.
	 */
	public void videoRent(String film, int n) throws IllegalArgumentException, FilmNotInInventoryException,  
									     			 AllCopiesRentedOutException 
	{
		if(n <= 0 || film == null || film.isEmpty())
		{
			throw new IllegalArgumentException();
		}
		
	
		if (inventory.findElement(new Video(film, 1)) == null)
		{
			System.out.println("Film " + film + " is not in inventory");
			throw new FilmNotInInventoryException();
		}
		
		Video v = findVideo(film);
		
		if (v.getNumAvailableCopies() == 0)
		{
			System.out.println("Film " + film + " has been rented out");
			throw new AllCopiesRentedOutException();
		}
		
		if (v.getNumAvailableCopies() >= 1 && n > v.getNumAvailableCopies())
		{
			v.rentCopies(v.getNumAvailableCopies());
		}
		
		else 
		{
			v.rentCopies(n);
		}
	}

	
	/**
	 * Update inventory.
	 * 
	 *    1. Calls videoRent() repeatedly for every video listed in the file.  
	 *    2. For each requested video, do the following: 
	 *       a) If it is not in inventory or is rented out, an exception will be 
	 *          thrown from videoRent().  Based on the exception, prints out the following 
	 *          sb: "Film <film> is not in inventory" or "Film <film> 
	 *          has been rented out." In the sb, <film> shall be replaced with 
	 *          the name of the video. 
	 *       b) Otherwise, update the video record in the inventory.
	 * 
	 * For details on handling of multiple exceptions and sb printing, please read Section 3.4 
	 * of the project description. 
	 *       
	 * @param videoFile  correctly formatted if exists
	 * @throws FileNotFoundException
     * @throws IllegalArgumentException     if the number of copies of any film is <= 0
	 * @throws FilmNotInInventoryException  if any film from the videoFile is not in the inventory 
	 * @throws AllCopiesRentedOutException  if there is zero available copy for some film in videoFile
	 */
	public void bulkRent(String videoFile) throws FileNotFoundException, IllegalArgumentException, 
												  FilmNotInInventoryException, AllCopiesRentedOutException 
	{
		String srcPath = "src/edu/iastate/cs228/hw5/" + videoFile;
		File file = new File(srcPath);
		Scanner fileScanner = new Scanner(file);
		
		String nameOfVideo = "";
		boolean exceptionCondition1 = false; // for illegal argument exception 
		boolean exceptionCondition2 = false; // for film not in inventory exception
		StringBuilder sb = new StringBuilder();
		
		while (fileScanner.hasNextLine())
		{
			try 
			{
				String currentLine = fileScanner.nextLine();
				nameOfVideo = parseFilmName(currentLine);
				int number = parseNumCopies(currentLine);
				
				if (number <= 0)
				{
					exceptionCondition1 = true;
				}
				videoRent(nameOfVideo, number);
			}
			catch (FilmNotInInventoryException e)
			{
				exceptionCondition2 = true;
				sb.append("Film " + nameOfVideo + " not in inventory"); 
			}
			
			catch (AllCopiesRentedOutException e)
			{
				sb.append("Film " + nameOfVideo + " has been rented out");
			}
		}
		
		if (exceptionCondition1 == true)
		{
			throw new IllegalArgumentException(sb.toString());
		}
		
		else if (exceptionCondition2 == true)
		{
			throw new FilmNotInInventoryException(sb.toString());
		}
		
		else if (!sb.toString().isEmpty())
		{
			throw new AllCopiesRentedOutException(sb.toString());
		}
	}

	
	/**
	 * Update inventory.
	 * 
	 * If n exceeds the number of rented video copies, accepts up to that number of rented copies
	 * while ignoring the extra copies. 
	 * 
	 * @param film
	 * @param n
	 * @throws IllegalArgumentException     if n <= 0 or film == null or film.isEmpty()
	 * @throws FilmNotInInventoryException  if film is not in the inventory
	 */
	public void videoReturn(String film, int n) throws IllegalArgumentException, FilmNotInInventoryException 
	{
		if (n <= 0 || film == null || film.isEmpty())
		{
			throw new IllegalArgumentException();
		}
		
		if (inventory.findElement(new Video(film, 1)) == null)
		{
			throw new FilmNotInInventoryException();
		}
		
		findVideo(film).returnCopies(n);
	}
	
	
	/**
	 * Update inventory. 
	 * 
	 * Handles excessive returned copies of a film in the same way as videoReturn() does.  See Section 
	 * 3.4 of the project description on how to handle multiple exceptions. 
	 * 
	 * @param videoFile
	 * @throws FileNotFoundException
	 * @throws IllegalArgumentException    if the number of return copies of any film is <= 0
	 * @throws FilmNotInInventoryException if a film from videoFile is not in inventory
	 */
	public void bulkReturn(String videoFile) throws FileNotFoundException, IllegalArgumentException,
													FilmNotInInventoryException												
	{
		String srcPath = "src/edu/iastate/cs228/hw5/" + videoFile;
		File file = new File(srcPath);
		Scanner fileScanner = new Scanner(file);
		
		boolean exceptionCondition1 = false;
		StringBuilder sb = new StringBuilder();
		
		while(fileScanner.hasNext())
		{
			String currentLine = fileScanner.nextLine();
			String nameOfVideo = parseFilmName(currentLine);
			int number = parseNumCopies(currentLine);
			
			if (number <= 0)
			{
				exceptionCondition1 = true;
			}
			
			if (findVideo(nameOfVideo) == null)
			{
				sb.append("Film " + nameOfVideo + " is not in inventory");
			}
			
			videoReturn(nameOfVideo, number);
		}
		
		if (exceptionCondition1 == true)
		{
			throw new IllegalArgumentException(sb.toString());
		}
		
		else if (!sb.toString().isEmpty())
		{
			throw new FilmNotInInventoryException(sb.toString());
		}
	}
		
	

	// ------------------------
	// Methods without Splaying
	// ------------------------
		
	/**
	 * Performs inorder traversal on the splay tree inventory to list all the videos by film 
	 * title, whether rented or not.  Below is a sample string if printed out: 
	 * 
	 * 
	 * Films in inventory: 
	 * 
	 * A Streetcar Named Desire (1) 
	 * Brokeback Mountain (1) 
	 * Forrest Gump (1)
	 * Psycho (1) 
	 * Singin' in the Rain (2)
	 * Slumdog Millionaire (5) 
	 * Taxi Driver (1) 
	 * The Godfather (1) 
	 * 
	 * 
	 * @return
	 */
	public String inventoryList()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Films in inventory: \n \n");
		
		Iterator<Video> iter = inventory.iterator();
		
		while (iter.hasNext())
		{
			Video v = iter.next();
			sb.append(v.toString() + " ");
		}
		return sb.toString(); 
	}

	
	/**
	 * Calls rentedVideosList() and unrentedVideosList() sequentially.  For the string format, 
	 * see Transaction 5 in the sample simulation in Section 4 of the project description. 
	 *   
	 * @return 
	 */
	public String transactionsSummary()
	{
		String summary = "";
		
		summary += rentedVideosList() + "\n";
		summary += unrentedVideosList() + "\n";
		
		return summary; 
	}	
	
	/**
	 * Performs inorder traversal on the splay tree inventory.  Use a splay tree iterator.
	 * 
	 * Below is a sample return string when printed out:
	 * 
	 * Rented films: 
	 * 
	 * Brokeback Mountain (1)
	 * Forrest Gump (1) 
	 * Singin' in the Rain (2)
	 * The Godfather (1)
	 * 
	 * 
	 * @return
	 */
	private String rentedVideosList()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Rented films: \n \n");
		
		Iterator<Video> iter = inventory.iterator();
		
		while (iter.hasNext())
		{
			Video v = iter.next();
			if (v.getNumRentedCopies() >= 1)
			{
				sb.append(v.getFilm() + " (" + v.getNumRentedCopies() + ") \n");
			}
		}
		return sb.toString(); 
	}

	
	/**
	 * Performs inorder traversal on the splay tree inventory.  Use a splay tree iterator.
	 * Prints only the films that have unrented copies. 
	 * 
	 * Below is a sample return string when printed out:
	 * 
	 * 
	 * Films remaining in inventory:
	 * 
	 * A Streetcar Named Desire (1) 
	 * Forrest Gump (1)
	 * Psycho (1) 
	 * Slumdog Millionaire (4) 
	 * Taxi Driver (1) 
	 * 
	 * 
	 * @return
	 */
	private String unrentedVideosList()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Films remaining in inventory: \n \n");
		
		Iterator<Video> iter = inventory.iterator();
		
		while (iter.hasNext())
		{
			Video v = iter.next();
			if (v.getNumAvailableCopies() >= 1)
			{
				sb.append(v.getFilm() + " (" + v.getNumAvailableCopies() + ") \n");
			}
		}
		return sb.toString(); 
	}	

	
	/**
	 * Parse the film name from an input line. 
	 * 
	 * @param line
	 * @return
	 */
	public static String parseFilmName(String line) 
	{
		int index = line.indexOf('(');
		if (index != -1)
		{
			String nameOfVideo = line.substring(0, index).trim();
			return nameOfVideo;
		}
		
		else
		{
			return line;
		}
	}
	
	
	/**
	 * Parse the number of copies from an input line. 
	 * 
	 * @param line
	 * @return
	 */
	public static int parseNumCopies(String line) 
	{
		int index = line.indexOf('(');
		
		if (index != -1)
		{
			int number = Integer.parseInt(line.substring(index + 1, line.indexOf(')')));
			return number;
		}
		
		else 
		{
			return 1;
		}
		 
	}
}
