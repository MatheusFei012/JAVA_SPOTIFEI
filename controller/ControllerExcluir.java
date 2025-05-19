package controller;

import DAO.Conexao;
import DAO.PlaylistDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Playlist;
import view.ExcluirFrame;
import view.PlaylistFrame;

/**
 *
 * @author unicmcruz
 */
public class ControllerExcluir {
    
    private ExcluirFrame view;
    private Playlist playlist;

    public ControllerExcluir(ExcluirFrame view) {
        this.view = view;
    }
    
    public void excluirPlay(){
        String playlisttext = view.getPlaylist_excluir().getText();

        
        playlist = new Playlist(playlisttext, " ", " ", " ", " ", " ", " ");
        
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PlaylistDAO dao = new PlaylistDAO(conn);
            dao.remover(playlist);
            JOptionPane.showMessageDialog(view, "Playlist removida");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão!");
        }
    }
    
    

}
