package bridge;

public abstract class Manager {
	private Driver driver;
	
	public void getSession(){
		driver.getSession();
	}
	
	public Driver getDriver(){
		return driver;
	}
	
	public void setDriver(Driver driver){
		this.driver = driver;
	}
}
