package com.course.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.course.entity.UsersEntity;

import jakarta.persistence.Query;

@Repository
public class UsersDao {

	@SuppressWarnings("unchecked")
	public UsersEntity findByUsername(String username) {
		Session session = getDbConnection();
		String sql = "select u from UsersEntity u where u.username = ?1";
		Query query = session.createQuery(sql, UsersEntity.class);
		query.setParameter(1, username);
		
		List<UsersEntity> users = query.getResultList();
		
		return users != null && users.size() > 0 ? users.get(0) : null;
	}
	
	
	private Session getDbConnection() {
	    Configuration configuration = new Configuration().configure();
	    SessionFactory sessionFactory = configuration.buildSessionFactory();
	    Session session = sessionFactory.openSession();
	    return session;
	}

}
