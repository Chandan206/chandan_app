package com.mvc.spring.productservice.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.spring.productservice.entity.ProductEntity;

public interface ProductService {

	public ProductEntity saveProduct(ProductEntity entity);

	public ProductEntity findProductById(Long id);

	public List<ProductEntity> findAllProduct();

	public Integer findProductQuantityById(Long id);

	public ProductEntity deleteProductById(Long id);

	public List<ProductEntity> getProductByName(String name);
	// public List<ProductEntity> FindALLproductSortedByName();

}
