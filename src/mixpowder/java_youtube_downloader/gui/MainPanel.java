package mixpowder.java_youtube_downloader.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import mixpowder.java_youtube_downloader.UrlsCreation;

public class MainPanel extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JMenu menu;
	private JMenuBar menuBar;
	private String[] split;

	public MainPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtName = new JTextField();
		txtName.setBounds(17, 50, 136, 25);
		contentPane.add(txtName);
		txtName.setColumns(10);

		menuBar = new JMenuBar();
		menuBar.setBounds(318, 0, 45, 31);
		contentPane.add(menuBar);
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UrlsCreation creation = new UrlsCreation();
				creation.Load(txtName.getText());
				try {
					new ResultPanel(creation).setVisible(true);

				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
				setMenu(txtName.getText());
				setJmenu();
			}
		});
		btnNewButton.setBounds(180, 49, 119, 27);
		contentPane.add(btnNewButton);

		menu = new JMenu("履歴");
		setJmenu();
	}

	public void setJmenu(){

		try {
			menu.removeAll();
			File file = new File("history.txt");

			if (file.exists()) {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String data = br.readLine();
				br.close();
				split = data.split(",");
				JMenuItem item;
				for(int i = 0; i < 5; i++){
					item = new JMenuItem(split[i]);
					item.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							txtName.setText(e.getActionCommand());
						}
					});
					menu.add(item);
				}
			}else{
				file.createNewFile();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		menuBar.add(menu);
	}

	public void setMenu(String a){
		FileWriter file;
		for(int i = 4; 0 < i; i--){
			split[i] = split[i - 1];
		}
		split[0] = a;
		try {
			file = new FileWriter("history.txt", false);
			BufferedWriter bw = new BufferedWriter(file);
			bw.write(String.join(",", split));
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}