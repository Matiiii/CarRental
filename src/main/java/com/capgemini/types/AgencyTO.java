package com.capgemini.types;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.capgemini.domain.Address;

public class AgencyTO {

	private Long id;
	private Address address;
	private Set<Long> employees = new HashSet<>();

	private int version;
	private Date created;
	private Date updated;

	public AgencyTO() {
	}

	public AgencyTO(Long id, Address address, Set<Long> employees, int version, Date created, Date updated) {
		this.id = id;
		this.address = address;
		this.employees = employees;
		this.version = version;
		this.created = created;
		this.updated = updated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Long> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Long> employees) {
		this.employees = employees;
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

	public static AgencyTOBuilder builder() {
		return new AgencyTOBuilder();
	}

	public static class AgencyTOBuilder {

		private Long id;
		private Address address;
		private Set<Long> employees = new HashSet<>();
		private int version;
		private Date created = null;
		private Date updated = null;

		public AgencyTOBuilder() {
			super();
		}

		public AgencyTOBuilder employees(Set<Long> employeesToAdded) {
			this.employees.addAll(employeesToAdded);
			return this;
		}

		public AgencyTOBuilder address(Address address) {
			this.address = address;
			return this;
		}

		public AgencyTOBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public AgencyTOBuilder version(int version) {
			this.version = version;
			return this;
		}

		public AgencyTOBuilder created(Date created) {
			this.created = created;
			return this;
		}

		public AgencyTOBuilder updated(Date updated) {
			this.updated = updated;
			return this;
		}

		public AgencyTO build() {
			checkBeforeBuild(address);
			return new AgencyTO(id, address, employees, version, created, updated);
		}

		private void checkBeforeBuild(Address address) {
			if (!address.checkAddress()) {
				throw new RuntimeException("Incorrect Agency to be created");
			}

		}

	}

	@Override
	public String toString() {
		return "AgencyTO [id=" + id + ", address=" + address + ", employees=" + employees + ", version=" + version
				+ ", created=" + created + ", updated=" + updated + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AgencyTO other = (AgencyTO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
