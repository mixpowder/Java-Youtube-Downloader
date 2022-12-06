package mixpowder.java_youtube_downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class UrlsCreation {
	public String[][] urls;
	private String html;

	public void Load(String name){
		urls = new String[3][30];
		try {
			name = URLEncoder.encode(name, "UTF-8");
			String url = "https://www.youtube.com/results?search_query=" + name;
			this.read(url);

			this.setUrls(0, "{\"videoRenderer\":{\"videoId\":\"", "\"");
			this.setUrls(1, "\"width\":360,\"height\":202},{\"url\":\"", "\"");
			this.setUrls(2, "\"title\":{\"runs\":[{\"text\":\"", "\"}],\"accessibility\"");

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void read(String url) throws Exception {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader((new URL(url).openConnection()).getInputStream(),"UTF-8"));
			String line = null;
			while((line = br.readLine()) != null) {
				html += line;
			}
			br.close();
		}catch(IOException e){
			System.out.println(e);
		}
	}

	public void setUrls(int length, String f_len, String l_len) {
		int num1 = 0, num2 = 0;
		for(int i = 0; i < 30; i++){
			num1 = html.indexOf(f_len, num1) + f_len.length();
			num2 = html.indexOf(l_len, num1 + 1);
			this.urls[length][i] = html.substring(num1, num2);
		}
	}
}