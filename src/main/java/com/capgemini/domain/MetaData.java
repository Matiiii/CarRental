package com.capgemini.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import lombok.Data;

@Data
public abstract class MetaData {

	@Version
	@Column(nullable = true)
	private int version;

	@Column(nullable = true)
	private Timestamp created;

	@Column(nullable = true)
	private Timestamp updated;

	@PrePersist
	protected void onCreate() {
		created = new Timestamp(new Date().getTime());
		version = 1;
	}

	@PreUpdate
	protected void onUpdate() {
		updated = new Timestamp(new Date().getTime());
		version += 1;
	}

}
