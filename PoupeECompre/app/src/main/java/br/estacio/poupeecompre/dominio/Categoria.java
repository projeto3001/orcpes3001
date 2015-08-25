package br.estacio.poupeecompre.dominio;

public class Categoria extends EntidadeBase{
    private String descricao;

    private Categoria(String descricao){
        super();
        this.descricao = descricao;
    }

    public static Categoria criar(String descricao){
        return new Categoria(descricao);
    }

    public String getDescricao() {
        return descricao;
    }
}
