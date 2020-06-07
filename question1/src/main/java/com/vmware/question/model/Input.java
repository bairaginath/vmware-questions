package com.vmware.question.model;

import java.io.Serializable;

public class Input implements Serializable {
	
	String Goal;
	String Step;
	
	public Input(String Goal,String Step) {
		this.Goal=Goal;
		this.Step=Step;
	}
	public String getGoal() {
		return Goal;
	}
	public void setGoal(String goal) {
		Goal = goal;
	}
	public String getStep() {
		return Step;
	}
	public void setStep(String step) {
		Step = step;
	}
	

}
