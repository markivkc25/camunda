package com.cognizant.eas.ipm.camunda.cc.app.process.variables;

import java.util.Objects;

/**
 * Address
 */


public class Address   {

  private Long id = null;

  
  private String homeType = null;


  private String streetAddress = null;


  private String apt = null;


  private String city = null;


  private String state = null;


  private String zipCode = null;

  public Address id(Long id) {
    this.id = id;
    return this;
  }

 


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Address homeType(String homeType) {
    this.homeType = homeType;
    return this;
  }




  public String getHomeType() {
    return homeType;
  }

  public void setHomeType(String homeType) {
    this.homeType = homeType;
  }

  public Address streetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
    return this;
  }




  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public Address apt(String apt) {
    this.apt = apt;
    return this;
  }


  public String getApt() {
    return apt;
  }

  public void setApt(String apt) {
    this.apt = apt;
  }

  public Address city(String city) {
    this.city = city;
    return this;
  }


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Address state(String state) {
    this.state = state;
    return this;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Address zipCode(String zipCode) {
    this.zipCode = zipCode;
    return this;
  }



  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.id, address.id) &&
        Objects.equals(this.homeType, address.homeType) &&
        Objects.equals(this.streetAddress, address.streetAddress) &&
        Objects.equals(this.apt, address.apt) &&
        Objects.equals(this.city, address.city) &&
        Objects.equals(this.state, address.state) &&
        Objects.equals(this.zipCode, address.zipCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, homeType, streetAddress, apt, city, state, zipCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    homeType: ").append(toIndentedString(homeType)).append("\n");
    sb.append("    streetAddress: ").append(toIndentedString(streetAddress)).append("\n");
    sb.append("    apt: ").append(toIndentedString(apt)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

