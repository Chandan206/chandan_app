package com.mvc.spring.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.spring.productservice.entity.ProductEntity;
import com.mvc.spring.productservice.service.imp.ProductServiceImp;

@RestController
public class ProductController {
	@Autowired

	private ProductServiceImp productServiceImp;

	@PostMapping(value = "/saveProduct")
	public ProductEntity saveProduct(@RequestBody ProductEntity entity) {
		return productServiceImp.saveProduct(entity);

	}

	@GetMapping(value = "/findProductQuantityById")
	public @ResponseBody Integer findProductQuantityById(@RequestParam("altkey") Long id) {
		return productServiceImp.findProductQuantityById(id);

	}

	@GetMapping(value = "/findProductById/{altkey}")
	public @ResponseBody ProductEntity findProductById(@PathVariable("id") Long id) {
		return productServiceImp.findProductById(id);

	}

	@GetMapping(value = "/findAllProduct")
	public @ResponseBody List<ProductEntity> findAllProduct() {
		return productServiceImp.findAllProduct();

	}

	@DeleteMapping(value = "/deleteProductById")
	public ProductEntity deleteProductById(@RequestParam Long id) {
		return productServiceImp.deleteProductById(id);

	}

	@GetMapping(value = "/FindAllProductSortedByName")
	public @ResponseBody List<ProductEntity> FindAllProductSortedByName(ProductEntity entity) {
		return productServiceImp.FindAllProductSortedByName(entity);
	}

	@GetMapping(value = "/getProductByName")
	public List<ProductEntity> getProductByName(@RequestParam("name") String name) {
		return productServiceImp.getProductByName(name);
	}

	@GetMapping(value = "/GetProductInRange")
	public List<ProductEntity> GetProductInRange(@RequestParam("lowerPrice") double lowerPrice,
			@RequestParam("higherPrice") double higherPrice) {
		return productServiceImp.GetProductInRange(lowerPrice, higherPrice);
	}

}