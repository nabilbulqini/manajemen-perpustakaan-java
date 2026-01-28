/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan.main;

/**
 *
 * @author LENOVO
 */
import perpustakaan.gui.Dashboard;

public class MainApp {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Dashboard().setVisible(true);
        });
    }
}
