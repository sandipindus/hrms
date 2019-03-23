package com.easybusiness.hrmanagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.easybusiness.hrmanagement.domain.VisaDocument;

public interface VisaDocumentRepository extends CrudRepository<VisaDocument, Long>{
	public List<VisaDocument> findByvisaID(Long id);
}
