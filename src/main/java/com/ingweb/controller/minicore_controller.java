package com.ingweb.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ingweb.model.client;
import com.ingweb.model.contract;
import com.ingweb.interfaz.client_interfaz;
import com.ingweb.interfaz.contract_interfaz;

@Controller
@RequestMapping("/minicore") 

public class minicore_controller {
	

	@Autowired
	private contract_interfaz contractinterfaz;
	
	@Autowired
	private client_interfaz clientinterfaz;
	
	
	@RequestMapping(value = "/suma", method = { RequestMethod.POST, RequestMethod.GET })
	public String suma(Model model,  Date fechaFin, Date fechaInicio){
		List<List<String>> sumas = new ArrayList<>();
		
		List<Date> dates = new ArrayList<>();
		dates.add(fechaInicio);
		Calendar c = Calendar.getInstance();
		Calendar h = Calendar.getInstance();
		c.setTime(fechaInicio);
		h.setTime(fechaFin);
		Date fechaTemp;
		fechaTemp = new java.sql.Date(c.getTimeInMillis());
		System.out.println(fechaTemp);
		while(c.before(h)) {
			c.add(Calendar.DATE, 1);
			fechaTemp = new java.sql.Date(c.getTimeInMillis());
			dates.add(fechaTemp);
		}
		float globalSum=0;
		for (client i : clientinterfaz.findAll()) {
			List<String> clients = new ArrayList<String>();
			clients.add(i.getName());
			float sum = 0;			
			for (contract j : contractinterfaz.findAll()) {
				for(Date f : dates) {
					if (j.getClient().getIdClient()== i.getIdClient() && f.compareTo(j.getFecha()) == 0) {
						sum = sum + j.getAmount();
						globalSum= globalSum+sum;
						
					}
				}
				
			}
			clients.add(Float.toString(sum));	
			sumas.add(clients);
		}
		List<String> amounts = new ArrayList<String>();
		amounts.add("Total");
		amounts.add(Float.toString(globalSum));
		sumas.add(amounts);
		return Mostrar(model,sumas);
	}
	
	@GetMapping
	public String Default(Model model){
		return "index";
	}
	
	
	
	@GetMapping("/Mostrar")
	public String Mostrar(Model model, List<List<String>> sumas ){
		model.addAttribute("proceso", sumas);
		return "index";
	}
	
	
	
	
	
	


}