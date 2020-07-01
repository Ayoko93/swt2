package de.fhdo.swt.example.swtexampleapplication.entity;

import de.fhdo.swt.example.swtexampleapplication.service.HolidayService;

import java.util.ArrayList;

public class HolidayFinder {
    public double calcPrice(Holiday exampleHoliday) {
        return exampleHoliday.getTravelDuration() * exampleHoliday.getPricePerDay();
    }

    public boolean checkPriceRange(Holiday exampleHoliday, int priceIdea) {
        double allPrice = calcPrice(exampleHoliday);
        return (allPrice != 0 && allPrice < priceIdea);
    }

    public boolean checkMinPrice(Holiday exampleHoliday, double minPrice) {
        return exampleHoliday.getPricePerDay() >= minPrice;
    }

    public boolean checkMaxPrice(Holiday exampleHoliday, double maxPrice) {
        return exampleHoliday.getPricePerDay() <= maxPrice;
    }

    public boolean checkContinent(Holiday exampleHoliday, String continent) {
        return exampleHoliday.getHotel().getContinent().equals(continent);
    }

    public boolean checkCountry(Holiday exampleHoliday, String country) {
        return exampleHoliday.getHotel().getCountry().equals(country);
    }

    public boolean checkCity(Holiday exampleHoliday, String city) {
        return exampleHoliday.getHotel().getCity().equals(city);
    }

    // For one Search
    private int destinationRange = 10;

    public void setDestinationRange(int destinationRange) {
        this.destinationRange = destinationRange;
    }

    public int getDestinationRange() {
        return destinationRange;
    }

    public ArrayList<Holiday> serchForHolidays(HolidayService service, double minConst, double maxCost, String continent, String country, String city, String startDate, String endDate, int person) {
        ArrayList<Holiday> selectedHolidays = new ArrayList<>();
        for (Holiday h : service.findAll()) {
            if (!checkMinPrice(h, minConst))
                continue;
            if (maxCost != 0 && !checkMaxPrice(h, maxCost))
                continue;
            if (!continent.isEmpty() && !checkContinent(h, continent))
                continue;
            if (!country.isEmpty() && !checkCountry(h, country))
                continue;
            if (!city.isEmpty() && !checkCity(h, city))
                continue;

            //TODO: Datum wird nicht berücksichtigt
            selectedHolidays.add(h);
        }
        return selectedHolidays;
    }

}