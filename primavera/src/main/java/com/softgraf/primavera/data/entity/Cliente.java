package com.softgraf.primavera.data.entity;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.softgraf.primavera.data.model.GrupoCnpj;
import com.softgraf.primavera.data.model.GrupoCpf;
import com.softgraf.primavera.data.model.TipoPessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


// Anotações JPA
@Table(name="clientes")
@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 414789771607776382L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Tipo de pessoa é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pessoa", length = 8)
	private TipoPessoa tipoPessoa;
	
	@NotBlank(message = "Nome é obrigatório")
	@Size(min=3, max=60)
	@Column(length = 60, nullable = false)
	private String nome;
	
	@NotBlank(message = "CPF/CNPJ é obrigatório")
	@CPF(groups = GrupoCpf.class)
	@CNPJ(groups = GrupoCnpj.class)
	@Column(name = "cpf_cnpj", nullable = false)
	private String cpfOuCnpj;
	
	@Size(max=60)
	@Email(message = "E-mail inválido")
	@Column(length = 60)
	private String email;
	
	@Column(length = 14)
	private String fone;
	
	@Embedded
	private Endereco endereco;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
	

}
