package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entities.Lead;
import com.marketing.services.LeadService;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;
	
	@RequestMapping("/createLead")
	public String viewCreateLeadPage() {
		return "create_lead";
	}
	
	@RequestMapping("/saveLead")
	public String saveOneLead(@ModelAttribute("lead") Lead lead,ModelMap model) {
	leadService.saveLead(lead);
		model.addAttribute("msg", "lead is saved!!");
		
		return "create_lead";	
	}
	
	@RequestMapping("/listAll")
	public String listAllLeads(ModelMap model) {
		List<Lead> leads = leadService.listAllLeads();
		model.addAttribute("leads", leads);//adding jstl dependence
		return "lead_search_result";//adding directive tag from jstl core lib
									//adding for each tag
	}
//	@RequestMapping("/saveLead")
//	public String saveOneLead(@RequestParam("firstN") String Fname,@RequestParam("lastN") String Lname,@RequestParam("emailid") String email,@RequestParam("mobileno") long mobile,ModelMap model) {
//		Lead l=new Lead();
//		l.setFirstName(Fname);
//		l.setLastName(Lname);
//		l.setEmail(email);
//		l.setMobile(mobile);
//		leadService.saveLead(l);
//		model.addAttribute("msg", "lead is saved!!");
//		return "create_lead";
//		
////	}
//	@RequestMapping("/saveLead")
//	public String saveOneLead(LeadData data,ModelMap model) {
//		Lead l=new Lead();
//		l.setFirstName(data.getFirstName());
//		l.setLastName(data.getLastName());
//		l.setMobile(data.getMobile());
//		l.setEmail(data.getEmail());
//		leadService.saveLead(l);
//		model.addAttribute("msg", "lead is saved!!");
//		return "create_lead";
//	}

	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id,ModelMap model) {
		leadService.deleteOneLead(id);
		List<Lead> leads = leadService.listAllLeads();
		model.addAttribute("leads", leads);
		return "lead_search_result";
		
	}

	@RequestMapping("/update")
	public String updateOneLead(@RequestParam("id") long id,ModelMap model) {
		Lead lead = leadService.updateOneLead(id);
		model.addAttribute("lead", lead);
		return "update_searchResult";
		
	}
	@RequestMapping("/updateLead")
	public String updateLead(@RequestParam("id")long id, LeadData data,ModelMap model) {
		Lead l=new Lead();
		l.setId(id);
		l.setFirstName(data.getFirstName());
		l.setLastName(data.getLastName());
		l.setEmail(data.getEmail());
		l.setMobile(data.getMobile());
		leadService.saveLead(l);
		List<Lead> leads = leadService.listAllLeads();
		model.addAttribute("leads", leads);
		return "lead_search_result";
	}

}
