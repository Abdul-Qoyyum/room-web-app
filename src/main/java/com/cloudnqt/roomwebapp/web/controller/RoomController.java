package com.cloudnqt.roomwebapp.web.controller;

import com.cloudnqt.roomwebapp.data.entity.RoomEntity;
import com.cloudnqt.roomwebapp.data.repository.RoomRepository;
import com.cloudnqt.roomwebapp.data.service.RoomService;
import com.cloudnqt.roomwebapp.web.model.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public String room(Model model){
        ArrayList<Room> roomList = roomService.getAllRooms();
        model.addAttribute("rooms", roomList);
        return "room";
    }
}
