/* 
 * File: CustomerController.java
 * Course materials (20F) CST 8277
 * 
 * @author (original) Prof. Mike Norman
 * @author Dikshit Dikshit 040946969
 * 
 */
package com.algonquincollege.cst8277.customers.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.SessionMap;
import javax.inject.Inject;
import javax.inject.Named;

import com.algonquincollege.cst8277.customers.dao.CustomerDao;
import com.algonquincollege.cst8277.customers.model.CustomerPojo;

// TODO: Auto-generated Javadoc
/**
 * Description: Responsible for collection of Customer Pojo's in XHTML (list)
 * 
 * Delegates all C-R-U-D behaviour to DAO.
 */

@Named
@SessionScoped
public class CustomerController implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The session map. */
    @Inject
    @SessionMap
    protected Map<String, Object> sessionMap;

    /** The customer dao. */
    @Inject
    protected CustomerDao customerDao;

    /** The customers. */
    protected List<CustomerPojo> customers;

    // necessary methods to make controller work

    /**
     * Load customers.
     */
    public void loadCustomers() {
        setCustomers(customerDao.readAllCustomers());
    }

    /**
     * Gets the customers.
     *
     * @return the customers
     */
    public List<CustomerPojo> getCustomers() {
        return customers;
    }

    /**
     * Sets the customers.
     *
     * @param customers the new customers
     */
    public void setCustomers(List<CustomerPojo> customers) {
        this.customers = customers;
    }

    /**
     * Navigate to add form.
     *
     * @return the string
     */
    public String navigateToAddForm() {
        sessionMap.put("newCustomer", new CustomerPojo());
        return "add-customer?faces-redirect=true";
    }

// TODO

    /**
 * Submit customer.
 *
 * @param newCustomer the new customer
 * @return the string
 */
public String submitCustomer(CustomerPojo newCustomer) {
        customerDao.createCustomer(newCustomer);

        return "list-customers.xhtml?faces-redirect=true";
    }

    /**
     * Navigate to update form.
     *
     * @param customer the customer
     * @return the string
     */
    public String navigateToUpdateForm(CustomerPojo customer) {

        sessionMap.put("Customer", customer);

        return "edit-customer.xhtml?faces-redirect=true";
    }

    /**
     * Submit updated customer.
     *
     * @param Customer the customer
     * @return the string
     */
    public String submitUpdatedCustomer(CustomerPojo Customer) {

        customerDao.updateCustomer(Customer);

        return "list-customers.xhtml?faces-redirect=true";

    }

    /**
     * Delete customer.
     *
     * @param id the id
     * @return the string
     */
    public String deleteCustomer(int id) {

        customerDao.deleteCustomerById(id);

        return "list-customers.xhtml?faces-redirect=true";

    }

}