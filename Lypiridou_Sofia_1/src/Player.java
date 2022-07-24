import java.util.Scanner;

import java.util.Random;


public class Player {
	private int sum,next_card;
    private Random rand = new Random();          
    private Scanner keyboard = new Scanner (System.in);
    
    
    
//-----arxikopoiish klashs------
    public Player () {                  
     	this.sum= 2 + rand.nextInt(10);
    	this.next_card=2+ rand.nextInt(10);}
    
   
//-----prwto apotelesma apo moirasia-------   
    public void ResultsUser() {
    	System.out.println("You get a " +sum + " and " + next_card); }
    
    
//-----neo athrisma pontwn--------  
    public int add () {
    	sum= sum+next_card;
    	System.out.println("Your total is " + sum + "\n");   
    	if (sum>21)
    		sum=-1;
 	   return sum;}
    
    
//------stelnei to sketo sum sthn main-------- 
    public int getSum() {
    	return sum;}
    
//--------epilogh xrhsth an synexisei na trava kartes---------
    public boolean choice() {
    	System.out.println( "Would you like to “hit” or “stay”?");  
    	String answer = keyboard.nextLine();
    	while (!(answer.equals("hit") || answer.equals("stay")  )) {
    		System.out.println( "Please answer STRICTLY with “hit” or “stay”?");
    		 answer = keyboard.nextLine();}
    	return (answer.equals("hit") );}
    
//-----trava thn epomeni karta-------
    public int hit() {
    	next_card = (2 + rand.nextInt(10) );
    	System.out.println( "you drew a "+ next_card);       
    	return next_card;}
  
    
}
  