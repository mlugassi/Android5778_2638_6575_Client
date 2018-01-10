package lugassi.wallach.android5778_2638_6575_client.model.backend;

import android.content.ContentValues;

import java.util.ArrayList;

import lugassi.wallach.android5778_2638_6575_client.model.entities.*;


/**
 * Created by Michael on 21/11/2017.
 */

public interface DB_manager {

    public String checkUser(String userName, String password);

    public Boolean createUser(String userName, String password, int userID);

    public int addCustomer(ContentValues contentValues);

    public int addReservation(ContentValues contentValues);

    public int addPromotion(ContentValues contentValues);


    public boolean updateCar(int carID, ContentValues contentValues);

    public boolean updateCustomer(int customerID, ContentValues contentValues);

    public boolean updateReservation(int reservationID, ContentValues contentValues);

    public boolean updatePromotion(int customerID, ContentValues contentValues);


    public boolean removeCustomer(int customerID);

    public boolean removePromotion(int customerID);


    public ArrayList<Branch> getBranches();

    public ArrayList<Branch> getBranches(int carModel);

    public ArrayList<Car> getFreeCars();

    public ArrayList<Car> getFreeCars(int branchID);

    public ArrayList<CarModel> getCarModels();

    public ArrayList<Customer> getCustomers();

    public ArrayList<Promotion> getPromotions();

    public ArrayList<Reservation> getReservations();

    public ArrayList<Reservation> getReservationsOnGoing();


    public boolean closeReservation(int mileage);


    public boolean checkReservations();
}
