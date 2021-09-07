import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {
    Map<String, Double> map = new HashMap<>();

    public void generate() throws IOException {
        List<String> list = new ArrayList<>();
        Document doc = Jsoup.connect("https://www.cbr.ru/currency_base/daily/").get();
        Pattern numPattern = Pattern.compile("^[0-9]*[.,][0-9]+$");
        Pattern idPattern = Pattern.compile("^[A-Z]{3}$");
        Elements tables = doc.select("table");

        for (Element table : tables) {
            Elements tableRows = table.select("tr");

            for (Element tableRow : tableRows) {
                Elements tableData = tableRow.select("td");

                ArrayList<String> arrayID = (ArrayList<String>) tableData
                        .stream()
                        .map(Element::text)
                        .filter(idPattern.asPredicate())
                        .collect(Collectors.toList());
                ArrayList<String> arrayNum = (ArrayList<String>) tableData
                        .stream()
                        .map(Element::text)
                        .filter(numPattern.asPredicate())
                        .map(x -> x.replaceAll("\\,", "."))
                        .collect(Collectors.toList());


                for (int i = 0; i < arrayID.size(); i++) {

                    map.put(arrayID.get(i), Double.parseDouble(arrayNum.get(i)));

                }

                //System.out.println(map);


            }
        }


    }

    public Map<String, Double> getCurrency() {
        return map;
    }

    public String currencyToHTML() {

        StringBuilder builder = new StringBuilder();
        map.forEach((x, y) -> builder
                .append("<option value=\"")
                .append(x)
                .append("\"")
                .append(">")
                .append(x)
                .append("</option>"));


        return builder.toString();

    }


}

