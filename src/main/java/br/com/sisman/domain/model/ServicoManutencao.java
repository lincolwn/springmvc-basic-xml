package br.com.sisman.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="servicoManutencao")
@EqualsAndHashCode 
@ToString
public class ServicoManutencao 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private Long id;
	
	@Size (min=6, max=6, message="O código do serviço de manutenção deve ter 6 caracteres." )
	@NotNull
	@Column(unique=true, length=6)
	@Getter @Setter
	private String codigo;
	
	@Getter @Setter
	@Size(max=50, message="A descrição não pode conter mais de 50 caracteres.")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="area_mnt_id", nullable=false)
	@Getter @Setter
	private AreaManutencao areaManutencao;
}
