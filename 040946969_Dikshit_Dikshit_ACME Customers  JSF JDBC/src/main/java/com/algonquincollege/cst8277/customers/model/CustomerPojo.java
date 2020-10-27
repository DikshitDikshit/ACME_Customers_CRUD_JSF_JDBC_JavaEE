/* 
 * File: CustomerPojo.java
 * Course materials (20F) CST 8277
 * 
 * @author (original) Prof. Mike Norman
 * @author Dikshit Dikshit 040946969
 * 
 */
package com.algonquincollege.cst8277.customers.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.faces.view.ViewScoped;

// TODO: Auto-generated Javadoc
/**
 * Description: model for the Customer object.
 */
@ViewScoped
public class CustomerPojo implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    protected int id;
    
    /** The first name. */
    protected String firstName;
    
    /** The last name. */
    protected String lastName;
    
    /** The email. */
    protected String email;
    
    /** The phone number. */
    protected String phoneNumber;
    //TODO additional Model fields

    

    /** The version. */
    // these Model fields not used in Assignment 1 (later)
    protected int version;
    
    /** The created. */
    protected LocalDateTime created;
    
    /** The updated. */
    protected LocalDateTime updated;
    
    /** The editable. */
    protected boolean editable;

    /**
     * Checks if is editable.
     *
     * @return true, if is editable
     */
    public boolean isEditable() {
        return editable;
    }
    
    /**
     * Sets the editable.
     *
     * @param editable the new editable
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    /**
     * Sets the id.
     *
     * @param id new value for id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the first name.
     *
     * @return the value for firstName
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Sets the first name.
     *
     * @param firstName new value for firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // TODO additional Model getter's and setter's

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Gets the phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * Sets the phone number.
     *
     * @param phoneNumber the new phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // these methods not used in Assignment 1 (later)

    /**
     * Gets the version.
     *
     * @return the version
     */
    public int getVersion() {
        return version;
    }
    
    /**
     * Sets the version.
     *
     * @param version the new version
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * Gets the created date.
     *
     * @return the created date
     */
    public LocalDateTime getCreatedDate() {
        return created;
    }
    
    /**
     * Sets the created date.
     *
     * @param created the new created date
     */
    public void setCreatedDate(LocalDateTime created) {
        this.created = created;
    }

    /**
     * Gets the updated date.
     *
     * @return the updated date
     */
    public LocalDateTime getUpdatedDate() {
        return updated;
    }
    
    /**
     * Sets the updated date.
     *
     * @param updated the new updated date
     */
    public void setUpdatedDate(LocalDateTime updated) {
        this.updated = updated;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomerPojo)) {
            return false;
        }
        CustomerPojo other = (CustomerPojo) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder
            .append("Customer [id=")
            .append(id)
            .append(", ");
        if (firstName != null) {
            builder
                .append("firstName=")
                .append(firstName)
                .append(", ");
        }
        builder.append("]");
        return builder.toString();
    }

}