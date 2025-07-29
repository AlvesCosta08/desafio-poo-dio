package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private int duracaoDias;  // nova variável para duração
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    // Construtor parametrizado para duração
    public Bootcamp(String nome, String descricao, int duracaoDias) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracaoDias = duracaoDias;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataInicial.plusDays(duracaoDias);
    }

    public int getDuracaoDias() {
        return duracaoDias;
    }

    public void setDuracaoDias(int duracaoDias) {
        this.duracaoDias = duracaoDias;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public void setDevsInscritos(Set<Dev> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    // método para ranking de devs inscritos ordenados por XP decrescente
    public List<Dev> getRanking() {
        return devsInscritos.stream()
                .sorted(Comparator.comparingDouble(Dev::calcularTotalXp).reversed())
                .collect(Collectors.toList());
    }

    // exibe ranking no console
    public void exibirRanking() {
        System.out.println("Ranking do Bootcamp: " + nome);
        List<Dev> ranking = getRanking();
        for (int i = 0; i < ranking.size(); i++) {
            Dev dev = ranking.get(i);
            System.out.printf("%d. %s - XP: %.2f%n", i + 1, dev.getNome(), dev.calcularTotalXp());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return duracaoDias == bootcamp.duracaoDias &&
                Objects.equals(nome, bootcamp.nome) &&
                Objects.equals(descricao, bootcamp.descricao) &&
                Objects.equals(dataInicial, bootcamp.dataInicial) &&
                Objects.equals(devsInscritos, bootcamp.devsInscritos) &&
                Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, duracaoDias, devsInscritos, conteudos);
    }
}
