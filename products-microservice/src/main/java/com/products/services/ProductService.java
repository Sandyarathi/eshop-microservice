package com.products.services;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.products.model.Inventory;
import com.products.model.Product;
import com.products.repositories.IProductDetailsRepository;

@Service
public class ProductService {
	
	@Autowired
	private IProductDetailsRepository productDetailsRepo;
	
	final String inventoryURI = "http://ec2-54-67-113-169.us-west-1.compute.amazonaws.com:8084/inventory/";
	//final String inventoryURI = "http://localhost:8084/inventory/";

	
	private Log log = LogFactory.getLog(ProductService.class);
	
	public boolean addProduct(Product product){
		productDetailsRepo.save(product);
		return true;
	}

	public boolean isValid(String productId) {
		if(!(productDetailsRepo.exists(productId)))
			return false;
		return true;
	}

	public ArrayList<Product> listAll() throws JSONException {
		//if(addProducts()){
			System.out.println("returning product list");
			return (ArrayList<Product>) productDetailsRepo.findAll();
		//}
			
		//return null;
		
	/*if(addProducts()){
		List<Product> productList = productDetailsRepo.findAll();
	    List<JSONObject> products = new ArrayList<JSONObject>();
	    for (Product p : productList) {
	        JSONObject product = new JSONObject();
	        product.put("productId", p.getId());
	        product.put("productName", p.getProductName());
	        
	        products.add(product);
	    }
	    return (ArrayList<JSONObject>) products;
	}
	
		return null;
		*/
	}
	
	public boolean addProducts(){
		System.out.println("***CREATING PRODUCT DATA****");
		productDetailsRepo.deleteAll();
		ArrayList<Product> productList= new ArrayList<Product>();
		Product product1 = new Product(UUID.randomUUID().toString(), "Not a Penny More, Not a Penny less",259.23,"Novel by Jeffery Archer", "Novel");
		Product product2 = new Product(UUID.randomUUID().toString(), "Macbeth",40.00,"Play by Sherlock Holmes", "Plays");
		Product product3 = new Product(UUID.randomUUID().toString(), "Head First Java",20.00,"A java beginners reference", "Textbook");
		Product product4 = new Product(UUID.randomUUID().toString(), "Head First Design Patterns",25.00,"A design patterns reference book", "Textbook");
		Product product5 = new Product(UUID.randomUUID().toString(), "fairy Colors",25.00,"Coloring Book", "Kids");
		Product product7 = new Product(UUID.randomUUID().toString(), "Guitar Guide",40.00,"A guitar lesson book", "Music");
		
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);
		productList.add(product5);
		productList.add(product7);
		
		productDetailsRepo.save(productList);
		createInventory(productList);
		
		
		return true;
	}

	private void createInventory(ArrayList<Product> productList) {
		System.out.println("***DELETING INVENTORY****");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(inventoryURI);
		
		System.out.println("***CREATING INVENTORY****");
		for(Product product:productList){
			Inventory newInventory = new Inventory(product.getId(),1000);
			restTemplate.postForObject(inventoryURI + "create", newInventory, Inventory.class);
		}
		
		
	}

	public Product getProductInfo(String productId) {
		// TODO Auto-generated method stub
		return productDetailsRepo.findById(productId);
	}


}
