package com.example.shop.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "drives")
public class Drive {
    @Id
    @Column(name = "drive_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driveId;

    @Column(name = "client_id")
    private int clientId;

    public Drive() {
    }

    public Drive(int driveId, int clientId) {
        this.driveId = driveId;
        this.clientId = clientId;
    }

    public Drive(int clientId) {
        this.clientId = clientId;
    }

    public int getDriveId() {
        return driveId;
    }

    public void setDriveId(int driveId) {
        this.driveId = driveId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Driveid = " + driveId +
                ", clientId=" + clientId + "\n";
    }
}