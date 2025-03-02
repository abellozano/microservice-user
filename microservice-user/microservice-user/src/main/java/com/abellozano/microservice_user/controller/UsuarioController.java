package com.abellozano.microservice_user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abellozano.microservice_user.dto.Usuario;
import com.abellozano.microservice_user.response.UsuarioResponse;
import com.abellozano.microservice_user.service.UsuarioService;


@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/getUserId")
    public ResponseEntity<Page<Usuario>> getUser(@RequestParam(defaultValue = "0")int pag, @RequestParam(defaultValue = "10")int size) {

        return service.getUsuarios(pag, size);
    }

    @GetMapping("/getUserById/{dni}")
    public ResponseEntity<UsuarioResponse> getUserById(@PathVariable Long dni) {

        return service.getUsuariosById(dni);
    }

    @PostMapping("/createUser")
    public ResponseEntity<UsuarioResponse> createUser(@RequestBody Usuario usuario) {

        return service.createUser(usuario);
        
    }
    
    @PutMapping("/updateUser")
    public ResponseEntity<UsuarioResponse> updateUser(@RequestBody Usuario usuario) {

        return service.updateUsuario(usuario);
        
    }
    
    @DeleteMapping("/deleteUser/{dni}")
    public ResponseEntity<UsuarioResponse> eliminarUsuario(@PathVariable Long dni) {
        return service.deleteUsuario(dni);
    }

}
