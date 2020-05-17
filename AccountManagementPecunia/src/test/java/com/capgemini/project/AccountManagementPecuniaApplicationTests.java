package com.capgemini.project;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.junit.jupiter.api.function.Executable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Assertions;

import com.capgemini.project.entity.Account;
import com.capgemini.project.entity.Address;
import com.capgemini.project.entity.Customer;
import com.capgemini.project.exception.AccountException;
import com.capgemini.project.service.AccountManagementService;
import com.capgemini.project.service.AccountManagementServiceImp;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Import(AccountManagementServiceImp.class)
class AccountManagementPecuniaApplicationTests {
	
	@Autowired
    private AccountManagementService accountService;

    @Autowired
    private EntityManager entityManager;
	    
	@Test
	void contextLoads() {
	}
	
	/*
	 * case when customer added to database
	 */
	@Test
	public void testAddAccount() {
		
		String accountNumber="466454144112";
    	String accountHolderId="1111111";
    	String accountStatus="open";
    	double accountBalance=45612.56;
    	String branchId="64646";
    	String accountType="saving";
    	double accountInterest=6.65;
    	Date lastUpdate=new Date();
    	Account account= new Account();
    	account.setAccountNumber(accountNumber);
    	account.setAccountHolderId(accountHolderId);
    	account.setAccountStatus(accountStatus);
    	account.setAccountBalance(accountBalance);
    	account.setBranchId(branchId);
    	account.setAccountType(accountType);
    	account.setAccountInterest(accountInterest);
    	account.setLastUpdate(lastUpdate);
    	
    	String addressId ="123123";
    	Customer customer=new Customer();
    	customer.setCustomerName("Yashveer Singh");
    	customer.setCustomerId(accountHolderId);
    	customer.setAddress(addressId);
    	customer.setGender("Male");
    	customer.setAadharNumber("333125962133");
    	customer.setPanNumber("panw21133");
    	
    	Address address= new Address();
    	address.setAddressId(addressId);
    	address.setAddressLine("Avas Vikas Colony");
    	address.setCity("Amroha");
    	address.setState("Uttar Pradesh");
    	address.setCountry("India");
    	address.setZipCode("IN1231");
    	String result = accountService.addAccount(account, customer, address);
    	
    	List<Account> fetched = entityManager.createQuery("from Accounts").getResultList();
    	List<Customer> fetchedCustomer = entityManager.createQuery("from Customers").getResultList();
    	List<Address> fetchedAddress = entityManager.createQuery("from Addresses").getResultList();
        Assertions.assertEquals(1, fetched.size());// verifying one got inserted
        Account expected = fetched.get(0);
        Customer expected2 = fetchedCustomer.get(0);
        Address expected3 = fetchedAddress.get(0);
        Assertions.assertEquals(expected, account);// verifying fetch and stored are equal
        Assertions.assertEquals(expected2, customer);// verifying fetch and stored are equal
        Assertions.assertEquals(expected3, address);// verifying fetch and stored are equal
       
	}
	
	/**
     * case when account doesn't exist , verifying AccountException is thrown
     */
	@Test
    public void testFindByAccountNumber() {
        //Executable class is in junit, don't choose the other one
        Executable executable = () -> accountService.fetchAccountByAccountId("101");

        Assertions.assertThrows(AccountException.class, executable);

    }
	/**
     * case when room exist , verifying room is correctly fetched
     * precondition: room exists in database
     */
    @Test
    public void testFindByAccountNumber_2() {
    	String accountNumber="466454144112";
    	String accountHolderId="1111111";
    	String accountStatus="open";
    	double accountBalance=45612.56;
    	String branchId="64646";
    	String accountType="saving";
    	double accountInterest=6.65;
    	Date lastUpdate=new Date();
    	Account account= new Account();
    	account.setAccountNumber(accountNumber);
    	account.setAccountHolderId(accountHolderId);
    	account.setAccountStatus(accountStatus);
    	account.setAccountBalance(accountBalance);
    	account.setBranchId(branchId);
    	account.setAccountType(accountType);
    	account.setAccountInterest(accountInterest);
    	account.setLastUpdate(lastUpdate);
    	
        
        //
        //added the account
        //
    	account=entityManager.merge(account);
    	String accountId=account.getAccountNumber();
        Account result=accountService.fetchAccountByAccountId(accountId);
        
        //
        //verifying details are correctly fetched
        //
        Assertions.assertEquals(account, result);
        Assertions.assertEquals(accountNumber, account.getAccountNumber());
        
    }

}
