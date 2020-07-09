package org.csu.personalManagementSystem.persistence;


import org.csu.personalManagementSystem.domain.Leaving;
import org.springframework.stereotype.Repository;

@Repository
public interface HandleMapper {
    void handleLeaving(Leaving leaving);
}
