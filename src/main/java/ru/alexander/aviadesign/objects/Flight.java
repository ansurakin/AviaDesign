package ru.alexander.aviadesign.objects;

import ru.alexander.aviadesign.spr.objects.Aircraft;
import ru.alexander.aviadesign.spr.objects.City;

import java.util.Calendar;

public class Flight {

    private String duration;// длительность полета в виде текста, этого поля нет в таблице
    private Boolean existFreePlaces;
    private Long id;
    private String code;
    private Calendar dateDepart;
    private Calendar dateCome;
    private Aircraft aircraft;
    private City cityFrom;
    private City cityTo;
    private int price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Calendar getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Calendar dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Calendar getDateCome() {
        return dateCome;
    }

    public void setDateCome(Calendar dateCome) {
        this.dateCome = dateCome;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isExistFreePlaces() {
        return existFreePlaces;
    }

    public void setExistFreePlaces(boolean existFreePlaces) {
        this.existFreePlaces = existFreePlaces;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
