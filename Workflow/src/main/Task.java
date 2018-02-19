package main;


import java.util.Scanner;

import state.OpenState;
import state.State;

public class Task {
	
	private boolean isAssign;
	
	private State state;

	
	public Task(){
		this.state = new OpenState(this);
		this.isAssign = true;
	}
	
	
	public void Opened(){
		System.out.println(state.Opened());
	}
	
	public void Resolved(){
		System.out.println(state.Resolved());
	}
	
	public void Reopened(){
		System.out.println(state.Reopened());
	}
	
	public void Closed(){
		System.out.println(state.Closed());
	}
	
	
	public void menuTask(){
		Scanner sc = new Scanner(System.in);
		int numberMenu;
		boolean isRun = true;
		System.out.println("Enter 0 to exit");
		System.out.println("Enter 1 to change state to Open");
		System.out.println("Enter 2 to change state to Resolve");
		System.out.println("Enter 3 to change state to Reopen");
		System.out.println("Enter 4 to change state to Close");
		while(isRun){
			numberMenu = sc.nextInt();
			if(numberMenu == 1) {
				this.Opened();
			} else if (numberMenu == 2) {
				this.Resolved();
			} else if (numberMenu == 3) {
				this.Reopened();
			} else if(numberMenu == 4) {
				this.Closed();
			} else {
				sc.close();
				isRun = false;
			}
		}
	}
	
	
	public boolean isAssign() {
		return isAssign;
	}

	public void setAssign(boolean isAssign) {
		this.isAssign = isAssign;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
}
