package de.fhdo.swt.example.swtexampleapplication.entity;

import java.util.ArrayList;
import java.util.Date;

public class Holidays extends ArrayList<Holiday> {
    private static final long serialVersionUID = -6660835738761367121L;

    public Holidays() {
        Hotel hotel = new Hotel("Afrika", "Ägypten", "Hurghada",
                "ABC-Straße 3", "Golden 5 Diamond Resort", "In zentraler "
                + "Lage in der Innenstadt von Hurghada und nur 10 "
                + "Autominuten vom internationalen Flughafen Hurghada "
                + "entfernt begrüßt Sie das 4-Sterne-Casa Del Mar Resort. "
                + "Das Resort verfügt über 204 gut gestaltete "
                + "Gästezimmer, die mit den Annehmlichkeiten und "
                + "Einrichtungen ausgestattet sind, die Sie während "
                + "Ihres Aufenthalts benötigen. Egal, ob es ein Urlaub "
                + "mit einer großen Familie ist, oder ein süßer "
                + "Zufluchtsort mit Ihren Lieben, die Merkmale der "
                + "Resortunterkunft werden Ihre Bedürfnisse erfüllen. Die "
                + "bezaubernden Zimmer verfügen über einen Balkon mit "
                + "Garten- oder Poolblick, um ruhige Morgenstunden zu "
                + "genießen und die sanfte Brise in der Nacht zu "
                + "spüren.\nGenießen Sie im Hauptrestaurant Panorama eine "
                + "Auswahl an Aromen aus der ganzen Welt, die ein "
                + "internationales Buffet zum Frühstück, Mittag- und "
                + "Abendessen servieren. Verbringen Sie entspannte Nächte "
                + "in der kleinen Lobbybar oder im Pub Le Bouchon, "
                + "während Sie exotische Cocktails genießen.\nDer "
                + "Privatstrand ist ein wahrer Genuss. Tauchen, "
                + "Schnorcheln, Wassersport und Strandaktivitäten. Es "
                + "gibt so viel zu genießen, außer sich am Strand zu "
                + "sonnen oder ein Bad im Pool zu nehmen. Die 3 "
                + "Wasserrutschen sind eine weitere Ergänzung zu den "
                + "unterhaltsamen Wasseraktivitäten. Nicht nur für Sie, "
                + "sondern auch für die Kleinen.");

        for(int i = 1; i <= 10; i++) {
            Holiday h = new Holiday();
            h.setHotel(hotel);
            h.setCurrency("Euro");
            h.setEndDate(new Date());
            h.setStartDate(new Date());
            h.setPricePerDay(2500.99);
            h.setPriceModel("All-inclusive");
            h.setTravelAgency("ITS Reisen");
            this.add(h);
        }
    }

}
