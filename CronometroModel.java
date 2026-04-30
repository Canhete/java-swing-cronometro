// Cronometro Model, gerencia a parte lógica da aplicação

public class CronometroModel {
    // Atributos
    private int segundosDecorridos; // Conta os segundos
    boolean rodando; // Controla se o timer está rodando ou não

    // Incrementa o contador
    public void incrementar() {
        segundosDecorridos++;
    }

    // Zera o contador
    public void zerar() {
        segundosDecorridos = 0;
    }

    // Getter
    public boolean isRodando() {
        return rodando;
    }

    // Obtem o tempo, mas formatado para string
    public String getTempoFormatado() {
        int horas = segundosDecorridos / 3600;
        int minutos = (segundosDecorridos % 3600) / 60;
        int segundos = segundosDecorridos % 60;

        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    // Setters
    public void setRodando(boolean rodando) {
        this.rodando = rodando;
    };
}