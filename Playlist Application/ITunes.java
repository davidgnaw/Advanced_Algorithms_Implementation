public class ITunes{

  public static void main(String[] args){



    // Sample testing code ...
    Playlist pl = new Playlist();

 
    

    pl.addFirst("PlanetMoney",26.0);
    pl.addFirst("HowIBuiltThis",10);
    pl.addFirst("EzraKleinShow",65.0);
    
    pl.addLast("MakeMeSmart",24.5);
    pl.addLast("Worldly",55);

    pl.add("RadioLab",25.5, 1);

   
    pl.addLast("Explained",23.0);
    pl.addLast("Invisibilia",33.5);

     pl.displayPlaylistForward();
    
    pl.displayPlaylistBackward();

    // pl.displayPlaylistForward();

   

    // pl.displayPlaylistForward();
    // pl.displayPlaylistBackward();

  }
}
