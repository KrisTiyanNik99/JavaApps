import java.text.DecimalFormat;

public class NewTest {
    private String name;
    private int kolichesto;
    private double cena;

    //Novi stoinosti za test
    private int maxKolichestvo;
    private double totalCena = 0;
    private int fiksiranaStoinost;

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
        this.fiksiranaStoinost = maxKolichestvo;
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
        if (kolichesto > fiksiranaStoinost) { //s tazi proverka kazvame ako kolichestvoto ot spinera koeto poluchavame e poveche ot maksimalnata broika
            //ne mojem poveche da uvelichavame stoinostta na kolichestvoto
            this.kolichesto = fiksiranaStoinost;
        } else {
            this.kolichesto = kolichesto;
        }
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getMaxKolichestvo() {
        if (maxKolichestvo < 0) {
            return maxKolichestvo = 0;
        } else {
            return maxKolichestvo;
        }
    }

    public void setMaxKolichestvo(int maxKolichestvo) {
        if (maxKolichestvo < 0) {
            this.maxKolichestvo = 0;
        } else {
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
        return new Object[]{
                this, name, kolichesto, cena, maxKolichestvo, "$ " + totalCena //za da suzdadem row v jtable ot rozi klass s dadenite harakteristiki
                //vsichki stoinosti trqbva da gi vurnem kato Object array, zashtoto s nego e nai- bezopasno da se raboti
        };
    }
}
