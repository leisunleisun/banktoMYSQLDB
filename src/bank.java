



public class bank {
	private String name;
	private String email;
	private String phonenum;
	private double balance;
	private int accountnum;
		
		
	public bank() {
		
	}
	public bank(String name,String email,String phonenum,double balance) {
		super();
        this.name = name;
        this.email = email;
        this.phonenum=phonenum;
        this.balance=balance;
	}
	
public bank(String name,String email,String phonenum,double balance, int accountnum) {
	super();
    this.name = name;
    this.email = email;
    this.phonenum=phonenum;
    this.balance=balance;
    this.accountnum=accountnum;
	}
	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }

	   public String getemail() {
			return email;
			
		}
		public void setmail(String email)
		{
			this.email=email;
		}
		public String getphonenum() {
			return phonenum;
			
		}
		public void setphonenum(String phonenum)
		{
			this.phonenum=phonenum;
		}
		
		public double getbalance() 
		{
			return balance;
		}
		public void setbalance(double balance) {
			this.balance=balance;
		}
		public int getaccountnum() {
			return accountnum;
			
		}
		public void setaccountnum(int accountnum)
		{
			this.accountnum=accountnum;
		}

		

		
}
