package com.cloudnqt.roomwebapp.web.api;

import com.cloudnqt.roomwebapp.data.service.RoomService;
import com.cloudnqt.roomwebapp.web.model.Room;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/rooms")
public class RoomApiController {

    private final RoomService roomService;

    public RoomApiController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable(name = "id") UUID id) {
        return this.roomService.findById(id);
    }

    @GetMapping
    public List<Room> getRooms() {
        return this.roomService.getAllRooms();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room createRoom(@RequestBody Room room) {
        return this.roomService.createRoom(room);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable(name = "id") UUID id, @RequestBody Room room) {
        return this.roomService.updateRoom(id, room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable(name = "id") UUID id) {
        this.roomService.deleteRoom(id);
    }
}
