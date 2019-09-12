package com.easybusiness.hrmanagement.id_generator;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.easybusiness.hrmanagement.constant.HRManagementConstant;

public class RecruitmentJdDetailsIdGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		return HRManagementConstant.JD + new Date().getTime();
	}

}
