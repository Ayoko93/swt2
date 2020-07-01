package de.fhdo.swt.example.swtexampleapplication.sorting;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;

import java.util.Comparator;

public class SortHolidaysByTravelDuration implements Comparator<Holiday>{

    @Override
    public int compare(Holiday o1, Holiday o2) {
        return Integer.compare(o1.getTravelDuration(), o2.getTravelDuration());
    }
}
