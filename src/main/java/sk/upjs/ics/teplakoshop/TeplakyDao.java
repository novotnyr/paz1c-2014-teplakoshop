package sk.upjs.ics.teplakoshop;


import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TeplakyDao {
    public void save(Teplaky teplaky) {
        //...
    }
    
    public List<Teplaky> dajVsetky() {
        try {
            List<Teplaky> zoznamTeplakov = new ArrayList<Teplaky>();
            Scanner scanner = new Scanner(new File("teplaky.txt"), "utf-8");
            while(scanner.hasNextLine()) {
                String riadok = scanner.nextLine();
                
                String[] polozky = riadok.split(";");
                
                Teplaky teplaky = new Teplaky();
                teplaky.setId(Long.parseLong(polozky[0]));
                teplaky.setFarba(polozky[1]);
                teplaky.setVelkost(polozky[2]);
                teplaky.setCena(new BigDecimal(polozky[3]));
                
                zoznamTeplakov.add(teplaky);
            }
            // TODO zatvorit skener!!!!
            return zoznamTeplakov;
        } catch (FileNotFoundException e) {
            System.err.println("Subor sa nenasiel");
            return Collections.emptyList();
        }
    }
    
    public List<Teplaky> hladatPodlaFarby(String filter) {
        List<Teplaky> najdeneTeplaky = new LinkedList<Teplaky>();
        for(Teplaky teplaky : dajVsetky()) {
            if(teplaky.getFarba().contains(filter)) {
                najdeneTeplaky.add(teplaky);
            }
        }        
        return najdeneTeplaky;
    }
}
