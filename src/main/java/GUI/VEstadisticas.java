
package GUI;

import Controlador.Controlador;
import data.Perro;

/**
 *
 * @author Rober y Cris
 */
public class VEstadisticas extends javax.swing.JFrame {

    /**
     * Creates new form VEstadisticas
     */
    Controlador c;
    public VEstadisticas(Controlador c) {
        this.c=c;
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        minitComponents();
        setTitle("Ventana Estadísticas");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bOK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        e_Estadisticas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setPreferredSize(new java.awt.Dimension(730, 500));

        bOK.setText("OK");
        bOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOKActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(e_Estadisticas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(bOK)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bOK)
                .addGap(26, 26, 26))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_bOKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bOK;
    private javax.swing.JLabel e_Estadisticas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void minitComponents() {
        String cad="<HTML><BODY><CENTER><H1><FONT COLOR=\"red\">ESTADÍSTICAS</H1></CENTER><BR>";
        cad+="<H3><FONT COLOR=\"blue\"> PERROS MAS MAYORES: </H3> <BR><UL>";
        for (Perro p: c.perrosConCondicion("MAX","edad")) {
            cad+="<LI>"+p+"</LI>";
        }
        cad+="</UL> <BR> <H3><FONT COLOR=\"blue\"> PERROS MAS JOVENES: </H3> <BR><UL>";
        for (Perro p: c.perrosConCondicion("MIN","edad")) {
            cad+="<LI>"+p+"</LI>";
        }
        cad+="</UL> <BR> </BODY> </HTML>";
        e_Estadisticas.setText(cad);
    }
}
