package dao;

import models.PetStore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;


public class Sql2oPetStoreDaoTest {
    private Sql2o sql2o;
    private Sql2oPetStoreDao petStoreDao;
    private Connection con;
    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        sql2o = new Sql2o(connectionString, "", "");
        petStoreDao = new Sql2oPetStoreDao(sql2o);
        con = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    public PetStore createPetStore(){
        return new PetStore("Cats & Dogs", "PDX", "11111111", true);
    }
    @Test
    public void add() throws Exception {
        PetStore petStore = createPetStore();
        petStoreDao.add(petStore);
        assertEquals(1, petStore.getId());
        assertEquals("Cats & Dogs", petStore.getName());
    }

    @Test
    public void getAllStores() throws Exception {
        PetStore petStore = createPetStore();
        PetStore petStore1 = createPetStore();
        petStoreDao.add(petStore);
        petStoreDao.add(petStore1);
        assertEquals(2, petStoreDao.getAllStores().size());
    }


    @Test
    public void findById() throws Exception {
        PetStore petStore = createPetStore();
        petStoreDao.add(petStore);
        PetStore returnedStore = petStoreDao.findById(petStore.getId());
        assertEquals(petStore, returnedStore);
    }


    @Test
    public void update() throws Exception {
        PetStore petStore = createPetStore();
        petStoreDao.add(petStore);
        petStoreDao.update(petStore.getId(), "Kate's Pets", "PDX", "3433434");
        PetStore updatedShop = petStoreDao.findById(petStore.getId());
        assertEquals("Kate's Pets", updatedShop.getName());
        assertEquals("3433434", updatedShop.getPhone());
    }

    @Test
    public void deleteById() throws Exception {
        PetStore petStore = createPetStore();
        PetStore petStore1 = createPetStore();
        petStoreDao.add(petStore);
        petStoreDao.add(petStore1);
        petStoreDao.deleteById(petStore.getId());
        assertEquals(1, petStoreDao.getAllStores().size());
    }

    @Test
    public void deleteAll() throws Exception {
        PetStore petStore = createPetStore();
        PetStore petStore1 =  createPetStore();
        petStoreDao.add(petStore);
        petStoreDao.add(petStore1);
        petStoreDao.deleteAll();
        assertEquals(0, petStoreDao.getAllStores().size());
    }

}