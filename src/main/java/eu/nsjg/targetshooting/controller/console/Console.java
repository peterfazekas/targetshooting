package eu.nsjg.targetshooting.controller.console;

import java.util.Scanner;

public class Console {

	private final Scanner scanner;

	public Console(final Scanner scanner) {
		this.scanner = scanner;
	}
	
	public int reatInt() {
		return scanner.nextInt();
	}
}
