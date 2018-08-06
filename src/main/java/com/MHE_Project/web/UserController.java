package com.MHE_Project.web;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.MHE_Project.domain.MHE_SensorData;
import com.MHE_Project.domain.MHE_SensorDataRepository;

@Controller
public class UserController {
	private List<User> users = new ArrayList<User>();
	// private List<MHE_SensorData> mhe_sensordatas = new
	// ArrayList<MHE_SensorData>();

	@Autowired
	private MHE_SensorDataRepository mhe_sensorDataRepository;

	/*
	 * @PostMapping("/create") public String create(User user) {
	 * System.out.println("user : " + user); users.add(user); return "index"; }
	 */

	@PostMapping("/create")
	public String test(String a) {
		String[] ar = a.split(","); // 총 몇개의 데이터가 들어가는지? ar에 다 배열로 저장된다
		System.out.println("[POST] a : " + a);

		int mNumMemberSensorData = 18;

		MHE_SensorData[] mhe_sensorData = new MHE_SensorData[ar.length / mNumMemberSensorData]; // MHE_SensorData/18만큼의
																								// 배열 생성
		for (int i = 0; i < mhe_sensorData.length; i++) { // 위에서 만든 배열 수만큼 MHE_SensorData를넣는다
			mhe_sensorData[i] = new MHE_SensorData();
		}

		for (int i = 0; i < ar.length; i += mNumMemberSensorData) {
			mhe_sensorData[i / mNumMemberSensorData].setMAC(ar[i]);
			mhe_sensorData[i / mNumMemberSensorData].setUID(ar[i + 1]);
			mhe_sensorData[i / mNumMemberSensorData].setActivity(Integer.parseInt(ar[i + 2]));
			mhe_sensorData[i / mNumMemberSensorData].setVector0(Integer.parseInt(ar[i + 3]));
			mhe_sensorData[i / mNumMemberSensorData].setVector1(Integer.parseInt(ar[i + 4]));
			mhe_sensorData[i / mNumMemberSensorData].setVector2(Integer.parseInt(ar[i + 5]));
			mhe_sensorData[i / mNumMemberSensorData].setVector3(Integer.parseInt(ar[i + 6]));
			mhe_sensorData[i / mNumMemberSensorData].setVector4(Integer.parseInt(ar[i + 7]));
			mhe_sensorData[i / mNumMemberSensorData].setVector5(Integer.parseInt(ar[i + 8]));
			mhe_sensorData[i / mNumMemberSensorData].setVector6(Integer.parseInt(ar[i + 9]));
			mhe_sensorData[i / mNumMemberSensorData].setVector7(Integer.parseInt(ar[i + 10]));
			mhe_sensorData[i / mNumMemberSensorData].setVector8(Integer.parseInt(ar[i + 11]));
			mhe_sensorData[i / mNumMemberSensorData].setVector9(Integer.parseInt(ar[i + 12]));
			mhe_sensorData[i / mNumMemberSensorData].setVector10(Integer.parseInt(ar[i + 13]));
			mhe_sensorData[i / mNumMemberSensorData].setVector11(Integer.parseInt(ar[i + 14]));
			mhe_sensorData[i / mNumMemberSensorData].setVector12(Integer.parseInt(ar[i + 15]));
			mhe_sensorData[i / mNumMemberSensorData].setVector13(ar[i + 16]);
			mhe_sensorData[i / mNumMemberSensorData].setTime(ar[i + 17]);

			// mhe_sensordatas.add(mhe_sensorData[i/mNumMemberSensorData]);
			mhe_sensorDataRepository.save(mhe_sensorData[i / mNumMemberSensorData]);
		}

		for (int i = 0; i < mhe_sensorData.length; i++) {
			System.out.println(mhe_sensorData[i]);
		}

		return "index";
	}

	/*
	 * @GetMapping("/create") public String test2(String a, String b) {
	 * System.out.println("[GET] a : " + a + "b : "+ b); return "index"; } test
	 */

	@GetMapping("/list")
	public String list(Model model) {
		List<MHE_SensorData> mhe_sensordatas = mhe_sensorDataRepository.findAll();
		model.addAttribute("CW", mhe_sensordatas);
		return "list";
	}
	
	@GetMapping("/Search")
	public String SelectedlistMAC(String q, Model model) {
		System.out.println("Search : q - " + q);
		List<MHE_SensorData> mhe_sensordatas = mhe_sensorDataRepository.findByMAC(q);
		model.addAttribute("CW", mhe_sensordatas);
		return "list";
	}

	String setContent(List<MHE_SensorData> mhe_sensordatas) {
		String ret = "MAC,UID,Activity,Vector0,Vector1,Vector2,Vector3,Vector4,Vector5,Vector6,Vector7,Vector8,Vector9,Vector10,Vector11,Vector12,time\n";
		for(MHE_SensorData i:mhe_sensordatas) {
			ret += i.toCVS();
		}
		return ret;
	}
	
	@GetMapping("/DownloadMAC")
	public ResponseEntity<String> getSelectedMAC(String q, Model model){
		
		List<MHE_SensorData> mhe_sensordatas = mhe_sensorDataRepository.findByMAC(q); //DB에서 가져온 데이터 리스트
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "text/csv; charset=MS949");
		header.add("Content-Disposition", "attachment; filename=\"" + "MHE_Result_MAC:" + q + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) +".csv" + "\"");
		
		return new ResponseEntity<String>(setContent(mhe_sensordatas), header, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/SearchId")
	public String SelectedlistID(String q2, Model model) {
		System.out.println("Search : q2 - " + q2);
		List<MHE_SensorData> mhe_sensordatas2 = mhe_sensorDataRepository.findByID(q2);
		model.addAttribute("CW", mhe_sensordatas2);
		return "list";
	}

	@GetMapping("/DownloadID")
	public ResponseEntity<String> getSelectedID(String q2, Model model){
		
		List<MHE_SensorData> mhe_sensordatas = mhe_sensorDataRepository.findByID(q2); //DB에서 가져온 데이터 리스트
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "text/csv; charset=MS949");
		header.add("Content-Disposition", "attachment; filename=\"" + "MHE_Result_ID:" + q2 + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) +".csv" + "\"");
		
		return new ResponseEntity<String>(setContent(mhe_sensordatas), header, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/SearchTime")
	public String SelectedlistTIME(String q3, Model model) {
		System.out.println("Search : q3 - " + q3);
		List<MHE_SensorData> mhe_sensordatas3 = mhe_sensorDataRepository.findByTIME(q3);
		model.addAttribute("CW", mhe_sensordatas3);
		System.out.println("입력받은 time 데이터: " + mhe_sensordatas3);
		return "list";
	}

	@GetMapping("/DownloadTIME")
	public ResponseEntity<String> getSelectedTIME(String q3, Model model){
		
		List<MHE_SensorData> mhe_sensordatas = mhe_sensorDataRepository.findByTIME(q3); //DB에서 가져온 데이터 리스트
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "text/csv; charset=MS949");
		header.add("Content-Disposition", "attachment; filename=\"" + "MHE_Result_TIME:" + q3 + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) +".csv" + "\"");
		
		return new ResponseEntity<String>(setContent(mhe_sensordatas), header, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/SearchPeriod")
	public String SelectedlistTIME(String q4, String q5, Model model) {
		System.out.println("Search : q4 :" + q4 + "q5:" + q5);
		List<MHE_SensorData> mhe_sensordatas4 = mhe_sensorDataRepository.findByPERIOD(q4, q5);
		model.addAttribute("CW", mhe_sensordatas4);
		System.out.println("입력받은 period 데이터: " + mhe_sensordatas4);
		return "list";
	}

	@GetMapping("/DownloadPERIOD")
	public ResponseEntity<String> getSelectedPERIOD(String q4,String q5, Model model){
		
		List<MHE_SensorData> mhe_sensordatas = mhe_sensorDataRepository.findByPERIOD(q4,q5); //DB에서 가져온 데이터 리스트
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "text/csv; charset=MS949");
		header.add("Content-Disposition", "attachment; filename=\"" + "MHE_Result_PERIOD:" + q4 + "_"+ q5 + "_"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) +".csv" + "\"");
		
		return new ResponseEntity<String>(setContent(mhe_sensordatas), header, HttpStatus.CREATED);
		
	}
}
