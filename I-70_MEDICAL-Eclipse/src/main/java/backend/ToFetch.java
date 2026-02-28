package backend;

import database.BillHandlerDataFetcher;
import database.HipaaDataFetcher;
import database.InsuranceNameDataFetcher;
import database.PatientDataFetcher;
import database.PatientInsuranceDataFetcher;
import database.SubscriberDataFetcher;
import frontend.AdminPanel;
import frontend.UIHelperMethods;

public class ToFetch {
	
	private AdminPanel objFetchTable;
	
	public ToFetch(AdminPanel objFetchTable) {
		this.objFetchTable = objFetchTable;
	}
	
	public void btnPatientInformation() {
		objFetchTable.setPnlPreviewPaneAdmin(UIHelperMethods.getQueryTableScrollable(PatientDataFetcher.fetchAllPatientData()));	
	}
	
	public void btnHIPAAInformation() {
		objFetchTable.setPnlPreviewPaneAdmin(UIHelperMethods.getQueryTableNonScrollable(HipaaDataFetcher.fetchAllHipaaData()));	
	}
	
	public void btnBillHandlerInformation() {
		objFetchTable.setPnlPreviewPaneAdmin(UIHelperMethods.getQueryTableScrollable(BillHandlerDataFetcher.fetchAllBillHandlerData()));	
	}
	
	public void btnInsuranceInformation() {
		objFetchTable.setPnlPreviewPaneAdmin(UIHelperMethods.getQueryTableNonScrollable(InsuranceNameDataFetcher.fetchAllInsuranceNameData()));
	}
	
	public void btnPatientInsuranceInformation() {
		objFetchTable.setPnlPreviewPaneAdmin(UIHelperMethods.getQueryTableNonScrollable(PatientInsuranceDataFetcher.fetchAllPatientInsuranceData()));
	}
	
	public void btnSubscriberInformation() {
		objFetchTable.setPnlPreviewPaneAdmin(UIHelperMethods.getQueryTableNonScrollable(SubscriberDataFetcher.fetchAllSubscriberData()));	
	}	
}
