// Cronometro app, inicia e chama todos os módulos
import javax.swing.SwingUtilities;

public class CronometroApp {
    public static void main(String[] args) {
        // Cria as instâncias dentro da Event Dispatch Thread (EDT)
        // para evitar comportamentos imprevisíveis
        SwingUtilities.invokeLater(() -> {
            CronometroModel model = new CronometroModel(); // Instancia model
            CronometroView view = new CronometroView(); // Instancia view
            new CronometroController(view, model); // Passa model e view para Controller

            view.setVisible(true); // View aparece visível
        });
    }
}