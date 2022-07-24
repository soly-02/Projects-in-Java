import java.util.ArrayList;



public class Registry {
	private ArrayList<Suspect> Sus= new ArrayList <Suspect>();  // a list of all the suspects
	private ArrayList<Communication> comm = new ArrayList <Communication>(); // a  list of all the communications
	private ArrayList<String> numsofsus= new ArrayList<String>();  // a list of all the registered numbers
	
	
	public Registry() {
		
	}
	
	public void addSuspect(Suspect s) {
		Sus.add(s);
	}
	
	
	public void addCommunication(Communication c) {
		 comm.add(c);
		 int i,j;
		 Suspect s1=null,s2=null;
		 
		
		 for (i=0;i<Sus.size();i++) {         // for every suspect checks every number they own, and if it is equal
			 numsofsus=(Sus.get(i).getNumbers());  // to the first number of the communication, it saves the suspect
			 for (j=0; j<numsofsus.size();j++) {                       
				 if (numsofsus.get(j).equals(c.getNum1())) {
					 s1= Sus.get(i); 
				 } 
			 }
		 }
		 
				 for (i=0;i<Sus.size();i++) {
					 numsofsus=(Sus.get(i).getNumbers());
					 for (j=0; j<numsofsus.size();j++) {           // same as the previous two loops but also checks if the suspect is different 
						 if (numsofsus.get(j).equals(c.getNum2())&& !(s1.equals(Sus.get(i)))) { // than the one saved before
							 s2= Sus.get(i);
							}
						} 
					 }
					s1.addPartner(s2);       //adds each suspect to the other's partner list
					s2.addPartner(s1);
	           }
	
	
	public Suspect getSuspectWithMostPartners() {
		int i,max=-1;
		Suspect s = null;
		for (i=0;i<Sus.size();i++) {
		  if (max<Sus.get(i).getSizeOfPartners()) {   // finds the max number of partners for each suspect until it finds the max and returns it
			  max=Sus.get(i).getSizeOfPartners();
			  s=Sus.get(i);
			}
		}
		return s;
	}
			
	
	public PhoneCall getLongestPhoneCallBetween(String n1, String n2) {
		int i,max=-1;
		 PhoneCall  ph=null;
		 
		for (i=0; i<comm.size(); i++) {
			if (((comm.get(i).getNum1()== n1 && comm.get(i).getNum2()== n2) || (comm.get(i).getNum1()== n2 && comm.get(i).getNum2()== n1))
					&& (comm.get(i) instanceof PhoneCall)){   // checks the whole communication list to find the two numbers and also 
				if (max<((PhoneCall)comm.get(i)).getDuration()) { // checks if the communication type is a phonecall so that it will
				 max=((PhoneCall)comm.get(i)).getDuration();  // be able to set the communication as a phonecall to get the duration of it
				 ph=(PhoneCall)comm.get(i);
				}
		      }
		  }
			
		return ph;
	}
	
	public ArrayList<SMS> getMessagesBetween(String n1, String n2){
		int i;
		

		
		ArrayList<SMS> mess= new ArrayList<SMS>();
		for (i=0; i<comm.size(); i++) {
			if (((comm.get(i).getNum1().equals(n1) && comm.get(i).getNum2().equals(n2)) || (comm.get(i).getNum1().equals(n2) && comm.get(i).getNum2().equals(n1)))
					&& (comm.get(i) instanceof SMS)){
				if ((((SMS)comm.get(i)).getText()).contains("Bomb")                      // checks the whole communication list to find the two numbers and also 
						|| (((SMS)comm.get(i)).getText()).contains("Attack")             // checks if the communication type is a SMS so that it will
						|| (((SMS)comm.get(i)).getText()).contains("Explosives")        // be able to set the communication as a SMS to get the text written in it
						|| (((SMS)comm.get(i)).getText()).contains("Gun")) 
				mess.add((SMS)(comm.get(i)));
		       
				
				
				
			}
		 }
		
		
		return mess;

	  } 
	
	
	
	public boolean includesName (String n) {
		boolean answer= false;
		for(Suspect s: Sus)
		{
			if (s.getName().equals(n))
				answer= true;
		}
		return answer;
	      }
	
	
	
	
	
	
	public Suspect GetSuspect (String n) {
		for(Suspect s: Sus)
		{
			if (s.getName().equals(n))
				return s;
		}
		return null;
	      }
		
	}
	
	
	
	
	


	 
	

