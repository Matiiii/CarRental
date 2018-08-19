package com.capgemini.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public abstract class MetaData {

	private int version;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Timestamp created;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Timestamp updated;

	@PrePersist
	protected void onCreate() {
		created = new Timestamp(new Date().getTime());
		version = 1;
	}

	@PostUpdate
	protected void onUpdate() {
		updated = new Timestamp(new Date().getTime());
		version += 1;
	}

	public int getVersion() {
		return version;
	}

	public Timestamp getCreated() {
		return created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public MetaData() {
	}

}
