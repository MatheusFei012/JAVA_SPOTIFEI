package DAO;

import java.sql.*;
import java.util.*;
import model.Historico;

public class HistoricoDAO {
    private Connection conn;

    public HistoricoDAO(Connection conn) {
        this.conn = conn;
    }

    // Inserir nome no histórico
    public void inserir(Historico h) throws SQLException {
        String sql = "INSERT INTO historico (nome) VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, h.getNome());
        stmt.executeUpdate();
        stmt.close();
    }

    // Pegar últimos 10 nomes
    public List<Historico> listarUltimos10() throws SQLException {
        List<Historico> lista = new ArrayList<>();
        String sql = "SELECT nome FROM historico ORDER BY ctid DESC LIMIT 10";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Historico h = new Historico();
            h.setNome(rs.getString("nome"));
            lista.add(h);
        }

        rs.close();
        stmt.close();
        return lista;
    }
    

    public List<String> listarArtistasHistorico() throws SQLException {
        String sql = "SELECT nome FROM historico ORDER BY ctid DESC LIMIT 10";  // ordena pelo mais recente
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<String> artistas = new ArrayList<>();
        while (rs.next()) {
            artistas.add(rs.getString("nome"));
        }

        rs.close();
        stmt.close();
        return artistas;
    }

}
