package com.abellozano.microservice_user.response;

import com.abellozano.microservice_user.dto.Usuario;


public class UsuarioResponse {
   
   private Usuario usuario;
   private String mensaje;

   public UsuarioResponse(Usuario usuario, String mensaje) {
       this.usuario = usuario;
       this.mensaje = mensaje;
   }

   public Usuario getUsuario() {
       return usuario;
   }

   public void setUsuario(Usuario usuario) {
       this.usuario = usuario;
   }

   public String getMensaje() {
       return mensaje;
   }

   public void setMensaje(String mensaje) {
       this.mensaje = mensaje;
   }
   
}
