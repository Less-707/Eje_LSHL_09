package com.upiiz.db.controllers;

import com.upiiz.db.entities.EntrenadorEntity;
import com.upiiz.db.services.EntrenadorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorServiceImpl entrenadorService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("entrenadores", entrenadorService.listarEntrenadores());
        return "listado-entrenadores";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("entrenador", new EntrenadorEntity());
        return "agregar-entrenador";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute EntrenadorEntity entrenador) {
        entrenadorService.guardarEntrenador(entrenador);
        return "redirect:/entrenadores";
    }

    @GetMapping("/actualizar/{id}")
    public String formularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("entrenador", entrenadorService.obtenerEntrenadorPorId(id));
        return "actualizar-entrenador";
    }

    @GetMapping("/eliminar/confirmar/{id}")
    public String confirmarEliminar(@PathVariable Long id, Model model) {
        model.addAttribute("entrenador", entrenadorService.obtenerEntrenadorPorId(id));
        return "eliminar-entrenador";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        entrenadorService.eliminarEntrenador(id);
        return "redirect:/entrenadores";
    }
}
