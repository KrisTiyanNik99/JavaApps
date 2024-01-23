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
        this.fiksiranaStoinost = 0;
    }

    public NewTest(String name, double cena, int fiksiranaStoinost) {
        this.name = name;
        this.kolichesto = 0;
        this.cena = cena;
        this.fiksiranaStoinost = fiksiranaStoinost;
        this.maxKolichestvo = fiksiranaStoinost;
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
        if (kolichesto > fiksiranaStoinost) { //s tazi proverka kazvame ako kolichestvoto ot spinera koeto poluchavame e poveche ot maksimalnata fiksirana broika
            //nqma da mojem poveche da uvelichavame stoinostta na kolichestvoto
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
        return maxKolichestvo;
    }

    public void setMaxKolichestvo(int maxKolichestvo) {
        this.maxKolichestvo = Math.max(maxKolichestvo, 0);
        /*
        if (maxKolichestvo < 0) {
            this.maxKolichestvo = 0;
        } else {
            this.maxKolichestvo = maxKolichestvo;
        }
        */
    }

    public double getTotalCena() {
        return totalCena;
    }

    public void setTotalCena(double totalCena) {
        this.totalCena = totalCena;
    }

    public void setFiksiranaStoinost(int fiksiranaStoinost) {
        this.fiksiranaStoinost = fiksiranaStoinost;
    }

    public int getFiksiranaStoinost() {
        return fiksiranaStoinost;
    }

    public Object[] toTableRow() {
        // Izkluchitelno vajen metod koito zaduljinelno ni trqbva za da mojem da vurnem Object arr(moje i da ne e object, no e silno preporuchitelno)
        return new Object[]{
                this, name, kolichesto, cena, maxKolichestvo, fiksiranaStoinost, "$ " + totalCena //za da suzdadem row v jtable ot rozi klass s dadenite harakteristiki
                //vsichki stoinosti trqbva da gi vurnem kato Object array, zashtoto s nego e nai- bezopasno da se raboti
        };
    }
}
