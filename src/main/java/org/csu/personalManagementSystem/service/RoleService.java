package org.csu.personalManagementSystem.service;

import org.csu.personalManagementSystem.domain.Role;
import org.csu.personalManagementSystem.persistence.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

//    public List<Role> getAllPermission(){
//        return roleMapper.findAllPermission ();
//
//    }
    public Role getRoleByUserId(String userId){
        return roleMapper.findRoleByAdminUserId (userId);
    }
}
