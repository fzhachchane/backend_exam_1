package org.example.hello_world_ejb_2.beans;

import jakarta.ejb.EJB;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import org.example.hello_world_ejb_2.model.CD;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
@Remote(EjbStateful.class)
public class EjbStatelessBean implements EjbStateless {
    @EJB(beanName = "EjbStatefulBean")
    EjbStateful ejbStateful;

    @Override
    public void pretCD(String title, String artist) {
        List<CD> cds = ejbStateful.getCDs();
        Optional<CD> cdToBorrow = cds.stream()
                .filter(cd -> cd.getTitle().equals(title) && cd.getArtist().equals(artist) && cd.isAvailable())
                .findFirst();

        cdToBorrow.ifPresent(cd -> {
            cd.setAvailable(false);
            System.out.println("CD emprunté: " + cd.getTitle() + " by " + cd.getArtist());
        });
    }

    @Override
    public void retourCD(String title, String artist) {
        List<CD> cds = ejbStateful.getCDs();
        Optional<CD> cdToReturn = cds.stream()
                .filter(cd -> cd.getTitle().equals(title) && cd.getArtist().equals(artist) && !cd.isAvailable())
                .findFirst();

        cdToReturn.ifPresent(cd -> {
            cd.setAvailable(true);
            System.out.println("CD retourné: " + cd.getTitle() + " by " + cd.getArtist());
        });
    }
}

