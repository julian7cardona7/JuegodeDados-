import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dado {

    private int numero;
    private Random r = new Random();

    public void Lanzar() {
        numero = r.nextInt(6) + 1;
    }

    public void mostrar(JLabel lblDado) {
        String rutaImagen = "imagenes/"+numero+".jpeg";
        ImageIcon imgDado = new ImageIcon(getClass().getResource(rutaImagen));
        lblDado.setIcon(imgDado);

    }

    public int getNumero() {
        return numero;
    }

}
