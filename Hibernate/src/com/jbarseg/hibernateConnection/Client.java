package com.jbarseg.hibernateConnection;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para indicar que es la clave principal
    @Column(name="idClients")
    private int idclient;
    @Column(name="name")
    private String name;
    @Column(name="lastname")
    private String lastname;
    @Column(name="location")
    private String location;


    public Client(String name, String lastname, String location) {
        this.name = name;
        this.lastname = lastname;
        this.location = location;
    }
    public Client() {
    }

    public int getIdclient() {
        return idclient;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    @Override
    public String toString() {
        return "Clients [idclient=" + idclient + ", name=" + name + ", lastname=" + lastname + ", location=" + location
                + "]";
    }

}
