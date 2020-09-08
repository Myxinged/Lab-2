import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Lab2 {

   public static void main(String[] args) throws FileNotFoundException {

       String line="";
       int NumOfSong=0;
       int NumOfArtist=0;
       //get the data from the file
       File file = new File("C:\\Java\\Lab-2\\SpotifyData.csv");
       Scanner sc = new Scanner(file);
       //Get the output to the file
       File outfile = new File("C:\\Java\\Lab-2\\Artist.txt");
       PrintWriter output = new PrintWriter(outfile);

       //Set the maximum number of artist that can be read
       int maxArtistNum = 200;
       String artists[] = new String[maxArtistNum];
       int artistsCount[] = new int[maxArtistNum];

       //Set count to zero
       for(int i=0;i<artistsCount.length;i++){
           artistsCount[i] = 0;
       }

       //Count the number of songs that was readed
	   while(sc.hasNextLine()){
		   NumOfSong++;
	       
	       //read line and split by comma
	       line = sc.nextLine();
	       String columns[] = line.split(",(?=\\S)");

	       //Artist will be at second columns
	       String Artist = columns[2];

	       //remove quotes from artist names
	       Artist = Artist.replaceAll("\"", "");
	       for(String art : Artist.split(",")){
	           boolean found = false;

	           //Count the number of times that the artist appear
	           for(int i=0;i<NumOfArtist;i++){
	               if(art.equalsIgnoreCase(artists[i])){
	                   artistsCount[i]++;
	                   found = true;
	                   break;
	               }
	           }
	         //count the number of artists that appear in the list
	           if(!found){
	               artists[NumOfArtist] = art;
	               artistsCount[NumOfArtist]=1;
	               NumOfArtist++;
	           }
	       }
	   }

       output.printf("%-20s%s\n","Artist Name","Counts");
       for(int i=0;i<NumOfArtist;i++){
    	   output.printf("%-20s%s\n",artists[i],artistsCount[i]);
       }
       output.println("--------------------------------------------");
       output.println("Total song readed : "+NumOfSong);
       output.println("Total of artist that appear in the list : "+NumOfArtist);
       sc.close();
       output.close();
   }
}
