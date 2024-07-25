package com.Javacristhian.tienda_api.controler;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Javacristhian.tienda_api.Dto.JWTAuthResponse;
import com.Javacristhian.tienda_api.Dto.LoginDTO;
import com.Javacristhian.tienda_api.Dto.registroDTO;
import com.Javacristhian.tienda_api.Repositorio.RolRepositorio;
import com.Javacristhian.tienda_api.Repositorio.UsuarioRepositorio;
import com.Javacristhian.tienda_api.entity.rol;
import com.Javacristhian.tienda_api.entity.usuario;
import com.Javacristhian.tienda_api.seguridad.JwtTokenProvider;




@RestController
@RequestMapping("/usuario/auth")

public class Autcontroler {
	
	 @Autowired
	    private AuthenticationManager authenticationManager;
	 
	 @Autowired
	 private UsuarioRepositorio usuarioRepositorio;
	 
	 @Autowired
	 private RolRepositorio rolRepositorio;
	 
	 @Autowired
	 private PasswordEncoder passwordEncoder;
	 @Autowired
	    private JwtTokenProvider tokenProvider;
	
	 @PostMapping("/iniciarSesion")
	    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDTO loginDTO){
	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));

	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        // get token form tokenProvider
	        String token = tokenProvider.generateToken(authentication);

	        return ResponseEntity.ok(new JWTAuthResponse(token));
	 }
	 
	 @PostMapping("/registrar")
	    public ResponseEntity<?> registrarUsuario(@RequestBody registroDTO registroDTO){

	        // add check for username exists in a DB
	        if(usuarioRepositorio.existsByusername(registroDTO.getUsername())){
	            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
	        }

	        // add check for email exists in DB
	        if(usuarioRepositorio.existsByemail(registroDTO.getEmail())){
	            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
	        }

	        // create user object
	        usuario user = new usuario();
	        user.setNombre(registroDTO.getNombre());
	        user.setUsername(registroDTO.getUsername());
	        user.setEmail(registroDTO.getEmail());
	        user.setPassword(passwordEncoder.encode(registroDTO.getPassword()));

	        rol roles = rolRepositorio.findByNombre("ROLE_ADMIN").get();
	        user.setRoles(Collections.singleton(roles));

	        usuarioRepositorio.save(user);

	        return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.OK);

	    }
}
