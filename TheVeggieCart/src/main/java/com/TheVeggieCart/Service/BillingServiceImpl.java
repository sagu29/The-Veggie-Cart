package com.TheVeggieCart.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.TheVeggieCart.Exception.BillNotFoundException;
import com.TheVeggieCart.Model.BillingDetails;
import com.TheVeggieCart.Repository.BillingDetailsRepository;
import com.TheVeggieCart.Repository.CustomerRepository;
import com.TheVeggieCart.Repository.OrdersRepository;

public class BillingServiceImpl implements IBillingService {
	
	 @Autowired
	    private OrdersRepository ordersRepository;
	    @Autowired
	    private CustomerRepository customerRepository;
	    @Autowired
	   private  BillingDetailsRepository billingRepository;

//	    @Autowired
//	    private AddressRepository addressRepository;

	@Override
	public BillingDetails addBill(BillingDetails bill) {
		if(bill == null) {
			throw new BillNotFoundException("Bill not found with ID: " + bill.getBillingId());
		}
		return billingRepository.save(bill);
	}

	@Override
	public BillingDetails updateBill(BillingDetails bill) {
		 if (!billingRepository.existsById(bill.getBillingId())) {
	            throw new BillNotFoundException("Bill not found with ID: " + bill.getBillingId());
	        }
	        return billingRepository.save(bill);
	}

	@Override
	public BillingDetails viewBill(int id) {
		BillingDetails b = billingRepository.getById(id);
		if(b == null) {
			throw new BillNotFoundException("Bill not found with ID: " + b.getBillingId());
		}
		return b;
	}



}
