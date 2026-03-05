package com.cloudnqt.roomwebapp.data.service;

import com.cloudnqt.roomwebapp.data.entity.Position;
import com.cloudnqt.roomwebapp.data.entity.StaffEntity;
import com.cloudnqt.roomwebapp.data.repository.StaffRepository;
import com.cloudnqt.roomwebapp.web.model.Staff;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> findAll() {
        List<StaffEntity> staffEntities = staffRepository.findAll();
        ArrayList<Staff> staff = new ArrayList<>(staffEntities.size());
        for (StaffEntity staffEntity : staffEntities) {
            staff.add(this.getStaffFromStaffEntity(staffEntity));
        }
        return staff;
    }

    public @Nullable Staff findById(UUID id) {
        StaffEntity staffEntity = this.staffRepository.findById(id).orElse(null);
        if(staffEntity == null){
            return null;
        }
        return this.getStaffFromStaffEntity(staffEntity);
    }

    public Staff createStaff(Staff staff) {
        StaffEntity staffEntity = this.staffRepository.save(this.getStaffEntityFromStaff(staff));
        return this.getStaffFromStaffEntity(staffEntity);
    }

    public @Nullable Staff updateStaff(UUID id, Staff staff) {
        staff.setId(id);
        StaffEntity staffEntity = this.staffRepository.save(this.getStaffEntityFromStaff(staff));
        return this.getStaffFromStaffEntity(staffEntity);
    }

    public void deleteStaff(UUID id) {
        this.staffRepository.deleteById(id);
    }

    private StaffEntity getStaffEntityFromStaff(Staff staff) {
        return new StaffEntity(
            staff.getId(),
            staff.getFirstName(),
            staff.getLastName(),
            Position.valueOf(staff.getPosition())
        );
    }

    private Staff getStaffFromStaffEntity(StaffEntity staffEntity) {
        return new Staff(
            staffEntity.getId(),
            staffEntity.getFirstName(),
            staffEntity.getLastName(),
            staffEntity.getPosition().toString()
        );
    }
}
