package ru.alexander.aviadesign.interfaces.impls;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.alexander.aviadesign.database.PassengerDB;
import ru.alexander.aviadesign.database.ReservationDB;
import ru.alexander.aviadesign.interfaces.Buy;
import ru.alexander.aviadesign.objects.Flight;
import ru.alexander.aviadesign.objects.Passenger;
import ru.alexander.aviadesign.objects.Reservation;
import ru.alexander.aviadesign.spr.objects.Place;
import ru.alexander.aviadesign.utils.GMTCalendar;


public class BuyImpl implements Buy {
    
    private ReservationDB reservDB = ReservationDB.getInstance();
    private PassengerDB passengerDB = PassengerDB.getInstance();

    @Override
    public boolean buyTicket(Flight flight, Place place, Passenger passenger, String addInfo) {

        try {

            Reservation reserv = new Reservation();
            reserv.setAddInfo(addInfo);
            reserv.setCode(UUID.randomUUID().toString());
            reserv.setPassenger(passenger);

            Calendar c = GMTCalendar.getInstance();
            reserv.setReserveDateTime(c);

            reserv.setPlace(place);
            reserv.setFlight(flight);

            // желательно реализовать обе операции в одной транзакции
            int id = passengerDB.insert(passengerDB.getInsertStmt(passenger));
            passenger.setId(id);
            
            reservDB.insert(reservDB.getInsertStmt(reserv));

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BuyImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
