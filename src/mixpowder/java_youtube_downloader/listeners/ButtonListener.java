package mixpowder.java_youtube_downloader.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mixpowder.java_youtube_downloader.Threads.ProcessingThread;
import mixpowder.java_youtube_downloader.gui.ProcessingPanel;

public class ButtonListener implements ActionListener{

	private String[][] urls;

	public ButtonListener(String[][] urls){
		this.urls = urls;
	}

	public void actionPerformed(ActionEvent e){
		String[] data = (e.getActionCommand()).split("_");
		if(data[0].equals("mp3")){
			this.mp3(Integer.parseInt(data[1]));
		}else{
			this.mp4(Integer.parseInt(data[1]));
		}
	}

	public void mp3(int num){
		//いつか作成
	}

	public void mp4(int num){
		ProcessingPanel panel = new ProcessingPanel();
		panel.setVisible(true);
		String cmd = "tools\\yt-dlp.exe " + "https://www.youtube.com/watch?v=" + this.urls[0][num - 1] + " -o mp4\\%(title)s.mp4 -f mp4";
		(new ProcessingThread(cmd, panel)).start();
	}
}