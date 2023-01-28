/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labo;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import javax.swing.*;


public class Impression1 extends JPanel implements Printable, ActionListener{

  /** **/

JPanel frameToPrint;

    Impression1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  public int print(Graphics g, PageFormat pf, int page) throws PrinterException {

    if (page > 0) {
      return NO_SUCH_PAGE;
    }

    Graphics2D g2d = (Graphics2D) g;
    g2d.translate(pf.getImageableX(), pf.getImageableY());

    frameToPrint.printAll(g);

    return PAGE_EXISTS;
   }

  public void actionPerformed(ActionEvent e) {
    PrinterJob job = PrinterJob.getPrinterJob();
    job.setPrintable(this);
    boolean ok = job.printDialog();
    if (ok) {
      try {
        job.print();
      } catch (PrinterException ex) {
     }
    }
  }

  public Impression1(JPanel f) {
    frameToPrint = f;
  }

 }

