package com.data.accessor.controller.definition;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.data.accessor.entity.Client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(value = "Client", description = "Clients Controller Application")
@RequestMapping("v1/clients")
public interface ClientController {
	
	public static final String REGEX_VALIDATE_NUMERIC = "^(0|[1-9][0-9]*)$";
	
	@ApiOperation(value = "Get Client by id")
	@ApiResponse(code = 200, message = "OK", response = Client.class)
	@GetMapping("{id}")
	ResponseEntity<?> getClientById(@PathVariable @Valid @Pattern(message = "Invalid Client Id " , regexp = REGEX_VALIDATE_NUMERIC) Long id);
	
	@ApiOperation(value = "Get Clients")
	@ApiResponse(code = 200, message = "Client Was Created", response = Client.class)
	@GetMapping("/all")
	ResponseEntity<List<Client>> getCLients();
	
	@ApiOperation(value = "Create Client")
	@ApiResponse(code = 201, message = "OK", response = Client.class)
	@PostMapping()
	ResponseEntity<?> createClient(@RequestBody Client client);
	
	@ApiOperation(value = "Get Client By Name")
	@ApiResponse(code = 200, message = "OK", response = Client.class)
	@GetMapping()
	ResponseEntity<?> getClientByName(@RequestParam String name,@RequestParam String lastName);
	
	@ApiOperation(value = "Update Client")
	@ApiResponse(code = 200, message = "OK", response = Client.class)
	@PutMapping()
	ResponseEntity<?> updateClient(@RequestBody @Validated(Client.ClientValidation.class) Client client);
	
	@ApiOperation(value = "Delete Client")
	@ApiResponse(code = 200, message = "OK", response = String.class)
	@DeleteMapping("/{id}")
	ResponseEntity<?> deleteClient(@PathVariable Long id);
}
