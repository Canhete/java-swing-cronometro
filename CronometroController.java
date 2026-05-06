// Cronometro Controller, atualiza tanto o Model, quanto o View, para mantê-los sincronizados
// Bibliotecas
import java.awt.event.ActionEvent; // Biblioteca necessária para criar eventos
import javax.swing.JButton; // Biblioteca necessária para criar o botão interativo
import javax.swing.JList; // JList
import javax.swing.Timer; // Importa timer

public class CronometroController {
    private final CronometroView view;
    private final CronometroModel model;
    private final Timer timer;

    // Constructor
    public CronometroController(CronometroView view, CronometroModel model) {
        this.view = view;
        this.model = model;
        timer = new Timer(1000, e -> {
            model.incrementar();
            view.setDisplay(
                    model.getTempoFormatado()
            );
        });
        pausar();
        view.setIniciar("Iniciar");
        configurarEventos();
    }

    // Iniciar cronômetro
    public void iniciar() {
        timer.start(); // Timer começa
        model.setRodando(true); // Rodando é verdadeiro
        view.setDisplay(model.getTempoFormatado());
        view.setIniciar("Rodando");
        view.setBotoesAtivos(model.isRodando());
    }

    // Pausar cronômetro
    public void pausar() {
        timer.stop(); // Pausa o timer
        model.setRodando(false); // Não está rodando
        view.setDisplay(model.getTempoFormatado());
        view.setIniciar("Continuar");
        view.setBotoesAtivos(model.isRodando());
    }

    // Zera o cronômetro
    public void zerar() {
        timer.stop();
        model.zerar();
        model.setRodando(false);
        view.setDisplay(model.getTempoFormatado());
        view.setIniciar("Iniciar");
        view.setBotoesAtivos(model.isRodando());
    }

    // Registra uma volta (salva a String atual e continua rodando)
    public void registrarVolta() {
        view.adicionarVolta(
                model.getTempoFormatado()
        );
    }
    
    // Remove uma volta da lista de voltaas
    public void removerVolta() {
        view.removerVolta();
    }

    // Configura os eventos
    public void configurarEventos() {
        JButton btnInicar = view.getBtnIniciar();
        JButton btnPausar = view.getBtnPausar();
        JButton btnZerar = view.getBtnZerar();
        JButton btnVolta = view.getBtnVolta();
        JButton btnRemoverVolta = view.getBtnRemoverVolta();
        JList listaVoltas = view.getListaVoltas();

        // Adiciona eventos a cada um deles e associa a uma função
        btnInicar.addActionListener((ActionEvent e) -> iniciar());
        btnPausar.addActionListener((ActionEvent e) -> pausar());
        btnZerar.addActionListener((ActionEvent e) -> zerar());
        btnVolta.addActionListener((ActionEvent e) -> registrarVolta());
        btnRemoverVolta.addActionListener((ActionEvent e) -> removerVolta());

        listaVoltas.addListSelectionListener(e -> {
            btnRemoverVolta.setEnabled(listaVoltas.getSelectedIndex() != -1);
        });
    }
}