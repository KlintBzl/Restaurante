package DAO;

import DAO.ConexaoDAO;
import DTO.PedidoDTO;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import views.telaPedido;


public class PedidoDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;


    public void inserirUsuario(PedidoDTO objPedidoDTO) {
        String sql = "insert into pedidos (id_pedido, id_cliente, data_pedido, valor_total)"
                + " values (?, ?, ?, ?)";
        conexao = ConexaoDAO.conector();
        
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objPedidoDTO.getId());
            pst.setInt(2, objPedidoDTO.getIdC());
            pst.setDate(3, objPedidoDTO.getData());
            pst.setDouble(4, objPedidoDTO.getValorTotal());
            int add  = pst.executeUpdate();
            if (add > 0) {
                pesquisaAuto();
                pst.close();
                limparCampos();
                JOptionPane.showMessageDialog(null, "Pedido inserido com sucesso! ");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " Método Inserir " + e);
        }
    }

    public void listar() {
        
        String sql = "SELECT p.id_pedido, c.nome AS cliente, p.data_pedido, p.valor_total "
                   + "FROM pedidos p "
                   + "INNER JOIN clientes c ON p.id_cliente = c.id_cliente";

        try (Connection conexao = ConexaoDAO.conector();
             PreparedStatement pst = conexao.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {
                JOptionPane.showMessageDialog(null,
                        "Cliente cadastrado: \n"
                        + rs.getString(1) + "\n"
                        + rs.getString(2) + "\n"
                        + rs.getString(3) + "\n"
                        + rs.getString(4) );
                
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
                limparCampos();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void pesquisaAuto() {
        String sql = "select * from pedidos";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) telaPedido.tbPedidos.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                int id = rs.getInt("id_pedido");
                int idC = rs.getInt("id_cliente");
                String data = rs.getString("data_pedido");
                String total = rs.getString("valor_total");
                model.addRow(new Object[]{id, idC, data, total});
            }
            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método Pesquisar Automático " + e);
        }
    }

    //Método editar
    public void editar(PedidoDTO objPedidoDTO) {
        String sql = "update pedidos set id_cliente = ?, data_pedido = ?, valor_total = ? where id_pedido = ?";
        conexao = ConexaoDAO.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(4, objPedidoDTO.getId());
            pst.setInt(3, objPedidoDTO.getIdC());
            pst.setDate(2, objPedidoDTO.getData());
            pst.setDouble(1, objPedidoDTO.getValorTotal());
            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Pedido editado com sucesso!");
                pesquisaAuto();
                conexao.close();
                limparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método editar " + e);
        }
    }

    //Método deletar
    public void deletar(PedidoDTO objPedidoDTO) {
        String sql = "delete from pedidos where id_pedido = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objPedidoDTO.getId());
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, " Pedido deletado com sucesso!");
                pesquisaAuto();
                conexao.close();
                limparCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método deletar " + e);
        }
    }

    public void limparCampos() {
        telaPedido.txtId.setText(null);
        telaPedido.txtIdC.setText(null);
        telaPedido.txtData.setText(null);
        telaPedido.txtValorTotal.setText(null);
    }
    
}