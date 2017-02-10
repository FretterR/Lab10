/**
 * Created by Frett on 2/9/2017.
 */
public class UsedCar extends Car {
    private double mileage;

    public UsedCar(String make, String model, int year, double price) {
        super(make, model, year, price);
    }

    public UsedCar(String make, String model, int year, double price, double mileage) {   //overloading constructor
        super(make, model, year, price);
        this.mileage = mileage;
    }

    public double getMilage() {
        return mileage;
    }

    public void setMilage(double mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + "(Used)" +"\t" + mileage;
    }
}
