package controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import model.Cliente;
import view.LoginFrame;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import view.InicioFrame;
import view.PlaylistFrame;
import view.PesquisaFrame;


public class ControllerLogin {
    private LoginFrame view;

    public ControllerLogin(LoginFrame view) {
        this.view = view;
    }
    
    public void loginAluno(){
        Cliente aluno = new Cliente(null, 
                                view.getTxt_usuario_login().getText(),
                                view.getTxt_senha_login().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(aluno);
            if(res.next()){
                JOptionPane.showMessageDialog(view,"Login Efetuado!");
                String nome = res.getString("nome");
                String usuario = res.getString("usuario");
                String senha = res.getString("senha");
                Cliente aluno2 = new Cliente(nome, usuario, senha);
                InicioFrame aec = new InicioFrame();
                aec.setVisible(true);
                view.setVisible(false);
            } else{
                JOptionPane.showMessageDialog(view, "Login Não Efetuado!");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão!");
        }
    }
}
