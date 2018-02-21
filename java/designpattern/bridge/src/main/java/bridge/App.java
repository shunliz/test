package bridge;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager manager = new DriverManager();
		Driver driver = new MysqlDriver();
		manager.setDriver(driver);
		manager.getSession();
	}

}
