package DataScraper;

import Main.ShopToSearch;
import View.ViewGui;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.List;

public class DataScraper {
    private List<ShopToSearch> shops;

    public DataScraper(List<ShopToSearch> shop) {
        this.shops = shop;
    }


    private Document visitWebsiteOne() {
        try {
            Document doc = (Document) Jsoup.connect(shops.get(0).getUrlAddress());
            return doc;
        } catch (Exception e) {
            System.out.println("Cannot retrieve website.");
        }
        return null;
    }

    public boolean scrapeKeyword(String keyword) {
        Elements elements = document.body().select("*");
        for (Element element : elements) {
            if (element.ownText().contains(keyword)) {
                System.out.println(element.ownText());
                return true;
            }
        }
        return false;
    }
}
