package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.Cliente;


public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Cliente aluno) throws SQLException{
       // String sql = "select * from aluno where usuario = '" +
       //               aluno.getUsuario() + "' AND senha = '" +
       //               aluno.getSenha()   + "'";
        String sql = "select * from usuarios where usuario = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, aluno.getUsuario());
        statement.setString(2, aluno.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void atualizar(Cliente aluno) throws SQLException{
        String sql = "update aluno set senha = ? where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, aluno.getSenha());
        statement.setString(2, aluno.getUsuario());
        statement.execute();
        conn.close();
    }
    
    public void remover (Cliente aluno) throws SQLException{
        String sql = "delete from aluno where usuario = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, aluno.getUsuario());
        statement.execute();
        conn.close();
    }
    public void inserir(Cliente aluno) throws SQLException{
        String sql = "insert into usuarios (nome, usuario, senha) values ('"
                     + aluno.getNome()    + "' , '"
                     + aluno.getUsuario() + "' , '"
                     + aluno.getSenha()   + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
}
