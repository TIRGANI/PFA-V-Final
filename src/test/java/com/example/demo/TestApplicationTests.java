package com.example.demo;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.Produit;
import com.example.demo.repository.ProduitRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest
public class TestApplicationTests {

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception {

//		MvcResult mvcResult = mockMvc.perform(
//				MockMvcRequestBuilders.get("produits/all").accept(MediaType.APPLICATION_JSON)
//		).andReturn();
//		
//		System.out.println(mvcResult.getResponse());
		
		 Produit p = new Produit();
		 p.setNom("HP");
		 p.setPrix(3000);
		 p.setDateAchat(new Date());
		
		 produitRepository.save(p);

	}

}
