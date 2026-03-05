package com.cloudnqt.roomwebapp.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

    public UUID id;
    public String firstName;
    public String lastName;
    public String position;
}
