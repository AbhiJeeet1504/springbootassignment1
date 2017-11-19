package com.services;


import com.dao.EmployeeDao;
import com.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices {

    @Autowired
    EmployeeDao employeeDao;

    public void saveEmployee(Employee employee){
        employeeDao.saveemp(employee);
    }

    public Employee getEmp(int id){

        return employeeDao.getEmp(id);
    }
    public void updateemp(int id,Employee emp){
        employeeDao.updateemp(id,emp);
    }
}
