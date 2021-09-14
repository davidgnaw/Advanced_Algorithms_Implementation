
/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
YU FUNG DAVID WANG */

public class Playlist
{
   private Episode head;
   private int size;

   public Playlist(){
      head = null;
      size = 0;
   }

   public boolean isEmpty()
   { return head == null; }

   public int getSize()
   { return this.size; }

   // Displays the Episodes starting from the head and moving forward

   public void displayPlaylistForward()
   {
     String output = "[BEGIN] ";
     Episode current = head;
     if( current != null ){
       while( current.next != head ){
         output += current + " -> ";
         current = current.next;
       }
       output += current + " [END]\n";
     }
     else{
       output += " [END]\n";
     }
     System.out.println(output);
   }

   // Displays the Episodes starting from the end and moving backwards

   public void displayPlaylistBackward()
 {
     String output = "[END] ";
     Episode current = head.prev;
     if( current != null ){
       while( current.prev != head.prev ){
         output += current + " -> ";
         current = current.prev;
       }
       output += current + " [BEGIN]\n";
     }
     else{
       output += " [BEGIN]\n";
     }
     System.out.println(output);
   }

   // Add a new Episode at the beginning of the Playlist
   public void addFirst( String title, double length )
   {
    Episode current = new Episode(title, length, null, null);
    
    if (isEmpty()) {
      //build pointers
      current.next = current; //both first and last episodes point to the same episode
      current.prev = current; 

      //update
      head = current;
      size++;

    }
    else {

      //build pointers
      //linking current with last episode (head.prev)
      current.prev = head.prev; 
      head.prev.next = current; 
      //linking current with first episode (head)
      head.prev = current; 
      current.next = head; 
      
      //update
      head = current; 
      size++;
     }

   }

   // Add a new Episode at the end of the Playlist
   public void addLast( String title, double length )
   {
    Episode current = new Episode(title, length, null, null);

    if (isEmpty()) {
      //same as addFirst
      current.next = current; 
      current.prev = current;

      head = current; 
      size++;
    }
    else {
      //pointer idea same as addFirst
      current.prev = head.prev; 
      head.prev.next = current;
      head.prev = current;
      current.next = head;

      //update last episode instead of first
      head.prev = current; 
      size++;
    }
   }

   // Add a new Episode at the given index, assuming that index
   // zero corresponds to the first node
   public void add( String title, double length, int index )
   {
    Episode current = new Episode(title, length, null, null);

    if (index == 0) {
      addFirst(title, length); //0 index = first episode
    }

    else {

      Episode itr = head; //set episode as iterator beginning at the first episode (j = 0)
      for (int i = 1; i <= size; i++) { 
        
        if (index > size) { //index is out of bounds
          throw new RuntimeException("[Error] Index is Out Of Bounds in the List");
        
        }

        if (index == i) { 
          Episode temp = itr.next; //temp episode acts as one after current episode

          //build pointers
          //linking current with it's previous episode
          itr.next = current; 
          current.prev = itr; 
          //linking current with it's next episode
          current.next = temp; 
          temp.prev = current; 

        }

        itr = itr.next; //moves the iterating episode to next episode (j++)
      }

      size++;
    }
   }

   // Remove (delete) the Episode that has the given "title"
   public Episode deleteEpisode(String title)
   {
    Episode itr = head; //iterator
    int prevSize = size; //saves the starting size before iteration for corner case if episode does not exist

    if (isEmpty()){ //corner case -> no episodes
      throw new RuntimeException("[Error] Cannot delete episode from an empty Playlist!");
    }


      for (int i = 0; i < size; i++) { //once itr of title is found, break out of for loop

        if(itr.getTitle().equals(title)) { //idea is to remove/unlink itr from list in each case

          if (i == 0  && size == 1){ //corner case -> only one episode
            head = null;
            size = 0;
            break;
          }

          else if (i == 0) { //corner case -> first episode
            head = itr.next;
            head.prev = itr.prev;
            head.prev.next = itr.next;
            size--;
            break;
            
          }

          else if (i == size - 1) { //corner case -> last episode
            head.prev = itr.prev;
            head.prev.next = itr.next;
            size--;
            break;
          }

          else { //removing from middle
            itr.prev.next = itr.next;
            itr.next.prev = itr.prev;
            size--;
            break;
          }

        }


        itr = itr.next; //iterator
     
     }

      if(prevSize == size) { //corner case -> title inputted does not match any episode in linked list
          throw new RuntimeException("[Error] Episode does not exist");
        }
        
     return itr; //returns removed episode
   }  


   public Episode deleteEveryMthEpisode(int m)
   {

   if (isEmpty()) { //corner case -> empty list
      throw new RuntimeException("[Error] Cannot delete episode from an empty Playlist!");
    }

   if (m == 1) { //corner case -> if remove at every 1st, delete every spot
       head = null;
       size = 0;
    }

   else if (m < 0) { //corner case -> if given negative index
       throw new RuntimeException("[Error] Cannot delete from negative index!");
    }

   else if (m == 0) { //corner case -> if remove at every 0th, then leave method and list as is
      return null;
    }

   else {

     Episode itr = head; //start iterator off at head position

     while (size > 1) { //when size = 1 (surviving episode is found), exit loop
      int count = 1;

      while (count < m) { 
        itr = itr.next; //loop itr to the episode at position m
        count++;
     }

      if (itr == head) { //corner case -> mth episode is head
        //pointer update to remove itr
        head = itr.next;
        head.prev = itr.prev;
        head.prev.next = itr.next;

        //update to starting itr position for next loop and size update
        itr = itr.next; 
        size--;
      }

      else if (itr == head.prev) { //corner case -> mth episode is last
        head.prev = itr.prev;
        head.prev.next = head;

        itr = itr.next;
        size--;
      }

      else {
        itr.prev.next = itr.next;
        itr.next.prev = itr.prev;

        itr = itr.next;
        size--;
      }
    }
  }
  return head; //returns surviving episode
 }

} 