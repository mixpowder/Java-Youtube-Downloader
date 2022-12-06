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
	private JLabel[] thumblabels = new JLabel[30];
	private JLabel[] titlelabels = new JLabel[30];
	private String[][] urls;
	private int page = 1;

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

		for(int i = 0; i < 30; i++){
			thumblabels[i] = new JLabel();
			titlelabels[i] = new JLabel();
		}

		this.setComponents(listener);
	}

	public void setComponents(ButtonListener listener) throws MalformedURLException{
		URL url;
		int place_number = 0;
		JButton button;
		for(int i = ((page - 1) * 5); i < (5 * page); i++){
			try{
				url = new URL(this.urls[1][i]);
				thumblabels[i].setIcon(new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(160, 90, Image.SCALE_DEFAULT)));
				thumblabels[i].setBounds(17, 21 + (95 * place_number) , 160, 90);
				contentPane.add(thumblabels[i]);
			}catch(MalformedURLException ex){
				ex.getStackTrace();
			}

			if(this.urls[2][i].length() >= 20){
				titlelabels[i].setText(this.urls[2][i].substring(0, 20));
			}else{
				titlelabels[i].setText(this.urls[2][i]);
			}
			titlelabels[i].setBounds(195, 59 + (95 * place_number), 200, 19);
			contentPane.add(titlelabels[i]);

			button = new JButton("MP4_" + (i + 1));
			button.setBounds(400, (55 + (place_number * 93)), 73, 27);
			button.addActionListener(listener);
			contentPane.add(button);

			place_number++;
		}
	}

}
