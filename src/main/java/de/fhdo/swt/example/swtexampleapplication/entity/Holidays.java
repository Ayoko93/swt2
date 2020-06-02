package de.fhdo.swt.example.swtexampleapplication.entity;

import java.util.ArrayList;
import java.util.Date;

public class Holidays extends ArrayList<Holiday> {

    public Holidays(){
        for(int i = 1; i <= 10; i++)
        {
            Holiday h = new Holiday();
            h.setCity("Akumal " + i);
            h.setCountry("Mexiko");
            h.setCurrency("Euro");
            h.setDescription("Ein Hauch von Luxus und Exklusivität direkt am Strand: der perfekte Ort für alle, die erstklassigen Service in einem Hotel am Meeresufer suchen. Der dazugehörige Golfplatz und die modernen Ferienchalets bietet Exklusivität on top.");
            h.setEndDate(new Date());
            h.setStartDate(new Date());
            h.setHotelName("Bahia Principe Luxury Akumal");
            h.setPrice(2500.99);
            h.setPriceModel("All-inclusive");
            h.setTravelAgency("ITS Reisen");

            this.add(h);
        }
    }

}
