package com.upgrade.erp.app.controllers.auth;

import com.upgrade.erp.app.models.models.JwtResponse;
import com.upgrade.erp.app.models.models.LoginRequest;
import com.upgrade.erp.app.security.jwt.JwtUtils;
import com.upgrade.erp.app.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/public/auth")
public class AuthUserController {

	private final Logger log = LoggerFactory.getLogger(AuthUserController.class);
	private String passwGen = "C0d1g0Sup3rS3cr3t0";

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	/*
	 * @PostMapping("/login") public ResponseEntity<?> login(@Valid @RequestBody
	 * SignupUserWebRequest signupUserWebRequest) { LoginRequest loginRequest = new
	 * LoginRequest(); loginRequest.setUsername(signupUserWebRequest.getUsername());
	 * loginRequest.setPassword(passwGen); if
	 * (!userWebRepository.existsByUsername(signupUserWebRequest.getUsername())) {
	 * registerUser(signupUserWebRequest); return authenticateUser(loginRequest); }
	 * return authenticateUser(loginRequest); }
	 */

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		log.info(authentication.toString());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl admUserDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = admUserDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		List<String> permisos = admUserDetails.getPermisos().stream().map(item -> item.getNombre())
				.collect(Collectors.toList());

		return ResponseEntity
				.ok(new JwtResponse(jwt, admUserDetails.getId(), admUserDetails.getUsername(), roles, permisos));
	}

}
