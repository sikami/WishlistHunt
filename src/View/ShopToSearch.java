package View;

public class ShopToSearch {
    private String phoneNumber;
    private String urlAddress;
    private String keyWord;
    private boolean exist;

    public ShopToSearch(String phoneNumber, String urlAddress, String keyWord, boolean exist) {
        this.phoneNumber = phoneNumber;
        this.urlAddress = urlAddress;
        this.keyWord = keyWord;
        this.exist = exist;
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

    public boolean isExist() {
        return exist;
    }

    public String toString() {
        return "Url address: " + this.urlAddress + "\n" + "Keyword to search: " + this.keyWord + "\n" +
                "Phone number: " + this.phoneNumber + "\n" + this.exist + "\n";
    }
}
