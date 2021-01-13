package DataScraper;

import View.ShopToSearch;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * DataScraper class. A handler to scrape website.
 * @author listya
 */
public class DataScraper {
    private ShopToSearch shop;

    public DataScraper(ShopToSearch shopToSearch) {
        this.shop = shopToSearch;
    }

    private Document visitWebsite(ShopToSearch shopToSearch) {
        try {
            Connection connection = Jsoup.connect(shopToSearch.getUrlAddress());
            connection.userAgent("Mozilla");
            connection.referrer("http://google.com");
            Document doc = connection.get();
            return doc;
        } catch (Exception e) {
            System.out.println("Cannot retrieve website.");
        }
        return null;
    }

    public boolean scrapeKeyword() {

        Document document = visitWebsite(this.shop);
        try {
            Elements elements  = document.getAllElements();
            //Elements elements = document.body().select("*");
            for (Element element : elements) {
                if (element.ownText().toLowerCase().contains(this.shop.getKeyWord().toLowerCase())) {
                    System.out.println(element.ownText());
                    return true;
                }
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }

        return false;
    }
}
