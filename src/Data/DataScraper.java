package Data;

import Main.ShopToSearch;
import View.ViewGui;

import java.util.List;

public class DataScraper {
    List<ShopToSearch> shops;
    ViewGui viewGui;

    public DataScraper() {
        this.viewGui = new ViewGui();
        this.shops = viewGui.getShops();
    }




}
