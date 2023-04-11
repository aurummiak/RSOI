package com.example.shop.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "offences")
public class Offence {

    @Id
    @Column(name = "offence_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int offenceId;

    @Column(name = "client")
    private int client;

    @Column(name = "fine")
    private int fine;

    @Column(name = "date")
    private LocalDate date;


    public Offence() {
    }

    public Offence(int offenceId, int client, int fine, LocalDate date) {
        this.offenceId = offenceId;
        this.client = client;
        this.fine = fine;
        this.date = date;
    }

    public Offence(int clientId, int fine) {
        this.client = clientId;
        this.fine = fine;
    }

    public Offence(int clientId, int fine, LocalDate now) {
        this.client = clientId;
        this.fine = fine;
        this.date = now;
    }

    public int getOffenceId() {
        return offenceId;
    }

    public void setOffenceId(int offenceId) {
        this.offenceId = offenceId;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "offenceId = " + offenceId +
                ", client = " + client +
                ", fine = " + fine +
                ", date = " + date + "\n";
    }
}
