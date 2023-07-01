package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customers, String> {
	Customers findByEmail(String email);
	
	@Query("SELECT c FROM Customers c WHERE c.email LIKE %?1%"
			+" OR c.name LIKE %?1%"
			+" OR c.contact LIKE %?1%"
			+" OR c.address LIKE %?1%")
	public List<Customers> searchCustomer(String keyword);
}
