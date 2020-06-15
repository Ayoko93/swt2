package de.fhdo.swt.example.swtexampleapplication.entity;

public class HolidayFinder {

    private int destinationId;
    private double pricePerDay;
    private double allPrice;


    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Holiday exampleHoliday) {
        this.pricePerDay =  exampleHoliday.getPrice() / exampleHoliday.getTravelDuration();
    }

    public double calcPrice(Holiday exampleHoliday)
    {
        this.allPrice = exampleHoliday.getTravelDuration() * pricePerDay;
        return allPrice;
    }

    public boolean checkBelow(int priceIdea)
    {
        if (allPrice != 0) {
             if (allPrice < priceIdea){
                return true;
             }
        }
        return false;
    }

    // For one Search
    private int destinationRange = 10;

    public void setDestinationRange(int destinationRange) {
        this.destinationRange = destinationRange;
    }




}
