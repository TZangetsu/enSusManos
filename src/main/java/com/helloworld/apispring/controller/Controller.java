/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.controller;

//import com.helloworld.apispring.model.entity.Evento;
import com.helloworld.apispring.model.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.http.MediaType;


@RestController
@RequestMapping("/v1")
public class Controller {
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
   /* @Autowired
    private EventoServicio eventoServicio;
    */
    
    //Ciudadano
    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioServicio.getAllUsers();
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }
    
    //Ciudadano por id
    @RequestMapping(value="/IdUser/{Id_Usuario}", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> obtenerUsuariosFiltro(
       @RequestParam(value = "Id_Usuario") Integer userID){
       List<Usuario> IdUser = usuarioServicio.getUsersID(userID);
               return new ResponseEntity<List<Usuario>>(IdUser,HttpStatus.OK);
    }
    /*
    //Evento
    @RequestMapping(value = "/eventos", method = RequestMethod.GET)
    public ResponseEntity<List<Evento>> getAllEventos() {
        List<Evento> eventos = eventoServicio.getAllEvents();
        return new ResponseEntity<List<Evento>>(eventos, HttpStatus.OK);
    
   }
    
    //Ciudadano por id
    @RequestMapping(value="/IdUser/{Id_Evento}", method = RequestMethod.GET)
    public ResponseEntity<List<Evento>> obtenerEventosFiltro(
       @RequestParam(value = "Id_Evento") Integer eventID){
       List<Evento> IdEvent = eventoServicio.getEventsID(eventID);
               return new ResponseEntity<List<Evento>>(IdEvent,HttpStatus.OK);
    }
    //Login 
    /*METODO CON ERRORES
    @RequestMapping(value = "/login/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> loginUser(@RequestBody Usuario usuario) {
        String inf = usuarioServicio.loginUser(usuario);
        return ResponseEntity.ok().body(inf);
    }
    */
    
}    

    
