package de.fhdo.fak.sorting;

import de.fhdo.fak.entity.Offer;

import java.util.Comparator;

public class OfferPriceComparator implements Comparator<Offer> {
    @Override
    public int compare(Offer o1, Offer o2) {
        return Double.compare(o1.getTotalPrice(), o2.getTotalPrice());
    }
}
