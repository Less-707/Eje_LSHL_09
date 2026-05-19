package com.upiiz.db.controllers;

import com.upiiz.db.entities.JugadorEntity;
import com.upiiz.db.services.JugadorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {
    @Autowired
    private JugadorServiceImpl jugadorServiceImpl;

    @GetMapping
    public String jugadores(Model model){
        List<JugadorEntity> listadoJugadores = jugadorServiceImpl.listarJugadores();
        model.addAttribute("jugadores",listadoJugadores);
        return "listado-jugadores";
    }
    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("jugador", new JugadorEntity());
        return "agregar-jugador";
    }


    @PostMapping("/guardar")
    public String guardar(@ModelAttribute JugadorEntity jugador) {
        jugadorServiceImpl.guardarJugador(jugador);
        return "redirect:/jugadores";
    }

    @GetMapping("/actualizar/{id}")
    public String formularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("jugador", jugadorServiceImpl.obtenerJugadorPorId(id));
        return "actualizar-jugador";
    }

    @GetMapping("/eliminar/confirmar/{id}")
    public String confirmarEliminar(@PathVariable Long id, Model model) {
        model.addAttribute("jugador", jugadorServiceImpl.obtenerJugadorPorId(id));
        return "eliminar-jugador";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        jugadorServiceImpl.eliminarJugador(id);
        return "redirect:/jugadores";
    }
}
