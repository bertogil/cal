package com.berto.varios;

	public enum GenericStatus {
		S {
			@SuppressWarnings("unused")
			public String getActive() {
				return "ACTIVO";
			}

		},

		N {
			@SuppressWarnings("unused")
			public String getNotActive() {
				return "NO ACTIVO";
			}
		}
	}
