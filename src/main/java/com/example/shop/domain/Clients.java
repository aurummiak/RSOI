package com.example.shop.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Clients {
    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "exp")
    private int exp;


    public Clients() {
    }

    public Clients(int id, String name, int exp) {
        this.id = id;
        this.name = name;
        this.exp = exp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", name = " + name +
                ", exp = " + exp +"\n";
    }
}
