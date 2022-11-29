package mixpowder.java_youtube_downloader;

import java.io.File;
import java.net.MalformedURLException;

import mixpowder.java_youtube_downloader.gui.MainPanel;

public class Main {

	public static void main(String[] args) throws MalformedURLException {
		File file = new File("mp4");
		if(!file.exists()){
			file.mkdir();
		}
		new MainPanel().setVisible(true);
	}

}
