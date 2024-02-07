public class GlabalString {
    private static GlabalString instance = null;
    private StringBuilder data = new StringBuilder();

    // Create private constructor for preventing from new instance object of this class
    private GlabalString(){}

    // This method checks if an instance of the GlabalString class has already been created
    public static GlabalString getInstance(){
        // If there is no such instance yet, it creates a new instance by calling the constructor new GlabalString
        if (instance == null){
            instance = new GlabalString();
        }
        // As a result, the first call to getInstance() creates a new instance of the GlobalData class, and subsequent calls return the existing instance
        return instance;
    }

    public StringBuilder getData() {
        return data;
    }

    public void setData(StringBuilder newData) {
        //this.data.append(newData);
        this.data = newData;
    }

}
