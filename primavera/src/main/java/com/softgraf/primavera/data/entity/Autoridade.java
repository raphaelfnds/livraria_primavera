package com.softgraf.primavera.data.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
// tabela que define os roles do usuário
@Table(name="Authorities")
public class Autoridade {

	@EmbeddedId
	private AutoridadeId id;

	public AutoridadeId getId() {
		return id;
	}

	public void setId(AutoridadeId id) {
		this.id = id;
	}
	
	
}
