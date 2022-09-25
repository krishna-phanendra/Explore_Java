package com.nk.ssampleprj;

import java.util.Date;

public class PolicyManagementService {

	public PolicyResponse createPolicy(PolicyRequest policyRequest) {
		double totalPremium = 0;

		InsuredPersons[] insuredPersons = policyRequest.getInsuredPersons();
		for (InsuredPersons insuredPerson : insuredPersons) {
			totalPremium = totalPremium + insuredPerson.getPremium();
		}
		
		String policyId = "policy_1";
		PolicyResponse policyResponse = new PolicyResponse();
		policyResponse.setPolicyId(policyId);
		policyResponse.setInsuredPersons(insuredPersons);
		policyResponse.setTotalPremium(totalPremium);
		
		String json = "convert policyResponse to JSON";
		
		PolicyDetails details = new PolicyDetails();
		details.setPolicyId(policyId);
		details.setPolicyStartDate(new Date());
		details.setPolicyInfo(json);
		
		//call save method to save details into DB
		//dao.save(PolicyDetails)
		
		return policyResponse;
		
	}

}
