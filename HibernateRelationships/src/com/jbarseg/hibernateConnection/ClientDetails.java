package com.jbarseg.hibernateConnection;

import javax.persistence.*;

@Entity
@Table(name = "client_details")
public class ClientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para indicar que es la clave principal
    @Column(name="id")
    private int idclient;
    @Column(name="web")
    private String web;
    @Column(name="phone")
    private String phone;
    @Column(name="comments")
    private String comments;


    public ClientDetails(String web, String phone, String comments) {
        this.web = web;
        this.phone = phone;
        this.comments = comments;
    }

    public ClientDetails() {
    }

    public int getIdclient() {
        return idclient;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ClientDetails [idclient=" + idclient + ", web=" + web + ", phone=" + phone + ", comments=" + comments
                + "]";
    }

}
