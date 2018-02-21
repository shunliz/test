package bridge;

public class DriverManager extends Manager {
	public void getSession(){
		getDriver().getSession();
	}
}
