package br.estacio.poupeecompre.dominio;

public class EntidadeBase {
    private Long id;

    public EntidadeBase(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }
}
