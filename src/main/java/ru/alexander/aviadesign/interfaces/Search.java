package ru.alexander.aviadesign.interfaces;

import java.util.ArrayList;
import ru.alexander.aviadesign.objects.Flight;
import ru.alexander.aviadesign.spr.objects.City;

public interface Search {
    
    ArrayList<Flight> searchFlight(long date, City cityFrom, City cityTo);  
    
    ArrayList<City> getAllCities();

}
