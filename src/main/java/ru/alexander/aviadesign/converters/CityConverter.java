package ru.alexander.aviadesign.converters;

import ru.alexander.aviadesign.controllers.CitiesController;
import ru.alexander.aviadesign.spr.objects.City;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@ManagedBean
@RequestScoped
public class CityConverter implements Converter {


    @ManagedProperty(value="#{citiesController}")
    private CitiesController citiesController;


    public CitiesController getCitiesController() {
        return citiesController;
    }

    public void setCitiesController(CitiesController citiesController) {
        this.citiesController = citiesController;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                City city = citiesController.getCity(Integer.parseInt(value));
                return city;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((City) object).getId());
        }
        else {
            return null;
        }
    }
}