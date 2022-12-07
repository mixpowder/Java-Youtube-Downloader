package mixpowder.java_youtube_downloader.gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ProcessingPanel extends JFrame {

	private JTextArea textArea;

	public ProcessingPanel() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 406, 100);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.textArea = new JTextArea("started download");
		textArea.setFont(new Font("ＭＳ 明朝", Font.PLAIN, 20));
		textArea.setEditable(false);
		textArea.setBounds(0, 0, 384, 44);
		contentPane.add(textArea);
	}

	public JTextArea getTextArea(){
		return textArea;
	}
}