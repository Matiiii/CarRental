package com.capgemini.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
<<<<<<< HEAD
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import lombok.Data;

@Data
public abstract class MetaData {

	@Version
=======
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MetaData {

>>>>>>> 1cf9227fac64f7c55c790189c3bc7517cfd9d7af
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
