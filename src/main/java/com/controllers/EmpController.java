package com.controllers;


import com.models.Employee;
import com.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/api/employee")
public class EmpController {

    @Autowired
    EmployeeServices employeeServices;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<String> saveDetails(@RequestBody Employee employee, UriComponentsBuilder uriComponentsBuilder) {
        employeeServices.saveEmployee(employee);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("api/employee/{id}").buildAndExpand(employee.getEmpid()).toUri());
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/getemp/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getEmployee(@PathVariable("id") int id) {
        Employee employee = employeeServices.getEmp(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "updateemp/{id}",method = RequestMethod.PUT)
        public ResponseEntity<?> updateEmpData(@PathVariable("id")int id,@RequestBody Employee employee){
        employeeServices.updateemp(id,employee);
return new ResponseEntity<Employee>(employee,HttpStatus.OK);
        }
}
