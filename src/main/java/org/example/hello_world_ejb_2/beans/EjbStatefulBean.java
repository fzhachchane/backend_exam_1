package org.example.hello_world_ejb_2.beans;

import jakarta.ejb.Remote;
import jakarta.ejb.Stateful;
import org.example.hello_world_ejb_2.model.CD;

import java.util.ArrayList;
import java.util.List;

@Stateful
@Remote (EjbStateful.class)
public class EjbStatefulBean implements EjbStateful {
    private List<CD> cdCollection = new ArrayList<>();

    @Override
    public List<CD> getCDs() {
        return cdCollection;
    }

    @Override
    public void ajouterCD(String title, String artist) {
        CD newCD = new CD(title, artist);
        cdCollection.add(newCD);
        System.out.println("CD ajouté: " + newCD);
    }

    @Override
    public void supprimerCD(String title, String artist) {
        if (!cdCollection.isEmpty()) {
            CD removedCD = cdCollection.remove(cdCollection.size() - 1);
            System.out.println("CD supprimé: " + removedCD);
        } else {
            System.out.println("Collection de CD vide.");
        }
    }

    @Override
    public void listerCD() {
        if (!cdCollection.isEmpty()) {
            System.out.println("Collection de CD :");
            for (CD cd : cdCollection) {
                System.out.println(cd);
            }
        } else {
            System.out.println("Collection de CD vide.");
        }
    }
}