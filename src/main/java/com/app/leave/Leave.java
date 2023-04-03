package com.app.leave;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="leaves")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Leave {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leaveId;
	
	private LocalDate startDate;
	private LocalDate endDate;
	private Long employeeId;
	private String employeeName;
	private Long departmentId; 
	private Long managerId;
	private String leaveReason;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private LeaveStatus status;
	
		
}
