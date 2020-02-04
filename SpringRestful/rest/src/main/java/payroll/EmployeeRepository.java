package payroll;

import org.springframework.data.jpa.repository.JpaRepository;

//继承Jpa接口， 指定实体类， 指定主键
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
