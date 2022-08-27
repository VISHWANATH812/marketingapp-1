package com.marketing.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marketing.entities.Lead;



public interface LeadService {
	
	public void saveLead(Lead lead);//abstraction

	public List<Lead> listAllLeads();

	public void deleteOneLead(long id);

	public Lead updateOneLead(long id);
}
