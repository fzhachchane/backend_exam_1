package org.example.hello_world_ejb_2.beans;

import jakarta.ejb.Remote;

@Remote
public interface EjbStateless {
    public void pretCD(String title, String artist);
    public void retourCD(String title, String artist);
}
