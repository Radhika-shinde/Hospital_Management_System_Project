package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.entity.Admin;
import com.hms.services.AdminService;

@RestController
@RequestMapping("/admins")
public class AdminController {
	 private final AdminService adminService;
	 @Autowired
	  public AdminController(AdminService adminService) {
	        this.adminService = adminService;
	    }
	 

	   
	    @GetMapping
	    public List<Admin> getAllAdmins() {
	        return adminService.getAllAdmins();
	    }

	    @GetMapping("/{id}")
	    public Admin getAdminById(@PathVariable Long id) {
	        return adminService.getAdminById(id);
	    }

	    @PostMapping
	    public Admin createAdmin(@RequestBody Admin admin) {
	        return adminService.createAdmin(admin);
	    }

	    @PutMapping("/{id}")
	    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
	        return adminService.updateAdmin(id, admin);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteAdmin(@PathVariable Long id) {
	        adminService.deleteAdmin(id);
	    }

}
