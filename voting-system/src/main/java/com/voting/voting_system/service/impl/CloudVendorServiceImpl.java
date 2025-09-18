package com.voting.voting_system.service.impl;

import com.voting.voting_system.model.CloudVendor;
import com.voting.voting_system.repository.CloudVendorRepository;
import com.voting.voting_system.service.CloudVendorService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        //More Business Logic
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success ";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }

    @Transactional
    public CloudVendor vote(String vendorId){
        CloudVendor vote = cloudVendorRepository.findById(vendorId).orElseThrow();
        vote.setVotes(vote.getVotes() + 1);
        return vote;
    }

}
