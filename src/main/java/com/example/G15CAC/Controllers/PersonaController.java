package com.example.G15CAC.Controllers;

import com.example.G15CAC.Entity.Persona;
import com.example.G15CAC.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PersonaController
{
    @Autowired
    private Repository repo;
    @GetMapping()
    public String index(Model model)
    {
        List<Persona> personas = repo.findAll();
        model.addAttribute("persona", personas);
        return "index";
    }
    @GetMapping("/crear")
    public String crearPersonaForm(Model model)
    {
        model.addAttribute("persona", new Persona());
        return "crear_persona";
    }

    @PostMapping("/guardar")
    public String guardarPersona(@ModelAttribute Persona persona)
    {
        repo.save(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editarPersonaForm(@PathVariable Long id, Model model)
    {
        Persona persona = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
        model.addAttribute("persona", persona);
        return "editar_persona";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarPersona(@PathVariable Long id, @ModelAttribute Persona persona)
    {
        persona.setId(id);
        repo.save(persona);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id)
    {
        Persona persona = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));
        repo.delete(persona);
        return "redirect:/";
    }
}
