import com.google.gson.Gson;
import dao.Sql2oCoffeeShopDao;
import dao.Sql2oPetStoreDao;
import models.CoffeeShop;
import models.PetStore;
import models.Store;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;

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

        // Create a new coffee shop
        post("/coffeeshops/new", "application/json", (request, response) -> {
            CoffeeShop coffeeShop = gson.fromJson(request.body(), CoffeeShop.class);
            coffeeShopDao.add(coffeeShop);
            response.status(201);
            return gson.toJson(coffeeShop);
        });

        // Create a new pet store
        post("/petstores/new", "application/json", (request, response) -> {
            PetStore petStore = gson.fromJson(request.body(), PetStore.class);
            petStoreDao.add(petStore);
            response.status(201);
            return gson.toJson(PetStore.class);
        });

        // Read all coffee shops
        get("/stores/coffeeshops", "application/json", (request, response) -> {
            return gson.toJson(coffeeShopDao.getAll());
        });

        // Read all pet stores
        get("/stores/petstores", "application/json", (request, response) -> {
            return gson.toJson(petStoreDao.getAllStores());
        });

        // Read a specific coffee shop
        get("/stores/coffeeshops/:coffeeshopId", "application/json", (request, response) -> {
            int coffeeshopId = Integer.parseInt(request.params("coffeeshopId"));
            CoffeeShop coffeeShop = coffeeShopDao.findById(coffeeshopId);
            return gson.toJson(coffeeShop);
        });

        // Read a specific pet store
        get("/stores/petstores/:petstoreId", "application/json", (request, response) -> {
            int petstoreId = Integer.parseInt(request.params("petstoreId"));
            CoffeeShop coffeeShop = coffeeShopDao.findById(petstoreId);
            return gson.toJson(coffeeShop);
        });

        // Update a coffee shop info
        post("/stores/coffeeshops/:coffeeshopId/update", "application/json", (request, response) -> {
            int coffeeshopId = Integer.parseInt(request.params("coffeeshopId"));
            CoffeeShop coffeeShop = gson.fromJson(request.body(), CoffeeShop.class);
            coffeeShopDao.update(coffeeshopId, coffeeShop.getName(), coffeeShop.getLocation(), coffeeShop.getPhone());
            response.status(201);
            return gson.toJson(coffeeShop);
        });

        // Update a pet store info
        post("/stores/petstores/:petstoreId/update", "application/json", (request, response) -> {
            int petstoreId = Integer.parseInt(request.params("petstoreId"));
            PetStore petStore = gson.fromJson(request.body(), PetStore.class);
            coffeeShopDao.update(petstoreId, petStore.getName(), petStore.getLocation(), petStore.getPhone());
            response.status(201);
            return gson.toJson(petStore);
        });

        // Delete a coffee shop











        //FILTERS
        after((req, res) ->{
            res.type("application/json");
        });
//        exception(ApiException.class, (exc, req, res) -> {
//            ApiException err = (ApiException) exc;
//            Map<String, Object> jsonMap = new HashMap<>();
//            jsonMap.put("status", err.getStatusCode());
//            jsonMap.put("errorMessage", err.getMessage());
//            res.type("application/json"); //after does not run in case of an exception.
//            res.status(err.getStatusCode()); //set the status
//            res.body(gson.toJson(jsonMap));  //set the output.
//        });

    }
}
