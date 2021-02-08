package com.OnlineFashionStore.customer.jpa;

import org.springframework.data.repository.CrudRepository;

public interface AttendanceRepository extends CrudRepository<Attendance, String> {

	Attendance findByEmployeeIdIgnoreCase(String Employee_id);

}
