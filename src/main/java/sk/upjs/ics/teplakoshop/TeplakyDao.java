package sk.upjs.ics.teplakoshop;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeplakyDao {
    public void save(Teplaky teplaky) {
        teplaky.setId(generujId());
        
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter("teplaky.txt", true));
            writer.print(toString(teplaky));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TeplakyDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TeplakyDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(writer != null) {
                writer.close();
            }
        }
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

    private String toString(Teplaky teplaky) {
        StringBuilder sb = new StringBuilder();
        return sb.append(teplaky.getId())
                .append(";")
                .append(teplaky.getFarba())
                .append(";")
                .append(teplaky.getVelkost())
                .append(";")
                .append(teplaky.getCena())
                .append("\n")
                .toString();
    }

    private Long generujId() {
        Long id = nacitajIdZoSuboru();
        id++;
        ulozIdDoSuboru(id);
        return id;
    }

    private Long nacitajIdZoSuboru() {
        Long id = 0L;
        try {
            Scanner scanner = new Scanner(new File("teplaky-id.txt"));
            if(scanner.hasNextLong()) {
                id = scanner.nextLong();
            }
        } catch (FileNotFoundException e) {
            // nerobime nic, ID bude rovne nule
        }
        return id;
    }

    private void ulozIdDoSuboru(Long id) {
        // ulozi novo nagenerovane ID do suboru
        FileWriter writer = null;
        try {
            writer = new FileWriter("teplaky-id.txt");
            writer.write(Long.toString(id));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (Exception e) {
                    // nic sa nedeje
                }
            }
        }
    }
}
