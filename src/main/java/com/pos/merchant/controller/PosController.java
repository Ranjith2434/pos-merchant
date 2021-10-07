package com.pos.merchant.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pos.merchant.entity.DrugDetailsEntity;
import com.pos.merchant.entity.OrderDTO;


@RestController
public class PosController {	
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView indexPage() {
		
		String drugDetails = "[{\"id\":1,\"name\":\"paracetamol\",\"imgUrl\":\"https://drive.google.com/uc?export=view&id=1okEmJaUcS6T4-KIOIUXCrt1lttVOtTrX\",\"price\":14},{\"id\":2,\"name\":\"Remdesivir\",\"imgUrl\":\"https://drive.google.com/uc?export=view&id=17swVC43svANAh_FbR4I7-_n0VdLUPvxT\",\"price\":4700},{\"id\":3,\"name\":\"Doxycycline\",\"imgUrl\":\"https://drive.google.com/uc?export=view&id=12FlvjCvd22ubMpn0fvXron_GU3K02dRQ\",\"price\":75},{\"id\":4,\"name\":\"Azithromycin\",\"imgUrl\":\"https://drive.google.com/uc?export=view&id=1nhtkesyidjjXUbebFZsE8r8J7Tf1AI_o\",\"price\":108},{\"id\":5,\"name\":\"favipiravir\",\"imgUrl\":\"https://drive.google.com/uc?export=view&id=1BTygjX9IFzKRM0WWYrZUtzUSTxuWvwSg\",\"price\":85}]";
		List<DrugDetailsEntity> drugDetailsEntity = new LinkedList<DrugDetailsEntity>();
		
		try {
			drugDetailsEntity = new ObjectMapper().readValue(drugDetails, new TypeReference<List<DrugDetailsEntity>>() {});
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addObject("drugDetails",drugDetailsEntity);
		modelAndView.setStatus(HttpStatus.OK);		
		return modelAndView;
	}

	@RequestMapping(path = "/submit", method = RequestMethod.POST)
	public Boolean submitData(@RequestBody OrderDTO order) {		
		System.out.println("Total: " + order.getOrderTotal());
		return true;
	}
	
}
