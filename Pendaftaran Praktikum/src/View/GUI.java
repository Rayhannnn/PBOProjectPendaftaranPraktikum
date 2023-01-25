package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class GUI {

    JFrame LogReg = new JFrame();
    JLabel login, daftar, top;
    JRadioButton radioaslab, radiopraktikan;
    JTextField textnpmlogin, textnama, textnotelp, texttgllahir, textnpmdaftar, textkelas;
    JLabel labelnpmlogin, labelnama, labelpasswordlogin, labelnotelp, labeltgllahir, labelnpmdaftar, labelpassworddaftar, kelaslabel;
    JButton check, reg;
    JPasswordField passwordlogin, passworddaftar;
    private boolean ceklogin = false;

    public GUI() {
        LogReg.setSize(700, 630);
        LogReg.setLayout(null);
        LogReg.getContentPane().setBackground(Color.PINK);
        top = new JLabel("Lab Rekayasa Perangkat Lunak");
        top.setBounds(50, 10, 600, 50);
        top.setFont(new Font("Times New Roman", Font.BOLD, 40));
        LogReg.add(top);
        login = new JLabel("login");
        login.setBounds(100, 50, 100, 100);
        login.setFont(new Font("Times New Roman", Font.BOLD, 30));
        LogReg.add(login);
        radioaslab = new JRadioButton("asisten Lab");
        login.setBounds(100, 50, 100, 100);

        radioaslab.setBounds(30, 150, 100, 30);
        radioaslab.setBackground(Color.CYAN);
        LogReg.add(radioaslab);
        radiopraktikan = new JRadioButton("praktikan");
        radiopraktikan.setBounds(149, 150, 100, 30);
        radiopraktikan.setBackground(Color.CYAN);
        LogReg.add(radiopraktikan);
        labelnpmlogin = new JLabel("NPM");
        labelnpmlogin.setBounds(38, 188, 30, 30);
        LogReg.add(labelnpmlogin);
        textnpmlogin = new JTextField();
        textnpmlogin.setBounds(30, 210, 200, 30);
        LogReg.add(textnpmlogin);
        labelpasswordlogin = new JLabel("Password");
        labelpasswordlogin.setBounds(39, 240, 100, 30);
        LogReg.add(labelpasswordlogin);
        passwordlogin = new JPasswordField();
        passwordlogin.setBounds(30, 279, 280, 36);
        LogReg.add(passwordlogin);
        check = new JButton("check");
        check.setBounds(90, 320, 180, 40);
        check.setBackground(Color.GREEN);
        LogReg.add(check);
        daftar = new JLabel("Buat Akun");
        daftar.setFont(new Font("Times New Roman", Font.BOLD, 30));
        daftar.setBounds(440, 50, 150, 100);
        LogReg.add(daftar);
        labelnpmdaftar = new JLabel("NPM");
        labelnpmdaftar.setBounds(400, 150, 30, 30);
        LogReg.add(labelnpmdaftar);
        textnpmdaftar = new JTextField();
        textnpmdaftar.setBounds(400, 180, 200, 30);
        LogReg.add(textnpmdaftar);
        labelnama = new JLabel("Nama");
        labelnama.setBounds(400, 210, 100, 30);
        LogReg.add(labelnama);
        textnama = new JTextField();
        textnama.setBounds(400, 240, 200, 30);
        LogReg.add(textnama);
        labelpassworddaftar = new JLabel("Password");
        labelpassworddaftar.setBounds(400, 270, 100, 30);
        LogReg.add(labelpassworddaftar);
        passworddaftar = new JPasswordField();
        passworddaftar.setBounds(400, 300, 200, 30);
        LogReg.add(passworddaftar);
        labelnotelp = new JLabel("No Telepon");
        labelnotelp.setBounds(400, 330, 100, 30);
        LogReg.add(labelnotelp);
        textnotelp = new JTextField();
        textnotelp.setBounds(400, 360, 200, 30);
        LogReg.add(textnotelp);
        labeltgllahir = new JLabel("tanggal Lahir (dd/mm/yyyy)");
        labeltgllahir.setBounds(400, 390, 200, 30);
        LogReg.add(labeltgllahir);
        texttgllahir = new JTextField();
        texttgllahir.setBounds(400, 420, 200, 30);
        LogReg.add(texttgllahir);
        kelaslabel = new JLabel("Kelas");
        kelaslabel.setBounds(400, 450, 200, 30);
        LogReg.add(kelaslabel);
        textkelas = new JTextField();
        textkelas.setBounds(400, 480, 200, 30);
        LogReg.add(textkelas);
        reg = new JButton("Daftar");
        reg.setBounds(460, 520, 100, 40);
        reg.setBackground(Color.GREEN);
        LogReg.add(reg);
        LogReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogReg.setVisible(true);
        LogReg.setLocationRelativeTo(null);
        radioaslab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (radioaslab.isSelected()) {
                    radiopraktikan.setSelected(false);
                    ceklogin = true;
                }
            }
        });
        radiopraktikan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (radiopraktikan.isSelected()) {
                    radioaslab.setSelected(false);
                    ceklogin = false;
                }
            }
        });
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ceklogin == true) {
                    try {
                        Allobjctrl.admin.dataAslab();
                        Allobjctrl.admin.login(textnpmlogin.getText(), passwordlogin.getText());
                        String nama = Allobjctrl.admin.aslabEntity07220().getNama();
                        JOptionPane.showMessageDialog(null, "selamat datang " + nama, "information", JOptionPane.INFORMATION_MESSAGE);
                        AslabGUI asisten = new AslabGUI();
                        LogReg.dispose();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(
                                null, "NPM atau password salah", "information", JOptionPane.INFORMATION_MESSAGE);
                        kosong();
                    }
                } else {
                    try {
                        Allobjctrl.Praktikan.login(textnpmlogin.getText(), passwordlogin.getText());
                        String nama = Allobjctrl.Praktikan.PraktikanEntity().getNama();
                        JOptionPane.showMessageDialog(null, "Selamat Datang " + nama, "information", JOptionPane.INFORMATION_MESSAGE);
                        PraktikanGUI prak = new PraktikanGUI();
                        LogReg.dispose();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, "NPM atau password salah", " information", JOptionPane.INFORMATION_MESSAGE);
                        kosong();
                    }
                }
            }
        });
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String npm = textnpmdaftar.getText();
                    String pass = passworddaftar.getText();
                    String nama = textnama.getText();
                    String notelp = textnotelp.getText();
                    Date tgllahir = new Date(texttgllahir.getText());
                    String kelas = textkelas.getText();
                    Allobjctrl.Praktikan.insert(npm, pass, nama, notelp, tgllahir, kelas);
                    JOptionPane.showMessageDialog(null, "Registrasi Sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Registrasi Gagal", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    void kosong() {
        textnpmdaftar.setText(null);
        passworddaftar.setText(null);
        textnama.setText(null);
        textnotelp.setText(null);
        texttgllahir.setText(null);
        textnpmlogin.setText(null);
        passwordlogin.setText(null);
        textkelas.setText(null);

    }
}
