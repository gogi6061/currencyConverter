import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Currency {
    private String name;
    private String value;
    HashMap<String,Double> otherValues = new HashMap<>();



    public Currency() {

    }

    public Currency( String value) {

        if(value.equals("KZT")){
            otherValues.put("USD",0.0023d);
            otherValues.put("RUB",0.18d);
            otherValues.put("KZT",1d);

        }
        if(value.equals("USD")){
            otherValues.put("USD",1d);
            otherValues.put("RUB",74d);
            otherValues.put("KZT",428.37d);

        }
        if(value.equals("RUB")){
            otherValues.put("USD",0.0013d);
            otherValues.put("RUB",1d);
            otherValues.put("KZT",5.71d);

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    static HashMap<String,Currency> setCurrency(){
        HashMap<String,Currency> currencies = new HashMap<>();
        currencies.put("KZT",new Currency("KZT"));
        currencies.put("USD",new Currency("USD"));
        currencies.put("RUB",new Currency("RUB"));

        return currencies;
    }
}
