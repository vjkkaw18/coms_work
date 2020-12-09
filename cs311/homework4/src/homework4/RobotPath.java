package homework4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class RobotPath {

	private final Character OBSTACLE = '*';
	private final Character START = 'S';
	private final Character DESTINATION = 'D';
	private char[][] arr;
	private int numRows, numCols;
	private int sRow, sCol; 
	private int dRow, dCol;
	private String[][] plan;
	private String FileName;
	private ArrayList<Node> predecessors;
	private ArrayList<Character> pDirections;
	private int distance;
	private Node[][] nodes;
	private Node destinationNode;
	private boolean[][] explored;
	
//######################################################################################
	public void readInput(String FileName) throws IOException 
	{
		this.FileName = FileName;
		Scanner scanner = new Scanner(new File(FileName));
		scanner.next();
		numRows = scanner.nextInt();
		scanner.next();
		numCols = scanner.nextInt();
		arr = new char[numRows][numCols];
		plan = new String[numRows][numCols];

		for (int i = 0; i < numRows; i++)
		{
			for (int j = 0; j < numCols; j++)
			{
				arr[i][j] = '0';
				plan[i][j] = "";
			}
		}

		scanner.next();
		sRow = scanner.nextInt();
		sCol = scanner.nextInt();
		arr[sRow][sCol] = 'S';

		scanner.next();
		dRow = scanner.nextInt();
		dCol = scanner.nextInt();
		arr[dRow][dCol] = 'D';

		scanner.next();
		while(scanner.hasNextInt())
		{
			int tempRow = scanner.nextInt();
			int tempCol = scanner.nextInt();
			arr[tempRow][tempCol] = '*';
		}
		scanner.close();
		
//		//FOR TESTING PURPOSES
//		System.out.println(Arrays.deepToString(arr).replace("], ", "],\n "));
//		System.out.println(numRows);
//		System.out.println(numCols);
//		System.out.println(sRow + ", " + sCol);
//		System.out.println(dRow + ", " + dCol);
	}

//######################################################################################

	// Always use BFS for shortest path. We will reverse BFS later on to back track each of the nodes explored by the vertex.  
	public void planShortest() throws IOException 
	{
		readInput(FileName); // used to reset the 2d array 
		distance = 0;
		predecessors = new ArrayList<Node>();
		pDirections = new ArrayList<Character>();
		
		Node south = new Node(1, 0);
		Node east = new Node(0, 1);
		Node west = new Node(0, -1);
		Node north = new Node(-1, 0);
		
		Node[] moves = new Node[4];
		moves[0] = south;
		moves[1] = east;
		moves[2] = west;
		moves[3] = north;
		
		Character[] directions = new Character[4];
		directions[0] = 's';
		directions[1] = 'e';
		directions[2] = 'w';
		directions[3] = 'n';
		
		explored = new boolean[numRows][numCols]; // all set to false initially
		Queue<Node> queue = new LinkedList<Node>();
		Node startNode = new Node(sRow, sCol, distance);
		queue.add(startNode);
		explored[sRow][sCol] = true;
		nodes = new Node[numRows][numCols];
		
		int tempDistance = Integer.MAX_VALUE; // set to infinity or the max int value
		int count = 0;
		while(queue.isEmpty() == false)
		{
			count = 0;
			Node currentNode = queue.poll();
			
			for (int i = 0; i < moves.length; i++) // looping through every neighbor of currentNode
			{
				int currentRow = currentNode.row + moves[i].row;
				int currentCol = currentNode.column + moves[i].column;
				
				if ((currentRow >= 0) && (currentRow < numRows) && 
						(currentCol >= 0) && (currentCol < numCols))
				{
					if (arr[currentRow][currentCol] == DESTINATION)
					{
						int distanceCount = currentNode.distance + 1;
						if (distanceCount < tempDistance)
						{
							predecessors.clear();
							pDirections.clear();
							tempDistance = distanceCount;
							predecessors.add(currentNode);
							pDirections.add(directions[count]);
						}
						else if (distanceCount == tempDistance)
						{
							predecessors.add(currentNode);
							pDirections.add(directions[count]);
						}
					}
					Character neighbor = arr[currentRow][currentCol];
					if ((neighbor != START) && (neighbor != DESTINATION) && (neighbor != OBSTACLE))
					{
						if (explored[currentRow][currentCol] == false)
						{
							Node n = new Node(currentRow, currentCol, currentNode.distance+1, 
									currentNode, directions[count]);
							nodes[currentRow][currentCol] = n;
							queue.add(nodes[currentRow][currentCol]);
							explored[currentRow][currentCol] = true;
						}
						else 
						{
							Node n = nodes[currentRow][currentCol];
							if (currentNode.distance + 1 == n.distance)
							{
								if(n.previous.contains(currentNode) == false)
								{
									n.previous.add(currentNode);
									n.direction.add(directions[count]);
								}
							}
							if (currentNode.distance + 1 < n.distance) 
							{
								n.previous.clear();
								n.direction.clear();
								if(n.previous.contains(currentNode) == false)
								{
									n.previous.add(currentNode);
									n.direction.add(directions[count]);
								}
							}
						}
					}
				}
				count = count + 1;
			}
		}
		
		explored = new boolean[numRows][numCols];
		Queue<Node> queue2 = new LinkedList<Node>(predecessors);
		
		for (int i = 0; i < pDirections.size(); i++)
		{
			int pRow = predecessors.get(i).row;
			int pCol = predecessors.get(i).column;
			plan[pRow][pCol] = plan[pRow][pCol] + pDirections.get(i);
			explored[pRow][pCol] = true;
		}
		
		while(queue2.isEmpty() == false)
		{
			Node currentNode = queue2.poll();
			explored[currentNode.row][currentNode.column] = true;
			for (int i = 0; i < currentNode.previous.size(); i++)
			{
				Node n = currentNode.previous.get(i);
				if(arr[n.row][n.column] != 'S')
				{
					if(explored[n.row][n.column] == false)
					{
						queue2.add(n);
					}
					if(plan[n.row][n.column].contains("" + currentNode.direction.get(i)) == false)
					{
						plan[n.row][n.column] = plan[n.row][n.column] + currentNode.direction.get(i);
					}
				}
			}
		}
		
	}
	
//######################################################################################
	// This method should return true if it was able to search for the quickest path to destination. 
	// should be called from quickplan method. 
	// Will be using Euclidean distance to compare the next path of a vertex. No back-paddling. 
	// The next path of a vertex will be determined by the minimum or lowest of the neighbor's euclidean distance to destination value
	// If there happens to be more than one neighbor with equal euclidean distance to destination, then we will choose the lower value of row or col
	// recursive call to keep searching for the next path until destination node is reached. 
	public boolean depthFirstSearch(Node currentNode) {
//		boolean destExplored = false;
		Node south = new Node(1, 0);
		Node east = new Node(0, 1);
		Node west = new Node(0, -1);
		Node north = new Node(-1, 0);
		
		Node[] moves = new Node[4];
		moves[0] = south;
		moves[1] = east;
		moves[2] = west;
		moves[3] = north;
		
		Character[] directions = new Character[4];
		directions[0] = 's';
		directions[1] = 'e';
		directions[2] = 'w';
		directions[3] = 'n';
		
		double minEuclidean = Double.MAX_VALUE;
		double tempEuclidean= 0.0;
		
		// either two things will happen for this if statement to execute
		// the start node is equal to the destination node
		// or the search has reached the destination node or the end point 
		if ((currentNode.row == dRow) && (currentNode.column == dCol))
		{
			destinationNode = currentNode;
			return true;
		}
		
		
		for (int i = 0; i < moves.length; i++)
		{
			Node preferredNode = null;
			
			for (int j = 0; j < moves.length; j++)
			{
				int currentRow = currentNode.row + moves[j].row;
				int currentCol = currentNode.column + moves[j].column;
				
				if ((currentRow >= 0) && (currentRow < numRows) && 
						(currentCol >= 0) && (currentCol < numCols))
				{
					if ((arr[currentRow][currentCol] != '*') && (explored[currentRow][currentCol] == false))
					{
						Node n = new Node (currentRow, currentCol, (currentNode.distance)+1, currentNode, directions[j]);
						
						tempEuclidean = euclideanDistance(n);
						
						if(tempEuclidean < minEuclidean)
						{
							minEuclidean = tempEuclidean;
							preferredNode = n;
						}
						
						// same distance with more than one neighbor of the currentNode
						else if (tempEuclidean == minEuclidean)
						{
							if (n.row < preferredNode.row)
							{
								preferredNode = n;
							}
							
							else if (n.row == preferredNode.row && n.column == preferredNode.column)
							{
								preferredNode = n;
							}
						}
					}
				}
			}
			
			if (preferredNode == null)
			{
				return false;
			}
			
			else if (explored[preferredNode.row][preferredNode.column] == false)
			{
				explored[preferredNode.row][preferredNode.column] = true;
				if (depthFirstSearch(preferredNode) == true) // repeat to get the next path of the current Node until destination is reached
				{
					return true;
				}
			}
		}
		return false;
	}
	
//######################################################################################
	// Using depth first search to calculate for the quickest path to destination by incorporating euclidean distance
	public void quickPlan() throws IOException
	{
		readInput(FileName);
		explored = new boolean[numRows][numCols];
		explored[sRow][sCol] = true;
		distance = 0;
		Node startNode = new Node(sRow, sCol, distance);
		Node temp = null;
		
		if (depthFirstSearch(startNode) == true) // meaning explored all the way to destination 
		{
			temp = destinationNode;
			
			while((temp.previous.get(0).row != sRow) || (temp.previous.get(0).column) != sCol)
			{
				plan[temp.previous.get(0).row][temp.previous.get(0).column] = plan[temp.previous.get(0).row][temp.previous.get(0).column] +
						temp.direction.get(0);
				temp = temp.previous.get(0);
			}
		}
	}
	
//######################################################################################
	// output the 2d array from arr[][] and plan[][]
	public void output()
	{
		for (int i = 0; i < numRows; i++)
		{
			for (int j = 0; j < numCols; j++)
			{
				if (plan[i][j].equals(""))
				{
					System.out.printf("%5c", arr[i][j]);
				}
				
				else 
				{
					System.out.printf("%5s", plan[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
//######################################################################################
	// HELPER METHODS
	// Helper class to keep track of vertex's row, column, distance, predecessor, and direction of 
	// its predecessor. 
	public static class Node 
	{
		int row, column, distance;
		List<Node> previous = new ArrayList<Node>();
		List<Character> direction = new ArrayList<Character>();

		Node (int row, int column)
		{
			this.row = row;
			this.column = column;
		}

		Node (int row, int column, int distance)
		{
			this.row = row;
			this.column = column;
			this.distance = distance;
		}

		Node (int row, int column, int distance, Node previous, Character direction)
		{
			this.row = row;
			this.column = column;
			this.distance = distance;
			this.previous.add(previous);
			this.direction.add(direction);
		}

		@Override
		public boolean equals(Object obj)
		{
			if (obj == null)
			{
				return false;
			}

			if (this == obj)
			{
				return true;
			}

			if ((obj instanceof Node) == false)
			{
				return false;
			}

			Node n = (Node) obj;
			if ((row == n.row) && (column == n.column))
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
	}

	public double euclideanDistance(Node currentNode) {
		int row = currentNode.row;
		int col = currentNode.column;

		double euclidean = Math.sqrt(((dRow - row) * (dRow - row)) + ((dCol - col) * (dCol - col)));

		return euclidean;
	}

	public static void main(String[] args) 
	{
		RobotPath rp = new RobotPath();
		try {
			rp.readInput("Grid17.txt");
//			rp.planShortest();
//			rp.output();
//			System.out.println();
			rp.quickPlan();
			rp.output();
//			System.out.println();

//			rp.readInput("Grid2.txt");
//			rp.planShortest();
//			rp.output();
//			System.out.println();
//
//			rp.readInput("Grid3.txt");
//			rp.planShortest();
//			rp.output();
//			System.out.println();
//
//			rp.readInput("Grid_NoPath.txt");
//			rp.planShortest();
//			rp.output();
//			System.out.println();
//
//			rp.readInput("Grid.txt");
//			rp.planShortest();
//			rp.quickPlan();
//			rp.output();
//			System.out.println();
//
//			rp.readInput("Grid2.txt");
//			rp.planShortest();
//			rp.quickPlan();
//			rp.output();
//			System.out.println();
//
//			rp.readInput("Grid3.txt");
//			rp.planShortest();
//			rp.quickPlan();
//			rp.output();
//			System.out.println();
//
//			rp.readInput("Grid_NoPath.txt");
//			rp.planShortest();
//			rp.quickPlan();
//			rp.output();
//			System.out.println();

		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}

