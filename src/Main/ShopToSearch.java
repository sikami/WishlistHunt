package Main;

public class ShopToSearch {
    private String phoneNumber;
    private String urlAddress;
    private String keyWord;

    public ShopToSearch(String phoneNumber, String urlAddress, String keyWord) {
        this.phoneNumber = phoneNumber;
        this.urlAddress = urlAddress;
        this.keyWord = keyWord;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public String toString() {
        return "Url address: " + this.urlAddress + "\n" + "Keyword to search: " + this.keyWord + "\n" +
                "Phone number: " + this.phoneNumber + "\n";
    }
}
