package mixpowder.java_youtube_downloader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

import mixpowder.java_youtube_downloader.gui.MainPanel;

public class Main {

	public static void main(String[] args) throws MalformedURLException {

		Main.fileCheck();

		new MainPanel().setVisible(true);
	}

	public static void fileCheck() {

		if(!(new File("history.txt")).exists()) {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("history.txt", false));
				bw.write(" , , , , ");
				bw.flush();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		File file = new File("mp4");
		if(!file.exists()){
			file.mkdir();
		}

	}

}
