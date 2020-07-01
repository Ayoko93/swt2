package de.fhdo.swt.example.swtexampleapplication.sorting;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;

import java.util.Comparator;

public class HolidaySorting {

    public static Comparator<Holiday> createComparatorByName(String name){
        switch (name.toLowerCase()) {
            case "hotelname":
                return new sortHolidaysByHotelName();
            case "totalprice":
                return new SortHolidaysByTotalPrice();
            case "priceperday":
                return new SortHolidaysByPriceByDay();
            case "travelduration":
                return new SortHolidaysByTravelDuration();
            default:
                return new SortHolidaysByNothing();
        }

    }

}

