package com.iluwatar.command2;

public class OpenCommand implements Command {

	private Recevier recevier = null;
	
	private int state = 1;
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		recevier.actionOpen();
	}

	@Override
	public void setRecevier(Recevier re) {
		// TODO Auto-generated method stub
		this.recevier = re;
	}

}
