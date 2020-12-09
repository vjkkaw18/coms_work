package homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

//import com.sun.tools.jdeprscan.scan.Scan;

//import com.sun.tools.javac.parser.Scanner;
//import com.sun.tools.jdeprscan.scan.Scan;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class RobotPath2 {

    private String fName;
    private char[][] gridview;
    private int sRow;
    private int sCol;
    private int eRow;
    private int eCol;
    private String[][] route;
    private Point[][] cUnit;
    private Point eCoord;
    private int rows, columns;
    private int shortestRoute = Integer.MAX_VALUE;

    public RobotPath2() {
    	
    }
    
    class Point {
    	
        int row;
        int col;
        int des;
        List<Point> pred;
        List<Character> dPred;

        Point(int r, int c, int d) {
            this.row = r;
            this.col = c;
            this.des = d;
        }
        
        Point(int r, int c, int d, Point pred, Character dirPred) {
            this.row = r;
            this.col = c;
            this.des = d;
            this.pred = new ArrayList<>();
            this.pred.add(pred);
            this.dPred = new ArrayList<>();
            this.dPred.add(dirPred);
        }

        @Override
        public String toString() {
        	
            return String.format("(%d,%d)", row, col);
        }
    }

    public void readInput(String fileName) throws FileNotFoundException {
    	
    	int k = 0,r, c;
    	
        this.fName = fileName;
        File file = new File(fName);
        Scanner sc = new Scanner(file);
        
        while((sc.hasNext())) {
        	
        	if(k == 0) {
                
                sc.next();
                rows = Integer.parseInt(sc.next());
                sc.next();
                columns = Integer.parseInt(sc.next());
        	}
        	else if(k == 1) {

        		sc.next();
                sRow = Integer.parseInt(sc.next());
                sCol = Integer.parseInt(sc.next());
        	}
        	else if(k == 2) {

        		sc.next();
                eRow = Integer.parseInt(sc.next());
                eCol = Integer.parseInt(sc.next());
                break;
        	}
        	k++;
        }

        gridview = new char[rows][columns];
        route = new String[rows][columns];
        
        sc.next();
        
        for (int i = 0; i < rows; i++) {
        	
            for (int j = 0; j < columns; j++) {
            	
            	gridview[i][j] = '0';
            	route[i][j] = "";
            }
        }
        
        gridview[sRow][sCol] = 'S';
        gridview[eRow][eCol] = 'D';
        
        while ((sc.hasNext())) {
        	
            r = Integer.parseInt(sc.next());
            c = Integer.parseInt(sc.next());
            gridview[r][c] = '*';
        }
        
        sc.close();
    }

    interface myInterface{
    	
    	boolean dfs(Point start, boolean[][]visitedPart);
    }
    
    public void quickPlan() throws IOException {

    	readInput(fName);

        boolean[][] visitedPart = new boolean[rows][columns];
        
        visitedPart[sRow][sCol] = true;

        Point sPoint = new Point(sRow, sCol, 0, null, null);

        myInterface r = new myInterface() {
        	
        	public boolean dfs(Point sPoint2, boolean[][] visitedPoint) {
	        	  
        		boolean dfsCheck = false;
        		int rs = sPoint2.row;
        		int cs = sPoint2.col;
        		double minimum = rows + columns;
        		
	        	Character movement[] = new Character[4];
	        	movement[0] = 's';
	        	movement[1] = 'n';
	        	movement[2] = 'e';
	        	movement[3] = 'w';
	        	
        		if (sPoint2.row == eRow && sPoint2.col == eCol) {
	        	  
        			eCoord = sPoint2;
        			dfsCheck = true;
	            
        			return dfsCheck;
        		}
	          
        		ArrayList<int[]> dirArrows = new ArrayList<>(Arrays.asList(new int[] { 1, 0 }, new int[] { -1, 0 }, new int[] { 0, 1 }, new int[] { 0, -1 })); 
	  
        		while (!dirArrows.isEmpty()) {
	        	  
        			Point maxStep = null;
	              
        			int counter = 0;
        			int maxCounter = 0;
	              
        			for (int[] dir : dirArrows) {
	            	  
        				int nextRows = rs + dir[0];
        				int nextCols = cs + dir[1];
        				if (nextRows >= 0 && nextCols >= 0 && nextRows < rows && nextCols < columns && gridview[nextRows][nextCols] != '*' && !visitedPoint[nextRows][nextCols]) {
	                	  
        					Point step = new Point(nextRows, nextCols, sPoint2.des + 1, sPoint2, movement[counter]);
        					double dist = distance(step);
	                      
        					if (dist < minimum) {
	                    	  
        						minimum = dist;
        						maxStep = step;
        						maxCounter = counter;
        					} 
        					else if (dist == minimum) {
	  
        						if (step.row == maxStep.row && step.col < maxStep.col) {
	                        	  
        							maxStep = step;
        							maxCounter = counter;
        						}
        						else if (step.row < maxStep.row) {
	                        	  
        							maxStep = step;
        							maxCounter = counter;
        						} 

        					}
        				}
	                  counter++;
	              }
	  
	              dirArrows.remove(maxCounter);
	              
	              if (maxStep == null) {
	            	  
	            	  dfsCheck = false;
	                  return dfsCheck;
	              }
	              if (!visitedPoint[maxStep.row][maxStep.col]) {
	            	  
	            	  visitedPoint[maxStep.row][maxStep.col] = true;
	                  if (dfs(maxStep, visitedPoint)) {
	                	  
	                	  dfsCheck = true;
	                      return dfsCheck;
	                  }
	              }
	          }
	  
	          return dfsCheck;
	          };
	        };
        
        if (r.dfs(sPoint,visitedPart)) {
        	
        	Point traceRoute = eCoord;
            while (traceRoute.pred.get(0).row != sRow || traceRoute.pred.get(0).col != sCol) {
            	
            	route[traceRoute.pred.get(0).row][traceRoute.pred.get(0).col] = route[traceRoute.pred.get(0).row][traceRoute.pred.get(0).col] + traceRoute.dPred.get(0);
            	traceRoute = traceRoute.pred.get(0);
            }
        }
    }
    public void planShortest() throws IOException {
    	
    	ArrayList<Point>fP = new ArrayList<>();
    	ArrayList<Character>fD = new ArrayList<>();
        boolean[][] visitedPoint = new boolean[rows][columns];
        Queue<Point> queue = new LinkedList<>();
    	
        int counter;
        int[][] directions = {{1, 0}, {-1, 0},{0, 1},{0, -1}};
        Character[] dirCode = {'s','n','e','w'};
        
        queue.add(new Point(sRow, sCol, 0, null, null));
        visitedPoint[sRow][sCol] = true;
        cUnit = new Point[rows][columns];

        while (!queue.isEmpty()){
        	
        	Point coord = queue.poll();
            int newrow = coord.row;
            int newcol = coord.col;
            int newdes = coord.des + 1;

            counter = 0;
            
            for (int[] Arrow : directions) {
                int nextrow = newrow + Arrow[0];
                int nextcol = newcol + Arrow[1];

                if ((nextrow >= 0 && nextcol >= 0) && (nextrow < rows && nextcol < columns) && gridview[nextrow][nextcol] != 'S' && gridview[nextrow][nextcol] != 'D' && gridview[nextrow][nextcol] != '*'){
	                        	
	               if (!visitedPoint[nextrow][nextcol]) {
	                            	
	                  cUnit[nextrow][nextcol] = new Point(nextrow, nextcol, newdes, coord, dirCode[counter]);
	                  queue.add(cUnit[nextrow][nextcol]);
	                  visitedPoint[nextrow][nextcol] = true;
	               } 
	               else {
	                            	
	            	   Point dest = cUnit[nextrow][nextcol];
	                                
	                   	if (newdes < dest.des && !dest.pred.contains(coord)) {         	
	                   		dest.pred.clear();
	                   		dest.dPred.clear();
	                   		dest.pred.add(coord);
	                   		dest.dPred.add(dirCode[counter]);
	                   	} 
	                   	else if (newdes == dest.des && !dest.pred.contains(coord)) {      	
	                   		dest.pred.add(coord);
	                   		dest.dPred.add(dirCode[counter]);
	                   	}
	               }
                }
                    
                    if ((nextrow >= 0 && nextcol >= 0) && (nextrow < rows && nextcol < columns) && gridview[nextrow][nextcol] == 'D'){
                        if (newdes == shortestRoute) {
                        	fD.add(dirCode[counter]);
                        	fP.add(coord);
                        }
                        else if (newdes < shortestRoute){
                        	fD.clear();
                        	fP.clear();
                        	shortestRoute = newdes;
                            fD.add(dirCode[counter]);
                            fP.add(coord);
                        }
                    }
                counter++;
            }
        }
        
        bfs(fP,fD);

    }
    
    public void bfs(ArrayList<Point>fP, ArrayList<Character>fD) {
    	
        boolean[][] bVisitedPoint = new boolean[rows][columns];

        Queue<Point> queuel = new LinkedList<>(fP);
        
        for (int i = 0; i < fD.size(); i++) {
        	
        	int currentRow = fP.get(i).row;
        	int currentCol = fP.get(i).col;
        
        	route[currentRow][currentCol] = route[currentRow][currentCol] + fD.get(i);
        	bVisitedPoint[currentRow][currentCol] = true;
        }
        	
        for(int i = 0; i < queuel.size() - 1; i++) {
        	
        	Point cell = queuel.poll();
        	
        	int pointSize = cell.pred.size();

            bVisitedPoint[cell.row][cell.col] = true;
            
            for (int j = 0; j < pointSize; j++) {
            	
            	Point predCell = cell.pred.get(i);
            	int predRow = cell.pred.get(i).row;
            	int predCol = cell.pred.get(i).col;
                
                if (gridview[predRow][predCol] != 'S' && (!route[predRow][predCol].contains("" + cell.dPred.get(i)))) {
                    	
                	route[predRow][predCol] = route[predRow][predCol] + cell.dPred.get(i);
                }
                    
                if (gridview[predRow][predCol] != 'S' && !bVisitedPoint[predRow][predCol]) {
                    	
                	queuel.add(predCell);
                }
            }
        }	
    }
    
    public void output() {
        
        for(int iC = 0; iC < route.length; iC++) {
        	for(int jR = 0; jR <route[iC].length; jR++) {
            	
        		if(String.valueOf(route[iC][jR]).matches("[nwse]+")) {
        			System.out.printf("%5s", route[iC][jR]);
        		}
        		else {
        			System.out.printf("%5c", gridview[iC][jR]);
        		}

        	}
        	System.out.println();
        }

    }
    
    private double distance(Point sInput) {
    	
    	double diffCol = eCol - sInput.col;
    	
    	double diffRow = eRow - sInput.row;
    	
    	double distance = Math.sqrt((diffCol * diffCol) + (diffRow * diffRow));
    	
        return distance;
    }
}

