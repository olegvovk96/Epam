package state;

import main.Task;

public class ResolveState extends State{

	public ResolveState(Task task) {
		super(task);
	}

	@Override
	public String Opened() {
		return "Locked";
	}

	@Override
	public String Resolved() {
		return "Locked. The Task is already resolve";
	}

	@Override
	public String Reopened() {
		task.setState(new ReopenState(task));
		return "Task has a new state - Reopened";
	}

	@Override
	public String Closed() {
		task.setState(new CloseState(task));
		task.setAssign(false);
		return "Task has a new state - Closed";
	}

}
