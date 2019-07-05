package com.easybusiness.hrmanagement.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.easybusiness.hrmanagement.domain.OmsActivityMaster;

@Repository
public class GetFromStoredProcedure {

	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<OmsActivityMaster> getActivityMaster() {
		return em.createNamedStoredProcedureQuery("secondProcedure").getResultList();
	}
	
	public void add(OmsActivityMaster omsActivityMaster) {
		
		em.createNamedStoredProcedureQuery("firstProcedure")
		.setParameter("p_activtyid", omsActivityMaster.getActivityNum())
		.setParameter("p_activty", omsActivityMaster.getActivity())
		.setParameter("p_modby", omsActivityMaster.getModBy())
		.setParameter("p_moddate", omsActivityMaster.getModDate()).execute();
		
		
	}
}
