


package grafos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class principal_gui extends javax.swing.JFrame {

     /*
     * Creates new form principal_gui
     */
    ArrayList<String> colaAtaques;
    
    public principal_gui() {
        initComponents();
        this.labelVidaJugador.setText("100 %");
        colaAtaques = new ArrayList<String>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        matriz = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        labelVidaJugador = new javax.swing.JLabel();
        botonAtacar = new javax.swing.JButton();
        textField_ataque = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        matriz1 = new javax.swing.JTable();
        coordenadasAtaque = new javax.swing.JTextField();
        botonAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        matriz.setBorder(new javax.swing.border.MatteBorder(null));
        matriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null, null, null, null, null, null, null, null, null},
                {"2", null, null, null, null, null, null, null, null, null, null},
                {"3", null, null, null, null, null, null, null, null, null, null},
                {"4", null, null, null, null, null, null, null, null, null, null},
                {"5", null, null, null, null, null, null, null, null, null, null},
                {"6", null, null, null, null, null, null, null, null, null, null},
                {"7", null, null, null, null, null, null, null, null, null, null},
                {"8", null, null, null, null, null, null, null, null, null, null},
                {"9", null, null, null, null, null, null, null, null, null, null},
                {"10", null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "a", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
            }
        ));
        matriz.setGridColor(new java.awt.Color(0, 0, 0));
        matriz.setShowGrid(true);
        matriz.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(matriz);

        jLabel1.setText("Vida : ");

        botonAtacar.setText("Atacar");
        botonAtacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtacarActionPerformed(evt);
            }
        });

        matriz1.setBorder(new javax.swing.border.MatteBorder(null));
        matriz1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null, null, null, null, null, null, null, null, null},
                {"2", null, null, null, null, null, null, null, null, null, null},
                {"3", null, null, null, null, null, null, null, null, null, null},
                {"4", null, null, null, null, null, null, null, null, null, null},
                {"5", null, null, null, null, null, null, null, null, null, null},
                {"6", null, null, null, null, null, null, null, null, null, null},
                {"7", null, null, null, null, null, null, null, null, null, null},
                {"8", null, null, null, null, null, null, null, null, null, null},
                {"9", null, null, null, null, null, null, null, null, null, null},
                {"10", null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "a", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
            }
        ));
        matriz1.setGridColor(new java.awt.Color(0, 0, 0));
        matriz1.setShowGrid(true);
        matriz1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(matriz1);

        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelVidaJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(textField_ataque, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(coordenadasAtaque))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(botonAtacar)
                            .addGap(18, 18, 18)
                            .addComponent(botonAgregar))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelVidaJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_ataque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coordenadasAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAtacar)
                    .addComponent(botonAgregar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtacarActionPerformed
        //aca poner el grafo enemigo
        Grafo a = (Grafo) Main.grafos.get(0);
        if(colaAtaques!=null){
            while(colaAtaques.size()>0){
                System.out.println("ultimo "+colaAtaques.get(colaAtaques.size()-1));
                String[] valores = colaAtaques.get(colaAtaques.size()-1).split("");
                int x = Integer.valueOf(valores[1]);
                int y = Integer.valueOf(valores[3]);;
                
                int valor = Integer.valueOf(this.textField_ataque.getText());
                a.atacarXY(x,y,valor);
                a.imprimir3();
                colaAtaques.remove(colaAtaques.size()-1);
                
                int vidaActual = a.pesoAristas();
                System.out.println("vida actual: "+vidaActual);
                System.out.println("vida original: "+a.pesoTotal);
                int porcentaje = vidaActual*100/(a.pesoTotal);
                this.labelVidaJugador.setText(String.valueOf(porcentaje)+" %");
            }
        }
        
        /*
        //aca poner el grafo enemigo
        Grafo a = (Grafo) Main.grafos.get(0);
        int valor = Integer.valueOf(this.textField_ataque.getText());
        a.atacarXY(2,4,valor);
        a.imprimir3();
        int vidaActual = a.pesoAristas();
        System.out.println("vida actual: "+vidaActual);
        System.out.println("vida original: "+a.pesoTotal);
        int porcentaje = vidaActual*100/(a.pesoTotal);
        this.labelVidaJugador.setText(String.valueOf(porcentaje)+" %");
        */
                
    }//GEN-LAST:event_botonAtacarActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        if(colaAtaques.size()<10){
           String valor = coordenadasAtaque.getText().toString();
            this.colaAtaques.add(valor);
            System.out.println("coordenadas "+colaAtaques); 
        }
        else{
            JOptionPane.showMessageDialog(this,"Maximo 10 ataques en la cola","warning",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonAgregarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principal_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal_gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonAtacar;
    private javax.swing.JTextField coordenadasAtaque;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelVidaJugador;
    public javax.swing.JTable matriz;
    public javax.swing.JTable matriz1;
    private javax.swing.JTextField textField_ataque;
    // End of variables declaration//GEN-END:variables
}
