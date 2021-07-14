package Algorithms_ii;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Optional;

public class EnormousPrime {
    public static final String GOOGLE_FINANCE_QUOTE_BTC_CAD = "https://www.google.com/finance/quote/BTC-CAD";
    public static final String GOOGLE_FINANCE_QUOTE_BTC_USD = "https://www.google.com/finance/quote/BTC-USD";
    public static final String CAD_TEXT = "Bitcoin to Canadian dollar";
    public static final String USD_TEXT = "Bitcoin to United States Dollar";
    public static final String Google_F="https://www.google.com/finance/quote/USD-BDT";
    public static final String BDT_TEXT="USD to Bangladeshi TK: ";
    public Optional<String> getBTCValueInCAD()
    {
        return getValue(GOOGLE_FINANCE_QUOTE_BTC_CAD,CAD_TEXT);
    }
    public Optional<String> getBTCValueInUSA()
    {
        return getValue(GOOGLE_FINANCE_QUOTE_BTC_USD,USD_TEXT);
    }
    public Optional<String> usdToTAKA()
    {
        return getValue(Google_F,BDT_TEXT);
    }
    private Optional<String> getValue(String url,String texttofound)
    {
        var connect=Jsoup.connect(url);
        try{
            var document=connect.get();
            var select=document.select("h1");
            return select.stream()
                    .filter(element -> element.text().contains(texttofound))
                    .map(Element::parent)
                    .map(Element::text)
                    .findFirst();
        } catch (IOException e) {
            return Optional.empty();
            }

    }
    public static void main(String[] args) {
        System.out.println(new EnormousPrime().usdToTAKA());
      }
}
