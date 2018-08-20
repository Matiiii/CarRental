package com.capgemini.types;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.capgemini.domain.PersonalDetail;
import com.capgemini.enums.Position;

public class EmployeeTO {

	private Long id;

	private Position position;
	private Long agency;
	private PersonalDetail personalDetail;
	private Set<Long> cars = new HashSet<>();

	private int version;
	private Date created;
	private Date updated;

	public EmployeeTO(Long id, Position position, Long agency, PersonalDetail personalDetail, Set<Long> cars,
			int version, Date created, Date updated) {
		this.id = id;
		this.position = position;
		this.agency = agency;
		this.personalDetail = personalDetail;
		this.cars = cars;
		this.version = version;
		this.created = created;
		this.updated = updated;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public PersonalDetail getPersonalDetail() {
		return personalDetail;
	}

	public void setPersonalDetail(PersonalDetail personalDetail) {
		this.personalDetail = personalDetail;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Long getAgency() {
		return agency;
	}

	public void setAgency(Long agency) {
		this.agency = agency;
	}

	public Set<Long> getCars() {
		return cars;
	}

	public void setCars(Set<Long> cars) {
		this.cars = cars;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public static EmployeeTOBuilder builder() {
		return new EmployeeTOBuilder();
	}

	public static class EmployeeTOBuilder {

		private Long id;
		private Position position;
		private PersonalDetail personalDetail;
		private Set<Long> cars = new HashSet<>();
		private Long agency;
		private int version;
		private Date created = null;
		private Date updated = null;

		public EmployeeTOBuilder() {
			super();
		}

		public EmployeeTOBuilder cars(Set<Long> cars) {
			this.cars.addAll(cars);
			return this;
		}

		public EmployeeTOBuilder personalDetail(PersonalDetail personalDetail) {
			this.personalDetail = personalDetail;
			return this;
		}

		public EmployeeTOBuilder position(Position position) {
			this.position = position;
			return this;
		}

		public EmployeeTOBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public EmployeeTOBuilder agency(Long agency) {
			this.agency = agency;
			return this;
		}

		public EmployeeTOBuilder version(int version) {
			this.version = version;
			return this;
		}

		public EmployeeTOBuilder created(Date created) {
			this.created = created;
			return this;
		}

		public EmployeeTOBuilder updated(Date updated) {
			this.updated = updated;
			return this;
		}

		public EmployeeTO build() {
			checkBeforeBuild(personalDetail);
			return new EmployeeTO(id, position, agency, personalDetail, cars, version, created, updated);
		}

		private void checkBeforeBuild(PersonalDetail personalDetail) {
			if (!personalDetail.checkPersonalDetail()) {
				throw new RuntimeException("Incorrect Person to be created");
			}

		}

	}

	@Override
	public String toString() {
		return "EmployeeTO [id=" + id + ", position=" + position + ", agency=" + agency + ", personalDetail="
				+ personalDetail + ", cars=" + cars + ", version=" + version + ", created=" + created + ", updated="
				+ updated + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agency == null) ? 0 : agency.hashCode());
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((personalDetail == null) ? 0 : personalDetail.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + version;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeTO other = (EmployeeTO) obj;
		if (agency == null) {
			if (other.agency != null)
				return false;
		} else if (!agency.equals(other.agency))
			return false;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (personalDetail == null) {
			if (other.personalDetail != null)
				return false;
		} else if (!personalDetail.equals(other.personalDetail))
			return false;
		if (position != other.position)
			return false;
		if (version != other.version)
			return false;
		return true;
	}

}
