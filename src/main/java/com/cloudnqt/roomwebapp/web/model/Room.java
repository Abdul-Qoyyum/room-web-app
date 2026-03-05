package com.cloudnqt.roomwebapp.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    public UUID id;
    public String name;
    public String number;
    public String bedInfo;
}

