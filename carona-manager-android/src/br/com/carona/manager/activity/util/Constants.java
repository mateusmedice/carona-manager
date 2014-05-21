package br.com.carona.manager.activity.util;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static final String WS_SERVER_ADDRESS = "http://192.168.1.101:8080/carona-manager-server/";

	public static List<Object> getStateSpinner() {

		List<Object> stateList = new ArrayList<Object>();

		stateList.add("");
		stateList.add("AC");
		stateList.add("AL");
		stateList.add("AP");
		stateList.add("AM");
		stateList.add("BA");
		stateList.add("CE");
		stateList.add("DF");
		stateList.add("ES");
		stateList.add("GO");
		stateList.add("MA");
		stateList.add("MT");
		stateList.add("MS");
		stateList.add("MG");
		stateList.add("PR");
		stateList.add("PB");
		stateList.add("PA");
		stateList.add("PE");
		stateList.add("PI");
		stateList.add("RJ");
		stateList.add("RN");
		stateList.add("RS");
		stateList.add("RO");
		stateList.add("RR");
		stateList.add("SC");
		stateList.add("SE");
		stateList.add("SP");
		stateList.add("TO");

		return stateList;
	}

	
}
