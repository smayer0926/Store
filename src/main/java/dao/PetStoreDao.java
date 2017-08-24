package dao;


import com.sun.xml.internal.bind.v2.TODO;
import models.PetFood;
import models.PetStore;


import java.util.List;

public interface PetStoreDao {
    //Create
    void add(PetStore petStore);

    //Read
    List<PetStore> getAllStores();
    PetStore findById(int id);

    //Update
    void update(int id, String name, String location, String phone);

    //TODO:
    //set a product on sale
    //void update(PetStore petStore, )

    //Delete
    void deleteById(int id);
    void deleteAll();

}
