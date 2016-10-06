package com.product.services;


import java.util.ArrayList;
import java.util.UUID;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.product.model.Product;
import com.product.repositories.IProductDetailsRepository;

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

	public ArrayList<Product> listAll() {
		if(addProducts())
			return (ArrayList<Product>) productDetailsRepo.findAll();
		return null;
	}
	
	public boolean addProducts(){
		productDetailsRepo.deleteAll();
		ArrayList<Product> productList= new ArrayList<Product>();
		Product product1 = new Product(UUID.randomUUID(), "SonyTV",259.23,"Electronics", null);
		Product product2 = new Product(UUID.randomUUID(), "ZenDesk Keyboard",40.00,"Electronics", null);
		Product product3 = new Product(UUID.randomUUID(), "VeraModa Top",20.00,"Clothing", null);
		Product product4 = new Product(UUID.randomUUID(), "Jeans",25.00,"Clothing", null);
		Product product5 = new Product(UUID.randomUUID(), "Sweater Top",25.00,"Clothing", null);
		Product product6 = new Product(UUID.randomUUID(), "Jeans",25.00,"Clothing", null);
		Product product7 = new Product(UUID.randomUUID(), "Logitech Monitor",40.00,"Electronics", null);
		
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);
		productList.add(product5);
		productList.add(product6);
		productList.add(product7);
		
		productDetailsRepo.save(productList);
		return true;
	}


}
