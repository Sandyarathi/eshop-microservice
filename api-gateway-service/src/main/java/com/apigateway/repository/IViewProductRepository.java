package com.apigateway.repository;

import java.util.Map;
import java.util.UUID;

import com.apigateway.model.ViewProduct;

public interface IViewProductRepository {
	
	public void save(ViewProduct viewProduct);

    public ViewProduct find(UUID id);

    public void delete(UUID id);
    public Map<Object, Object> findAll();


}
