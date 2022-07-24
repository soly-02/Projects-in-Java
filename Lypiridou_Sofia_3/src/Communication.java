

public abstract class Communication {

	private String num1;
	private String num2;
	private String date;
	 
	 public Communication(String num1, String num2, int d, int m, int y) {
		 
		 date= y+"/"+m+"/"+d;
		  this.num1=num1;
		  this.num2=num2;
		  
	 }
		  
		  public void printInfo() {
				System.out.println ("Between "+num1+" --- "+num2+" on " +date);
			
		 
	 }
		  
		  public String getNum1() {
			  return num1;
			  
		  }

		  public String getNum2() {
			  return num2;
			  
		  }
		 
		  
}
