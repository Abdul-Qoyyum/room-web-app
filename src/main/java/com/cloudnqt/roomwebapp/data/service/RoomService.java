package com.cloudnqt.roomwebapp.data.service;

import com.cloudnqt.roomwebapp.data.entity.RoomEntity;
import com.cloudnqt.roomwebapp.data.repository.RoomRepository;
import com.cloudnqt.roomwebapp.web.model.Room;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomService {

    RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public ArrayList<Room> getAllRooms() {
        List<RoomEntity> roomList = roomRepository.findAll();
        ArrayList<Room> rooms = new ArrayList<>();
        roomList.forEach(e -> rooms.add(getRoomFromRoomEntity(e)));
        return rooms;
    }

    public Room findById(UUID id) {
        Optional<RoomEntity> roomEntity = roomRepository.findById(id);
        return roomEntity.map(this::getRoomFromRoomEntity).orElse(null);
    }

    public Room createRoom(Room room) {
        RoomEntity roomEntity = getRoomEntityFromRoom(room);
        roomEntity = roomRepository.save(roomEntity);
        return getRoomFromRoomEntity(roomEntity);
    }

    public Room updateRoom(UUID id, Room room) {
        room.setId(id);
        RoomEntity roomEntity = roomRepository.save(getRoomEntityFromRoom(room));
        return getRoomFromRoomEntity(roomEntity);
    }

    public void deleteRoom(UUID id) {
        roomRepository.deleteById(id);
    }

    private Room getRoomFromRoomEntity(RoomEntity roomEntity) {
        return new Room(
                roomEntity.getId(),
                roomEntity.getName(),
                roomEntity.getNumber(),
                roomEntity.getBedInfo()
        );
    }

    private RoomEntity getRoomEntityFromRoom(Room room) {
        return new RoomEntity(
                room.getId(),
                room.getName(),
                room.getNumber(),
                room.getBedInfo()
        );
    }

}
