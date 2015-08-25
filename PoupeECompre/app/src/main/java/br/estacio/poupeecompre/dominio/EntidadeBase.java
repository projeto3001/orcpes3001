package br.estacio.poupeecompre.dominio;

public class EntidadeBase {
    private Long id;

    public EntidadeBase(Long id){
        this.id = id;
    }

    public EntidadeBase(){}

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
}
