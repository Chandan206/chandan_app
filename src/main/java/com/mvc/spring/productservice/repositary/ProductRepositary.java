package com.mvc.spring.productservice.repositary;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.spring.productservice.entity.ProductEntity;

public interface ProductRepositary {

	public ProductEntity saveProduct(ProductEntity entity);

	public ProductEntity findProductById(Long id);

	public List<ProductEntity> findAllProduct();

	public Integer findProductQuantityById(Long id);

	public ProductEntity deleteProductById(Long id);

	public List<ProductEntity> FindAllProductSortedByName(ProductEntity entity);

	public List<ProductEntity> getProductByName(String name);
}
