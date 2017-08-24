package dao;

import models.CoffeeShop;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oCoffeeShopDaoTest {
    private Sql2o sql2o;
    private Sql2oCoffeeShopDao coffeeShopDao;
    private Connection con;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        sql2o = new Sql2o(connectionString, "", "");
        coffeeShopDao = new Sql2oCoffeeShopDao(sql2o);
        con = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    //helper
    public CoffeeShop createCoffeeShop(){
        return new CoffeeShop("Spella", "PDX", "11111111", 9, false, false, true);
    }

    @Test
    public void add() throws Exception {
        CoffeeShop coffeeShop = createCoffeeShop();
        coffeeShopDao.add(coffeeShop);
        assertEquals(1, coffeeShop.getId());
        assertEquals(9, coffeeShop.getCoffeeTypes());
    }

    @Test
    public void getAll() throws Exception {
        CoffeeShop coffeeShop = createCoffeeShop();
        CoffeeShop coffeeShopOne = createCoffeeShop();
        coffeeShopDao.add(coffeeShop);
        coffeeShopDao.add(coffeeShopOne);
        assertEquals(2, coffeeShopDao.getAll().size());
    }

    @Test
    public void findById() throws Exception {
        CoffeeShop coffeeShop = createCoffeeShop();
        coffeeShopDao.add(coffeeShop);
        CoffeeShop returnedShop = coffeeShopDao.findById(coffeeShop.getId());
        assertEquals(coffeeShop, returnedShop);
    }

    @Test
    public void deleteById() throws Exception {
        CoffeeShop coffeeShop = createCoffeeShop();
        CoffeeShop coffeeShopOne = createCoffeeShop();
        coffeeShopDao.add(coffeeShop);
        coffeeShopDao.add(coffeeShopOne);
        coffeeShopDao.deleteById(coffeeShop.getId());
        assertEquals(1, coffeeShopDao.getAll().size());
    }

    @Test
    public void update() throws Exception {
        CoffeeShop coffeeShop = createCoffeeShop();
        coffeeShopDao.add(coffeeShop);
        coffeeShopDao.update(coffeeShop.getId(), "Peets", "PDX", "3433434");
        CoffeeShop updatedShop = coffeeShopDao.findById(coffeeShop.getId());
        assertEquals("Peets", updatedShop.getName());
        assertEquals("3433434", updatedShop.getPhone());
    }
}