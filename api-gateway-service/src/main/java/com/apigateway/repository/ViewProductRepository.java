package com.apigateway.repository;

import com.apigateway.model.ViewProduct;

import java.util.Map;
import java.util.UUID;

import org.springframework.data.redis.core.RedisTemplate;

public class ViewProductRepository implements IViewProductRepository {

	private RedisTemplate<String, ViewProduct> redisTemplate;
	private static String PRODUCT_KEY = "ProductInfo";

	public RedisTemplate<String, ViewProduct> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, ViewProduct> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void save(ViewProduct viewProduct) {
		this.redisTemplate.opsForHash().put(PRODUCT_KEY, viewProduct.getProductBasicInfo().getId(), viewProduct);

	}

	@Override
	public ViewProduct find(UUID id) {
		return (ViewProduct) this.redisTemplate.opsForHash().get(PRODUCT_KEY, id);
	}

	@Override
	public void delete(UUID id) {
		this.redisTemplate.opsForHash().delete(PRODUCT_KEY, id);

	}

	@Override
	public Map<Object, Object> findAll() {
		return this.redisTemplate.opsForHash().entries(PRODUCT_KEY);
	}

}
