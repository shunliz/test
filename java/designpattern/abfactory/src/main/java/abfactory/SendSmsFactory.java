package abfactory;

public class SendSmsFactory implements Provider {

	public Sender produce() {
		// TODO Auto-generated method stub
		return new SmsSender();
	}

}
