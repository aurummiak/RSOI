package com.example.cars.domain;

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

    @Column(name = "premium")
    private boolean premium;

    public Clients() {
    }

    public Clients(int id, String name, int exp, boolean premium) {
        this.id = id;
        this.name = name;
        this.exp = exp;
        this.premium = premium;
    }


    public boolean getPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
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
                ", exp = " + exp +
                ", premium = " + premium + "\n";
    }


}
