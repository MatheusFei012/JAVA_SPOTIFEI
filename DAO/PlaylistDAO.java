package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Playlist;
import model.Cliente;
import view.PlaylistFrame;


public class PlaylistDAO {
        
        private Connection conn;

    public PlaylistDAO(Connection conn) {
        this.conn = conn;
    }
        
        
    
    
        public void inserir(Playlist playlist) throws SQLException{
        String sql = "insert into playlists (nome, musica1, musica2,musica3, musica4, musica5, usuario) values ('"
                     + playlist.getNome()    + "' , '"
                     + playlist.getMusica1() + "' , '"
                     + playlist.getMusica2() + "' , '"
                     + playlist.getMusica3() + "' , '"
                     + playlist.getMusica4() + "' , '"
                     + playlist.getMusica5() + "' , '"
                     + playlist.getUsuario() + "')";
                     
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
        
        
        public void remover (Playlist playlist) throws SQLException{
        String sql = "delete from playlists where nome = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, playlist.getNome());
        statement.execute();
        conn.close();
    }
        
        public List<Playlist> listarTudo() throws SQLException {
        String sql = "SELECT * FROM playlists";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Playlist> lista = new ArrayList<>();
        while (rs.next()) {
            Playlist p = new Playlist();
            p.setNome(rs.getString("nome"));
            lista.add(p);
        }

        rs.close();
        stmt.close();
        return lista;
    }

    

}

