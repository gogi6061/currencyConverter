public class Currency {
    private  String name;
    private  double value;


    public Currency(String name, double value) {
        this.name = name;
        this.value = value;

    }


    @Override
    public String toString() {
        return name + " : " + value;
    }
}
