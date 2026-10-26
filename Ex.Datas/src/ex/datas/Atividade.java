package ex.datas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Atividade {
    private LocalDateTime dataHora;
    private String descricao;
    
    public Atividade(LocalDateTime dataHora, String descricao){
        this.dataHora = dataHora;
        this.descricao = descricao;
    }
    
    public LocalDateTime getDataHora(){
        return dataHora;
    }
    public String getDescricao(){
        return descricao;
    }
    
    public void alterarDataHora(LocalDateTime novaDataHora){
        this.dataHora = novaDataHora;
    }
    
    public long calcularDiasRestantes(){
        return ChronoUnit.DAYS.between(
            LocalDateTime.now(), dataHora);
    }
    
    public String verificarSituacao() {
        LocalDateTime agora = LocalDateTime.now();

        if (dataHora.isBefore(agora)) {
            return "Vencida";
        } else if (!dataHora.isAfter(agora.plusDays(3))) {
            return "Proxima do vencimento";
        } else {
            return "Futura";
        }
    }
    
    @Override
     public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return descricao+" Prazo: "+dataHora.format(formato)+" Dias restantes: "+calcularDiasRestantes()
                +" Situacao: "+verificarSituacao();
    }

}
