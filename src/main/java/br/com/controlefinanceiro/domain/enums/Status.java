package br.com.controlefinanceiro.domain.enums;

public enum Status {

	ABERTO(1,"ROLE_ABERTO"),
	PAGO(2,"ROLE_PAGO"),
	VENCIDO(3,"ROLE_VENCIDO"),
	INADIMPLENTE(3,"ROLE_INADIMPLENTE");
	
	private Integer cod;
	private String descricao;

	Status(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
    public static Status toEnum (Integer id) {//id chega para comparação

        if(id == null) {
            return null;
        }
        for(Status ids : Status.values()) {//compara id vindo da tela com cdigo do enum
            if(id.equals(ids.getCod())) {
                return ids;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + id);
    }
	
	
	
}
