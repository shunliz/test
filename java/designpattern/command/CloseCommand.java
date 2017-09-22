package com.iluwatar.command2;


public class CloseCommand implements Command {
	
	private Recevier receiver = null;

	private int state = 0;
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		receiver.actionClose();
	}

	@Override
	public void setRecevier(Recevier re) {
		// TODO Auto-generated method stub
		this.receiver = re;
	}

}
