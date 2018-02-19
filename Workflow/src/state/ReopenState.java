package state;

import main.Task;

public class ReopenState extends State{

	public ReopenState(Task task) {
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
		return "Locked. The Task is already reopen";
	}

	@Override
	public String Closed() {
		task.setState(new CloseState(task));
		task.setAssign(true);
		return "Task has a new state - Closed";
	}

}
