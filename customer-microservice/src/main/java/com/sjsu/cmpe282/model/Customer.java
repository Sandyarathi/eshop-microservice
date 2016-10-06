package com.sjsu.cmpe282.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("customer")
public class Customer {
	@PrimaryKey("customer_id")
	private UUID customerId;

	@Column("first_name")
	private String firstName;

	@Column("last_name")
	private String lastName;
	
	@Column("email")
	private String email;
	
	@Column("password")
	private String password;
	
	@Column("created")
	private Date createDate;

	/**
	 * @param customerId
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param createDate
	 */
	public Customer(UUID customerId, String firstName, String lastName,
			String password, Date createDate) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		
		if (createDate != null) {
			this.createDate = createDate;
		} else {
			this.createDate = new Date();
		}
	}

	/**
	 * @param customerId
	 * @param firstName
	 * @param lastName
	 * @param createDate
	 */
	public Customer(UUID userId, String firstName, String lastName,
			Date createDate) {
		super();
		this.customerId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createDate = createDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", createDate=" + createDate + "]";
	}

	/**
	 * @return the customerId
	 */
	public UUID getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 
	 */
	public Customer() {
		super();
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
