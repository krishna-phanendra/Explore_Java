package com.nk.ssampleprj;

import java.util.Date;

public class PolicyRequest {

	private String policyId;

	private Date policyStartDate;

	private InsuredPersons[] insuredPersons;

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public Date getPolicyStartDate() {
		return policyStartDate;
	}

	public void setPolicyStartDate(Date policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	public InsuredPersons[] getInsuredPersons() {
		return insuredPersons;
	}

	public void setInsuredPersons(InsuredPersons[] insuredPersons) {
		this.insuredPersons = insuredPersons;
	}

}
