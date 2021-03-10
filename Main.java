package assigemnt2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
		
	public Main() {			
	}	
	
	public static void main(String[] Args) {				

		try {		     
			Scanner sc = new Scanner(System.in);
			String in = "./" + sc.next();
			Scanner myReader = new Scanner(new File(in));				
		      while (myReader.hasNext()) {		    	  	
		    		int maxC = Integer.parseInt(myReader.next());		    		
		    		int maxS = Integer.parseInt(myReader.next());		    				    	  		    	    
		    	    Scheduler s = new Scheduler(maxS);
		    	    s.setMaxClients(maxC);		    	    
		    	    int time = Integer.parseInt(myReader.next());
		    	    s.setTime(time);		    		
		    	    int minA = Integer.parseInt(myReader.next());
		    	    int maxA = Integer.parseInt(myReader.next());
		    	    s.setArrivals(minA, maxA);		    	    
		    	    int minW = Integer.parseInt(myReader.next());
		    	    int maxW = Integer.parseInt(myReader.next());
		    	    s.setWaits(minW, maxW);		    	    		    	    
		    		Thread schedulerThread = new Thread(s);
		    		schedulerThread.start();		        
		      }
		      myReader.close();
		}catch (FileNotFoundException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
	    }			
		try
	        {
			 	Scanner sc = new Scanner(System.in);
			 	String out = "./" + sc.next();			 			 	
	            PrintStream fileOut = new PrintStream(out);	          	            
	            System.setOut(fileOut);
	       }catch(FileNotFoundException ex){
	            ex.printStackTrace();
	       }
		
	}	
}
