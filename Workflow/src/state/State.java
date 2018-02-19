package state;

import main.Task;

public abstract class State {
	
	public Task task;

	public State(Task task) {
		this.task = task;
	}
	
	public abstract String Opened();
	
	public abstract String Resolved();
	
	public abstract String Reopened();
	
	public abstract String Closed();
	
}
