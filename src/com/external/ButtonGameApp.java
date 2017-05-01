package com.external;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.flipword.Game;

public class ButtonGameApp {
	public static void main(String[] args) {
		Game game = new Game();
		int choice = -1;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				game.showGameWithState();
				System.out.print("Which button to click now? ");
				choice = sc.nextInt();
				if (choice < 1 || choice > 4) {
					System.out.println(
						"Invalid choice. Possible choices [1,2,3,4]. -1 to exit.");
					continue;
				}

				game.buttonClick(choice - 1);

			} catch (InputMismatchException ime) {
				System.out.println(
					"Invalid choice. Possible choices [1,2,3,4]. -1 to exit.");

			} catch (Exception e) {
				// TODO Auto-generated catch block
 				e.printStackTrace();
			}
		} while (choice != -1);

	}
}
