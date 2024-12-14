package br.com.rodrigoeduque;

import br.com.rodrigoeduque.model.Candidatos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class ProcessoSeletivo {

    private static final double SALARIO_BASE = 2000.00;

    public static void main(String[] args) {

        System.out.println("Processo Seletivo");
        System.out.println("---------------------------------------------------");
        List<Candidatos> candidatos = selecionarCandidatos();

        System.out.println("LISTA DE CANDIDATOS SELECIONADOS : ");
        List<Candidatos> selecionados = candidatos.stream()
                .filter(c -> c.getSalarioPretendido() <= SALARIO_BASE)
                .limit(5)
                .collect(Collectors.toList());

        selecionados.forEach(c -> System.out.println("NOME: " + c.getNome() + " PRETENSÃO: " + c.getSalarioPretendido()));

        System.out.println("TENTATIVAS DE CONTATOS");
        System.out.println("---------------------------------------------------");

        tentarContato(selecionados);
    }

    private static void tentarContato(List<Candidatos> selecionados) {
        selecionados.forEach(candidato -> {
            int tentativas = ThreadLocalRandom.current().nextInt(1, 5);

            if (tentativas <= 3) {
                System.out.println("CONSEGUIMOS CONTATO COM " + candidato.getNome() + " APÓS [" + tentativas + "] TENTATIVA(S)");
            } else {
                System.out.println("NÃO CONSEGUIMOS CONTATO COM O CANDIDATO : " + candidato.getNome());
            }
        });
    }

    static void analisarCandidato(double salarioPretendido) {
        if (SALARIO_BASE > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (SALARIO_BASE == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }

    static List<Candidatos> selecionarCandidatos() {
        List<Candidatos> candidatos = new ArrayList<>();
        String[] nomesCandidatos = {"JOSÉ", "MARIA", "JOÃO", "BENTO", "CAMILA", "HENRIQUE", "CÉLIA", "MARLENA", "VICENTE", "MARTHA"};

        for (int i = 0; i < nomesCandidatos.length; i++) {
            Candidatos candidato = new Candidatos(nomesCandidatos[i], ThreadLocalRandom.current().nextDouble(1800.00, 2200.00));
            System.out.println("O candidato " + candidato.getNome() + " solicitou o seguinte valor: R$ " + candidato.getSalarioPretendido());
            analisarCandidato(candidato.getSalarioPretendido());
            System.out.println("---------------------------------------------------");
            candidatos.add(candidato);
        }
        return candidatos;
    }
}
