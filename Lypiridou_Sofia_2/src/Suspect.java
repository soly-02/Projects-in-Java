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
		 
	 
	 
}
