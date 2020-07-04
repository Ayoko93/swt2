package de.fhdo.fak.sorting;

import de.fhdo.fak.entity.Offer;

import java.util.Comparator;

public class OfferComparatorFactory {
    public static Comparator<Offer> create(String name){
        switch (name.toLowerCase()) {
            case "hotelname":
                return new OfferNameComparator();
            case "totalprice":
                return new OfferPriceComparator();
            case "priceperday":
                return new OfferPricePerDayComparator();
            case "travelduration":
                return new OfferTravelDurationComparator();
            default:
                return new OfferNothingComparator();
        }
    }
}

