package com.voting.voting_system.repository;

import com.voting.voting_system.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {
}
