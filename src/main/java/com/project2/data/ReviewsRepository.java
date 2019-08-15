package com.project2.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReviewsRepository {

	@Autowired
	private EntityManager entityManager;
	
	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	public List<Reviews> getReviews(String animename){
		Query<Reviews> q = null;
		q = getSession().createQuery("SELECT c FROM Reviews c WHERE c.animename = :animename", Reviews.class);
		List<Reviews> reviews = null;
		try {
			reviews = q.setParameter("animename", animename).getResultList();
		} catch (NoResultException e) {
			System.out.println("review not found");
		}
		return reviews;
	}
	
	public void storeReview(Reviews review) {
		getSession().save(review);
	}
}
