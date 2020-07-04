package de.fhdo.fak.entity;

import de.fhdo.fak.service.OfferService;

import java.util.ArrayList;

public class OfferFinder {
    public double calcPrice(Offer exampleHoliday) {
        return exampleHoliday.getTravelDuration() * exampleHoliday.getPricePerDay();
    }

    public boolean checkPriceRange(Offer exampleHoliday, int priceIdea) {
        double allPrice = calcPrice(exampleHoliday);
        return (allPrice != 0 && allPrice < priceIdea);
    }

    public boolean checkMinPrice(Offer exampleHoliday, double minPrice) {
        return exampleHoliday.getTotalPrice() >= minPrice;
    }

    public boolean checkMaxPrice(Offer exampleHoliday, double maxPrice) {
        return exampleHoliday.getTotalPrice() <= maxPrice;
    }

    public boolean checkContinent(Offer exampleHoliday, String continent) {
        return exampleHoliday.getHotel().getContinent().equals(continent);
    }

    public boolean checkCountry(Offer exampleHoliday, String country) {
        return exampleHoliday.getHotel().getCountry().equals(country);
    }

    public boolean checkCity(Offer exampleHoliday, String city) {
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

    public ArrayList<Offer> searchForHolidays(OfferService service,
            double minCost, double maxCost, String continent, String country,
            String city, String startDate, String endDate, int person) {
        ArrayList<Offer> selectedHolidays = new ArrayList<>();
        for (Offer h : service.findAll()) {
            if (!checkMinPrice(h, minCost))
                continue;
            if (!checkMaxPrice(h, maxCost))
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