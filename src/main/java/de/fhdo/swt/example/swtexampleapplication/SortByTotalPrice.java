package de.fhdo.swt.example.swtexampleapplication;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;

import java.util.Comparator;

public class SortByTotalPrice implements Comparator<Holiday> {
    @Override
    public int compare(Holiday o1, Holiday o2) {
        return Double.compare(o1.getTotalPrice(), o2.getTotalPrice());
    }
}
