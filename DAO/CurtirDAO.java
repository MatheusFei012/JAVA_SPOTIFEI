package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Curtir;

public class CurtirDAO {
    private Connection conn;

    public CurtirDAO(Connection conn) {
        this.conn = conn;
    }

    public void remover_curtida(Curtir curtir) throws SQLException {
        String sql = "DELETE FROM curtir WHERE nome = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, curtir.getNome());
        statement.execute();
        statement.close(); // ✅ Fechar o statement corretamente
        // ❌ NÃO feche a conexão aqui (quem chama decide isso)
    }

    public List<Curtir> listarcurtidas() throws SQLException {
        String sql = "SELECT * FROM curtir";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Curtir> lista = new ArrayList<>();
        while (rs.next()) {
            Curtir p = new Curtir();
            p.setNome(rs.getString("nome"));
            lista.add(p);
        }

        rs.close();
        stmt.close();
        return lista;
    }
}
