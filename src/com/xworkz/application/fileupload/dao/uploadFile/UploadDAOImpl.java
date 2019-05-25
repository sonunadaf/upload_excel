package com.xworkz.application.fileupload.dao.uploadFile;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.application.fileupload.entity.uploadFile.UploadEntity;
import com.xworkz.application.fileupload.exception.DAOException;

@Repository
public class UploadDAOImpl implements IUploadDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer save(UploadEntity uploadEntity) throws DAOException {

		Session session = null;
		Transaction transaction = null;
		Integer pk = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			pk = (Integer) session.save(uploadEntity);
			transaction.commit();
		} catch (HibernateException e) {
			System.err.println("Hibernate Exception from DAO " + e.getMessage());
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			System.err.println("Hibernate Exception from DAO " + e.getMessage());
			throw new DAOException(e.getMessage());
		}

		return pk;
	}

}
