package com.darekzon.shoppinglist.repository;

import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;

import com.darekzon.shoppinglist.model.Product;
import com.darekzon.shoppinglist.model.ProductsList;
import com.darekzon.shoppinglist.mongoose.EntityManager;
import com.darekzon.shoppinglist.mongoose.Sendmail;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ProductListRepositoryImpl implements ProductListRepository{

	private Sendmail mailer;
	
	private EntityManager em;
	
	@Inject
	public ProductListRepositoryImpl(Provider<EntityManager> em,Provider<Sendmail> mail) {
		this.em = em.get();
		this.mailer = mail.get();
	}

	@Override
	public void create(String email) {
		Random r = new Random();
		int code = 10000+Math.abs(r.nextInt())%100000;
		StringBuffer sb = new StringBuffer(mailer.getProperty("mail.message"));
		int codeStart = sb.indexOf("[ACCESS_CODE]");
		
		ProductsList pr = new ProductsList();
		pr.setEmail(email);
		pr.setCode(String.valueOf(code));
		em.create(pr);
		
		sb.replace(codeStart, codeStart+"[ACCESS_CODE]".length(), String.valueOf(code));
		try {
			mailer.sendMail(email, "Shopping list User", "new Shopping list", sb.toString());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addProduct(ProductsList pr, Product p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ProductsList pr) {
		//em.
		
	}

	@Override
	public void deleteProduct(ProductsList pr, Product p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
