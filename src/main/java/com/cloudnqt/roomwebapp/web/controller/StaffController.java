package com.cloudnqt.roomwebapp.web.controller;

import com.cloudnqt.roomwebapp.data.service.StaffService;
import com.cloudnqt.roomwebapp.web.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/staffs")
    public String staffs(Model model) {
        List<Staff> staffList = staffService.findAll();
        model.addAttribute("staffs", staffList);
        return "staff";
    }
}
