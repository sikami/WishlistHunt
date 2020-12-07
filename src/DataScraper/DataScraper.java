package DataScraper;

import Main.ShopToSearch;
import View.ViewGui;
import org.jsoup.Connection;
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
            Connection connection = Jsoup.connect(shops.get(0).getUrlAddress());
            connection.userAgent("Mozilla");
            connection.referrer("http://google.com");
            Document doc = connection.get();
            return doc;
        } catch (Exception e) {
            System.out.println("Cannot retrieve website.");
        }
        return null;
    }

    public boolean scrapeKeyword(String keyword) {
        Document document = visitWebsiteOne();
        Elements elements = document.body().select("*");
        for (Element element : elements) {
            if (element.ownText().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(element.ownText());
                return true;
            }
        }
        return false;
    }
}
