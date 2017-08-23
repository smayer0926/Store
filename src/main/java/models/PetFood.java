package models;

/**
 * Created by Guest on 8/23/17.
 */
public class PetFood extends Product{
    private String animalType;
    private String allergicInfo;
    private int id;

    public PetFood(String productName, float price, String description, String animalType, String allergicInfo) {
        super(productName, price, description);
        this.animalType = animalType;
        this.allergicInfo = allergicInfo;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getAllergicInfo() {
        return allergicInfo;
    }

    public int getId() {
        return id;
    }
}
