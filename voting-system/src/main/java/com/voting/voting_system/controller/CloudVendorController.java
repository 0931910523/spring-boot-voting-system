package com.voting.voting_system.controller;

import com.voting.voting_system.model.CloudVendor;
import com.voting.voting_system.service.CloudVendorService;
import com.voting.voting_system.service.impl.CloudVendorServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    //Read Specific Vendor Details from DB
    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return cloudVendorService.getCloudVendor(vendorId);
                //new CloudVendor("C1", "Vendor 1", "Address One", "xxxxx");
    }

    //Read All Vendor Details from DB
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Create Successfully";
    }

    public CloudVendor vote(String vendorId){
        return cloudVendorService.vote(vendorId);
    }


    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor Updated Successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor Deleted Successfully";
    }
}
