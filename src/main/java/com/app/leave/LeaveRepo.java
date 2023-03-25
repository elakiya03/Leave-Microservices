package com.app.leave;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LeaveRepo extends JpaRepository<Leave, Long>{
	
	List<Leave> findByEmployeeId(Long employeeId); 
	
	@Query("SELECT l FROM Leave l WHERE l.managerId = :managerId AND l.status = 'PENDING'")
	List<Leave> findPendingLeaveRequestsByManagerId(Long managerId);

}
