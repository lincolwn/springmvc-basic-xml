package br.com.sisman.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Email;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="usuarios")
@EqualsAndHashCode
@ToString
public class Usuario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;
	
	@NotNull(message="Digite o nome.")
	@Size(max=50, message="O nome não pode exceder 50 caracteres.")
	@Getter @Setter
	private String nome;
	
	@NotNull(message="Digite o email.")
	@Email(message="Insira um email válido")
	@Getter @Setter
	private String email;
	
	@NotNull(message="Digite uma senha.")
	@Size(min=8, max=15, message="A senha deve possuir de 8 a 15 caracteres.")
	@Getter @Setter
	private String senha;
	
	@Getter @Setter
	private boolean habilitado;
}
