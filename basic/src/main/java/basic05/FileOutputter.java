package basic05;

import java.io.FileWriter;

public class FileOutputter implements Outputter {
	private String filePath;
	
	public void setFilePath(String path) {
		filePath = path;
	}
	
	@Override
	public void output(String msg) throws Exception {
		FileWriter writer = new FileWriter(filePath);
		writer.write(msg);
		writer.close();
	}
}
