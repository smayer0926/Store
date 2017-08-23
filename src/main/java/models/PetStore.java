package models;

/**
 * Created by Guest on 8/23/17.
 */
public class PetStore extends Store{
    private boolean sellsPets;

    public PetStore(String name, String location, String phone, boolean sellsPets) {
        super(name, location, phone);
        this.sellsPets = sellsPets;
    }

    public boolean sellsPets() {
        return sellsPets;
    }
}
