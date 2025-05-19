package controller;

import DAO.Conexao;
import DAO.CurtirDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Curtir;
import view.CurtidasFrame;

public class ControllerCurtir {
    private CurtidasFrame view;

    public ControllerCurtir(CurtidasFrame view) {
        this.view = view;
    }

    public void excluirCurtidas() {
        String curtirtext = view.getTxt_descurtir_artista().getText();

        // Criar objeto Curtir e setar o nome corretamente
        Curtir curtir = new Curtir();
        curtir.setNome(curtirtext);

        Conexao conexao = new Conexao();
        Connection conn = null;

        try {
            conn = conexao.getConnection();
            CurtirDAO dao = new CurtirDAO(conn);
            dao.remover_curtida(curtir);
            JOptionPane.showMessageDialog(view, "Artista descurtido!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao remover curtida!");
        } finally {
            // Fechar conexão após uso
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }
    
     public void carregarArtistasCurtidos() {
        Conexao conexao = new Conexao();
        try (Connection conn = conexao.getConnection()) {
            CurtirDAO dao = new CurtirDAO(conn);
            List<Curtir> curtidas = dao.listarcurtidas();

            StringBuilder resultado = new StringBuilder("<html>");
            for (Curtir h : curtidas) {
                resultado.append(h.getNome()).append("<br>");
            }
            resultado.append("</html>");

            view.getLbl_resultado_curtidas().setText(resultado.toString());

        } catch (SQLException e) {
            view.getLbl_resultado_curtidas().setText("Erro ao carregar curtidas.");
        }
    }
}
