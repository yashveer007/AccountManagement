package com.capgemini.project.service;

import java.util.List;

import javax.security.auth.login.AccountException;

import com.capgemini.project.entity.Account;
import com.capgemini.project.entity.Address;
import com.capgemini.project.entity.Customer;

public interface AccountManagementService {
	
	
	 String addAccount(Account account,Customer customer,Address address);
	 boolean deleteAccount(Account account) ;
	
	 boolean updateAccountAddress(Account account, Address address) ;
	
	 boolean updateName(Account account , Customer customer) ;
	
	 boolean updateContact(Account account , Customer customer);
	
	 List<Account> showAllAccount() ;
	
	 Account fetchAccountByAccountId(String accountId)  ;
	
	 Customer fetchCustomerByCustomerId(String customerId)  ;
	
	 Address fetchAddressByAddressId(String addressId) ;
}
