import java.util.Date;
import java.awt.Color;

final class Car {
    private enum Model {
        TOYOTA,
        FORD,
        AUIDI
    }


    private final Model model;
    private final int year;
    private final int capacity;
    private final Date productionDate;
    private final int km;
    private final Color color;

    public Car(Model model,int year, int capacity, Date productionDate, int km, Color color) {
        this.model = model;
        this.year = year;
        this.capacity = capacity;
        this.productionDate = productionDate;
        this.km = km;
        this.color = color;
    }

    public Model getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getCapacity() {
        return capacity;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public int getKm() {
        return km;
    }

    public Color getColor() {
        return color;
    }

}
