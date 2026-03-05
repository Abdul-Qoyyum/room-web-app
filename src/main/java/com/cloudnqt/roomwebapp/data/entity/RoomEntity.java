package com.cloudnqt.roomwebapp.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "ROOMS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomEntity {
    @Id
    @Column(name = "ROOM_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NUMBER", unique = true, nullable = false)
    private String number;

    @Column(name = "BED_INFO", nullable = false)
    private String bedInfo;
}
