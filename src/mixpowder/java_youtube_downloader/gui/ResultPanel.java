package mixpowder.java_youtube_downloader.gui;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mixpowder.java_youtube_downloader.UrlsCreation;
import mixpowder.java_youtube_downloader.listeners.ButtonListener;

public class ResultPanel extends JFrame {

	private JPanel contentPane;
	JLabel[] thumblabels = new JLabel[5];
	JLabel[] titlelabels = new JLabel[5];
	String[][] urls;

	public ResultPanel(UrlsCreation creation) throws MalformedURLException {
		setTitle("Downloader");
		this.urls = creation.urls;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 528, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ButtonListener listener = new ButtonListener(this.urls);

		for(int i = 0; i < 5; i++){
			thumblabels[i] = new JLabel();
			titlelabels[i] = new JLabel();
		}

		JButton mp4_1 = new JButton("MP4_1");
		mp4_1.setBounds(400, 55, 73, 27);
		mp4_1.addActionListener(listener);
		contentPane.add(mp4_1);

		JButton mp4_2 = new JButton("MP4_2");
		mp4_2.setBounds(400, 148, 73, 27);
		mp4_2.addActionListener(listener);
		contentPane.add(mp4_2);

		JButton mp4_3 = new JButton("MP4_3");
		mp4_3.setBounds(400, 241, 73, 27);
		mp4_3.addActionListener(listener);
		contentPane.add(mp4_3);

		JButton mp4_4 = new JButton("MP4_4");
		mp4_4.setBounds(400, 334, 73, 27);
		mp4_4.addActionListener(listener);
		contentPane.add(mp4_4);

		JButton mp4_5 = new JButton("MP4_5");
		mp4_5.setBounds(400, 427, 73, 27);
		mp4_5.addActionListener(listener);
		contentPane.add(mp4_5);

		/*JButton mp3_1 = new JButton("MP3_1");
		mp3_1.setBounds(500, 55, 73, 27);
		mp3_1.addActionListener(listener);
		contentPane.add(mp3_1);

		JButton mp3_2 = new JButton("MP3_2");
		mp3_2.setBounds(500, 148, 73, 27);
		mp3_2.addActionListener(listener);
		contentPane.add(mp3_2);

		JButton mp3_3 = new JButton("MP3_3");
		mp3_3.setBounds(500, 241, 73, 27);
		mp3_3.addActionListener(listener);
		contentPane.add(mp3_3);

		JButton mp3_4 = new JButton("MP3_4");
		mp3_4.setBounds(500, 334, 73, 27);
		mp3_4.addActionListener(listener);
		contentPane.add(mp3_4);

		JButton mp3_5 = new JButton("MP3_5");
		mp3_5.setBounds(500, 427, 73, 27);
		mp3_5.addActionListener(listener);
		contentPane.add(mp3_5);
		*/
		setLabels(contentPane);
	}

	public void setLabels(JPanel panel) throws MalformedURLException{
		for(int i = 0; i < 5; i++){
			URL url;
			try{
				url = new URL(this.urls[1][i]);
				thumblabels[i].setIcon(new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(160, 90, Image.SCALE_DEFAULT)));
				thumblabels[i].setBounds(17,21 + (95 * i) , 160, 90);
				panel.add(thumblabels[i]);
			}catch(MalformedURLException ex){
				ex.getStackTrace();
			}

			if(this.urls[2][i].length() >= 20){
				titlelabels[i].setText(this.urls[2][i].substring(0,20));
			}else{
				titlelabels[i].setText(this.urls[2][i]);
			}
			titlelabels[i].setBounds(195, 59 + (95 * i), 200, 19);
			contentPane.add(titlelabels[i]);

		}
	}
}
