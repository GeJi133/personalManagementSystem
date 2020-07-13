package org.csu.personalManagementSystem.persistence;


import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.Transfer;
import org.springframework.stereotype.Repository;

@Repository
public interface HandleMapper {
    void handleLeaving(Leaving leaving);
    void handleTransfer(Transfer transfer);
    void handleJobTransfer(String id,String wantedJob);
}
