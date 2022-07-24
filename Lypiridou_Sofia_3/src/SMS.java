
public class SMS extends Communication {

	private String text;
	private String date;
	
	public SMS(String num1, String num2, 
			int d, int m, int y, String text) {
		
       super(num1,num2, d, m, y);
       date= y+"/"+m+"/"+d;
       this.text = text;

}	
	public void printInfo() {
		System.out.println("This SMS has the following info");
		super.printInfo();
		System.out.println("Text: "+text);
		
	}
	public String getText() {
		return text;
	}
	
}
