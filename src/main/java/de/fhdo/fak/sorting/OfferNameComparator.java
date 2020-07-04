package de.fhdo.fak.sorting;

import de.fhdo.fak.entity.Offer;

import java.util.Comparator;

public class OfferNameComparator implements Comparator<Offer> {
    @Override
    public int compare(Offer o1, Offer o2) {
        return  o1.getHotel().getName().compareTo(o2.getHotel().getName());
    }
}


