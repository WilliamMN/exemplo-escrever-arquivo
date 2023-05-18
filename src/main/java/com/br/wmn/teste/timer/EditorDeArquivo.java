package com.br.wmn.teste.timer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author consultor
 */
public class EditorDeArquivo {

    private static final String TMP_DIR = System.getProperty("java.io.tmpdir") + "/projeto/";

    public String lerArquivo(String caminho) throws IOException {
        byte[] encoded = Files.readAllBytes(Path.of(caminho));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    public FileWriter criarArquivo(String nome) throws IOException {
        Path pasta = Path.of(TMP_DIR);

        if (!(Files.exists(pasta) && Files.isDirectory(pasta))) {
            Files.createDirectory(Path.of(TMP_DIR));
        }
        return new FileWriter(TMP_DIR + nome);
    }

    public Path buscarArquivo(String arquivo) {
        return Paths.get(TMP_DIR + arquivo);
    }

    public void escreverArquivo(String texto) {
        try {
            String nomeArquivo = LocalDate.now().toString() + "log.txt";
            String momento = LocalDateTime.now().toString();
            if (new File(this.buscarArquivo(nomeArquivo).toString()).exists()) {
                texto = String.format("%s\n%s - %s", this.lerArquivo(this.buscarArquivo(nomeArquivo).toString()), momento, texto);
            } else {
                texto = String.format("%s - %s", momento, texto);
            }

            FileWriter arq = criarArquivo(nomeArquivo);

            arq.write(texto);
            arq.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
