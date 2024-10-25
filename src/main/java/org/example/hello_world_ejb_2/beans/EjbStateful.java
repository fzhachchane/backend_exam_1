package org.example.hello_world_ejb_2.beans;

import jakarta.ejb.Remote;
import org.example.hello_world_ejb_2.model.CD;

import java.util.List;

@Remote
public interface EjbStateful {
    public void ajouterCD(String title, String artist);
    public void supprimerCD(String title, String artist);
    public void listerCD();
    public List<CD> getCDs();
}
