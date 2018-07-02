package com.store.domain.enums;

public enum Perfil {

	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");
	
	private int codigo;
	private String descricao;
	
	private Perfil(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static Perfil toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}
		
		for (Perfil x : Perfil.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
	
}
