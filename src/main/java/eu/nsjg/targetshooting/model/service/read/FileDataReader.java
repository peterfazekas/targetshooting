package eu.nsjg.targetshooting.model.service.read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader implements DataReader{

	private static final String PATH = "src\\main\\resources\\";
	
	private final String fileName;
	
	public FileDataReader(final String fileName) {
		this.fileName = PATH + fileName;
	}

	public List<String> read() {
		List<String> lines = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line;
			while((line=br.readLine())!= null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

}
