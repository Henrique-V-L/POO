package ex.datas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExDatas {

    public static void main(String[] args) {
         DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
         
         Prova prova = new Prova(LocalDateTime.now().plusDays(2), "Prova de POO");
         Trabalho trabalho = new Trabalho(LocalDateTime.now().plusDays(7), "Banco de Dados");
         Projeto projeto = new Projeto(LocalDateTime.now().minusDays(1), "Algebra");
         
         Atividade [] atividades = {prova, trabalho, projeto};
         
         System.out.println("Atividades cadastradas");
         
         for (int i = 0; i < atividades.length; i++){
             System.out.println(atividades[i]);
         }
         
         System.out.println("Alteracao de prazo");
         prova.alterarDataHora(LocalDateTime.now().plusDays(5));
         System.out.println(prova);
         
          for (int i = 0; i < atividades.length - 1; i++) {
            for (int j = i + 1; j < atividades.length; j++) {
                if (atividades[i].getDataHora().isAfter(
                        atividades[j].getDataHora())) {

                    Atividade auxiliar = atividades[i];
                    atividades[i] = atividades[j];
                    atividades[j] = auxiliar;
                }
            }
        }
          
          for (int i = 0; i < atividades.length; i++) {
            System.out.println(atividades[i]);
        }
          
          try {LocalDateTime data = LocalDateTime.parse("31/02/2026", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.println(data);

        } catch (Exception e) {
            System.out.println("Data invalida");
        }
         
    }
    
}
