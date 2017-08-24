package models;

public class PetStore extends Store{
    private boolean sellsPets;
    private int id;
    private String type;

    public PetStore(String name, String location, String phone, boolean sellsPets) {
        super(name, location, phone);
        this.sellsPets = sellsPets;
        this.type = "PetStore";
    }

    public boolean sellsPets() {
        return sellsPets;
    }
//Getters
    public boolean isSellsPets() {
        return sellsPets;
    }

    public int getId() {
        return id;
    }

    //Setters
    public void setSellsPets(boolean sellsPets) {
        this.sellsPets = sellsPets;
    }

    public void setId(int id) {
        this.id = id;
    }
}
