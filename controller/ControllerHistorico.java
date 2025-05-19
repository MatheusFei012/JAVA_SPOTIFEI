package controller;

import DAO.Conexao;
import DAO.HistoricoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import model.Historico;
import view.HistoricoFrame;

public class ControllerHistorico {
    private HistoricoFrame view;

    public ControllerHistorico(HistoricoFrame view) {
        this.view = view;
    }

    public void carregarUltimosHistoricos() {
        Conexao conexao = new Conexao();
        try (Connection conn = conexao.getConnection()) {
            HistoricoDAO dao = new HistoricoDAO(conn);
            List<Historico> historicos = dao.listarUltimos10();

            StringBuilder resultado = new StringBuilder("<html>");
            for (Historico h : historicos) {
                resultado.append(h.getNome()).append("<br>");
            }
            resultado.append("</html>");

            view.getLblHistorico().setText(resultado.toString());

        } catch (SQLException e) {
            view.getLblHistorico().setText("Erro ao carregar histórico.");
        }
    }
}
