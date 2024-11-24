package com.enums;

public enum Severity {
	
	CRITICAL(1), MAJOR(2),MINOR(3),LOW(4);
	
	private int fixingHours;
	

	private Severity(int hours) {
		fixingHours = hours;
	}

	public int getFixingHours() {
		return fixingHours;
	}

	public void setFixingHours(int hours) {
		fixingHours = hours;
	}
	
	
	
	/*
	
	CRITICAL {
		@Override
		public String asLowerCase() {
			// TODO Auto-generated method stub
			return null;
		}
	},
	MAJOR {
		@Override
		public String asLowerCase() {
			// TODO Auto-generated method stub
			return null;
		}
	},
	LOW {
		@Override
		public String asLowerCase() {
			// TODO Auto-generated method stub
			return null;
		}
	},
	HIGH {
		@Override
		public String asLowerCase() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	public abstract String asLowerCase();
	
	//also cant extend any class because by default extends enum class
	
	*/

}

