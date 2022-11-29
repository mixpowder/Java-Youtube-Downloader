package mixpowder.java_youtube_downloader.Threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import mixpowder.java_youtube_downloader.gui.ProcessingPanel;

public class ProcessingThread extends Thread{
	private Process process;
	private ProcessingPanel panel;

	public ProcessingThread(Process process, ProcessingPanel panel) throws IOException{
		this.process = process;
		this.panel = panel;
	}

	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			StringBuffer sb = new StringBuffer();
			while ((line = reader.readLine()) != null) {
			    sb.append(line);
			    sb.append("\n");
			}

		String result = sb.toString();
		System.out.println(result);
		panel.setText("Done!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
