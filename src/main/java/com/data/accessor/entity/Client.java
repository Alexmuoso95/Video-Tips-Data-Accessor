package com.data.accessor.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "client")
@NamedQuery(name = "client_find_all" , query = "FROM client" )
public class Client {
	//interface created to group and validate.
	public interface ClientValidation{}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "Client Id Can Not Be Empty" , groups= {Client.ClientValidation.class})
	private Long id;
	@NotEmpty(message = "Client name Can Not Be Empty")
	private String name;
	@NotEmpty(message = "Client lastName Can Not Be Empty")
	private String lastName;
	@Column()
	private Long phoneNumber;
	@Column()
	private Address address;
}
