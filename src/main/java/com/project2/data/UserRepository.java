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
public class UserRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	public List<Users> getAllUsers(){
		return getSession().createQuery("From Users", Users.class).list();
	}
	
	public Users getUser(String username) throws NoResultException {
		Query<Users> q = null;
		Users returnUser = null;
		q = getSession().createQuery("SELECT c FROM Users c WHERE c.username = :username", Users.class);
		try {
			returnUser = q.setParameter("username", username).getSingleResult();
		} catch (NoResultException e) {
			System.out.println("User not found");
		}
		return returnUser;
	}
	
	public void storeUser(Users user) {
		getSession().save(user);
	}
	
	public boolean doesUserExist(String username) throws NoResultException{
		Query<Users> q = null;
		Users user = null;
		q = getSession().createQuery("SELECT c FROM Users c WHERE c.username = :username", Users.class);
		try {
			user = q.setParameter("username", username).getSingleResult();
			if(user.getUsername().equals(username))
				return true;
			else
				return false;
		} catch (NoResultException e) {
			return false;
		}
	}

}
