package de.fhdo.swt.example.swtexampleapplication.entity;

public class HolidayFinder {

    private int destinationId;

    public double calcPrice(Holiday exampleHoliday)
    {

        return exampleHoliday.getTravelDuration() * exampleHoliday.getPricePerDay();
    }

    public boolean checkPriceRange(Holiday exampleHoliday, int priceIdea)
    {
        double allPrice = calcPrice(exampleHoliday);
        if (allPrice != 0) {
             if (allPrice < priceIdea){
                return true;
             }
        }
        return false;
    }

    public boolean checkContinent(Holiday exampleHoliday, String continent){
        if (exampleHoliday.getHotel().getContinent() == continent)
        {
            return true;
        }
        return false;
    }

    public boolean checkCity(Holiday exampleHoliday, String city){
        if (exampleHoliday.getHotel().getContinent() == city)
        {
            return true;
        }
        return false;
    }
    // For one Search
    private int destinationRange = 10;

    public void setDestinationRange(int destinationRange) {
        this.destinationRange = destinationRange;
    }




}
