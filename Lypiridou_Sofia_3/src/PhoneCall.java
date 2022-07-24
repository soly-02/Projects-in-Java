
public class PhoneCall extends Communication{
	
	private int duration;
	private String date;
	
	public PhoneCall(String num1, String num2, 
			int d, int m, int y, int duration) {
		
       super(num1,num2, d, m, y);
       date= y+"/"+m+"/"+d;
       this.duration = duration;

}
	
	public int getDuration() {
		return duration;
	}
	
	public void printInfo() {
		System.out.println("This phone call has the following info");
		super.printInfo();
		System.out.println("Duration: "+duration);
	
}
}
