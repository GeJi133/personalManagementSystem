package org.csu.personalManagementSystem.persistence;


import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.Transfer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ApplyMapper {
    void insertLeaving(Leaving leaving);
    void insertTransfer(Transfer transfer);
    ArrayList<Leaving> seeLeavings();
    ArrayList<Transfer> seeTransfers();
}
