package com.example.jpalearning.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jpalearning.dao.ProductDao;
import com.example.jpalearning.entity.Product;
import com.example.jpalearning.repo.ProductRepositery;

@Repository
public class ProductDaoImpl implements ProductDao {
	private ProductRepositery prrepo;

	@Autowired
	public ProductDaoImpl(ProductRepositery prrepo) {
		super();
		this.prrepo = prrepo;
	}

	@Override
	public Product saveProduct(Product pr) {
		pr = prrepo.save(pr);
		return pr;
	}

	@Override
	public List<Product> fetchAllProdcut() {
		return prrepo.findAll();
	}

	@Override
	public Optional<Product> getProdById(Integer id) {
		return prrepo.findById(id);
	}

	@Override
	public List<Product> getProdByName(String name) {
		return prrepo.findByPrName(name);
	}

}
