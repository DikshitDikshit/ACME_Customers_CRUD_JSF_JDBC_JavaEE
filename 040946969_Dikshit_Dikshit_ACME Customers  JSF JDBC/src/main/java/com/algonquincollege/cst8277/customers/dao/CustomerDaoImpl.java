/* 
 * File: CustomerDaoImpl.java
 * Course materials (20F) CST 8277
 * 
 * @author (original) Prof. Mike Norman
 * @author Dikshit Dikshit 040946969
 * 
 */
package com.algonquincollege.cst8277.customers.dao;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import com.algonquincollege.cst8277.customers.model.CustomerPojo;

// TODO: Auto-generated Javadoc
/**
 * Description: Implements the C-R-U-D API for the database.
 */
@Named
@ApplicationScoped
public class CustomerDaoImpl implements CustomerDao, Serializable {
	
	/**  explicitly set serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant CUSTOMER_DS_JNDI. for Data Source for establishing connection with database */
	private static final String CUSTOMER_DS_JNDI = "java:app/jdbc/customers";
	
	/** The Constant query for READ_ALL. */
	private static final String READ_ALL = "select * from customer";
	
	/** The Constant query for READ_CUSTOMER_BY_ID. */
	private static final String READ_CUSTOMER_BY_ID = /* TODO */ "select * from customer where id = ?";
	
	/** The Constant query for INSERT_CUSTOMER. */
	private static final String INSERT_CUSTOMER = /* TODO */ "insert into customer (FNAME,LNAME,EMAIL,PHONENUMBER) values (?,?,?,?)";
	
	/** The Constant query for UPDATE_CUSTOMER_ALL_FIELDS. */
	private static final String UPDATE_CUSTOMER_ALL_FIELDS = /* TODO */ "update customer set FNAME = ? , LNAME = ? , EMAIL = ?, PHONENUMBER=? where id = ?";
	
	/** The Constant query for DELETE_CUSTOMER_BY_ID. */
	private static final String DELETE_CUSTOMER_BY_ID = "delete from customer where id = ?";

	/** The external context. */
	@Inject
	protected ExternalContext externalContext;

	/**
	 * Log msg.
	 *
	 * @param msg the msg
	 */
	private void logMsg(String msg) {
		((ServletContext) externalContext.getContext()).log(msg);
	}

	/** The customer DS. */
	@Resource(lookup = CUSTOMER_DS_JNDI)
	protected DataSource customerDS;

	/** The conn. */
	protected Connection conn;
	
	/** The read all pstmt. */
	protected PreparedStatement readAllPstmt;
	
	/** The read by id pstmt. */
	protected PreparedStatement readByIdPstmt;
	
	/** The create pstmt. */
	protected PreparedStatement createPstmt;
	
	/** The update pstmt. */
	protected PreparedStatement updatePstmt;
	
	/** The delete by id pstmt. */
	protected PreparedStatement deleteByIdPstmt;

	/**
	 * Builds the connection and statements.
	 */
	@PostConstruct
	protected void buildConnectionAndStatements() {
		try {
			logMsg("building connection and stmts");
			conn = customerDS.getConnection();
			readAllPstmt = conn.prepareStatement(READ_ALL);
			createPstmt = conn.prepareStatement(INSERT_CUSTOMER, RETURN_GENERATED_KEYS);
			readByIdPstmt = conn.prepareStatement(READ_CUSTOMER_BY_ID);
			updatePstmt = conn.prepareStatement(UPDATE_CUSTOMER_ALL_FIELDS);
			deleteByIdPstmt = conn.prepareStatement(DELETE_CUSTOMER_BY_ID);
			try {
				deleteByIdPstmt = conn.prepareStatement(DELETE_CUSTOMER_BY_ID);
			} catch (Exception e) {
				logMsg("something went wrong preparing deletePstmt: " + e.getLocalizedMessage());
			}

		} catch (Exception e) {
			logMsg("something went wrong getting connection from database: " + e.getLocalizedMessage());
		}
	}

	/**
	 * Close all connection and statements.
	 */
	@PreDestroy
	protected void closeConnectionAndStatements() {
		try {
			logMsg("closing stmts and connection");
			readAllPstmt.close();
			createPstmt.close();
			/* TODO - close other stmts */
			readByIdPstmt.close();
			updatePstmt.close();
			deleteByIdPstmt.close();
			conn.close();
		} catch (Exception e) {
			logMsg("something went wrong closing stmts or connection: " + e.getLocalizedMessage());
		}
	}

	/**
	 * Read all customers from Database.
	 *
	 * @return the list
	 */
	@Override
	public List<CustomerPojo> readAllCustomers() {
		logMsg("reading all customers");
		List<CustomerPojo> employees = new ArrayList<>();
		try {
			ResultSet rs = readAllPstmt.executeQuery();
			while (rs.next()) {
				CustomerPojo newEmployee = new CustomerPojo();
				newEmployee.setId(rs.getInt("id"));
				newEmployee.setFirstName(rs.getString("fname"));
				// TODO additional Model fields
				newEmployee.setLastName(rs.getString("lname"));
				newEmployee.setEmail(rs.getString("email"));
				newEmployee.setPhoneNumber(rs.getString("phonenumber"));
				employees.add(newEmployee);
			}
			try {
				rs.close();
			} catch (Exception e) {
				logMsg("something went wrong closing resultSet: " + e.getLocalizedMessage());
			}
		} catch (SQLException e) {
			logMsg("something went wrong accessing database: " + e.getLocalizedMessage());
		}
		return employees;
	}

	/**
	 * Creates the customer.
	 *
	 * @param customer the customer
	 * @return the customer pojo
	 */
	@Override
	public CustomerPojo createCustomer(CustomerPojo customer) {
		logMsg("creating an customer");
		/* TODO */
		try {
			createPstmt.setString(1, customer.getFirstName());
			createPstmt.setString(2, customer.getLastName());
			createPstmt.setString(3, customer.getEmail());
			createPstmt.setString(4, customer.getPhoneNumber());

			int numRowsInserted = createPstmt.executeUpdate();
			if (numRowsInserted < 1) {
				throw new Exception("something went wrong inserting inventory");
			} else {
				ResultSet rs = createPstmt.getGeneratedKeys();
				if (rs != null && rs.next()) {

					customer.setId(rs.getInt(1));
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	/**
	 * Read customer by id.
	 *
	 * @param customerId the customer id
	 * @return the customer pojo
	 */
	@Override
	public CustomerPojo readCustomerById(int customerId) {
		logMsg("read a specific customer");
		CustomerPojo foundCustomer = null;
		/* TODO */
		try {
			readByIdPstmt.setInt(1, customerId);
			ResultSet result = readByIdPstmt.executeQuery();
			foundCustomer = new CustomerPojo();
			foundCustomer.setId(result.getInt("id"));
			foundCustomer.setFirstName(result.getString("fname"));
			foundCustomer.setFirstName(result.getString("lname"));
			foundCustomer.setFirstName(result.getString("email"));
			foundCustomer.setFirstName(result.getString("phonenumber"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foundCustomer;
	}

	/**
	 * Update customer.
	 *
	 * @param customer the customer
	 */
	@Override
	public void updateCustomer(CustomerPojo customer) {
		logMsg("updating a specific customer");
		/* TODO */
		try {
			updatePstmt.setString(1, customer.getFirstName());
			updatePstmt.setString(2, customer.getLastName());
			updatePstmt.setString(3, customer.getEmail());
			updatePstmt.setString(4, customer.getPhoneNumber());
			updatePstmt.setInt(5, customer.getId());
			updatePstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Delete customer by id.
	 *
	 * @param customerId the customer id
	 */
	public void deleteCustomerById(int customerId) {
		logMsg("deleting a specific customer");
		try {
			deleteByIdPstmt.setInt(1, customerId);
			int i = deleteByIdPstmt.executeUpdate();
			if (i < 1) {
				logMsg("something went wrong deleting from database (numRows < 1)");
			}
		} catch (SQLException e) {
			logMsg("something went wrong deleting from database (" + e.getSQLState() + ", " + e.getLocalizedMessage()
					+ ")");
		}
	}

}