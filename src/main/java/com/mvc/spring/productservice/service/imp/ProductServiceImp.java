package com.mvc.spring.productservice.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.spring.productservice.entity.ProductEntity;
import com.mvc.spring.productservice.repositary.ProductRepositoryImp;
import com.mvc.spring.productservice.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepositoryImp productRepositoryImp;

	@Override
	public ProductEntity saveProduct(ProductEntity entity) {

		return productRepositoryImp.saveProduct(entity);
	}

	@Override
	public ProductEntity findProductById(Long id) {

		return productRepositoryImp.findProductById(id);
	}

	@Override
	public List<ProductEntity> findAllProduct() {
		return productRepositoryImp.findAllProduct();
	}

	@Override
	public Integer findProductQuantityById(Long id) {

		return productRepositoryImp.findProductQuantityById(id);
	}

	@Override
	public ProductEntity deleteProductById(Long id) {

		return productRepositoryImp.deleteProductById(id);
	}

//	@Override
//	public List<ProductEntity> FindALLproductSortedByName() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public List<ProductEntity> FindAllProductSortedByName(ProductEntity entity) {
		return productRepositoryImp.FindAllProductSortedByName(entity);
	}

	@Override
	public List<ProductEntity> getProductByName(String name) {

		return productRepositoryImp.getProductByName(name);
	}

	public List<ProductEntity> GetProductInRange(double lowerPrice, double higherPrice) {
		// TODO Auto-generated method stub
		return productRepositoryImp.GetProductInRange(lowerPrice, higherPrice);
	}

}
