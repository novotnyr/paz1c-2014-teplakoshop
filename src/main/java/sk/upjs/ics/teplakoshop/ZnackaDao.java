/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.teplakoshop;

import java.util.List;

/**
 *
 * @author student
 */
public interface ZnackaDao {

    List<Znacka> dajVsetky();

    void save(Znacka znacka);
    
}
