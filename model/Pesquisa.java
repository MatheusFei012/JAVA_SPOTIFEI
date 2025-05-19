package model;

/**
 *
 * @author mcruz
 */
public class Pesquisa {
    private String nome;
    
    public Pesquisa() {
    }
    
    public Pesquisa (String nome){
        this.nome = nome;
    }
    
     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
