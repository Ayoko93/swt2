package de.fhdo.swt.example.swtexampleapplication;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;
import org.springframework.util.comparator.Comparators;

import java.util.Comparator;

public class SortByHotelName implements Comparator<Holiday> {

    @Override
    public int compare(Holiday o1, Holiday o2) {
        return  o1.getHotel().getName().compareTo(o2.getHotel().getName());
    }

}


