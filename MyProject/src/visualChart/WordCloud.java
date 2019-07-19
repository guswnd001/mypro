package visualChart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WordCloud {

	private static WordCloud instance = new WordCloud();
	
	private WordCloud() {};
	
	public static WordCloud getInstance() { return instance; }
	
	public Map<String, Long> map(String url, String selector, int num) {
		Document doc = null;
		String output = "";
		List<String> list = new ArrayList<String>();
		Map<String, Long> map = null;
		int count = 0;
		
		////////////////////////////////////////////////////
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Elements titles = doc.select(selector);
		////////////////////////////////////////////////////
		
		for (Element e : titles) {
			String line = e.text();
			System.out.println(line);
			
			line = line.replace(",,", ",");
			line = line.replace("\"", " ");
			line = line.replace("기사", "");
			line = line.replace("NEW", "");
			line = line.replace('1', ' ');
			line = line.replace('2', ' ');
			line = line.replace('3', ' ');
			line = line.replace('4', ' ');
			line = line.replace('5', ' ');
			line = line.replace('6', ' ');
			line = line.replace('7', ' ');
			line = line.replace('8', ' ');
			line = line.replace('9', ' ');
			line = line.replace('0', ' ');
			line = line.replace('%', ' ');
			line = line.replace('"', ' ');
			line = line.replace('\'', ' ');
			line = line.replace('[', ' ');
			line = line.replace(']', ' ');
			line = line.replace('/', ' ');
			line = line.replace('\n', ' ');
			
			String[] strs = line.split(" ");
			list.addAll(Arrays.asList(strs));
		}
		map = list.stream().filter(name -> !name.equals(""))
				  .collect(Collectors.groupingBy(
						  		String::toString, Collectors.mapping(
						  				String::toString, Collectors.counting())));
		return map;
	}
	
}
