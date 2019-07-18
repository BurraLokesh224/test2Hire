
package com.letsgettin.QBarter.tes2hire.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.letsgettin.QBarter.tes2hire.ExceptionHandling.ResourceNotFoundException;
import com.letsgettin.QBarter.tes2hire.message.request.CandidateProfileForm;
/*import com.letsgettin.QBarter.tes2hire.message.request.IntermediateForm;
import com.letsgettin.QBarter.tes2hire.message.request.SslcForm;

import com.letsgettin.QBarter.tes2hire.model.Intermediate;
import com.letsgettin.QBarter.tes2hire.model.Sslc;
import com.letsgettin.QBarter.tes2hire.repository.CandidateInterRepository;

import com.letsgettin.QBarter.tes2hire.repository.CandidateSslcRepository;*/
import com.letsgettin.QBarter.tes2hire.model.Candidate;
import com.letsgettin.QBarter.tes2hire.repository.RegisterRepository;
import com.letsgettin.QBarter.tes2hire.repository.CandidateRpository;
import com.letsgettin.QBarter.tes2hire.repository.RoleRepository;
import com.letsgettin.QBarter.tes2hire.security.jwt.JwtProvider;

@RestController

@RequestMapping("/api/candidate")
public class CandidateController {

	@Autowired
	RegisterRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	/*
	 * @Autowired CandidateSslcRepository candidateSslcRepository;
	 * 
	 * @Autowired CandidateInterRepository candidateInterRepository;
	 */

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	CandidateRpository candidateRpository;

	@Autowired
	public JavaMailSender JavaMailSender;

	@PostMapping("/Candidateprofile")
	public ResponseEntity<?> candidateprofileUpload(@Valid @RequestBody CandidateProfileForm candiRequest
			/*, SslcForm sslcRequest, IntermediateForm intrRequest,  @RequestParam("file") MultipartFile file*/)
			throws ResourceNotFoundException, IOException {

		Candidate candi = new Candidate(candiRequest.getFirstName(), candiRequest.getLastName(),
				candiRequest.getFathersName(), candiRequest.getFathersOccupation(), candiRequest.getDateOfBirth(),
				candiRequest.getGender(), candiRequest.getAddress(), candiRequest.getAadharNumber(),
				candiRequest.getPanNumber(), candiRequest.getCity(), candiRequest.getState(), candiRequest.getPincode(),
				candiRequest.getPhoneNumber(), candiRequest.getAlternateNumber());
		if ("MALE".equals(candiRequest.getGender())) {
		} else if ("FEMALE".equals(candiRequest.getGender())) {
		} else if ("OTHERS".equals(candiRequest.getGender())) {
		} else {
			new RuntimeException("Fail! -> Cause: Invalid Gender.");
			return ResponseEntity.ok().body("Invalid Gender");
		}

		/*
		 * Sslc sslc = new Sslc();
		 * 
		 * sslc.setSslc_Board(sslcRequest.getSslc_Board());
		 * sslc.setSslc_SchoolName(sslcRequest.getSslc_SchoolName());
		 * sslc.setSslc_Location(sslcRequest.getSslc_Location());
		 * sslc.setSslc_Percentage(sslcRequest.getSslc_Percentage());
		 * sslc.setSslc_YearOfPassing(sslcRequest.getSslc_YearOfPassing());
		 * //sslc.setSslc_upload(file.getBytes());
		 * 
		 * sslc = candiRequest.getSslc(); sslc.setCandidate(candi); candi.setSslc(sslc);
		 * 
		 * Intermediate intr = new Intermediate();
		 * 
		 * intr.setInter_Board(intrRequest.getInter_Board());
		 * intr.setInter_CollegeName(intrRequest.getInter_CollegeName());
		 * intr.setInter_Location(intrRequest.getInter_Location());
		 * intr.setInter_Percentage(intrRequest.getInter_Percentage());
		 * intr.setInter_YearOfPassing(intr.getInter_YearOfPassing());
		 * 
		 * //intr.setInter_Upload(file.getBytes());
		 * 
		 * intr = candiRequest.getIntermediate(); intr.setCandidate(candi);
		 * candi.setIntr(intr);
		 */

		candidateRpository.save(candi);

		return ResponseEntity.ok("candidate profile fetched successfully");

	}

}
