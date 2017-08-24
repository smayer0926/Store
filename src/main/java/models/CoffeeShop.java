package models;

/**
 * Created by Guest on 8/23/17.
 */
public class CoffeeShop extends Store {
    private int id;
    private int coffeeTypes;
    private boolean hasWifi;
    private boolean hasWorkSpace;
    private boolean hasVegan;
    private String type;

    public CoffeeShop(String name, String location, String phone, int coffeeTypes, boolean hasWifi, boolean hasWorkSpace, boolean hasVegan) {
        super(name, location, phone);
        this.coffeeTypes = coffeeTypes;
        this.hasWifi = hasWifi;
        this.hasWorkSpace = hasWorkSpace;
        this.hasVegan = hasVegan;
        this.type = "CoffeeShop";
    }

    public int getCoffeeTypes() {
        return coffeeTypes;
    }

    public boolean getHasWifi() {
        return hasWifi;
    }

    public boolean getHasWorkSpace() {
        return hasWorkSpace;
    }

    public boolean getHasVegan() {
        return hasVegan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCoffeeTypes(int coffeeTypes) {
        this.coffeeTypes = coffeeTypes;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public void setHasWorkSpace(boolean hasWorkSpace) {
        this.hasWorkSpace = hasWorkSpace;
    }

    public void setHasVegan(boolean hasVegan) {
        this.hasVegan = hasVegan;
    }
}
