package dao;

import models.CoffeeShop;
import models.Store;

import java.util.List;

/**
 * Created by Guest on 8/24/17.
 */
public interface StoreDao {
    void add();

    // read
    List<Store> getAll();
    Store findById(int id);

    // delete
    void deleteById(int id);

    // update
    void update(int id, String name, String location, String phoneNumber);
}
