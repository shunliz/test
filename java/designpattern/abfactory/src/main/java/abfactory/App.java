package abfactory;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Provider provier = new SendMailFactory();
		Sender sender = provier.produce();
		sender.Send();
	}

}
