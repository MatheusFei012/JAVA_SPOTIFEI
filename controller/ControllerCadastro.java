package controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import model.Cliente;
import view.CadastroFrame;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JOptionPane;


public class ControllerCadastro {
    private CadastroFrame view;

    public ControllerCadastro(CadastroFrame view) {
        this.view = view;
    }
    
    public void salvarAluno(){
        String nome = view.getTxt_nome_cadastro().getText();
        String usuario = view.getTxt_usuario_cadastro().getText();
        String senha = view.getTxt_senha_cadastro().getText();
        Cliente aluno = new Cliente(nome, usuario, senha);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.inserir(aluno);
            JOptionPane.showMessageDialog(view, "Usuário Cadastrado");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão!");
        }
    }
}
