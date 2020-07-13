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
        return continent.isEmpty() || offer.getHotel().getContinent().equals(continent);
    }

    public boolean checkCountry(Offer offer, String country) {
        return country.isEmpty() || offer.getHotel().getCountry().equals(country);
    }

    public boolean checkCity(Offer offer, String city) {
        return city.isEmpty() || offer.getHotel().getCity().equals(city);
    }

    public boolean checkStartDate(Offer offer, String start){
        return start.isEmpty() || offer.getStartDate().toString().compareTo(start) >= 0;
    }

    public boolean checkEndDate(Offer offer, String end){
        return end.isEmpty() || offer.getEndDate().toString().compareTo(end) <= 0;
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
        for (Offer offer : service.findUnbooked())
            if (checkMinPrice(offer, minCost) && checkMaxPrice(offer, maxCost)
                    && checkContinent(offer, continent)
                    && checkCountry(offer, country) && checkCity(offer, city) && checkStartDate(offer, startDate) && checkEndDate(offer, endDate))
                selectedHolidays.add(offer);
        return selectedHolidays;
    }
}