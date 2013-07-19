/**
 * ******************************************************************************************
 * Copyright (C) 2012 - Food and Agriculture Organization of the United Nations
 * (FAO). All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,this
 * list of conditions and the following disclaimer. 2. Redistributions in binary
 * form must reproduce the above copyright notice,this list of conditions and
 * the following disclaimer in the documentation and/or other materials provided
 * with the distribution. 3. Neither the name of FAO nor the names of its
 * contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT,STRICT LIABILITY,OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
 * IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * *********************************************************************************************
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.ejb.application.repository.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import org.sola.services.common.repository.ChildEntity;
import org.sola.services.common.repository.ExternalEJB;
import org.sola.services.common.repository.entities.AbstractVersionedEntity;
import org.sola.services.ejb.address.businesslogic.AddressEJBLocal;
import org.sola.services.ejb.address.repository.entities.Address;

/**
 * Entity representing the application.application_property table.
 *
 * @author soladev
 */
@Table(name = "application_property", schema = "application")
public class ApplicationProperty extends AbstractVersionedEntity {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "application_id")
    private String applicationId;
    @Column(name = "name_firstpart")
    private String nameFirstpart;
    @Column(name = "name_lastpart")
    private String nameLastpart;
    @Column(name = "area")
    private BigDecimal area;
    @Column(name = "total_value")
    private BigDecimal totalValue;
    @Column(name = "verified_exists")
    private boolean verifiedExists;
    @Column(name = "verified_location")
    private boolean verifiedLocation;
    @Column(name = "ba_unit_id")
    private String baUnitId;
    @Column(name = "land_use_code")
    private String landUseCode;
    
    //new additions by wandechris
    @Column(name = "development_stage")
    private String developmentStageCode;
    @Column(name = "capacity_in_which_property_is_owned")
    private String capacityTypeCode;
    @Column(name = "location_of_property")
    private String propertyLocation;
    @Column(name = "property_duration")
    private String propertyDuration;
    
    @ExternalEJB(ejbLocalClass = AddressEJBLocal.class,
    loadMethod = "getAddress", saveMethod = "saveAddress")
    @ChildEntity(childIdField = "addressId")
    private Address address;
    //

    public ApplicationProperty() {
        super();
    }

    public String getLandUseCode() {
        return landUseCode;
    }

    public void setLandUseCode(String landUseCode) {
        this.landUseCode = landUseCode;
    }

    public String getId() {
        id = id == null ? generateId() : id;
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public String getBaUnitId() {
        return baUnitId;
    }

    public void setBaUnitId(String baUnitId) {
        this.baUnitId = baUnitId;
    }

    public String getNameFirstpart() {
        return nameFirstpart;
    }

    public void setNameFirstpart(String nameFirstpart) {
        this.nameFirstpart = nameFirstpart;
    }

    public String getNameLastpart() {
        return nameLastpart;
    }

    public void setNameLastpart(String nameLastpart) {
        this.nameLastpart = nameLastpart;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public boolean isVerifiedExists() {
        return verifiedExists;
    }

    public void setVerifiedExists(boolean verifiedExists) {
        this.verifiedExists = verifiedExists;
    }

    public boolean isVerifiedLocation() {
        return verifiedLocation;
    }

    public void setVerifiedLocation(boolean verifiedLocation) {
        this.verifiedLocation = verifiedLocation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        if (address != null) {
            this.setPropertyLocation(address.getId());
        }
    }

    public String getCapacityTypeCode() {
        return capacityTypeCode;
    }

    public void setCapacityTypeCode(String capacityTypeCode) {
        this.capacityTypeCode = capacityTypeCode;
    }

    public String getDevelopmentStageCode() {
        return developmentStageCode;
    }

    public void setDevelopmentStageCode(String developmentStageCode) {
        this.developmentStageCode = developmentStageCode;
    }

    public String getPropertyDuration() {
        return propertyDuration;
    }

    public void setPropertyDuration(String propertyDuration) {
        this.propertyDuration = propertyDuration;
    }

    public String getPropertyLocation() {
        return propertyLocation;
    }

    public void setPropertyLocation(String propertyLocation) {
        this.propertyLocation = propertyLocation;
    }
    
    
}
