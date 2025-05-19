package DAO;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.Ouvir;

public class OuvirDAO {
        private Connection conn;

        public OuvirDAO(Connection conn) {
            this.conn = conn;
        }

    public List<Ouvir> listarArtistasouvir() throws SQLException {
            List<Ouvir> lista = new ArrayList<>();
            String sql = "SELECT nome FROM artistas_adicionados ORDER BY ctid DESC LIMIT 10";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Ouvir h = new Ouvir();
                h.setNome(rs.getString("nome"));
                lista.add(h);
            }

            rs.close();
            stmt.close();
            return lista;
        }

    public void remover_artistas (Ouvir ouvir) throws SQLException{
            String sql = "delete from artistas_adicionados where nome = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, ouvir.getNome());
            statement.execute();
            conn.close();
        }   

    public List<Ouvir> listarPlaylistouvir() throws SQLException {
        String sql = "SELECT DISTINCT nome FROM playlists"; 
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Ouvir> lista = new ArrayList<>();
        while (rs.next()) {
            Ouvir p = new Ouvir();
            p.setNome(rs.getString("nome")); 
            lista.add(p);
        }

        rs.close();
        stmt.close();
        return lista;
    }
    
    


}

