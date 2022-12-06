package mixpowder.java_youtube_downloader.gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ProcessingPanel extends JFrame {

	private JLabel label = new JLabel("Downloading...");

	public ProcessingPanel() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 241, 135);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		label.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 35));
		label.setBounds(0, 0, 301, 80);
		contentPane.add(label);
	}

	public void setText(String text){
		label.setText(text);
	}
}
