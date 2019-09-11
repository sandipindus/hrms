package com.easybusiness.hrmanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.easybusiness.hrmanagement.domain.EmployeeMaster;

/**
 * @author MS
 *
 */
public interface EmployeeRepository extends CrudRepository<EmployeeMaster, Long>{

}
