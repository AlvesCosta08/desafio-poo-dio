import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Bootcamp bootcamp = new Bootcamp("Bootcamp Java", "Aprenda Java do zero", 60); // duração 60 dias

        Curso curso1 = new Curso();
        curso1.setTitulo("Java Básico");
        curso1.setDescricao("Introdução ao Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Java Avançado");
        curso2.setDescricao("Conceitos avançados de Java");
        curso2.setCargaHoraria(10);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria Java");
        mentoria.setDescricao("Mentoria para tirar dúvidas");
        mentoria.setData(LocalDate.now());

        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devAlves = new Dev();
        devAlves.setNome("Alves");
        devAlves.inscreverBootcamp(bootcamp);

        Dev devMarcos = new Dev();
        devMarcos.setNome("Marcos");
        devMarcos.inscreverBootcamp(bootcamp);

        devAlves.progredir(); // conclui Java Básico
        devAlves.progredir(); // conclui Java Avançado

        devMarcos.progredir(); // conclui Java Básico

        bootcamp.exibirRanking();
    }
}

