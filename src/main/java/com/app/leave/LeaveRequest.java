package com.app.leave;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="leaverequest")
public class LeaveRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leaveId;
	

	
	private LocalDate startDate;
	private LocalDate endDate;
	private Long employeeId;
	private String reason;
	
	public LeaveRequest() {}
	
	
	
	public LeaveRequest(Long leaveId,LocalDate startDate, LocalDate endDate, Long employeeId, String reason) {
		super();
		this.leaveId=leaveId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.employeeId = employeeId;
		this.reason= reason;
	}
	
	public Long getId() {
		return leaveId;
	}



	public void setId(Long id) {
		this.leaveId = id;
	}



	public int getNumberOfDays() {
		return (int) ChronoUnit.DAYS.between(startDate, endDate) + 1;
	}


	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
