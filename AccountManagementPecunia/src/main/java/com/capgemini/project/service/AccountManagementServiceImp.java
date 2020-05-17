package com.capgemini.project.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.project.dao.AccountEntityDao;
import com.capgemini.project.dao.AddressEntityDao;
import com.capgemini.project.dao.CustomerEntityDao;
import com.capgemini.project.entity.Account;
import com.capgemini.project.entity.Address;
import com.capgemini.project.entity.Customer;
import com.capgemini.project.exception.AccountException;
import com.capgemini.project.util.AccountUtil;


@Service
@Transactional
public class AccountManagementServiceImp implements AccountManagementService {
	
	@Autowired
	private AccountEntityDao accountEntityDao;
	
	@Autowired
	private CustomerEntityDao customerEntityDao;
	
	@Autowired
	private AddressEntityDao addressEntityDao;
	
	

	@Override
	public String addAccount(Account account, Customer customer, Address address) {
		
		if(account==null) {
			throw new AccountException("Account can't find");
		}
		String generatedAccountNumber=AccountUtil.generateId(12);
		String genereatedAccountHolderId=AccountUtil.generateId(6);
		String generatedAddressId=AccountUtil.generateId(6);
		
		account.setAccountNumber(generatedAccountNumber);
		account.setAccountHolderId(genereatedAccountHolderId);
		account=accountEntityDao.save(account);
		customer.setCustomerId(genereatedAccountHolderId);
		customer.setAddress(generatedAddressId);
		customer=customerEntityDao.save(customer);
		address.setAddressId(generatedAddressId);
		address= addressEntityDao.save(address);
		
		return "Account Created Successfully :)" ;
		
	}

	@Override
	public boolean deleteAccount(Account account){
		
		if(account==null) {
			throw new AccountException("Account can't find");
		}
		account=accountEntityDao.save(account);
		return true;
	}

	@Override
	public boolean updateAccountAddress(Account account, Address address) {
		if(account==null) {
			throw new AccountException("Account can't find");
		}
		if(address==null) {
			throw new AccountException("Address can't find");
		}
		account=accountEntityDao.save(account);
		address= addressEntityDao.save(address);
		return true;
	}

	@Override
	public boolean updateName(Account account, Customer customer) {
		if(account==null) {
			throw new AccountException("Account can't find");
		}
		if(customer==null) {
			throw new AccountException("customer can't find");
		}
		account=accountEntityDao.save(account);
		customer=customerEntityDao.save(customer);
		return true;

	}

	@Override
	public boolean updateContact(Account account, Customer customer){
		if(account==null) {
			throw new AccountException("Account can't find");
		}
		if(customer==null) {
			throw new AccountException("customer can't find");
		}
		account=accountEntityDao.save(account);
		customer=customerEntityDao.save(customer);
		return true;
	}

	@Override
	public List<Account> showAllAccount() {
		
		List<Account> accounts=accountEntityDao.findAll();
		
		return accounts;
	}

	@Override  
	public Account fetchAccountByAccountId(String accountId)  {
		Optional<Account> optional=accountEntityDao.findById(accountId);
		 if(optional.isPresent()) {
	            Account account=optional.get();
	            return account;
	        }
	        throw new AccountException("Account not found for id="+accountId);
	}

	@Override
	public Customer fetchCustomerByCustomerId(String customerId)  {
		
		Optional<Customer> optional=customerEntityDao.findById(customerId);
		 if(optional.isPresent()) {
			 Customer  customer=optional.get();
	            return customer;
	        }
	        throw new AccountException("customer not found for id="+customerId);
	}

	@Override
	public Address fetchAddressByAddressId(String addressId) {
		
		Optional<Address> optional=addressEntityDao.findById(addressId);
		 if(optional.isPresent()) {
			 Address address=optional.get();
	            return address;
	        }
	        throw new AccountException("customer not found for id="+addressId);
	}
	
	

}
