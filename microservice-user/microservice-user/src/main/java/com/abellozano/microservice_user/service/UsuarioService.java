package com.abellozano.microservice_user.service;

import com.abellozano.microservice_user.dto.Usuario;
import com.abellozano.microservice_user.repository.UsuarioRepository;
import com.abellozano.microservice_user.response.UsuarioResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class UsuarioService {

	 @Autowired
	    private UsuarioRepository repository;

	    public ResponseEntity<UsuarioResponse> createUser(Usuario user) {
	        
	         Optional<Usuario> usuarioOptional = this.searchUser(user.getDni());
	         
	         if (usuarioOptional.isPresent()) {
	             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UsuarioResponse(null, "El usuario con ese dni ya ha sido creado"));
	         }
	         else
	             repository.save(user);

	        return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioResponse(user, "Usuario generado correctamente"));
	    }

    public ResponseEntity<UsuarioResponse> getUsuariosById(Long dni) {
         Optional<Usuario> usuarioOpcional = this.searchUser (dni);

        if (usuarioOpcional.isPresent()) {
            Usuario usuario = usuarioOpcional.get();

            return ResponseEntity.ok(new UsuarioResponse(usuario, null));

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UsuarioResponse(null, "El usuario no ha sido encontrado"));
        }
    }

    public ResponseEntity<Page<Usuario>> getUsuarios(int pag, int size) {
        
        return ResponseEntity.status(HttpStatus.OK).body(this.obtenerUsuarios(pag, size));
    }

    public ResponseEntity<UsuarioResponse> deleteUsuario(Long dni) {
        Optional<Usuario> usuarioOpcional = this.searchUser(dni);

        if (usuarioOpcional.isPresent()) {
            repository.deleteById(dni);

            return ResponseEntity.ok(new UsuarioResponse(null, "Usuario eliminado con exito"));

        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new UsuarioResponse(null, "El usuario no ha sido encontrado"));
        }

    }
    
    public ResponseEntity<UsuarioResponse> updateUsuario(Usuario user) {
        Optional<Usuario> usuarioOpcional = repository.findById(user.getDni());

        if (usuarioOpcional.isPresent()) {
            Usuario usuario = usuarioOpcional.get();
            usuario.setNombre(user.getNombre());
            usuario.setApellidos(user.getApellidos());
            usuario.setEdad(user.getEdad());
            repository.save(usuario);
            return ResponseEntity.ok(new UsuarioResponse(usuario, "Usuario actualizado"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UsuarioResponse(null, "Usuario no encontrado"));
    }

    public ResponseEntity<Page<Usuario>> getUser() {
        throw new UnsupportedOperationException("Not supported."); 
    }
    public Optional<Usuario> searchUser(Long dni) {
        Optional<Usuario> usuarioOptional = repository.findById(dni);
        
        return usuarioOptional;
    }
    
    public Page<Usuario> obtenerUsuarios(int pagina, int tamaño) {
        Pageable pageable = PageRequest.of(pagina, tamaño);
        return repository.findAll(pageable);
    }

   
}
