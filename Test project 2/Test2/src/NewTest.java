import java.text.DecimalFormat;

public class NewTest {
    private String name;
    private int kolichesto;
    private double cena;

    public NewTest() {
        this.name = "empty";
        this.kolichesto = 0;
        this.cena = 0;
    }

    public NewTest(String name, int kolichesto, double cena) {
        this.name = name;
        this.kolichesto = kolichesto;
        this.cena = cena;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKolichesto() {
        return kolichesto;
    }

    public void setKolichesto(int kolichesto) {
        this.kolichesto = kolichesto;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Object[] toTableRow(){
        // Izkluchitelno vajen metod koito zaduljinelno ni trqbva za da mojem da vurnem Object arr(moje i da ne e object, no e silno preporuchitelno)
        // ideqta e da moje da go izpolzvame v Jtable
        return new Object[]{
                this, name, kolichesto, cena //za da suzdadem row v jtable ot rozi klass s dadenite harakteristiki nie trqbva da gi vurnem kato Object array
        };
    }
}
