package com.capgemini.project.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

import javax.persistence.Convert;

import org.springframework.format.annotation.DateTimeFormat;

import com.capgemini.project.entity.Account;
import com.capgemini.project.entity.Address;
import com.capgemini.project.entity.Customer;

public class AccountUtil {
	
	public static Account convertToAccount(Map<String ,Object> map){
			
		Account account=new Account();
		
		double accountBalance=Double.parseDouble((String)map.get("accountBalance"));
		String branchId=(String)map.get("branchId");
		String accountType=(String)map.get("accountType");
		String accountStatus=(String)map.get("accountStatus");
		double accountInterest=Double.parseDouble((String)map.get("accountInterest"));
		//String sDate =(String)map.get("lastUpdate");
		//Date lastUpdate= new SimpleDateFormat("yyyy-mm-dd").parse(sDate);
		
		
		Date lastUpdate=((Date)map.get("lastUpdate"));
		
		account.setAccountBalance(accountBalance);
		account.setAccountInterest(accountInterest);
		account.setAccountStatus(accountStatus);
		account.setAccountType(accountType);
		account.setLastUpdate(lastUpdate);
		account.setBranchId(branchId);
		
		return account;
	}
	public static Customer convertToCustomer(Map<String ,Object> map)  {
			
			Customer customer = new Customer();
			
			String customerName=(String)map.get("customerName");
			//Date customerDob= new SimpleDateFormat("yyyy-mm-dd").parse((String)map.get("customerDob")) ;
			Date customerDob=(Date)map.get("customerDob");
			String customerGender=(String)map.get("customerGender");
			String customerContactNumber=(String)map.get("customerContactNumber");
			String customerPanNumber=(String)map.get("customerPanNumber");
			String customerAadharNumber=(String)map.get("customerAadharNumber");
			
			customer.setAadharNumber(customerAadharNumber);
			customer.setCustomerName(customerName);
			customer.setDOB(customerDob);
			customer.setGender(customerGender);
			customer.setContactNumber(customerContactNumber);
			customer.setPanNumber(customerPanNumber);
			
			return customer;
		}
		public static Address convertToAddress(Map<String ,Object> map) {
			
			Address address = new Address();
			String addressLine=(String)map.get("addressLine");
			String city=(String)map.get("city");
			String state=(String)map.get("state");
			String country=(String)map.get("country");
			String zipcode=(String)map.get("zipcode");
			
			address.setAddressLine(addressLine);
			address.setCity(city);
			address.setState(state);
			address.setCountry(country);
			address.setZipCode(zipcode);
			
			return address;
		}

}
