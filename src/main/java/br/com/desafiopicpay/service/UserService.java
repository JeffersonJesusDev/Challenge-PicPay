package br.com.desafiopicpay.service;

import br.com.desafiopicpay.domain.user.User;
import br.com.desafiopicpay.domain.user.UserTyper;
import br.com.desafiopicpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validationTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserTyper.MERCHANT){
            throw new Exception("Usuario do tipo lojista não está autorizado a realizar a transação");
        }

        if (sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente");
        }

    }

    public User findUserById(Long id) throws Exception{
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não enconrado!"));
    }

    public void saveUser(User user){
        this.repository.save(user);
    }

}
