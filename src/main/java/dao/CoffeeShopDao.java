package dao;


import models.CoffeeShop;
import models.Store;

import java.util.List;

public interface CoffeeShopDao {
    // create
    void add(CoffeeShop coffeeShop);

    // read
    List<CoffeeShop> getAll();
    CoffeeShop findById(int id);

    // delete
    void deleteById(int id);

    // update
    void update(int id, String name, String location, String phoneNumber);

}
