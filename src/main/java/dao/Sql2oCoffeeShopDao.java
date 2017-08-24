package dao;


import models.CoffeeShop;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oCoffeeShopDao implements CoffeeShopDao {

    private final Sql2o sql2o;

    public Sql2oCoffeeShopDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(CoffeeShop coffeeShop) {
        String sql = "INSERT INTO stores (name, location, phone, coffeeTypes, hasWifi, hasWorkSpace, hasVegan, type) VALUES (:name, :location, :phone,  :coffeeTypes, :hasWifi, :hasWorkSpace, :hasVegan, :type)";
        try(Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .addParameter("name", coffeeShop.getName())
                    .addParameter("location", coffeeShop.getLocation())
                    .addParameter("phone", coffeeShop.getPhone())
                    .addParameter("type", coffeeShop.getType())
                    .addParameter("coffeeTypes", coffeeShop.getCoffeeTypes())
                    .addParameter("hasWifi", coffeeShop.getHasWifi())
                    .addParameter("hasWorkSpace", coffeeShop.getHasWorkSpace())
                    .addParameter("hasVegan", coffeeShop.getHasVegan())
                    .bind(CoffeeShop.class)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
            coffeeShop.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<CoffeeShop> getAll() {
        String sql = "SELECT * FROM stores";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(CoffeeShop.class);
        }
    }

    @Override
    public CoffeeShop findById(int id) {
        String sql = "SELECT * FROM stores WHERE id = :id";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(CoffeeShop.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM stores WHERE id = :id";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void update(int id, String name, String location, String phone) {
        String sql = "UPDATE stores SET (name, location, phone) = (:name, :location, :phone) WHERE id = :id";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("name", name)
                    .addParameter("location", location)
                    .addParameter("phone", phone)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
