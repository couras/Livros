package br.biblioteca.livros.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {
	
	@Id
	@Column(name="id_usuario")
	@GeneratedValue
	private Long idUsuario;
	
	@Column(name="user_name", length=45, nullable=false)
	private String userName;
	
	@Column(name="email", length=45, nullable=true)
	private String email;
	
	@Column(name="password", length=45, nullable=false)
	private String password;

	@OneToMany(mappedBy="usuario")
	private List<Review> reviews = new ArrayList<Review>();
	
	@OneToMany(mappedBy="usuario")
	private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	
	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
}
