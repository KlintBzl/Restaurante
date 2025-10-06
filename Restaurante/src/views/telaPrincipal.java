
package views;

import DAO.ConexaoDAO;
import java.sql.*;
import javax.swing.*;


public class telaPrincipal extends javax.swing.JFrame {

        Connection conexao = null;

    
    public telaPrincipal() {
        initComponents();
        conexao = ConexaoDAO.conector();
        System.out.println(conexao);

        if (conexao != null) {
            ImageIcon iconeVerde = new ImageIcon("src/Imagens/conectado.png");
            lblConexao.setIcon(iconeVerde);
            lblAtencao.setText("Conectado ao Banco de dados!");
        }
            
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblConexao = new javax.swing.JLabel();
        lblAtencao = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        MenuGerenciar = new javax.swing.JMenu();
        MenuClientes = new javax.swing.JMenuItem();
        MenuPedidos = new javax.swing.JMenuItem();
        MenuAjuda = new javax.swing.JMenu();
        MenuSobre = new javax.swing.JMenuItem();
        MenuOpcoes = new javax.swing.JMenu();
        MenuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        setResizable(false);

        lblConexao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/desconectado.png"))); // NOI18N

        lblAtencao.setText("Desconectado do banco de dados!!!");

        MenuGerenciar.setText("Gerenciar");

        MenuClientes.setText("Clientes");
        MenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuClientesActionPerformed(evt);
            }
        });
        MenuGerenciar.add(MenuClientes);

        MenuPedidos.setText("Pedidos");
        MenuPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPedidosActionPerformed(evt);
            }
        });
        MenuGerenciar.add(MenuPedidos);

        MenuBar.add(MenuGerenciar);

        MenuAjuda.setText("Ajuda");

        MenuSobre.setText("Sobre");
        MenuAjuda.add(MenuSobre);

        MenuBar.add(MenuAjuda);

        MenuOpcoes.setText("Opções");

        MenuSair.setText("Sair");
        MenuSair.setToolTipText("");
        MenuSair.setSelected(true);
        MenuSair.setVerifyInputWhenFocusTarget(false);
        MenuOpcoes.add(MenuSair);

        MenuBar.add(MenuOpcoes);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblConexao))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAtencao)))
                .addContainerGap(533, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(444, Short.MAX_VALUE)
                .addComponent(lblConexao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAtencao)
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClientesActionPerformed
        telaCliente cliente = new telaCliente();
        cliente.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuClientesActionPerformed

    private void MenuPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPedidosActionPerformed
        telaPedido pedido = new telaPedido();
        pedido.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuPedidosActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAjuda;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem MenuClientes;
    private javax.swing.JMenu MenuGerenciar;
    private javax.swing.JMenu MenuOpcoes;
    private javax.swing.JMenuItem MenuPedidos;
    private javax.swing.JMenuItem MenuSair;
    private javax.swing.JMenuItem MenuSobre;
    private javax.swing.JLabel lblAtencao;
    private javax.swing.JLabel lblConexao;
    // End of variables declaration//GEN-END:variables
}
