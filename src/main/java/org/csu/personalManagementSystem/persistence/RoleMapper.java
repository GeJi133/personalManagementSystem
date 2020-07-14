package org.csu.personalManagementSystem.persistence;

import org.csu.personalManagementSystem.domain.Role;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoleMapper {
    public List<Role> findAllPermission();
    public Role findRoleByAdminUserId(String id);
}
