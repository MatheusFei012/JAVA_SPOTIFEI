package model;


public class Playlist {
    private String nome, musica1, musica2,musica3, musica4, musica5, usuario;

    public Playlist() {
    }

    public Playlist(String nome, String musica1, String musica2, String musica3, String musica4, String musica5, String usuario) {
        this.nome = nome;
        this.musica1 = musica1;
        this.musica2 = musica2;
        this.musica3 = musica3;
        this.musica4 = musica4;
        this.musica5 = musica5;
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMusica1() {
        return musica1;
    }

    public void setMusica1(String musica1) {
        this.musica1 = musica1;
    }

    public String getMusica2() {
        return musica2;
    }

    public void setMusica2(String musica2) {
        this.musica2 = musica2;
    }

    public String getMusica3() {
        return musica3;
    }

    public void setMusica3(String musica3) {
        this.musica3 = musica3;
    }

    public String getMusica4() {
        return musica4;
    }

    public void setMusica4(String musica4) {
        this.musica4 = musica4;
    }

    public String getMusica5() {
        return musica5;
    }

    public void setMusica5(String musica5) {
        this.musica5 = musica5;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
