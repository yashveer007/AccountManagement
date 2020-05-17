package com.capgemini.project.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Accounts")
public class Account {

	@Id
	@Size(min=12)
	@Column(name="Account_number")
	private String accountNumber;
	 
	@Size(min=6)
	@Column(name="Account_Holder_Id")
	private String accountHolderId;
	
	@Column(name="Account_Status")
	private String accountStatus;
	
	@Column(name="Account_Balance")
	private double accountBalance;
	
	@Size(min = 4)
	@Column(name="Branch_Id")
	private String branchId;
	
	@Column(name="Account_Type")
	private String accountType;
	
	@Column(name="Account_Interest")
	private double accountInterest;
	
	@Column(name="Last_Update")
	private Date lastUpdate;
	
	

	public String getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public String getAccountHolderId() {
		return accountHolderId;
	}



	public void setAccountHolderId(String accountHolderId) {
		this.accountHolderId = accountHolderId;
	}



	public String getAccountStatus() {
		return accountStatus;
	}



	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}



	public double getAccountBalance() {
		return accountBalance;
	}



	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}



	public String getBranchId() {
		return branchId;
	}



	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}



	public double getAccountInterest() {
		return accountInterest;
	}



	public void setAccountInterest(double accountInterest) {
		this.accountInterest = accountInterest;
	}

	

	public String getAccountType() {
		return accountType;
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}



	public Date getLastUpdate() {
		return lastUpdate;
	}



	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountHolderId=" + accountHolderId
				+ ", accountStatus=" + accountStatus + ", accountBalance=" + accountBalance + ", branchId=" + branchId
				+ ", accountType=" + accountType + ", accountInterest=" + accountInterest + ", lastUpdate=" + lastUpdate
				+ "]";
	}

	

	public Account(String accountNumber, String accountHolderId, String accountStatus, double accountBalance,
			String branchId, String accountType, double accountInterest, Date lastUpdate) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderId = accountHolderId;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
		this.branchId = branchId;
		this.accountType = accountType;
		this.accountInterest = accountInterest;
		this.lastUpdate = lastUpdate;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((accountHolderId == null) ? 0 : accountHolderId.hashCode());
		temp = Double.doubleToLongBits(accountInterest);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((accountStatus == null) ? 0 : accountStatus.hashCode());
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((branchId == null) ? 0 : branchId.hashCode());
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			return false;
		if (accountHolderId == null) {
			if (other.accountHolderId != null)
				return false;
		} else if (!accountHolderId.equals(other.accountHolderId))
			return false;
		if (Double.doubleToLongBits(accountInterest) != Double.doubleToLongBits(other.accountInterest))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (accountStatus == null) {
			if (other.accountStatus != null)
				return false;
		} else if (!accountStatus.equals(other.accountStatus))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (branchId == null) {
			if (other.branchId != null)
				return false;
		} else if (!branchId.equals(other.branchId))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		return true;
	}



	public Account() {
		super();
	}
	
	
}
