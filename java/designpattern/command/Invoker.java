package com.iluwatar.command2;

import java.util.Iterator;
import java.util.LinkedList;

public class Invoker {
	
	public LinkedList<Command> commands = new LinkedList<Command>();
	
	public void addCommand(Command command) {
		this.commands.add(command);
	}
	
	public void runCommand() {
		Iterator<Command> itor = commands.iterator();
		while(itor.hasNext()) {
			Command command = itor.next();
			command.execute();
		}
	}

}
