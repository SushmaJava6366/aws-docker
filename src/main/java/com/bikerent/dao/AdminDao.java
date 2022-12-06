package com.bikerent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bikerent.entities.Admin;

@Repository
public interface AdminDao  extends JpaRepository<Admin,Integer>{

   String findByAdminId(String adminId);

   Admin findByAdminIdAndPassword(String adminId, String password);



}