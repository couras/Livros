package br.biblioteca.livros.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Usuario;
import br.biblioteca.livros.services.RoleService;
import br.biblioteca.livros.services.SecurityService;
import br.biblioteca.livros.services.UserService;
import br.biblioteca.livros.services.UsuarioService;
import br.biblioteca.livros.validator.LoginValidator;
import br.biblioteca.livros.validator.UserValidator;


@Controller
@RequestMapping(UsuarioController.PATH_USUARIO)
public class UsuarioController {
	public static final String  PATH_USUARIO = "/usuario";
	public static final String PATH_USUARIO_LIST = "/usuarios";
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private LoginValidator loginValidator;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@RequestMapping(PATH_USUARIO_LIST)
	public ModelAndView usuarios() {
		List<Usuario> listaUsuarios = usuarioService.listaUsuarios();
		return new ModelAndView("usuario/usuarios", "usuarios", listaUsuarios);
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("usuario/form", "userForm", new Usuario());
	}

	@PostMapping("/autentication")
	public ModelAndView autentication(@ModelAttribute("userForm") Usuario userForm, BindingResult bindingResult,
			Model model) {

		loginValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return new ModelAndView("usuario/form");
		}

		securityService.login(userForm.getUserName(), userForm.getPassword());
		return new ModelAndView("redirect:/usuario/list");
	}
	
	@GetMapping("/list")
	public ModelAndView list() {
		return new ModelAndView("/usuario/list");
	}

	@GetMapping("/listadmin")
	public ModelAndView listadmin(Usuario user) {

		List<Usuario> users = userService.findAll();
		return new ModelAndView("/usuario/listadmin", "users", users);
	}
	
	@GetMapping(value = "/registration")
	public ModelAndView registration() {

		ModelAndView md = new ModelAndView("usuario/registration", "userForm", new Usuario());
		
		md.addObject("roles", roleService.listRoles());
		
		return md;
	}

	@PostMapping(value = "/registration")
	public ModelAndView registrationform(@ModelAttribute("userForm") Usuario userForm, BindingResult bindingResult,
			Model model) {

		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return new ModelAndView("usuario/registration");
		}

		String password = userForm.getPassword();

		userService.save(userForm);

		try {

			securityService.login(userForm.getUserName(), password);
			return new ModelAndView("redirect:/usuario/list");

		} catch (Exception e) {

			return new ModelAndView("redirect:/usuario/login");
		}
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		SecurityContextHolder.clearContext();
		if (session != null) {
			session.invalidate();
		}

		return "redirect:/usuario/login";
	}
	
	
}
