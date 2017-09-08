/*
 * Copyright (C) 2017 Metazone Infotech Pvt Ltd
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.mz.advisell.bean;

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
    private String contactNumber;
    private String phoneNumber;
    private String city;
    private String state;
    private String pinNumber;
    private String address;
    private String aadharCardNumber;
    private String PanNumber;
    private ArrayList<Document> documentList;
    private ArrayList<Investment> investmentList;
    
    public Profile(){
        documentList = new ArrayList<>();
        investmentList = new ArrayList<>();
    }

    public ArrayList<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(ArrayList<Document> documentList) {
        this.documentList = documentList;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public ArrayList<Investment> getInvestmentList() {
        return investmentList;
    }

    public void setInvestmentList(ArrayList<Investment> investmentList) {
        this.investmentList = investmentList;
    }

}
