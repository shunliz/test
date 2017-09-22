package com.iluwatar.command2;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Recevier re = new Recevier();
		Invoker in = new Invoker();
		Command com = new OpenCommand();
		com.setRecevier(re);
		in.addCommand(com);
		in.runCommand();
	}

}
