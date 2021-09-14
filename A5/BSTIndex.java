/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
YU FUNG DAVID WANG */

public class BSTIndex {

		private class Node {
			private String key;
			private MovieInfo data;
			private Node left, right;

			public Node(MovieInfo info) { //constructor for Node class
				data = info;
				key = data.shortTitle;
			}
		}

		private Node root;

		public BSTIndex() { //constructor for BSTIndex class
			root = null;
		}

		
		/* Calculate and return the height of the current tree. */
		public int calcHeight(){
			return calcNodeHeight(this.root);
		}

		/* Insert the given data element into the proper place in the BST structure. */
		public void insertMovie(MovieInfo data) {
			root = insertMovie(data, this.root);
		}

		/* Find and return the data element (i.e. the MovieInfo object)
		of the node where the movie's shortTitle matches the given key.
		Return null if the movie is not found. */
		public MovieInfo findMovie(String key) {
			return findMovie(this.root, key);
		}

		/* Print out all movies in the database whose shortTitle begins with
		the passed prefix string. If no movies match the given prefix, nothing
		will be printed. The order of printing does not matter, but make sure
		to print each match in a separate line. */
		public void printMoviesPrefix(String prefix) {
			printMoviesPrefix(this.root, prefix);
		}


		private int calcNodeHeight(Node t) {
			Node current = t;

			if (current == null) {
				return 0;
			}

			else {
				int left = calcNodeHeight(current.left);
				int right = calcNodeHeight(current.right);

				if (left > right) {
					return left + 1;
				}
				else {
					return right + 1;
				}
			}
		}

		private Node insertMovie(MovieInfo data, Node t) {
			Node current = t;


			if (current == null) 
				return (new Node(data)); //if tree is empty



			else if (data.shortTitle.compareToIgnoreCase(current.key) == 0) 
				return current; //if duplicate
			

			//recur down the tree

			//if title being inserted is less in alphabetical order than current node
			else {
				
				if (data.shortTitle.compareToIgnoreCase(current.key) < 0) { 
					current.left = insertMovie(data, current.left); 
				} 

				else {
					current.right = insertMovie(data, current.right);
				}
			}

			return current;
			

		}

		private MovieInfo findMovie(Node t, String key) {
			Node current = t;

			while (key.compareToIgnoreCase(current.key) != 0) {
				
				//if search movie title is less in alphabetical order than that of the current node
				if (key.compareToIgnoreCase(current.key) < 0) { 
					current = current.left;
				}

				else if (key.compareToIgnoreCase(current.key) > 0){
					current = current.right;
				}

				if (current == null) { //if cannot find movie
					return null;
				}
			}

			return current.data;

		}

		private void printMoviesPrefix(Node t, String prefix) {
			Node current = t;

			if (current == null){
				return; //base case
			}

			else {

				//split both prefix and title of current node so we can compare them
				String splitPrefix = prefix.split("\\*")[0];
				String splitTitle = "";
				if (current.data.shortTitle.length() >= splitPrefix.length()) {
					splitTitle = current.data.shortTitle.substring(0, splitPrefix.length());
				}

				else {
					//in the case that length of prefix is longer than title length
					splitTitle = current.data.shortTitle; 
				}
				

				if (splitTitle.compareToIgnoreCase(splitPrefix) == 0) { //comparison works
					System.out.println(current.data.shortTitle);
				}

				//continue traversal
				printMoviesPrefix(current.left, prefix);
				printMoviesPrefix(current.right, prefix);

				
		
			

		}



	}


}
