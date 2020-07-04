package de.fhdo.fak.sorting;

import de.fhdo.fak.entity.Offer;

import java.util.Comparator;

public class OfferTravelDurationComparator implements Comparator<Offer>{
    @Override
    public int compare(Offer o1, Offer o2) {
        return Integer.compare(o1.getTravelDuration(), o2.getTravelDuration());
    }
}
