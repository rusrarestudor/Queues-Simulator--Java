package assigemnt2;

public class Monitor implements Runnable {

	Scheduler s;
    boolean running = true;
    int seconds ;
    
    public void setSeconds(int s) {
    	this.seconds = s;
    }
    
    @Override
    public void run() {
        synchronized (this) {
        	int counter = 1;
        	System.out.println();
        	System.out.println("----------------------------");
            System.out.println("Simultation Timer started for: " + seconds + " seconds...");  
            System.out.print("Initial list of clients: " );  
            s.afisClients();
            System.out.println();
            System.out.println("----------------------------");
            
            while(counter < seconds) {
	            try {
	            	 wait(1000);
	            	System.out.println();
	                System.out.println("Timer: " + counter);	               	                
		            for(Server sv : s.getServers()) 
		                sv.printServer();
		            counter ++;
		           
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            if(counter ==  seconds) {
	            	System.out.println();
	            	float a = s.getAvgTime() / s.getNbClients() ;
	            	System.out.println("  Average time for a client to be served is: " + a); 
	            	System.out.println();
	            	System.out.println("                                                     -~- 'That's all folks!' -~-" ); 
	            }
	            	
            }
            this.running = false;
        }

    }
}