package Day16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Abc {

	public void fileReader() throws FileNotFoundException {
		File f = new File(System.getProperty("user.dir"));
		FileInputStream fis = new FileInputStream(f);
	}
}
