package com.flipword;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class Game {
	private final int buttonCount = 4;
	private final int primaryButtonCount = 2;
	private final int associatedButtonCount = 2;
	private Random random;
	private Set<Integer> associatedButtonSet;
	private Set<Integer> primaryButtonSet;
	private Set<Integer> combinedButtonSet;
	private Set<Integer> associatedButtonSetWithPrimary;

	private final Map<Integer, Button> buttonList = new HashMap<>();

	public Game() {
		// for (int i = 0; i < buttonCount; i++) {
		// Button button = new Button();
		// buttonList.add(button);
		// }
		random = new Random();
		associatedButtonSet = new HashSet<>();
		primaryButtonSet = new HashSet<>();
		associatedButtonSetWithPrimary = new HashSet<>();

		while (buttonList.size() != associatedButtonCount) {
			int randomButtonId = random.nextInt(4);
			if (!associatedButtonSet.contains(randomButtonId)) {
				Button button = new AssociatedButton(randomButtonId + 1);
				buttonList.put(randomButtonId, button);
				associatedButtonSet.add(randomButtonId);
			}
		}

		while (buttonList.size() != buttonCount - 1) {
			int randomButtonId = random.nextInt(4);
			if (!associatedButtonSet.contains(randomButtonId)
				&& !primaryButtonSet.contains(randomButtonId)) {
				for (Integer associatedButtonId : associatedButtonSet) {
					if (randomButtonId < associatedButtonId
						&& !associatedButtonSetWithPrimary
							.contains(associatedButtonId)) {
						PrimaryButton button = new PrimaryButton(
							randomButtonId + 1);
						button.setAssociatedButton(
							buttonList.get(associatedButtonId));
						buttonList.put(randomButtonId, button);
						primaryButtonSet.add(randomButtonId);
						associatedButtonSetWithPrimary.add(associatedButtonId);
						break;
					}
				}
			}
		}

	}

	public void showGameWithState() {
		TreeMap<Integer, Button> sortedButtonMap = new TreeMap<>(buttonList);
		for (int i = 0; i < sortedButtonMap.size(); i++) {
			System.out.print(" ----- ");
		}
		System.out.println();

		for (Integer i : sortedButtonMap.keySet()) {
			System.out.print("|  " + buttonList.get(i).getId() + "  |");
		}
		System.out.println();
		for (Integer i : sortedButtonMap.keySet()) {
			if (buttonList.get(i).getState().equals(ButtonStates.OFF)) {
				System.out.print("| " + buttonList.get(i).getState() + " |");
			} else {
				System.out.print("| " + buttonList.get(i).getState() + "  |");
			}
		}
		System.out.println();
		for (int i = 0; i < sortedButtonMap.size(); i++) {
			System.out.print(" ----- ");
		}
		System.out.println();
	}

	public void showGame() {
		for (int i = 0; i < buttonList.size(); i++) {
			System.out.print(" --- ");
		}
		System.out.println();
		for (int i = 0; i < buttonList.size(); i++) {
			System.out.print("| " + buttonList.get(i).getId() + " |");
		}
		System.out.println();
		for (int i = 0; i < buttonList.size(); i++) {
			System.out.print(" --- ");
		}
		System.out.println();
	}

	public void buttonClick(int choice) {
		// TODO Auto-generated method stub
		this.buttonList.get(choice).click();

	}
}
