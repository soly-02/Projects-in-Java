

public class Main {

	public static void main (String[] args) {
		
		System.out.println("Welcome to the simplified blackjack game!");
	   
		//arxikopoihsh
		Player Player= new Player();
		Dealer Dealer= new Dealer ();
		
	    // Player's turn
	    Player.ResultsUser();
	    int pAdd= Player.add();
	    
	       if (pAdd==-1) {   // o paikths kaike (an efere 11 dyo fores) telos paixnidiou
	    	   System.out.println("You got burned, Dealer wins!"); 
	           System.exit(0);
	       }
	       
	        // O paikths den kaike me ta 2 prwta fylla kai synexizei na paizei
	    	    Dealer.ResultsDealer();
          	    boolean answer = Player.choice();
          	   if (answer) {             
	               do {
	    	         Player.hit();
	    	         pAdd=Player.add();          
	    	            if (pAdd!=-1)
	            	      answer = Player.choice();
	            	
	               }while (answer && pAdd!=-1 );
	           }
          	// an o paikths  exei kaei apo ta hit
	           if (pAdd==-1) { 
	        	   System.out.println("You got burned, Dealer wins!");
	        	   System.exit(0);}                                        
	           
	        	   // an o paikths diale3e stay
	               //dealer's turn
	           
	        	   System.out.println("Okay, Dealer is playing.");    
	        	   Dealer.hidden();
	        	   int dAdd=Dealer.add();
	        	   
	        	   // o dealer kahke (an efere 11 dyo fores) telos paixnidiou
	        	   if (dAdd==-1) {
	    	    	   System.out.println("Dealer got burned, you win!"); 
	    	    	   System.exit(0);
	        	   }
	        	  
	        	// O dealer den kahke me ta 2 prwta fylla kai synexizei na paizei
	        	  answer= Dealer.choice();
	        	  if (answer) 
	        	  {
	        	   do {
	        		   Dealer.hit();
	        		   dAdd=Dealer.add();
	        		   
	        		   if (dAdd!=-1)
	   	            	answer = Dealer.choice();
	        		   
	        	   } while (answer && dAdd!=-1);
	        	   
	        	  }
	        	// an o dealer  exei kaei apo ta hit
	        	  if (dAdd==-1) { 
		        	   System.out.println("Dealer got burned, you win!");
		        	   System.exit(0);}       
	        	   
	        	// an kanenas den kahke kai twra tha sygkrinw pontoys
	        		   System.out.println("Dealer total is "+ Dealer.getSum());  
	        		   System.out.println("Your total is "+ Player.getSum());
	        		   
	        		   if (Player.getSum()>Dealer.getSum()) {
	        			   System.out.println("\nYOU WIN!");  
	        		   }
	        		   else
	        			   System.out.println("\nDEALER WINS!");
	        		   
	 } 
    
   }
  
 



