package mixpowder.java_youtube_downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class UrlsCreation {
	public String[][] urls;

	public void setUrls(String name){
		urls = new String[3][5];
		try {
			name = URLEncoder.encode(name, "UTF-8");
			String url = "https://www.youtube.com/results?search_query=" + name;
			String line = this.read(url);
			int num1 = 0, num2;
			for(int i = 0; i < 5; i++){
				num1 = line.indexOf("{\"videoRenderer\":{\"videoId\":\"", num1) + 29;
				num2 = line.indexOf("\"", num1 + 1);
				urls[0][i] = "https://www.youtube.com/watch?v=" + line.substring(num1, num2);
			}

			num1 = 0;
			for(int i = 0; i < 5; i++){
				num1 = line.indexOf("\"width\":360,\"height\":202},{\"url\":\"", num1) + 34;
				num2 = line.indexOf("\"", num1 + 1);
				urls[1][i] = line.substring(num1, num2);
			}

			num1 = 0;
			for(int i = 0; i < 5; i++){
				num1 = line.indexOf("\"title\":{\"runs\":[{\"text\":\"", num1) + 26;
				num2 = line.indexOf("\"}],\"accessibility\"", num1+1);
				urls[2][i] = line.substring(num1, num2);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public String read(String url) throws Exception {
		BufferedReader br = null;
		String html = "";
		try {
			br = new BufferedReader(new InputStreamReader((new URL(url).openConnection()).getInputStream(),"UTF-8"));
			String line = null;
			while((line = br.readLine()) != null) {
				html += line;
			}
			br.close();
			return html;
		}catch(IOException e){
			System.out.println(e);
		}
		return html;
	}
}