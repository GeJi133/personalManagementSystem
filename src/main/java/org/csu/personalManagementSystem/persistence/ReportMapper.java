package org.csu.personalManagementSystem.persistence;

import org.csu.personalManagementSystem.domain.Leaving;
import org.csu.personalManagementSystem.domain.Transfer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportMapper {
    List<Leaving> getAllLeaving();
    List<Transfer> getAllTransfer();
}
