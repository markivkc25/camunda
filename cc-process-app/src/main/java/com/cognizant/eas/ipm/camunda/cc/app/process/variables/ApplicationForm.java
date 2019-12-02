package com.cognizant.eas.ipm.camunda.cc.app.process.variables;

import java.util.Objects;
import org.springframework.stereotype.Component;

/**
 * ApplicationForm
 */
@Component("applicationForm")
public class ApplicationForm implements java.io.Serializable{

	private Long id = null;

	/**
	 * Gets or Sets overAllStatus
	 */
	public enum OverAllStatusEnum {
		APPROVED("Approved"),

		DENIED("Denied"),

		UNDERREVIEW("UnderReview"),

		ONHOLD("OnHold");

		private String value;

		OverAllStatusEnum(String value) {
			this.value = value;
		}

		public String toString() {
			return String.valueOf(value);
		}

		public static OverAllStatusEnum fromValue(String text) {
			for (OverAllStatusEnum b : OverAllStatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	private OverAllStatusEnum overAllStatus = null;

	private Applicant applicant = null;

	private Reference reference = null;

	private Boolean existingCustomer = null;

	public ApplicationForm id(Long id) {
		this.id = id;
		return this;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ApplicationForm overAllStatus(OverAllStatusEnum overAllStatus) {
		this.overAllStatus = overAllStatus;
		return this;
	}


	public OverAllStatusEnum getOverAllStatus() {
		return overAllStatus;
	}

	public void setOverAllStatus(OverAllStatusEnum overAllStatus) {
		this.overAllStatus = overAllStatus;
	}

	public ApplicationForm applicant(Applicant applicant) {
		this.applicant = applicant;
		return this;
	}


	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public ApplicationForm reference(Reference reference) {
		this.reference = reference;
		return this;
	}



	public Reference getReference() {
		return reference;
	}

	public void setReference(Reference reference) {
		this.reference = reference;
	}

	public ApplicationForm isExistingCustomer(Boolean isExistingCustomer) {
		this.existingCustomer = isExistingCustomer;
		return this;
	}


	public Boolean isExistingCustomer() {
		return existingCustomer;
	}

	public void setExistingCustomer(Boolean isExistingCustomer) {
		this.existingCustomer = isExistingCustomer;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ApplicationForm applicationForm = (ApplicationForm) o;
		return Objects.equals(this.id, applicationForm.id)
				&& Objects.equals(this.overAllStatus, applicationForm.overAllStatus)
				&& Objects.equals(this.applicant, applicationForm.applicant)
				&& Objects.equals(this.reference, applicationForm.reference)
				&& Objects.equals(this.existingCustomer, applicationForm.existingCustomer);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, overAllStatus, applicant, reference, existingCustomer);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ApplicationForm {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    overAllStatus: ").append(toIndentedString(overAllStatus)).append("\n");
		sb.append("    applicant: ").append(toIndentedString(applicant)).append("\n");
		sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
		sb.append("    existingCustomer: ").append(toIndentedString(existingCustomer)).append("\n");
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
