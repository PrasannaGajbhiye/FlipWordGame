package com.flipword;

public class PrimaryButton extends Button {
	public PrimaryButton(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public PrimaryButton(int id, IButtonClickListener listener) {
		super(id, listener);
	}

	private Button associatedButton;

	public Button getAssociatedButton() {
		return associatedButton;
	}

	public void setAssociatedButton(Button associatedButton) {
		this.associatedButton = associatedButton;
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		super.onClick();
		if (getAssociatedButton() != null) {
			getAssociatedButton().click();
		}

	}

}
