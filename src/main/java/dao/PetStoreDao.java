package dao;


import com.sun.xml.internal.bind.v2.TODO;
import models.PetFood;


import java.util.List;

public interface PetStoreDao {
    //Create
    void add();

    //Read
    List<PetFood> getAllFood();
    PetFood findById(int id);

    //Update
    void update(String name, float price, String description);

    //TODO:
    //set a product on sale
    //void update(PetStore petStore, )

    //Delete
    void deleteById(int id);
    void deleteAll();

}
