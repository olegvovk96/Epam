package state;

import main.Task;

public class OpenState extends State{

	public OpenState(Task task) {
		super(task);
	}

	@Override
	public String Opened() {
		return "Locked. The Task is already open";
	}

	@Override
	public String Resolved() {
		task.setState(new ResolveState(task));
		return "Task has a new state - Resolved";
	}

	@Override
	public String Reopened() {
		return "Locked";
	}

	@Override
	public String Closed() {
		return "Locked";
	}

}
