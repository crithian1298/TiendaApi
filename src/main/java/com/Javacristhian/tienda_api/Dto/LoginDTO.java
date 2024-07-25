package com.Javacristhian.tienda_api.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
	private String usernameOrEmail;
	private String password;
}
