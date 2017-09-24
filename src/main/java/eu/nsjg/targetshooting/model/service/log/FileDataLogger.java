package eu.nsjg.targetshooting.model.service.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileDataLogger implements DataLogger{

	private static final String PATH = "src\\main\\resources\\";
	
	private final String fileName;
	
	public FileDataLogger(final String fileName) {
		this.fileName = PATH + fileName;
	}

	public void printAll(String text) {
		try (PrintWriter file = new PrintWriter(new FileWriter(fileName))){
			file.print(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
