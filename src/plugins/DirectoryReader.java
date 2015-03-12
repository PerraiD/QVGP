package plugins;
import java.io.*;

public class DirectoryReader {
	
	public DirectoryReader() {
	}

	public File[] listFiles(String directoryPath){
		File[] files = null;
		File directoryToScan = new File(directoryPath);
		files = directoryToScan.listFiles();
		return files;
	}
}