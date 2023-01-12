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
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				if(line.contains("[download]") && line.contains("ETA")){
					panel.getTextArea().setText("Completed:" + line.substring(11,line.indexOf("of")) + "Time: " + line.substring(line.indexOf("ETA") + 4, line.length()));
				}else{
					panel.getTextArea().setText("Preparing...");
				}
			}
			panel.getTextArea().setText("Download is done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}