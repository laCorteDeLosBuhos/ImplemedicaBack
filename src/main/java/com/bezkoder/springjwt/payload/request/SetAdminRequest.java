package com.bezkoder.springjwt.payload.request;

import java.util.Set;

public class SetAdminRequest {
	    private int id;

	    private Set<String> role;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Set<String> getRole() {
			return role;
		}

		public void setRole(Set<String> role) {
			this.role = role;
		}

	}
