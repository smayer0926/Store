package dao;


import models.PetStore;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oPetStoreDao implements PetStoreDao {
    private final Sql2o sql2o;

    public Sql2oPetStoreDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(PetStore petStore) {
        String sql = "INSERT INTO stores (name, location, phone, type, sellsPets) VALUES (:name, :location, :phone, :type, :sellsPets)";
        try(Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(petStore)
                    .executeUpdate()
                    .getKey();
            petStore.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<PetStore> getAllStores() {
       String query = "SELECT * FROM stores";
        try(Connection con = sql2o.open()) {
            return con.createQuery(query)
                   .throwOnMappingFailure(false)
                    .executeAndFetch(PetStore.class);
        }
    }

//    public List<String>_testingNames() {
//        String query = "SELECT (name) FROM stores";
//        try(Connection con = sql2o.open()) {
//            return con.createQuery(query)
//                    .executeAndFetch(String.class);
//
//        }
//    }

    @Override
    public PetStore findById(int id) {
        String sql = "SELECT * FROM stores WHERE id = :id";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(PetStore.class);
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

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM stores WHERE id = :id";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public void deleteAll() {
        String sql = "DELETE from stores";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
