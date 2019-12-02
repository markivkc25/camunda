package com.cognizant.eas.ipm.camunda.cc.app.data;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the "PROMOTIONS" database table.
 * 
 */
@Entity
@Table(name="\"PROMOTIONS\"")
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"ID\"", nullable=false)
	private Integer id;

	@Column(name="\"PROMO_CODE\"", nullable=false, length=12)
	@Id
	private String promoCode;

	@Column(name="\"PROMO_DESC\"", length=400)
	private String promoDesc;

	@Column(name="\"PROMO_EXPIRATION_TS\"", nullable=false)
	private Timestamp promoExpirationTs;

	public Promotion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPromoCode() {
		return this.promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getPromoDesc() {
		return this.promoDesc;
	}

	public void setPromoDesc(String promoDesc) {
		this.promoDesc = promoDesc;
	}

	public Timestamp getPromoExpirationTs() {
		return this.promoExpirationTs;
	}

	public void setPromoExpirationTs(Timestamp promoExpirationTs) {
		this.promoExpirationTs = promoExpirationTs;
	}

}