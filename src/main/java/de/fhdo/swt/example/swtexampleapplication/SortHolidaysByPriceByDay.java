package de.fhdo.swt.example.swtexampleapplication;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;

import java.util.Comparator;

public class SortHolidaysByPriceByDay implements Comparator<Holiday> {
    @Override
    public int compare(Holiday o1, Holiday o2) {
        return Double.compare(o1.getPricePerDay(), o2.getPricePerDay());
    }
}
