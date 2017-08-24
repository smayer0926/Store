package dao;

import models.CoffeeShop;
import models.Store;

import java.util.List;

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
