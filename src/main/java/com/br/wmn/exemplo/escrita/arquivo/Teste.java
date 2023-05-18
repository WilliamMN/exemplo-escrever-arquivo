package com.br.wmn.exemplo.escrita.arquivo;

import com.github.britooo.looca.api.core.Looca;
import java.time.LocalDate;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author consultor
 */
public class Teste {

    public static void main(String[] args) {
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    Looca looca = new Looca();
                    EditorDeArquivo ea = new EditorDeArquivo();
                    looca.getGrupoDeJanelas().getJanelasVisiveis()
                            .forEach(item -> ea.escreverArquivo(item.toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 3000);
    }

}
