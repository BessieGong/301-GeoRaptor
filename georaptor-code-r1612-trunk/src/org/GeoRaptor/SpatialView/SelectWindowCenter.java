/*
 * SelectWindowCenter.java
 *
 * Created on Sobota, 18 marec 2006, 22:04
 */

package org.GeoRaptor.SpatialView;

import java.awt.Point;
import java.awt.geom.Point2D;

import java.text.DecimalFormat;

import java.text.ParsePosition;

import java.util.StringTokenizer;

import javax.swing.JDialog;

import javax.swing.SwingUtilities;

import org.GeoRaptor.SpatialView.SupportClasses.Envelope;
import org.GeoRaptor.tools.Coordinate;
import org.GeoRaptor.tools.ErrorDialogHandler;
import org.GeoRaptor.tools.PropertiesManager;
import org.GeoRaptor.tools.Tools;

/**
 *
 * @author  MaticP
 */
public class SelectWindowCenter extends JDialog {
    /**
     * Reference to main class
     */
    private SpatialViewPanel svPanel;

    /** 
     * Properties File Manager
     **/
    private static final String propertiesFile = "org.GeoRaptor.SpatialView.resource.SpatialViewPanel";
    protected PropertiesManager propertyManager = null;
    protected ErrorDialogHandler errorDialogHandler = null;

    /**
     * OK user operation
     */
    public static final String OPR_OK = "OK";

    /**
     * Cancel user operation
     */
    public static final String OPR_CANCEL = "CANCEL";

    /**
     * Last perform operation on dilaog
     */
    private String lastOpr = OPR_CANCEL;

    /** Creates new form SelectWindowCenter */
    public SelectWindowCenter(SpatialViewPanel _svPanel) 
    {
        try {
            initComponents();
    
            // get values from resource bandle
            this.svPanel = _svPanel;
       
            this.propertyManager = new PropertiesManager( propertiesFile );
            this.errorDialogHandler = new ErrorDialogHandler( propertiesFile );
            
            // set values from resource boudle
            //
            this.xL.setText(this.propertyManager.getMsg("SELECT_WINDOW_CENTER_X_LABEL"));
            this.yL.setText(this.propertyManager.getMsg("SELECT_WINDOW_CENTER_Y_LABEL"));
            this.okB.setText(this.propertyManager.getMsg("SELECT_WINDOW_CENTER_OK_B"));
            this.okB.setMnemonic(this.propertyManager.getMsg("SELECT_WINDOW_CENTER_OK_B_M").charAt(0));
            this.cancelB.setText(this.propertyManager.getMsg("SELECT_WINDOW_CENTER_CANCEL_B"));
            this.cancelB.setMnemonic(this.propertyManager.getMsg("SELECT_WINDOW_CENTER_CANCEL_B_M").charAt(0));
        } catch (Exception e) {
          
        }
    }

    /**
     * Set default variables
     */
    public void init() {
        this.setLastOpr(OPR_CANCEL);
        // set window coordinates
        Envelope rec = this.svPanel.getMapPanel().getWindow();
        final Coordinate center = rec.center();
        // format and set center number
        SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        DecimalFormat dFormat = Tools.getDecimalFormatter(svPanel.getActiveView().getPrecision(false),false);
                        xTF.setText(dFormat.format(center.x));
                        yTF.setText(dFormat.format(center.y));
                    }
                });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        xL = new javax.swing.JLabel();
        xTF = new javax.swing.JTextField();
        yL = new javax.swing.JLabel();
        yTF = new javax.swing.JTextField();
        okB = new javax.swing.JButton();
        cancelB = new javax.swing.JButton();

        xL.setText("_X:");

        yL.setText("_Y:");

        okB.setText("_OK");
        okB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBActionPerformed(evt);
            }
        });

        cancelB.setText("_Cancel");
        cancelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(xL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xTF, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yTF, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(okB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelB)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xL)
                    .addComponent(xTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yL)
                    .addComponent(yTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelB)
                    .addComponent(okB))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBActionPerformed
        this.lastOpr = OPR_CANCEL;
        this.setVisible(false);
    }//GEN-LAST:event_cancelBActionPerformed

    private void okBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBActionPerformed
        // check if input values are valid
        try  {
            getCenterX();
        } catch (Exception ex)  {
            this.errorDialogHandler.showErrorDialog(this,"SELECT_WINDOW_CENTER_ERROR", "X");
            return;
        } 
        try  {
            getCenterY();
        } catch (Exception ex)  {
            this.errorDialogHandler.showErrorDialog(this,"SELECT_WINDOW_CENTER_ERROR", "Y");
            return;
        } 
        
        this.lastOpr = SelectWindowCenter.OPR_OK;
        this.setVisible(false);
    }//GEN-LAST:event_okBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelB;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton okB;
    private javax.swing.JLabel xL;
    private javax.swing.JTextField xTF;
    private javax.swing.JLabel yL;
    private javax.swing.JTextField yTF;
    // End of variables declaration//GEN-END:variables

    public void setLastOpr(String lastOpr) {
        this.lastOpr = lastOpr;
    }

    public String getLastOpr() {
        return lastOpr;
    }
    
    public double getCenterX() {
        return getNumber(this.xTF.getText());
    }
    
    public double getCenterY() {
        return getNumber(this.yTF.getText());
    }

    public Point2D getCenter() {
        return new Point.Double(getNumber(this.xTF.getText()),getNumber(this.yTF.getText()));
    }
    
    /**
     * @method getNumber
     * @param _dNumber
     * @return double
     * @author Simon Greener, June 11th 2010
     *          Conversion from formatted string to double is based on iternationalisation symbols.
     */
    private double getNumber(String _dNumber ) 
    {
        DecimalFormat dFormat = Tools.getDecimalFormatter(svPanel.getActiveView().getPrecision(false),false);
        ParsePosition pp = new ParsePosition(0);
        Number num = dFormat.parse(_dNumber, pp);
        if ( num != null ) {
            return num.doubleValue();
        } else  {
            char decSymbol = dFormat.getDecimalFormatSymbols().getDecimalSeparator();
            char grpSymbol = dFormat.getDecimalFormatSymbols().getGroupingSeparator();
            String dNumber = _dNumber,
                   decValue = "", 
                   dValue = "",
                   tok = "";
                        
            // Convert -- depends on there always being a decimal place...
            if ( _dNumber.lastIndexOf(decSymbol) != -1 ) {
                decValue = _dNumber.substring(_dNumber.lastIndexOf(decSymbol)+1, _dNumber.length());
                dNumber      = _dNumber.substring(0,_dNumber.lastIndexOf(decSymbol)+1);
            }
            StringTokenizer st = new StringTokenizer(dNumber,String.valueOf(String.valueOf(grpSymbol)),true);
            while ( st.hasMoreTokens() ) {
                tok = st.nextToken();
                if ( Character.isDigit(tok.toCharArray()[0]) || tok.equalsIgnoreCase(String.valueOf(grpSymbol)) ) {
                    dValue += tok;
                }
            }
            return Double.parseDouble(dValue+"."+decValue);
        }
    }
}
