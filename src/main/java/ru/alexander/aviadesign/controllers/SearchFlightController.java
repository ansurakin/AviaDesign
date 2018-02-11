package ru.alexander.aviadesign.controllers;

import ru.alexander.aviadesign.interfaces.impls.SearchImpl;
import ru.alexander.aviadesign.objects.Flight;
import ru.alexander.aviadesign.spr.objects.City;
import ru.alexander.aviadesign.utils.GMTCalendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.*;

@ManagedBean
@SessionScoped
public class SearchFlightController {

    private Date dateDepart =  new Date(); // текущая дата
    private Date dateReturn = new Date(dateDepart.getTime()+604800000);// + 7 дней

    private City cityFrom;
    private City cityTo;

    private int passengersCount = 1;

    private SearchImpl searchImpl = new SearchImpl();

    private TimeZone timeZone = GMTCalendar.getInstance().getTimeZone();

    private ArrayList<Flight> flights;

    public Date getDateDepart() {
        return dateDepart;
    }
    
    
    public String search() {
        flights = searchImpl.searchFlight(dateDepart.getTime(), cityFrom, cityTo);
        return "result";
    }


    public void updatePassengersCount(){
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String,String> params = context.getExternalContext().getRequestParameterMap();
        int count = Integer.valueOf(params.get("count"));
        passengersCount = count;
    }




    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public City getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(City cityFrom) {
        this.cityFrom = cityFrom;
    }

    public City getCityTo() {
        return cityTo;
    }

    public void setCityTo(City cityTo) {
        this.cityTo = cityTo;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public void setPassengersCount(int passengersCount) {
        this.passengersCount = passengersCount;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
}
