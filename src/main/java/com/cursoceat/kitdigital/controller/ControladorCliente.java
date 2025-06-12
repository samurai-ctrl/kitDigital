/**
 * @autor David
 * @date
 *
 */

package com.cursoceat.kitdigital.controller;


import com.cursoceat.kitdigital.model.Cliente;
import com.cursoceat.kitdigital.repository.ClienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorCliente {

    // se linkea el repositorio al controlador para poder utilizar la base de datos
    private final ClienteRepository clienteRepository;

    public ControladorCliente(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/confirmacion")
    public String confirmacion() {
        return "confirmacion";
    }


    @GetMapping ("/")
    public String listaEmpleados(Model model) {
        model.addAttribute("inicio",clienteRepository.findAll());

        return "inicio";

    }

    // Página para registrar los empleados
    @GetMapping ("/registro-clientes")
    public String nuevoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "registro-clientes";

    }


    // PostMapping para guardar los empleados en el Repositorio

    /**
     *
     * @param model
     * @param cliente
     * @return a la pagina principal
     */

    @PostMapping("/guardar")
    public String guardarEmpleado(Model model, Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/confirmacion";
    }


}
