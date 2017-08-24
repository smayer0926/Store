import com.google.gson.Gson;
import dao.Sql2oCoffeeShopDao;
import dao.Sql2oPetStoreDao;
import models.Store;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class App {
    public static void main(String[] args) {
        Sql2oPetStoreDao petStoreDao;
        Sql2oCoffeeShopDao coffeeShopDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/Store.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'"; //check me!
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        petStoreDao = new Sql2oPetStoreDao(sql2o);
        coffeeShopDao = new Sql2oCoffeeShopDao(sql2o);
        conn = sql2o.open();


    }
}
