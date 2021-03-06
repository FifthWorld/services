/**
 * ******************************************************************************************
 * Copyright (C) 2012 - Food and Agriculture Organization of the United Nations (FAO).
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice,this list
 *       of conditions and the following disclaimer.
 *    2. Redistributions in binary form must reproduce the above copyright notice,this list
 *       of conditions and the following disclaimer in the documentation and/or other
 *       materials provided with the distribution.
 *    3. Neither the name of FAO nor the names of its contributors may be used to endorse or
 *       promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,PROCUREMENT
 * OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,STRICT LIABILITY,OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * *********************************************************************************************
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.ejb.party.repository.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import org.sola.services.common.repository.ChildEntity;
import org.sola.services.common.repository.ChildEntityList;
import org.sola.services.common.repository.DefaultSorter;
import org.sola.services.common.repository.ExternalEJB;
import org.sola.services.common.repository.entities.AbstractVersionedEntity;
import org.sola.services.ejb.address.businesslogic.AddressEJBLocal;
import org.sola.services.ejb.address.repository.entities.Address;

/**
 * Entity representing the party.party table. 
 */
@Table(name = "party", schema = "party")
@DefaultSorter(sortString="name, last_name")
public class Party extends AbstractVersionedEntity {

    public static final String TYPE_CODE_NON_NATURAL_PERSON = "nonNaturalPerson";
    public static final String TYPE_CODE_NATURAL_PERSON = "naturalPerson";
    public static final String QUERY_WHERE_BYTYPECODE = "type_code = #{partyTypeCode}";
    public static final String QUERY_WHERE_LODGING_AGENTS = "party.id in (select party_id from party.party_role where party.party_role.type_code = 'lodgingAgent')";
    
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "fathers_name")
    private String fathersName;
    @Column(name = "fathers_last_name")
    private String fathersLastName;
    @Column(name = "alias")
    private String alias;
    @Column(name = "ext_id")
    private String extId;
    @Column(name = "id_number")
    private String idNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "phone")
    private String phone;
    @Column(name = "fax")
    private String fax;
    @Column(name = "address_id")
    private String addressId;
    @Column(name = "id_type_code")
    private String idTypeCode;
    @Column(name = "preferred_communication_code")
    private String preferredCommunicationCode;
    @Column(name = "type_code")
    private String typeCode;
    @Column(name = "gender_code")
    private String genderCode;
    @ExternalEJB(ejbLocalClass = AddressEJBLocal.class,
    loadMethod = "getAddress", saveMethod = "saveAddress")
    @ChildEntity(childIdField = "addressId")
    private Address address;
    @ChildEntityList(parentIdField = "partyId")
    private List<PartyRole> roleList;
    @Column(name = "party.is_rightholder(id) AS is_rightholder", insertable=false, updatable=false)
    private boolean rightHolder;
    
    @ExternalEJB(ejbLocalClass = AddressEJBLocal.class,
    loadMethod = "getAddress", saveMethod = "saveAddress")
    @ChildEntity(childIdField = "employer_address_id")
    private Address employerAddress;

    //modified by wandechris
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    
     @ExternalEJB(ejbLocalClass = AddressEJBLocal.class,
    loadMethod = "getAddress", saveMethod = "saveAddress")
    @ChildEntity(childIdField = "present_home_address_id")
     private Address presentAddress;
    
     //Newly added columns start below update by friday
    @Column(name = "state_code")
    private String state_code;
    @Column(name = "home_town")
    private String homeTown;
    @Column(name = "lga_id")
    private String lga_code;
    @Column(name = "present_home_address_id")
    private String present_home_address_id;   
    @Column(name = "corporate_name")
    private String corporate_name;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "employer_name")
    private String employerName;
    @Column(name = "employer_address_id")
    private String employer_address_id;
    
    public Party() {
        super();
    }

    public String getId() {
        id = id == null ? generateId() : id;
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getFathersLastName() {
        return fathersLastName;
    }

    public void setFathersLastName(String fathersLastName) {
        this.fathersLastName = fathersLastName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getExtId() {
        return extId;
    }

    public void setExtId(String extId) {
        this.extId = extId;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getPreferredCommunicationCode() {
        return preferredCommunicationCode;
    }

    public void setPreferredCommunicationCode(String preferredCommunicationCode) {
        this.preferredCommunicationCode = preferredCommunicationCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        if (address != null) {
            this.setAddressId(address.getId());
        }
    }

    public List<PartyRole> getRoleList() {
        roleList = roleList == null ? new ArrayList<PartyRole>() : roleList;
        return roleList;
    }

    public void setRoleList(List<PartyRole> roleList) {
        this.roleList = roleList;
    }

    public String getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    public String getIdTypeCode() {
        return idTypeCode;
    }

    public void setIdTypeCode(String idTypeCode) {
        this.idTypeCode = idTypeCode;
    }

    public boolean isRightHolder() {
        return rightHolder;
    }

    public void setRightHolder(boolean rightHolder) {
        this.rightHolder = rightHolder;
    }
    
    //modified by Friday

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    //added by wandechris

    public String getCorporate_name() {
        return corporate_name;
    }

    public void setCorporate_name(String corporate_name) {
        this.corporate_name = corporate_name;
    }

    public String getEmployer_address_id() {
        return employer_address_id;
    }

    public void setEmployer_address_id(String employer_address_id) {
        this.employer_address_id = employer_address_id;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public Address getEmployerAddress() {
        return employerAddress;
    }

    public void setEmployerAddress(Address employerAddress) {
        this.employerAddress = employerAddress;
        if (employerAddress != null) {
            this.setEmployer_address_id(employerAddress.getId());
        }
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getLga_code() {
        return lga_code;
    }

    public void setLga_code(String lga_code) {
        this.lga_code = lga_code;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Address getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(Address presentAddress) {
        this.presentAddress = presentAddress;
        if (presentAddress != null) {
            this.setPresent_home_address_id(presentAddress.getId());
        }
    }

    public String getPresent_home_address_id() {
        return present_home_address_id;
    }

    public void setPresent_home_address_id(String present_home_address_id) {
        this.present_home_address_id = present_home_address_id;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }
    
    
}
