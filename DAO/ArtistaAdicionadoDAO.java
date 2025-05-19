package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pesquisa;
import java.sql.ResultSet;

public class ArtistaAdicionadoDAO {
    private Connection connection;

    public ArtistaAdicionadoDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Pesquisa artista) throws SQLException {
        String sql = "INSERT INTO artistas_adicionados (nome) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, artista.getNome());
            stmt.executeUpdate();
        }
    }
    
 
    
}
