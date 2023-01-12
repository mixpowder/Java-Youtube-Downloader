package mixpowder.java_youtube_downloader.gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	private JPanel contentPane = new JPanel();
	private JLabel[] thumblabels = new JLabel[30];
	private JLabel[] titlelabels = new JLabel[30];
	private String[][] urls;
	private int page = 1;
	private JButton[] buttons = new JButton[30];

	public ResultPanel(UrlsCreation creation) throws MalformedURLException {
		setTitle("Downloader");
		this.urls = creation.urls;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 528, 568);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ButtonListener listener = new ButtonListener(this.urls);

		for(int i = 0; i < 30; i++){
			thumblabels[i] = new JLabel();
			contentPane.add(thumblabels[i]);
			titlelabels[i] = new JLabel();
			contentPane.add(titlelabels[i]);
			buttons[i] = new JButton();
			buttons[i].addActionListener(listener);
			contentPane.add(buttons[i]);
		}

		JLabel pagelabel = new JLabel("1");
		pagelabel.setBounds(416, 489, 73, 19);
		contentPane.add(pagelabel);

		this.setComponents();

		JButton next = new JButton("次へ");
		next.setBounds(441, 485, 65, 27);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(page == 6)return;
				page++;
				try {
					setComponents();
					pagelabel.setText(String.valueOf(page));
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(next);

		JButton back = new JButton("前へ");
		back.setBounds(338, 485, 65, 27);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(page == 1)return;
				page--;
				try {
					setComponents();
					pagelabel.setText(String.valueOf(page));
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(back);


	}

	public void setComponents() throws MalformedURLException{
		URL url;
		int place_number = 0;
		for(int i = ((page - 1) * 5); i < (5 * page); i++){
			try{
				url = new URL(this.urls[1][i]);
				thumblabels[place_number].setIcon(new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(160, 90, Image.SCALE_DEFAULT)));
				thumblabels[place_number].setBounds(17, 21 + (95 * place_number) , 160, 90);

			}catch(MalformedURLException ex){
				ex.getStackTrace();
			}

			titlelabels[place_number].setText(this.urls[2][i]);
			titlelabels[i].setBounds(195, 59 + (95 * place_number), 200, 19);
			buttons[place_number].setText("MP4_" + (i + 1));
			buttons[place_number].setBounds(400, (55 + (place_number * 93)), 80, 27);

			place_number++;
		}
	}
}