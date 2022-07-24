import java.util.Random;

// oi methodoi toy dealer einai analoges me aytes toy paikth
public class Dealer {

	private int sum,next_card;
    private Random rand = new Random(); 

    
//-----------------------------------------------------------------  
    public Dealer () {
	     	this.sum= 2 + rand.nextInt(10);
	    	this.next_card=2+ rand.nextInt(10);}
    	
//-----------------------------------------------------------------     
    public void ResultsDealer() { 
    	    System.out.println("The Dealer has a " +sum + " showing, and a hidden card \n");}

//-----------------------------------------------------------------     	 
    public boolean choice() {
    	    if (sum<=16)
    			 System.out.println("Dealer chooses to hit");
    		else
    			 System.out.println("Dealer chooses to stay \n");
    	    	return (sum<=16);}
    
//----------Apokaliptei thn kryfh karta toy dealer-----------------	 
    public void hidden() {
    		System.out.println("Their hidden card was "+ next_card);}
 
//-----------------------------------------------------------------  	 
    public int hit() {
    	    next_card = (2 + rand.nextInt(10) );
    	    System.out.println( "They draw a "+ next_card);
    	   	return next_card;}
    
//-----------------------------------------------------------------
    	 
    public int add () {
    	    sum= sum+next_card;
    	    System.out.println("Their total is " + sum + "\n");
    	    if (sum>21)
    	    	sum=-1;
    	    return sum;}
    	  
//-----------------------------------------------------------------
    	  public int getSum() {
    	    	return sum;}

    	 
    	 
}
