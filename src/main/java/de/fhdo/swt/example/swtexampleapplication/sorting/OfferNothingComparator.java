package de.fhdo.swt.example.swtexampleapplication.sorting;

import de.fhdo.swt.example.swtexampleapplication.entity.Offer;

import java.util.Comparator;

public class OfferNothingComparator implements Comparator<Offer> {
    @Override
    public int compare(Offer o1, Offer o2) {
        return 0;
    }
}
