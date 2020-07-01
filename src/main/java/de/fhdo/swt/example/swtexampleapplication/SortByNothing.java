package de.fhdo.swt.example.swtexampleapplication;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;

import java.util.Comparator;

public class SortByNothing implements Comparator<Holiday> {
    @Override
    public int compare(Holiday o1, Holiday o2) {
        return 0;
    }
}
