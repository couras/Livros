package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Cliente;
import br.biblioteca.livros.services.ClienteService;

@Controller
@RequestMapping(ClienteController.PATH_CLIENTE)
public class ClienteController {
	public static final String  PATH_CLIENTE = "/cliente";
	public static final String PATH_CLIENTE_LIST = "/clientes";
	
	@Autowired
	ClienteService clienteService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@RequestMapping(PATH_CLIENTE_LIST)
	public ModelAndView clientes() {
		List<Cliente> listaClientes = clienteService.listaClientes();
		return new ModelAndView("cliente/clientes", "clientes", listaClientes);
	}
}
