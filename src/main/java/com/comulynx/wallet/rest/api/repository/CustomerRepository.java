package com.comulynx.wallet.rest.api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.comulynx.wallet.rest.api.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByCustomerId(String customerId);

	@Modifying
	@Query("DELETE FROM Customer c WHERE c.id = :customer_id")
  	int deleteCustomerByCustomerId(@Param("customer_id") String customer_id);


	@Modifying
	@Query("UPDATE Customer c SET c.firstName = :first_name WHERE c.id = :customer_id")
	int updateCustomerByCustomerId(@Param("first_name") String firstName, @Param("customer_id") String customer_id);

	 @Query("SELECT c FROM Customer c WHERE c.email LIKE '%gmail%' ")
	 List<Customer> findAllCustomersWhoseEmailContainsGmail();

	 Optional<Customer> findByUsername(String username);
}
