// Cronometro view, gerencia a parte visual da aplicação
// Importa as bibliotecas necessárias para criar o view
import javax.swing.*; // Necessária, afinal é o framework principal para a interface gráfica
import java.awt.*; // Necessária para a customização

public class CronometroView extends JFrame {
    // Atributos
    // Labels
    private JLabel lblDisplay;
    private JLabel lblVoltas;

    // Buttons
    private JButton btnIniciar;
    private JButton btnPausar;
    private JButton btnZerar;
    private JButton btnVolta;

    // Lists
    private JList<String> listaVoltas;
    private DefaultListModel<String> modeloVoltas;

    // Constructor
    public CronometroView() {
        // Define a janela do cronômetro
        setTitle("Cronometro"); // Título
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Permite o botão de fechar aplicação
        setResizable(true); // Dimensionável

        // Layout
        setLayout(new BorderLayout(6, 6));

        // Labels
        lblDisplay = new JLabel("00:00:00", SwingConstants.CENTER);
        lblVoltas = new JLabel("");

        JPanel painelVoltas = new JPanel(new BoxLayout(listaVoltas, BoxLayout.PAGE_AXIS));

        btnIniciar = new JButton("Iniciar");
        btnPausar = new JButton("Pausar");
        btnZerar = new JButton("Zerar");
        btnVolta = new JButton("Volta");
        listaVoltas = new JList<>();
        modeloVoltas = new DefaultListModel<>();

        pack();
        setLocationRelativeTo(null); // Centralizado
    }

    // Adiciona uma string de tempo à lista de voltas
    public void adicionarVolta(String tempo) {
        modeloVoltas.addElement(tempo);
    }

    // Setters
    // Atualiza o texto do label
    public void setDisplay(String texto) {
        lblDisplay.setText(texto);
    }

    // Ativa/Desativa botões se tiver rodando, zerar sempre fica habilitado
    public void setBotoesAtivos(boolean rodando) {
        btnIniciar.setEnabled(!rodando);
        btnPausar.setEnabled(rodando);
        btnVolta.setEnabled(rodando);
    }

    // Getters
    public JButton getBtnIniciar() {
        return btnIniciar;
    }
    public JButton getBtnPausar() {
        return btnPausar;
    }
    public JButton getBtnZerar() {
        return btnZerar;
    }
    public JButton getBtnVolta() {
        return btnVolta;
    }
}