package com.gateway.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gateway.model.Customer;
import com.gateway.model.Inventory;
import com.gateway.model.Product;
import com.gateway.model.Review;
import com.gateway.model.ViewProduct;
@Service
public class GatewayService {

	final String productURI = "http://localhost:8081/product/";
	final String customerURI = "http://localhost:8080/customer/";
	final String reviewURI = "http://localhost:8085/review/";
	final String inventoryURI = "http://localhost:8084/inventory/";

	RestTemplate restTemplate = new RestTemplate();

	public ViewProduct getProductInfo(UUID productId) {
		System.out.println("In gateway service class");
		//Map<String, String> params = new HashMap<String, String>();
		//params.put("id", productId);

		Product product = restTemplate.getForObject(productURI+productId, Product.class);
		System.out.println("product obtained");
		//Review review = restTemplate.getForObject(reviewURI, Review.class, params);
		Inventory inventory = restTemplate.getForObject(inventoryURI+productId, Inventory.class);
		System.out.println("inventory obtained");
		ViewProduct viewProduct = new ViewProduct(product, 0.0, inventory.getAvailableStock());
		return viewProduct;

	}

	public ResponseEntity<List<Product>> getCatalog() {
		System.out.println("Reached Gateway service!");
		/*ResponseEntity<List<Product>> responseList = restTemplate.exchange(productURI + "list", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Product>>() {
		});
		List<Product> productList = responseList.getBody();*/
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
	    /*ResponseEntity<Product[]> response = restTemplate.exchange(
				productURI + "list",HttpMethod.GET,entity, Product[].class);
				 
				 return (ArrayList<Product>) Arrays.asList(response.getBody());*/
		
		ParameterizedTypeReference<List<Product>> myProducts = new ParameterizedTypeReference<List<Product>>() {};
		ResponseEntity<List<Product>> response = restTemplate.exchange(productURI + "list",HttpMethod.GET, entity, myProducts);
		System.out.println("*****Response****"+response);
		return response;
	}

	public Customer createCustomer(Customer customer) {

		RestTemplate restTemplate = new RestTemplate();
		Customer createdCustomer = restTemplate.postForObject(customerURI + "create", customer, Customer.class);
		return createdCustomer;
	}

}
