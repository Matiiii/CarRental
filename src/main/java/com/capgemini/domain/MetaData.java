package com.capgemini.domain;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

public abstract class MetaData {

	private int version;

	@Temporal(value = TemporalType.TIMESTAMP)
	final private Date created = new Date();

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date updated;

	@PrePersist
	protected void onCreate() {

		version = 1;
	}

	@PreUpdate
	protected void onUpdate() {
		updated = new Date();
		version += 1;
	}

	public int getVersion() {
		return version;
	}

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public MetaData() {
	}

}
