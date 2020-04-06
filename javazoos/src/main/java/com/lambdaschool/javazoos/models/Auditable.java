package com.lambdaschool.javazoos.models;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class Auditable {
	@CreatedBy
	protected String createdby;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createddate;
	
	@LastModifiedBy
	protected String lastmodifiedby;
	
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastmodifieddate;

}
