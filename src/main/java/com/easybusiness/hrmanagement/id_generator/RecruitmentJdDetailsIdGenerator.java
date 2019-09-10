package com.easybusiness.hrmanagement.id_generator;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RecruitmentJdDetailsIdGenerator implements IdentifierGenerator{

	private String prefix;
	
	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		return prefix + new Date().getTime();
	}

}
