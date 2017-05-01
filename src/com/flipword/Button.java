package com.flipword;

import java.util.concurrent.atomic.AtomicInteger;

public class Button implements IButtonClickListener {
	private ButtonStates state;
	private IButtonClickListener listener;

	// private static final AtomicInteger count = new AtomicInteger(0);
	private final int id;

	public int getId() {
		return id;
	}

	public ButtonStates getState() {
		return state;
	}

	public void setState(ButtonStates state) {
		this.state = state;
	}

	public Button(int id, IButtonClickListener listener) {
		this.id = id;
		this.state = ButtonStates.ON;
		this.listener = listener;
	}

	public Button(int id) {
		this.state = ButtonStates.ON;
		this.id = id;
	}

	public void click() {
		System.out.println("In button-" + this.getId() + " click");
		if (this.listener != null) {
			this.listener.onClick();
		}
		onClick();
	}

	@Override
	public void onClick() {
		System.out.println("In button-" + this.getId() + " onClick");
		if (getState().equals(ButtonStates.OFF)) {
			setState(ButtonStates.ON);
		} else {
			setState(ButtonStates.OFF);
		}
	}

}