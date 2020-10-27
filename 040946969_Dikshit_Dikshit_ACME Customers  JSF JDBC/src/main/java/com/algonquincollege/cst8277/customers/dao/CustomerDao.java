/* 
 * File: CustomerDao.java
 * Course materials (20F) CST 8277
 * 
 * @author (original) Prof. Mike Norman
 * @author Dikshit Dikshit 040946969
 * 
 */
package com.algonquincollege.cst8277.customers.dao;

import java.util.List;

import com.algonquincollege.cst8277.customers.model.CustomerPojo;

// TODO: Auto-generated Javadoc
/**
 * Description: API for the database C-R-U-D operations.
 */
public interface CustomerDao {

    /**
     * Creates the customer.
     *
     * @param customer the customer
     * @return the customer pojo
     */
    // C
    public CustomerPojo createCustomer(CustomerPojo customer);
    
    /**
     * Read customer by id.
     *
     * @param customerId the customer id
     * @return the customer pojo
     */
    // R
    public CustomerPojo readCustomerById(int customerId);
    
    /**
     * Read all customers.
     *
     * @return the list
     */
    public List<CustomerPojo> readAllCustomers();
    
    /**
     * Update customer.
     *
     * @param customer the customer
     */
    // U
    public void updateCustomer(CustomerPojo customer);
    
    /**
     * Delete customer by id.
     *
     * @param customerId the customer id
     */
    // D
    public void deleteCustomerById(int customerId);

}