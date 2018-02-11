package ru.alexander.aviadesign.interfaces;

import ru.alexander.aviadesign.objects.Flight;
import ru.alexander.aviadesign.objects.Passenger;
import ru.alexander.aviadesign.spr.objects.Place;


public interface Buy {
    
    boolean buyTicket(Flight flight, Place place, Passenger passenger, String addInfo);

}
