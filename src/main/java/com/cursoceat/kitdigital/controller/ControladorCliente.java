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
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping ("/listado-clientes")
    public String listaClientes(Model model) {
        model.addAttribute("listaClientes",clienteRepository.findAll());

        return "listado-clientes";

    }
    @GetMapping ("/")
    public String inicio(Model model) {
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

    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable int id, Model model) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        model.addAttribute("cliente", cliente);
        return "registro-clientes";
    }
    /*
        utilizamos un getmapping para una página externa para eliminar los empleados que se den de baja
        de la empresa y de sus cargos
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable int id) {
        clienteRepository.deleteById(id);
        return "redirect:/listado-clientes";
    }
}
