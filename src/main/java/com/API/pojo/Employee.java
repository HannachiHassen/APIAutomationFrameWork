package com.API.pojo;

import lombok.Builder;
import lombok.Getter;

@Builder (setterPrefix = "set")
@Getter
public final class Employee {
	
	private int id;
	private String fname;
	private String lname;
}
