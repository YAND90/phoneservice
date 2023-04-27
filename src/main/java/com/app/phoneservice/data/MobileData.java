package com.app.phoneservice.data;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "mobile_data")
@Data
public class MobileData {
    @Id
    @Column(name = "id", nullable = false)
    Integer id;
    @Column(name = "name", length = 1024, nullable = false, unique = true)
    String name;
    @Column(name = "is_available", nullable = false)
    Boolean isAvailable;
    @Column(name = "booked_time")
    LocalDateTime bookedTime;
    @Column(name = "owner", length = 1024)
    String owner;

    public MobileData book(String owner) {
        this.owner = owner;
        this.isAvailable = false;
        this.bookedTime = LocalDateTime.now();
        return this;
    }

    public MobileData release() {
        this.owner = null;
        this.isAvailable = true;
        this.bookedTime = null;
        return this;
    }
}
