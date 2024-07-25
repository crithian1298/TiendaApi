package com.Javacristhian.tienda_api.seguridad;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Javacristhian.tienda_api.Repositorio.UsuarioRepositorio;
import com.Javacristhian.tienda_api.entity.rol;
import com.Javacristhian.tienda_api.entity.usuario;
@Service
public class CustomUserDetailsService implements UserDetailsService {
  
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
	usuario usuario =usuarioRepositorio.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
			.orElseThrow(()->new UsernameNotFoundException("usuario no encontrado con username o email"+usernameOrEmail));
	return new User(usuario.getEmail(), usuario.getPassword(),mapearRoles(usuario.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority>mapearRoles(Set<rol>roles){
		
		return roles.stream().map(rol->new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
	}

}
