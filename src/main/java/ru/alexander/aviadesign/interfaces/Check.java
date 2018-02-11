package ru.alexander.aviadesign.interfaces;

import ru.alexander.aviadesign.objects.Reservation;



public interface Check {

    Reservation checkReservationByCode(String code);

//    Reservation checkReservationByDateReserv(String docNumber);
//
//    Reservation checkReservationByDateReserv(long date);
//
//    Reservation checkReservationByFamilyName(String familyName);

}
