package state;

import main.Task;

public class CloseState extends State{

	public CloseState(Task task) {
		super(task);
	}

	@Override
	public String Opened() {
		return "Locked";
	}

	@Override
	public String Resolved() {
		return "Locked";
	}

	@Override
	public String Reopened() {
		task.setState(new ReopenState(task));
		return "Task has a new state - Reopened";
	}

	@Override
	public String Closed() {
		return "Locked. The Task is already close";
	}

}
