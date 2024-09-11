package org.springframework.samples.petclinic.model;

/**
 * Address
 */
@Embeddable
public class Address {

    private String detailedAddress;
    private String city;
    private String state;
    private String pincode;
}