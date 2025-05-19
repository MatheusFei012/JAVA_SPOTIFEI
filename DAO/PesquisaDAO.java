package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet; // <- Import necessário
import java.util.ArrayList;
import java.util.List;
import model.Pesquisa;

public class PesquisaDAO {
    private Connection conn;

    public PesquisaDAO(Connection conn) {
        this.conn = conn;
    }

    // Inserir novo artista
    public void inserir(Pesquisa pesquisa) throws SQLException {
        String sql = "INSERT INTO artista (nome) VALUES (?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pesquisa.getNome());

        statement.executeUpdate();
        statement.close(); // Fecha o statement
        // conn.close(); <-- Não feche aqui! Deixe para o chamador
    }
    
     // Inserir novo artista
    public void curtir(Pesquisa pesquisa) throws SQLException {
        String sql = "INSERT INTO curtir (nome) VALUES (?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pesquisa.getNome());

        statement.executeUpdate();
        statement.close(); // Fecha o statement
        // conn.close(); <-- Não feche aqui! Deixe para o chamador
    }

    // Buscar artista por nome
    public Pesquisa buscarPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM artista WHERE nome = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, nome);
        ResultSet rs = statement.executeQuery();

        Pesquisa pesquisa = null;

        if (rs.next()) {
            pesquisa = new Pesquisa();
            pesquisa.setNome(rs.getString("nome"));
        }

        rs.close(); // Fecha o ResultSet
        statement.close(); // Fecha o Statement
        // conn.close(); <-- Também não feche aqui

        return pesquisa;
    }
    
    
    
 
}

