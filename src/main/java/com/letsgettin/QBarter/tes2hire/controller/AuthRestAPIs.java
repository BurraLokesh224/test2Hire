package com.letsgettin.QBarter.tes2hire.controller;

import java.util.Calendar;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsgettin.QBarter.tes2hire.ExceptionHandling.ResourceNotFoundException;
/*import com.letsgettin.QBarter.tes2hire.message.request.CandidateProfileForm;*/
import com.letsgettin.QBarter.tes2hire.message.request.ForgetPassword;
import com.letsgettin.QBarter.tes2hire.message.request.LoginForm;
import com.letsgettin.QBarter.tes2hire.message.request.Otpsystem;
import com.letsgettin.QBarter.tes2hire.message.request.SignUpForm;
/*import com.letsgettin.QBarter.tes2hire.model.Candidate;*/
import com.letsgettin.QBarter.tes2hire.model.Register;
import com.letsgettin.QBarter.tes2hire.model.Role;
import com.letsgettin.QBarter.tes2hire.model.RoleName;
/*import com.letsgettin.QBarter.tes2hire.repository.CandidateRpository;*/
import com.letsgettin.QBarter.tes2hire.repository.RegisterRepository;
import com.letsgettin.QBarter.tes2hire.repository.RoleRepository;
import com.letsgettin.QBarter.tes2hire.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	RegisterRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;
	/*
	 * @Autowired CandidateRpository candidateRpository;
	 */
	@Autowired
	public JavaMailSender JavaMailSender;

	int otp;

	long otpgenTime;

	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest)
			throws ResourceNotFoundException {

		if (userRepository.existsByEmailId(signUpRequest.getEmailId())) {
			return new ResponseEntity<String>("Fail -> Email is already in use!", HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		Register user = new Register(signUpRequest.getEmailId(), encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "recruiter":
				
				Role recruiter = roleRepository.findByName(RoleName.ROLE_RECRUITER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(recruiter);

				break;

			case "employer":
				Role employerRole = roleRepository.findByName(RoleName.ROLE_EMPLOYER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(employerRole);

				break;

			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_CANDIDATE)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok().body("User registered successfully:" + signUpRequest.getEmailId());

	}

	// -------------signin form----------------------
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest)
			throws ResourceNotFoundException {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getemailId(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		return ResponseEntity.ok("User signin successfully:" + jwt);
	}

}

/*
 * ---------------for send mail ----------
 * 
 * @RequestMapping(value="/sendemail") public void sendEmail( @RequestBody
 * ForgetPassword resetRequest) { SimpleMailMessage message=new
 * SimpleMailMessage(); message.setTo(resetRequest.getEmail());
 * message.setSubject("simple mail seder ");
 * message.setText("hi how are you lokesh burra this is for check mail");
 * JavaMailSender.send(message); }
 */

/*
 * @PostMapping("/forgetpassword") public ResponseEntity<String>
 * registerUser(@Valid @RequestBody ForgetPassword resetRequest) {
 * 
 * try { SimpleMailMessage message = new SimpleMailMessage(); if
 * (userRepository.existsByEmail(resetRequest.getEmail())) {
 * message.setTo(resetRequest.getEmail());
 * message.setSubject("simple mail seder "); message.setText(
 * "hi how are you lokesh burra this is for check mail ... we u have successfully got reset password link ,click the below link and reset"
 * ); otp = this.generateotp(); Calendar cl = Calendar.getInstance(); otpgenTime
 * = cl.getTimeInMillis();
 * 
 * message.setText(" otp send to your email account = " + otp);
 * 
 * JavaMailSender.send(message);
 * 
 * return new ResponseEntity<String>(
 * "email exist successfully.....  we send reset password to your email id",
 * HttpStatus.FOUND); } return ResponseEntity.ok().
 * body("Invalid email does not exist, Please provide correct email"); } catch
 * (Exception e) { e.printStackTrace();
 * 
 * } return ResponseEntity.ok().body("User Forgetpassword Exception!"); }
 * 
 * @PostMapping("/otpcampar") public ResponseEntity<String>
 * otpvalidate(@Valid @RequestBody Otpsystem otpsystem) { try { Calendar cl =
 * Calendar.getInstance(); if ((otp) == otpsystem.getOtp()) { if
 * (cl.getTimeInMillis() - otpgenTime <= (500000)) { return new
 * ResponseEntity<String>(" otp validation successfully", HttpStatus.FOUND);
 * 
 * } } return ResponseEntity.ok().body("User otp invalid !"); } catch (Exception
 * e) { e.printStackTrace();
 * 
 * } return ResponseEntity.ok().body("Otp comparation Exception"); }
 * 
 * @PutMapping("/customers/{email}") public ResponseEntity<String>
 * resetpassword(@PathVariable("email") String email,
 * 
 * @RequestBody SignUpForm resetpassword) { try {
 * System.out.println("Update Customer with ID = " + email + "...");
 * 
 * Optional<Register> customerData = userRepository.findByEmailId(email);
 * 
 * if (customerData.isPresent()) { Register customer = customerData.get();
 * customer.setPassword(encoder.encode(resetpassword.getPassword()));
 * customer.setConfirmpassword(encoder.encode(resetpassword.getConfirmpassword()
 * ));
 * 
 * return new ResponseEntity<>(userRepository.save(customer), HttpStatus.OK); }
 * else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
 * 
 * 
 * userRepository.save(customer);
 * 
 * return ResponseEntity.ok().body("your new password created successfully!"); }
 * return new ResponseEntity<>("something went wrong", HttpStatus.NOT_FOUND); }
 * catch (Exception e) { e.printStackTrace();
 * 
 * } return ResponseEntity.ok().body("reset password Exception!");
 * 
 * }
 * 
 * @PutMapping("/updateprofile/{email}") public ResponseEntity<String>
 * editcustomerdetails(@PathVariable("email") String email,
 * 
 * @RequestBody SignUpForm editprofile) { try {
 * System.out.println("Update Customer with ID = " + email + "...");
 * 
 * Optional<Register> customerData = userRepository.findByEmail(email);
 * 
 * if (customerData.isPresent()) { Register customer = customerData.get();
 * customer.setFirstname(editprofile.getFirstname());
 * customer.setLastname(editprofile.getLastname());
 * customer.setUsername(editprofile.getUsername());
 * 
 * customer.setPassword(editprofile.getPassword());
 * customer.setConfirmpassword(encoder.encode(editprofile.getConfirmpassword()))
 * ;
 * 
 * customer.setGender(editprofile.getGender());
 * customer.setIdproof(editprofile.getIdproof());
 * customer.setPhonenumber(editprofile.getPhonenumber());
 * customer.setCountry(editprofile.getCountry());
 * customer.setState(editprofile.getState());
 * customer.setCity(editprofile.getCity());
 * customer.setOccupation(editprofile.getOccupation());
 * customer.setLandmark(editprofile.getLandmark());
 * customer.setFamily(editprofile.getFamily()); userRepository.save(customer);
 * 
 * return ResponseEntity.ok().body("your profile edited successfully!"); }
 * return new ResponseEntity<>("something went wrong", HttpStatus.NOT_FOUND);
 * 
 * } catch (Exception e) { e.printStackTrace();
 * 
 * } return ResponseEntity.ok().body("User updateprofile Exception");
 * 
 * }
 * 
 * public int generateotp() { Random rm = new Random(); int otp = 1000 +
 * rm.nextInt(9999); return otp; }
 * 
 * }
 */

/*
 * @RequestMapping(value = "/user/changePassword", method = RequestMethod.GET)
 * public String showChangePasswordPage(Locale locale, Model model,
 * 
 * @RequestParam("id") long id, @RequestParam("token") String token) { String
 * result = securityService.validatePasswordResetToken(id, token); if (result !=
 * null) { model.addAttribute("message", messages.getMessage("auth.message." +
 * result, null, locale)); return "redirect:/login?lang=" +
 * locale.getLanguage(); } return "redirect:/updatePassword.html?lang=" +
 * locale.getLanguage(); }
 * 
 * 
 * private HashMap<String, Otpsystem> otp_data = new HashMap<>();
 * 
 * @RequestMapping(value = "/email/{email}/otp", method = RequestMethod.POST)
 * public ResponseEntity<Object> sendotp(@PathVariable("email") String email) {
 * 
 * Otpsystem otpsystem = new Otpsystem(); otpsystem.setEmail(email);
 * otpsystem.setOtp(String.valueOf(((int) (Math.random(). * (10000 - 1000))) +
 * 1000)); otpsystem.setExpirytime(System.currentTimeMillis() + 2000);
 * 
 * return new ResponseEntity<>("otp send successfully", HttpStatus.OK);
 * 
 * }
 * 
 * @RequestMapping(value = "/email/otp", method = RequestMethod.PUT) public
 * ResponseEntity<Object> verifyotp(@PathVariable("email") String email,
 * 
 * @RequestBody Otpsystem Requestbodyotpsystem) {
 * 
 * if (Requestbodyotpsystem.getOtp() == null ||
 * Requestbodyotpsystem.getOtp().trim().length() <= 0) { return new
 * ResponseEntity<>(" please provide otp", HttpStatus.BAD_REQUEST); } if
 * (otp_data.containsKey(email)) { Otpsystem otpsystem = otp_data.get(email); if
 * (otpsystem != null) { if (otpsystem.getExpirytime() >=
 * System.currentTimeMillis()) { if
 * (Requestbodyotpsystem.getOtp().equals(otpsystem.getOtp())) { return new
 * ResponseEntity<>("otp is verified succefully", HttpStatus.OK); } return new
 * ResponseEntity<>(" invalid otp", HttpStatus.BAD_REQUEST); } return new
 * ResponseEntity<>("otp expired", HttpStatus.BAD_REQUEST); } return new
 * ResponseEntity<>("something went wrong", HttpStatus.BAD_REQUEST); } return
 * new ResponseEntity<>("email is not found", HttpStatus.NOT_FOUND);
 * 
 * }
 */
