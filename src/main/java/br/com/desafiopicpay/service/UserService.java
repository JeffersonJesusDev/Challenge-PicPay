package br.com.desafiopicpay.service;

import br.com.desafiopicpay.dto.UserDTO;
import br.com.desafiopicpay.domain.user.User;
import br.com.desafiopicpay.domain.user.UserTyper;
import br.com.desafiopicpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validationTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserTyper.MERCHANT){
            throw new Exception("Usuario do tipo lojista não está autorizado a realizar a transação");
        }

        if (sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficient");
        }

    }

    public User findUserById(Long id) throws Exception{
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não enconrado!"));
    }

    public void saveUser(User user){
        this.repository.save(user);
    }

    public User creatUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }
}
