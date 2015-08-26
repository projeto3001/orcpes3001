package br.estacio.poupeecompre.dominio;

public class Categoria extends EntidadeBase{
    private String descricao;

    public Categoria(String descricao){
        super();
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
