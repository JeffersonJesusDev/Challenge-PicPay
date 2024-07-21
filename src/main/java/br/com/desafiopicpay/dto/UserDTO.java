package br.com.desafiopicpay.dto;

import br.com.desafiopicpay.domain.user.UserTyper;

import java.math.BigDecimal;

public record UserDTO(String firstName, String secondName, String document, BigDecimal balance, String email, String password, UserTyper userType) {
}
