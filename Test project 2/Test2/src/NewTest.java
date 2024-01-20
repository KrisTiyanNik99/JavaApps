import java.text.DecimalFormat;

public class NewTest {
    private String name;
    private int kolichesto;
    private double cena;

    //Novi stoinosti za test
    private int maxKolichestvo;
    private double totalCena = 0;

    public NewTest() {
        this.name = "empty";
        this.kolichesto = 0;
        this.cena = 0;
        this.maxKolichestvo = 0;
    }

    public NewTest(String name, int kolichesto, double cena, int maxKolichestvo) {
        this.name = name;
        this.kolichesto = kolichesto;
        this.cena = cena;
        this.maxKolichestvo = maxKolichestvo;
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

    public int getMaxKolichestvo() {
        if (maxKolichestvo < 0){
            return maxKolichestvo = 0;
        }else {
            return maxKolichestvo;
        }
    }

    public void setMaxKolichestvo(int maxKolichestvo) {
        if (maxKolichestvo < 0){
            this.maxKolichestvo = 0;
        }else {
            this.maxKolichestvo = maxKolichestvo;
        }
    }

    public double getTotalCena() {
        return totalCena;
    }

    public void setTotalCena(double totalCena) {
        this.totalCena = totalCena;
    }

    public Object[] toTableRow() {
        // Izkluchitelno vajen metod koito zaduljinelno ni trqbva za da mojem da vurnem Object arr(moje i da ne e object, no e silno preporuchitelno)
        // ideqta e da moje da go izpolzvame v Jtable
        String maksBroika = String.valueOf(maxKolichestvo);
        return new Object[]{
                this, name, kolichesto, cena, maxKolichestvo, "$ " + totalCena //za da suzdadem row v jtable ot rozi klass s dadenite harakteristiki nie trqbva da gi vurnem kato Object array
        };
    }
}
