/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
YU FUNG DAVD WANG */

import java.util.Stack;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;

public class MazeSolver {

  static char[][] maze;
  static int startX, startY;  // indices for starting the maze search
  static int endX, endY; // indices for ending the maze search

  // Constructor that creates the maze
  public MazeSolver(String fileName) throws IOException {
    startX = 0;
    startY = 0;
    readMaze(fileName); // initialize maze
  }

  // Helper method for reading the maze content from a file
  public static void readMaze(String filename) throws IOException {
    Scanner scanner;
    try{
      scanner = new Scanner(new FileInputStream(filename));
    }
    catch(IOException ex){
      System.err.println("[ERROR] Invalid filename: " + filename);
      return;
    }

    int N = scanner.nextInt();
    scanner.nextLine();
    maze = new char[N][N];
    endX = N-1; endY = N-1;
    int i = 0;
    while(i < N && scanner.hasNext()) {
      String line =  scanner.nextLine();
      String [] tokens = line.split("\\s+");
      int j = 0;
      for (; j< tokens.length; j++){
        maze[i][j] = tokens[j].charAt(0);
      }
      if(j != N){
        System.err.println("[ERROR] Invalid line: " + i + " has wrong # columns: " + j);
        return;
      }
      i++;
    }
    if(i != N){
      System.err.println("[ERROR] Invalid file: has wrong number of rows: " + i);
      return;
    }
  }

  // Helper method for printing the maze in a matrix format
  public void printMaze() {
     for (int i=0; i < maze.length; i++) {
         for (int j=0; j < maze.length; j++) {
           System.out.print(maze[i][j]);
           System.out.print(' ');
          }
          System.out.println();
     }
  }


  public void solveMaze() {
    int x = 0;
    int y = 0;
    
    Stack<MazePosition> searchList = new Stack<MazePosition>(); //has the completed pathway
   
    MazePosition next = new MazePosition(x, y); //the next position to move to (start at 0, 0)

    MazePosition exit = new MazePosition(maze.length - 1, maze.length - 1); //exit of maze

  

    searchList.push(next); //push in (0,0) coords aka: start coords
    

    while (!searchList.empty()) {

      next = searchList.peek(); //checks the top coordinate

      x = next.getX(); //x coord of maze position of top coordinate
      y = next.getY(); //y coord of maze position of top cooredinate

      maze[x][y] = 'X'; //mark the top coordinate position to prevent revisiting a '0'

      
      searchList.pop(); 
      //pop the top coordinate to allow
      //evaluation of the next coordinate
      searchList.push(next); 
      //push the next coordinate in (top coordinate) 
      //to go through the checking process of left,right,up,down

      if (x == exit.getX() && y == exit.getY()) {  //check for completed maze
        System.out.println("Maze is Solvable"); //print traversed maze
      
        System.out.println("Potential Path: " + searchList);
        
        System.out.println("X: Paths visited by stack program when finding potential path");
        break; //break out of loop once exit coordinates is found
      } 

      else {
        if (x - 1 >= 0 && maze[x - 1][y] == '0') { //checking up
          MazePosition n = new MazePosition (x - 1, y);
          searchList.push(n); //push in new coords of MazePosition
        
        }
        else if (y - 1 >= 0 && maze[x][y - 1] == '0') { //checking left
          MazePosition n = new MazePosition (x, y - 1);
          searchList.push(n);
        
        }
        else if (x + 1 < maze.length && maze[x + 1][y] == '0') { //checking down
          MazePosition n = new MazePosition (x + 1, y);
          searchList.push(n);
    
        }
        else if (y + 1 < maze.length && maze[x][y + 1] == '0') { //checking right
          MazePosition n = new MazePosition (x, y + 1);
          searchList.push(n);

        }
        else {
          searchList.pop(); 
          //if dead end, pop the position coordinate and all previous ones w/o separate paths
          //to go back to original location that has separate path

        }
      }

    }
    if(searchList.empty() && x != exit.getX() && y != exit.getY()) {
      System.out.println("Maze is Unsolvable"); 
      //in the case of no exit where popping causes list to be empty 
      //and coords are not on exit

    }

  }

 

  public static void main(String[] args) throws IOException {
    // If no argument is provided, show error message
    if(args.length < 1) {
      System.err.println("[ERROR] Usage: java PathFinder maze_file");
      System.exit(-1);
    }
    // File name is provided properly as the first argument
    String fileName =  args[0];

    MazeSolver ms = new MazeSolver(fileName);
    System.out.println("[Before Traversal] Maze:");
    ms.printMaze();
    System.out.println();

    // Test solver
    ms.solveMaze();
    System.out.println();
    System.out.println("[After Traversal] Maze:");
    ms.printMaze();
  }

}
