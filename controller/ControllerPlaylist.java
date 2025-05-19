package controller;

import DAO.Conexao;
import DAO.PlaylistDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Playlist;
import view.PlaylistFrame;


        
public class ControllerPlaylist {
    private PlaylistFrame view;
    private Playlist playlist;

    public ControllerPlaylist(PlaylistFrame view) {
        this.view = view;
    }
    
    public void adicionarPlay(){
        String playlisttext = view.getPlaylist_musica().getText();
        String musica1 = view.getMusica1_play().getText();
        String musica2 = view.getMusica2_play().getText();
        String musica3 = view.getMusica3_play().getText();
        String musica4 = view.getMusica4_play().getText();
        String musica5 = view.getMusica5_play().getText();
        String usuarioplay = view.getTxt_usuario_play().getText();
        
        playlist = new Playlist(playlisttext, musica1, musica2, musica3, musica4, musica5, usuarioplay);
        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            dao.inserir(playlist);
            JOptionPane.showMessageDialog(view, "Música Cadastrada");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão!");
        }
    }
    
    public List<Playlist> buscarTudo() {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            return dao.listarTudo();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
    
