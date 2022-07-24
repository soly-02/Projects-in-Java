import java.util.ArrayList;

public class Suspect {

	// declaration of variables
	private String name; 
	private String codeName; 
	private String town;
	private ArrayList<String> numbers= new ArrayList <String>();
	private ArrayList<Suspect> partners= new ArrayList <Suspect>();
	
	
	// constructor of class "Suspect"
	public Suspect(String name, String codeName, String town) {
		this.name= name;
		this.codeName= codeName;
		this.town= town;
		}
	
	// getters and setters
	 public void addNumber(String number) {
		 numbers.add(number);
		 }
	 
	 
	  public String getName() {
		 return name;
		 }

	  public String getCodeName() {
	     return codeName;
		 }
	
	 public ArrayList<String> getNumbers() {
		return numbers;
		}
		 
	 public void addPartner(Suspect s) {
		 if (!partners.contains(s)) // checks if partner already exists
			 partners.add(s);
		 }
		 
		 public int getSizeOfPartners() {   // returns number of partners of one Suspect
			 return partners.size();
		 }
		 
		 public boolean isConnectedTo(Suspect s) {    // checks in a suspect is connected to another
			 if(partners.contains(s))
				 return true;
			 else return false;
		 }
		 
		 
		public ArrayList<Suspect> getCommonPartners(Suspect s){      
			int i;
			ArrayList<Suspect> part= new ArrayList <Suspect>();
			for (i=0;i< partners.size();i++) {
				if (partners.get(i).isConnectedTo(s)) {     // checks if the partners on the partner list of one suspects are connected to 
					part.add(partners.get(i));              // the other suspect
					}
			}return part;
		}
		

		public ArrayList<Suspect> GetPartners () {
			
			return partners;
		}
		
		
		public ArrayList<Suspect> SuggestedSuspects () {
			int i,j;
			Suspect s;
			ArrayList<Suspect> spart= new ArrayList <Suspect>();
			for (i=0;i< partners.size();i++) {                 // takes every partner from the partner list of the suspect
				s=partners.get(i);
				 for (j=0; j< s.getSizeOfPartners(); j++) {
					 if (!s.isConnectedTo((s.GetPartners()).get(j))) {      //checks if partner's partner exists in the current's suspect's list
						 spart.add((s.GetPartners()).get(j));               // if not they get added in the suspected partners list
					 }
					 
					 
				 }
			}return spart;
			
			
			
			
		}
		 
	 
	 
}
