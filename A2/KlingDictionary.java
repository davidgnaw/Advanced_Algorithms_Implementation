import java.util.*;

/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
YU FUNG DAVID WANG
*/


// This class represents a dictionary of Klingon words,
// where each word is represented by class "KlingWord"
public class KlingDictionary {

  // one member variable that represents the dictionary as an ArrayList;
  // all methods below will add/read/remove/etc. from this variable
  public ArrayList<KlingWord> dict;
  

  // constructor
  public KlingDictionary () {
      dict = new ArrayList<KlingWord>();
  }

  // Helper method to build the dictionary "dict" from two String arrays
  // Returns the number of words that have been added successfully

  public int buildDictionary() {
    // A list of Klingon words to be added to this dictionary
    String[] knWordsArray= {"adanji", "baH", "baktag", "batleth", "Bekk", "fote", "forshak", "ghoptu", "lol",	"eff", "grr",	"keshmalek",	"drumpf", "daH", "Kyamo"};
    // The corresponding English translations are stored in the same order below
    String[] enWordsArray = {"perfume", "blah", "insult", "sword", "soldier", "vin", "car", "insult", "look", "insult", "insult", "gameover", "prince", "duh", "Beautiful"};

    // Variables to be used inside the for-loop
    String knWord = "";
    String enWord = "";
    int numWords = 0;
    for(int i = 0; i < knWordsArray.length; i++) {
        knWord = knWordsArray[i];  //read the KN word
        enWord = enWordsArray[i];  //read the corresponding EN translation
        KlingWord word = new KlingWord(knWord, enWord); //create a KlingWord object

        addWord(word); //this will only work properly after you implement addWord() below!!
        numWords++; //update word counter
    }

    return numWords;
  }

  // -------------- Assignment#1 Dictionary Methods Below -------------- //
 
  // Return 0 if addition was successful, -1 otherwise. */
  public int addWord(KlingWord newWord) {
    int count = 0;
    Iterator <KlingWord> dictItr = dict.iterator();

    while(dictItr.hasNext()) { //trying out iterator in arrayList
      //makes sure case insensitive and only Kilgnon word is evauluated
      if (dictItr.next().getKN().equalsIgnoreCase(newWord.getKN()))
        count++; 
    }



   //count used to determine if there was a duplicate
   if (count > 0) {
    return -1;
   } else {
    dict.add(newWord); //add new word is no duplicate was found
    return 0;
    }
  }


  //Return 0 if a replacement did happen (i.e. you found oldWord), -1 otherwise. */
  public int replaceOrAddWord(KlingWord oldWord, KlingWord newWord) {
    int count = 0;

    for (int i = 0; i < dict.size(); i++) { //go back to for loop because want to index i
      
      if (dict.get(i).getKN().equalsIgnoreCase(oldWord.getKN())) {
        dict.set(i, newWord); //used to replace with new word
        count++; 
      }
    }

    //count used to determine if replacement occured or not
    if (count > 0) {
      return 0;
  } else {
      dict.add(newWord); //add new word to end of dictionary if no old word was found
      return -1;
  }
}




  // /* Delete all Klingon words that have the English meaning given in badEN

  public int deleteFromDict(String badEN){
    int count = 0;
    //collect all the entries in dict that should be deleted
    //collect and removeAll method
    ArrayList<KlingWord> deleteWords = new ArrayList <KlingWord>();

    for (int i = 0; i < dict.size(); i++) { 
      
      if (dict.get(i).getEN().equalsIgnoreCase(badEN)) {
        deleteWords.add(dict.get(i));
        count++;
      }
    }


    dict.removeAll(deleteWords); //remove all the entries in dict = badEN
    return count; //returning number of badEN deleted
  }





  //finds palindromes and puts them into a new dictionary
  public KlingDictionary createSubDict(){
    KlingDictionary dict2 = new KlingDictionary();

    for (int i = 0; i < dict.size(); i++) {
      if (dict.get(i).getKN().equalsIgnoreCase(reverse(dict.get(i).getKN()))) {
        dict2.addWord(dict.get(i));
      }
    }

    return dict2; //new dictonary with palindromes
  }

  //reverse a word method for finding the palindromes
  public String reverse(String str) {
    String reverse = "";

    if (str == null) {
      return str;
    }

    for (int i = str.length() - 1; i >= 0; i--) {
      reverse = reverse + str.charAt(i);

    }
    return reverse;

  }





  //*Prints all the KlingWord objects inside the ArrayList dict.
  public void printDictionary(){
    for( KlingWord kw : dict ){
      System.out.println(kw);
    }
  }





  // Main method includes constructing your dictionary and testing its methods
  public static void main(String[] args) {
    int result;
    KlingDictionary klingdict = new KlingDictionary();

    // Build the dictionary
    result = klingdict.buildDictionary();
    System.out.println("buildDictionary() result => " + result);
    // Print dictionary
    klingdict.printDictionary();

    // Add word
    result = klingdict.addWord(new KlingWord("klingothing","nothing"));
    // Remember, '\n' below stands for: print a "new line"
    System.out.println("\naddKlingWordictoDict() result => " + result);
    klingdict.printDictionary();

    // Replace or add word
    KlingWord testword = new KlingWord("forshak","vehicle");
    KlingWord newWord = new KlingWord("gamma","beta");
    result = klingdict.replaceOrAddWord(testword, newWord);
    System.out.println("\nreplaceOrAddWord(" + testword.getKN() +
                "," + newWord.getKN() + ") result => " + result);
    klingdict.printDictionary();



    // Get special words in a new dictionary
    KlingDictionary specialDict = klingdict.createSubDict();
    System.out.println("\nRunning createSubDict()...");
    specialDict.printDictionary(); // print new dictionary with special words


    // Delete all words that have this English meaning
    String badEN = "insult";
    result = klingdict.deleteFromDict(badEN);
    System.out.println("\ndeleteFromDict() result => " + result);
    klingdict.printDictionary();

  }

}
