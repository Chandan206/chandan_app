package com.mvc.spring.productservice.repositary;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.spring.productservice.entity.ProductEntity;

@Repository
@Transactional
public class ProductRepositoryImp implements ProductRepositary {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ProductEntity saveProduct(ProductEntity entity) {
		try {

			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} catch (Exception e) {

		}
		return entity;
	}

	@Override
	public ProductEntity findProductById(Long id) {
		StringBuilder builder = new StringBuilder();
		builder.append(" from ProductEntity where ");
		builder.append("altkey=:id");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(builder.toString());
		query.setParameter("id", id);
		return (ProductEntity) query.uniqueResult();
	}

	@Override
	public List<ProductEntity> findAllProduct() {

		String hqlQuery = "from ProductEntity";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hqlQuery);
		return query.getResultList();

	}

	@Override
	public Integer findProductQuantityById(Long id) {
		Session session = sessionFactory.openSession();
		String query =(" select quantity from ProductEntity where altkey=:id ");
		Query qu = session.createQuery(query);
		qu.setParameter("id", id);
		return (Integer) qu.uniqueResult();
	}

	@Override
	public ProductEntity deleteProductById(Long id) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		ProductEntity entity = session.find(ProductEntity.class, id);
		session.delete(entity);
		transaction.commit();
		return entity;

	}

	@Override
	public List<ProductEntity> FindAllProductSortedByName(ProductEntity entity) {

		
			Session session = sessionFactory.openSession();
			String hql="FROM ProductEntity ORDER BY name ASC";
			Query query = session.createQuery(hql);
			return query.getResultList();
	}

	@Override
	public List<ProductEntity> getProductByName(String name) {

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from ProductEntity where name=:name");
		query.setParameter("name", name);
		return query.getResultList();

	}

	public List<ProductEntity> GetProductInRange(double lowerPrice, double higherPrice) {
		String hqlQuery = "from ProductEntity where price between :lowerPrice and :higherPrice";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hqlQuery);
		query.setParameter("lowerPrice", lowerPrice);
		query.setParameter("higherPrice", higherPrice);
		return query.getResultList();

	}

}
