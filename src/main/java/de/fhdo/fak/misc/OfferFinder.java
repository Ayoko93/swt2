package de.fhdo.fak.misc;

import de.fhdo.fak.entity.Offer;
import de.fhdo.fak.service.OfferService;

import java.util.ArrayList;

public class OfferFinder {
    public double calcPrice(Offer offer) {
        return offer.getTravelDuration() * offer.getPricePerDay();
    }

    public boolean checkPriceRange(Offer offer, int priceIdea) {
        double allPrice = calcPrice(offer);
        return (allPrice != 0 && allPrice < priceIdea);
    }

    public boolean checkMinPrice(Offer offer, double minPrice) {
        return offer.getTotalPrice() >= minPrice;
    }

    public boolean checkMaxPrice(Offer offer, double maxPrice) {
        return offer.getTotalPrice() <= maxPrice;
    }

    public boolean checkContinent(Offer offer, String continent) {
        return offer.getHotel().getContinent().equals(continent);
    }

    public boolean checkCountry(Offer offer, String country) {
        return offer.getHotel().getCountry().equals(country);
    }

    public boolean checkCity(Offer offer, String city) {
        return offer.getHotel().getCity().equals(city);
    }

    // For one Search
    private int destinationRange = 10;

    public void setDestinationRange(int destinationRange) {
        this.destinationRange = destinationRange;
    }

    public int getDestinationRange() {
        return destinationRange;
    }

    public ArrayList<Offer> searchForOffers(OfferService service,
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