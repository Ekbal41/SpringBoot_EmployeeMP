
package com.asifekbal.management.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.asifekbal.management.Shema.Employee;
 

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
 
}