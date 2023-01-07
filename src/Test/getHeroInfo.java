package Test;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class getHeroInfo {
	public static String getHeroInfoFromWiki() throws IOException {
		String url = "https://vi.wikipedia.org/wiki/Anh_h%C3%B9ng_d%C3%A2n_t%E1%BB%99c_Vi%E1%BB%87t_Nam#%C4%90%E1%BA%B7c_%C4%91i%E1%BB%83m";
		Document doc = Jsoup.connect(url).get();
		//System.out.println(doc.html());
		Element table = doc.select(".wikitable.sortable").first();
		Elements lines = table.select("tbody tr");
		
		int nLines = lines.size();
		//System.out.println(nLines);
		String[][] heroInfo = new String[nLines][5];
		boolean[][] mark = new boolean[nLines][5];
		for (int i = 1; i < nLines; i++) {
			int k = 1;
			Elements thisLine = lines.get(i).select("td");
			for (int j = 0; j < 5; j++) {
				if (mark[i][j]) {
					continue;
				}
				Element inf = thisLine.get(k);
				k++;
				String rowspan = inf.attr("rowspan");
				if (rowspan.length() == 0) {
					heroInfo[i][j] = inf.text().toUpperCase();
					continue;
				}
				int r = Integer.parseInt(rowspan);
				for (int u = 0; u < r; u++) {
					heroInfo[i + u][j] = inf.text().toUpperCase();
					mark[i + u][j] = true;
				}
			}
		}
		String res = "";
		for (int i = 1; i < nLines; i++) {
			String[] th = heroInfo[i];
			res += String.format("Anh hùng thứ %d:%nTên anh hùng: %s, quê quán: %s, thời đại lịch sử: %s, nhà nước: %s, kinh đô: %s.%n%n", i, th[0], th[1], th[2], th[3], th[4]);
		}
		return res;
	}
}
