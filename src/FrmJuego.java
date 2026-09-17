import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrmJuego extends JFrame {

    public FrmJuego() {
        setSize(500, 300);
        setTitle("Juguemos a los dados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // cargar una imagen que corresponda a una de las caras de los dados
        String rutaImagen = "imagenes/3.jpeg";
        ImageIcon imgDado = new ImageIcon(getClass().getResource(rutaImagen));

        lblDado1 = new JLabel(imgDado);
        lblDado1.setBounds(10, 10, imgDado.getIconWidth(), imgDado.getIconHeight());
        add(lblDado1);

        lblDado2 = new JLabel(imgDado);
        lblDado2.setBounds(20 + 10 + imgDado.getIconWidth(), 10, imgDado.getIconWidth(), imgDado.getIconHeight());
        add(lblDado2);

        JLabel lblTituloLanzamientos = new JLabel("Lanzamientos");
        lblTituloLanzamientos.setBounds(30 + 2 * imgDado.getIconWidth(), 10, 100, 25);
        lblTituloLanzamientos.setHorizontalAlignment(JLabel.CENTER);
        add(lblTituloLanzamientos);

        JLabel lblTituloCenas = new JLabel("Cenas");
        lblTituloCenas.setBounds(140 + 2 * imgDado.getIconWidth(), 10, 100, 25);
        lblTituloCenas.setHorizontalAlignment(JLabel.CENTER);
        add(lblTituloCenas);

        lblLanzamientos = new JLabel("0");
        lblLanzamientos.setBounds(30 + 2 * imgDado.getIconWidth(), 45, 100, 100);
        lblLanzamientos.setFont(new Font("Impact", Font.BOLD, 72));
        lblLanzamientos.setHorizontalAlignment(JLabel.RIGHT);
        lblLanzamientos.setBackground(new Color('0', 0, 0));
        lblLanzamientos.setForeground(new Color('0', 255, 0));
        lblLanzamientos.setOpaque(true);
        add(lblLanzamientos);

        lblCenas = new JLabel("0");
        lblCenas.setBounds(140 + 2 * imgDado.getIconWidth(), 45, 100, 100);
        lblCenas.setFont(new Font("Impact", Font.BOLD, 72));
        lblCenas.setHorizontalAlignment(JLabel.RIGHT);
        lblCenas.setBackground(new Color('0', 0, 0));
        lblCenas.setForeground(new Color('0', 255, 0));
        lblCenas.setOpaque(true);
        add(lblCenas);

        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.setBounds(10, 20 + imgDado.getIconHeight(), 100, 25);
        add(btnIniciar);

        JButton btnLanzar = new JButton("Lanzar");
        btnLanzar.setBounds(10, 55 + imgDado.getIconHeight(), 100, 25);
        add(btnLanzar);

        // eventos
        btnIniciar.addActionListener(evento -> {
            IniciarLanzamientos();

        });

        btnLanzar.addActionListener(evento -> {
            RealizarLanzamiento();

        });
    }

    // Variables globales
    private JLabel lblDado1, lblDado2, lblLanzamientos, lblCenas;
    private Dado dado1 = new Dado();
    private Dado dado2 = new Dado();

    private int lanzamientos, cenas;

    private void IniciarLanzamientos() {

        lanzamientos = 0;
        lblLanzamientos.setText("0");

        cenas = 0;
        lblCenas.setText("0");

    }

    private void RealizarLanzamiento() {

        // lanzar dados
        dado1.Lanzar();
        dado2.Lanzar();

        // mostrar dados
        dado1.mostrar(lblDado1);
        dado2.mostrar(lblDado2);

        // contar lanzamientos
        lanzamientos++;
        lblLanzamientos.setText(String.valueOf(lanzamientos));

        // contar cenas
        if (dado1.getNumero() + dado2.getNumero() >= 11) {
            cenas++;
            lblCenas.setText(String.valueOf(cenas));
        }

    }
}
