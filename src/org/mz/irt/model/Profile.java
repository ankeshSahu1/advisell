/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mz.irt.model;

import java.util.ArrayList;

/**
 *
 * @author metazone
 */
public class Profile {

    private String firstName;
    private String lastName;
    private String gender;
    private String emailId;
    private String PhoneNumber;
    private String contactNumber;
    private String city;
    private String state;
    private String pinNumber;
    private String address;
    private String aadharCardNumber;
    private String PanNumber;
    private ArrayList<Document> documentList;

    public ArrayList<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(ArrayList<Document> documentList) {
        this.documentList = documentList;
    }
    
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getPanNumber() {
        return PanNumber;
    }

    public void setPanNumber(String PanNumber) {
        this.PanNumber = PanNumber;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getAadharCardNumber() {
        return aadharCardNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAadharCardNumber(String aadharCardNumber) {
        this.aadharCardNumber = aadharCardNumber;
    }

}
