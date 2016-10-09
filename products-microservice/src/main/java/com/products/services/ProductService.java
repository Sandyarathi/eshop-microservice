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

import com.products.model.Product;
import com.products.repositories.IProductDetailsRepository;

@Service
public class ProductService {
	
	@Autowired
	private IProductDetailsRepository productDetailsRepo;
	
	private Log log = LogFactory.getLog(ProductService.class);
	
	public boolean addProduct(Product product){
		productDetailsRepo.save(product);
		return true;
	}

	public boolean isValid(UUID productId) {
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
		productDetailsRepo.deleteAll();
		ArrayList<Product> productList= new ArrayList<Product>();
		Product product1 = new Product(UUID.randomUUID(), "Not a Penny More, Not a Penny less",259.23,"Novel by Jeffery Archer", "Novel");
		Product product2 = new Product(UUID.randomUUID(), "Macbeth",40.00,"Play by Sherlock Holmes", "Plays");
		Product product3 = new Product(UUID.randomUUID(), "Head First Java",20.00,"A java beginners reference", "Textbook");
		Product product4 = new Product(UUID.randomUUID(), "Head First Design Patterns",25.00,"A design patterns reference book", "Textbook");
		Product product5 = new Product(UUID.randomUUID(), "fairy Colors",25.00,"Coloring Book", "Kids");
		Product product7 = new Product(UUID.randomUUID(), "Guitar Guide",40.00,"A guitar lesson book", "Music");
		
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);
		productList.add(product5);
		productList.add(product7);
		
		productDetailsRepo.save(productList);
		return true;
	}

	public Product getProductInfo(UUID productId) {
		// TODO Auto-generated method stub
		return productDetailsRepo.findById(productId);
	}


}
