package br.com.controlefinanceiro.domain.enums;

public enum Perfis {

    RESPONSAVEL(1,"ROLE_RESPONSAVEL"),
    ADMIN(2, "ROLE_ADMIN");

    private Integer cod; 
    private String descriao;

    Perfis(Integer cod, String descriao) {
        this.cod = cod;
        this.descriao = descriao;
    }

    public String getDescriao() {
        return descriao;
    }

    public Integer getCod() {
        return cod;
    }

    public static Perfis toEnum (Integer id) {//id chega para comparação

        if(id == null) {
            return null;
        }
        for(Perfis ids : Perfis.values()) {//compara id vindo da tela com cdigo do enum
            if(id.equals(ids.getCod())) {
                return ids;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + id);
    }
}