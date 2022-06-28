package com.example.restdemo.service;

import com.example.restdemo.entity.Employee;
import com.example.restdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

        @Service
public class EmployeeServiceImpl implements EmployeeService{

//    private EmployeeDAO employeeDAO;
//
//    @Autowired
//    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
//        employeeDAO = theEmployeeDAO;
//    }
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        //return employeeDAO.findAll();
        System.out.println("total"+employeeRepository.findAll());
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Employee> findById(int theId) {
        //return employeeDAO.findById(theId);
        return employeeRepository.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        //employeeDAO.save(theEmployee);
            employeeRepository.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
            //employeeDAO.deleteById(theId);
        employeeRepository.deleteById(theId);
    }
}
