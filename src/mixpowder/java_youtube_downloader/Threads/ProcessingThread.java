package mixpowder.java_youtube_downloader.Threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import mixpowder.java_youtube_downloader.gui.ProcessingPanel;

public class ProcessingThread extends Thread{
	private String cmd;
	private ProcessingPanel panel;

	public ProcessingThread(String cmd, ProcessingPanel panel){
		this.cmd = cmd;
		this.panel = panel;
	}

	public void run() {
		try {
			Process process = Runtime.getRuntime().exec("cmd /c " + cmd);
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			    //sb.append("\n");
			}

		panel.setText("Done!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
