package ru.alexander.aviadesign.controllers;

import ru.alexander.aviadesign.interfaces.impls.SearchImpl;
import ru.alexander.aviadesign.spr.objects.City;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ManagedBean (eager = true) //загружаем все города при запуске приложения
@ApplicationScoped //города одни и те же для всех пользователей
public class CitiesController {

    private ArrayList<City> cities;
    private SearchImpl searchImpl = new SearchImpl();

    public CitiesController() {
        cities = searchImpl.getAllCities();
        System.out.println("cities = " + cities);
    }

    public List<City> completeCities(String cityName) {

        List<City> newCities = cities.stream().filter(p -> p.getName().toLowerCase().startsWith(cityName.toLowerCase())).collect(Collectors.toList());
        return newCities;

    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public City getCity(int id) {

        Optional<City> city = cities.stream().filter(p -> p.getId() == id).findFirst();
        return city.get();

    }
}
