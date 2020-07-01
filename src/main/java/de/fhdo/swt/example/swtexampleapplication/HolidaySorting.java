package de.fhdo.swt.example.swtexampleapplication;

import de.fhdo.swt.example.swtexampleapplication.entity.Holiday;

import java.util.Comparator;

public class HolidaySorting {

    public static Comparator<Holiday> getByName(String name){
        switch (name.toLowerCase()) {
            case "hotelname":
                return new SortByHotelName();
            case "totalprice":
                return new SortByTotalPrice();
            case "priceperday":
                return new SortByPriceByDay();
            case "TravelDuration":
                return new SortByTravelDuration();
            default:
                return new SortByNothing();
        }

    }

}

