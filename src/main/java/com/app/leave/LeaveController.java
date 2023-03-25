package com.app.leave;
//
import java.util.List;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import com.app.department.Department;
//import com.app.employee.Employee;
//
@RestController
@RequestMapping("/leaves")
@CrossOrigin("http://localhost:3000")
public class LeaveController {
//	
//	@Autowired(required=true)
//	private RestTemplate restTemplate;
//  
	@Autowired
	private LeaveRepo leaveRepo;
//	
//	@Autowired
//	private LeaveRequestRepo leaveRequestRepo;
//  
//	@Value("${manager.service.url}")
//	private String managerServiceUrl;
//  
//	@Value("${employee.service.url}")
//	private String employeeServiceUrl;
//
//	@Value("${department.service.url}")
//	private String departmentServiceUrl;
//	
//	@PostMapping("/leaverequest/{employeeId}")
//	public ResponseEntity<LeaveRequest> applyLeave(@PathVariable Long employeeId, @RequestBody LeaveRequest leaveRequest){
//		
//		Employee employee = restTemplate.getForObject(
//				employeeServiceUrl + "/employees/" + employeeId,
//				Employee.class
//				);
//		if (employee == null) {
//			return ResponseEntity.notFound().build();
//		}
//		
//		Long departmentId = employee.getDepartmentId();
//		Department department = restTemplate.getForObject(
//				departmentServiceUrl + "/departments/" + departmentId,
//				Department.class
//				);
//		if (department == null) {
//			return ResponseEntity.notFound().build();
//		}
//		
//		Long managerId = department.getManagerId();
//		String reason = leaveRequest.getReason();
//		
//		Leave leave = new Leave();
//		leave.setLeaveId(leaveRequest.getId());
//		leave.setStartDate(leaveRequest.getStartDate());
//		leave.setEndDate(leaveRequest.getEndDate());
//		leave.setStatus(LeaveStatus.PENDING);
//		leave.setEmployeeId(employeeId);
//		leave.setDepartmentId(departmentId);
//		leave.setManagerId(managerId);
//		leave.setLeaveReason(reason);
//		leaveRepo.save(leave);
//		    
//		leaveRequest.setEmployeeId(employeeId);
//		LeaveRequest savedLeaveRequest = leaveRequestRepo.save(leaveRequest);
//		
//		return ResponseEntity.ok(savedLeaveRequest);   
//					    
//	}
//	
//	@PutMapping("/leaveapproval/{managerId}/{leaveId}")
//	public ResponseEntity<Leave> leaveApproval(@PathVariable Long managerId, @PathVariable Long leaveId) {
//		
//		Leave leave = leaveRepo.findById(leaveId).orElseThrow(null);
//		if (leave == null) {
//	        return ResponseEntity.notFound().build();
//	    }
//		
//		if (leave.getManagerId() != managerId) {
//	        return ResponseEntity.badRequest().build();
//	    }
//		
//		if(leave.getStatus().equals(LeaveStatus.PENDING))
//			leave.setStatus(LeaveStatus.APPROVED);	
//	    leaveRepo.save(leave);
//	    
//	    return ResponseEntity.ok(leave);
//	}
//	
//	@PutMapping("/leavedenial/{managerId}/{leaveId}")
//	public ResponseEntity<Leave> leaveDenial(@PathVariable Long managerId, @PathVariable Long leaveId) {
//		
//		Leave leave = leaveRepo.findById(leaveId).orElseThrow(null);
//		if (leave == null) {
//	        return ResponseEntity.notFound().build();
//	    }
//		
//		if (leave.getManagerId() != managerId) {
//	        return ResponseEntity.badRequest().build();
//	    }
//		
//		if(leave.getStatus().equals(LeaveStatus.PENDING))
//			leave.setStatus(LeaveStatus.DENIED);
//	    leaveRepo.save(leave);
//	    
//	    return ResponseEntity.ok(leave);
//	}
//	
	@GetMapping("/employee/leave/{employeeId}")
	public List<Leave> getEmployeeLeaves(@PathVariable Long employeeId) {
	    return leaveRepo.findByEmployeeId(employeeId);
	}
//	
	@GetMapping("/manager/employeeleaves/{managerId}")
	public List<Leave> getEmployeeLeavesForManager(@PathVariable Long managerId){
		return leaveRepo.findPendingLeaveRequestsByManagerId(managerId);
	}
}
//---------------------------------------------------------------------------------------
//
////@GetMapping("/{managerId}/leaverequests")
////public ResponseEntity<List<LeaveRequest>> getLeaveRequestsForDepartment(@PathVariable Long managerId) {
////    
////	Manager manager = restTemplate.getForObject(
////			managerServiceUrl + "/managers/" + managerId,
////			Manager.class
////			);
////	Long deptid = manager.getDeptid();
////    
////	ResponseEntity<List<Employee>> employeeResponse = restTemplate.exchange(employeeServiceUrl+"/employees/", HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {});
////    List<Employee> employees = employeeResponse.getBody();
////    List<Employee> departmentEmployees = employees.stream()
////            .filter(e -> e.getDeptid().equals(deptid))
////            .collect(Collectors.toList());
////    
////    // Retrieve list of leave requests for each employee and combine them into a single list
////    ResponseEntity<List<LeaveRequest>> leaveResponse = restTemplate.exchange("http://localhost:8093/leaveRequests",HttpMethod.GET, null, new ParameterizedTypeReference<List<LeaveRequest>>() {});
////    List<LeaveRequest> leaveRequests = new ArrayList<>();
////    for (Employee employee : employees) {
////        List<LeaveRequest> employeeLeaveRequests = restTemplate.getForObject(
////            leaveServiceUrl + "/leaverequests?employeeId=" + employee.getId(),
////            new ParameterizedTypeReference<List<LeaveRequest>>() {});
////        leaveRequests.addAll(employeeLeaveRequests);
////    }
////    
////    return ResponseEntity.ok(leaveRequests);
////}
//////
//////@Autowired
//////private LeaveService leaveService;
//////
//////@PostMapping("/applyleave")
//////public ResponseEntity<LeaveRequest> applyLeave(@RequestBody LeaveRequest leaveRequest) {
//////	leaveService.applyLeave(leaveRequest);
//////	return ResponseEntity.ok().build();
//////}
//////
//////@PostMapping("/approve")
//////  public ResponseEntity<LeaveApproval> approveLeave(@RequestBody LeaveApproval leaveApproval) {
//////    leaveService.approveLeave(leaveApproval);
//////    return ResponseEntity.ok(leaveApproval);
//////  }
//////
//////  @PostMapping("/deny")
//////  public ResponseEntity<LeaveDenial> denyLeave(@RequestBody LeaveDenial leaveDenial) {
//////    leaveService.denyLeave(leaveDenial);
//////    return ResponseEntity.ok(leaveDenial);
//////  }