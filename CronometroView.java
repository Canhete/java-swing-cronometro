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
    private JButton btnRemoverVolta;
    
    // Lists
    private JList<String> listaVoltas;
    private DefaultListModel<String> modeloVoltas;

    // Constructor
    public CronometroView() {
        // Define a janela do cronômetro
        setTitle("Cronômetro"); // Título
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Permite o botão de fechar aplicação
        setResizable(true); // Dimensionável

        // Display (NORTH)
        lblDisplay = new JLabel("00:00:00", SwingConstants.CENTER); // Texto centralizado
        lblDisplay.setFont(new Font("Monospaced", Font.BOLD, 48)); // Fonte em negrito e grande
        lblDisplay.setAlignmentX(Component.CENTER_ALIGNMENT); // Centralizado
        
        // Label voltas (NORTH)
        lblVoltas = new JLabel("Voltas: 0", SwingConstants.CENTER);
        lblVoltas.setFont(new Font("Monospaced", Font.PLAIN, 20));
        lblVoltas.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Cria painel para guardar diplay label de voltas
        JPanel painelTopo = new JPanel();
        painelTopo.setLayout(new BoxLayout(painelTopo, BoxLayout.Y_AXIS));
        painelTopo.add(lblDisplay);
        painelTopo.add(lblVoltas);
        add(painelTopo, BorderLayout.NORTH);
        
        // Lista de voltas (CENTER)
        modeloVoltas = new DefaultListModel<>(); // Cria modelo
        
        // Lista voltas (CENTER)
        listaVoltas = new JList<>(modeloVoltas); // Cria lista
        listaVoltas.setAlignmentX(Component.LEFT_ALIGNMENT);
        listaVoltas.setFont(new Font("Noto Sans Mono", Font.PLAIN, 16));
        listaVoltas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaVoltas.setLayoutOrientation(JList.VERTICAL_WRAP);
        
        // Botão remover volta (CENTER)
        btnRemoverVolta = new JButton("Remover Volta");
        btnRemoverVolta.setFont(new Font("Noto Sans Mono", Font.PLAIN, 16));
        btnRemoverVolta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JScrollPane scrollPane = new JScrollPane(listaVoltas);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Voltas")); // Borda com título
        add(scrollPane, BorderLayout.CENTER);
        
        // Botões de iniciar, pausar, zerar (SOUTH)
        btnIniciar = new JButton("Iniciar");
        btnIniciar.setFont(new Font("Noto Sans Mono", Font.PLAIN, 16));
        btnIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnPausar = new JButton("Pausar");
        btnPausar.setFont(new Font("Noto Sans Mono", Font.PLAIN, 16));
        btnPausar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnZerar = new JButton("Zerar");
        btnZerar.setFont(new Font("Noto Sans Mono", Font.PLAIN, 16));
        btnZerar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnVolta = new JButton("Volta");
        btnVolta.setFont(new Font("Noto Sans Mono", Font.PLAIN, 16));
        btnVolta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Cria o painel
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));

        // Adiciona cada botão ao painel
        painelBotoes.add(btnIniciar);
        painelBotoes.add(btnPausar);
        painelBotoes.add(btnZerar);
        painelBotoes.add(btnVolta);
        painelBotoes.add(btnRemoverVolta);
        add(painelBotoes, BorderLayout.SOUTH);

        setBotoesAtivos(false);

        setMinimumSize(new Dimension(400, 400));
        pack();
        setLocationRelativeTo(null); // Centralizado
    }

    // Adiciona uma string de tempo à lista de voltas
    public void adicionarVolta(String tempo) {
        modeloVoltas.addElement(tempo); // Adiciona string ao dado de lista de voltas
        lblVoltas.setText("Voltas: " + modeloVoltas.size()); // Conta quantas voltas foram dadas
    }
    
     // Remove uma volta da lista de voltaas
    public void removerVolta() {
        int index = listaVoltas.getSelectedIndex();
        if (index != -1) {
            modeloVoltas.remove(index);
            lblVoltas.setText("Voltas: " + modeloVoltas.size());
        }
    }

    // Setters
    // Atualiza o texto do label
    public void setDisplay(String texto) {
        lblDisplay.setText(texto);
    }

    // Atualiza botão de iniciar/continuar
    public void setIniciar(String texto) {
        btnIniciar.setText(texto);
    }
    
    // Ativa/Desativa botões se tiver rodando, zerar sempre fica habilitado
    public void setBotoesAtivos(boolean rodando) {
        btnIniciar.setEnabled(!rodando);
        btnPausar.setEnabled(rodando);
        btnVolta.setEnabled(rodando);
        btnRemoverVolta.setEnabled(false);
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
    public JButton getBtnRemoverVolta() {
        return btnRemoverVolta;
    }
    public JList getListaVoltas() {
        return listaVoltas;
    }
}