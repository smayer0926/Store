package models;

public class PetStore extends Store{
    private boolean sellsPets;
    private int id;
    private String type = "PetStore";

    public PetStore(String name, String location, String phone, boolean sellsPets) {
        super(name, location, phone);
        this.sellsPets = sellsPets;
       this.type = "PetStore";
    }
    //Getters
    public boolean getSellsPets() {
        return sellsPets;
    }
    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }

    //Setters
    public void setSellsPets(boolean sellsPets) {
        this.sellsPets = sellsPets;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PetStore petStore = (PetStore) o;

        if (sellsPets != petStore.sellsPets) return false;
        return type.equals(petStore.type);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (sellsPets ? 1 : 0);
        result = 31 * result + type.hashCode();
        return result;
    }
}
