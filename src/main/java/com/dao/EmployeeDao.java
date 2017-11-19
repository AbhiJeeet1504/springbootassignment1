package com.dao;


import com.models.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class EmployeeDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveemp(Employee employee){
        entityManager.persist(employee);
    }
    public Employee  getEmp(int empid){
        return  entityManager.find(Employee.class,empid);
    }

    public void updateemp(int id,Employee emp){
        Employee employee=entityManager.find(Employee.class,id);
        employee.setDeptid(emp.getDeptid());
        emp.setEmpName(emp.getEmpName());
        emp.setMobileNumber(emp.getMobileNumber());
        entityManager.merge(employee);



    }
}
