package com.data.accessor.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {

	private String street;
	private Long  number;
}
