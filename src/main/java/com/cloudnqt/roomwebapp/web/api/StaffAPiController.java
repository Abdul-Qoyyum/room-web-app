package com.cloudnqt.roomwebapp.web.api;

import com.cloudnqt.roomwebapp.data.service.StaffService;
import com.cloudnqt.roomwebapp.web.model.Staff;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/staffs")
public class StaffAPiController {

    private final StaffService staffService;

    public StaffAPiController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getStaffs() {
        return this.staffService.findAll();
    }

    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable(name = "id") UUID id) {
        return this.staffService.findById(id);
    }

    @PostMapping
    public Staff createStaff(@RequestBody Staff staff) {
        return this.staffService.createStaff(staff);
    }

    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable(name = "id") UUID id, @RequestBody Staff staff) {
        return this.staffService.updateStaff(id, staff);
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable(name = "id") UUID id) {
        this.staffService.deleteStaff(id);
    }

}
