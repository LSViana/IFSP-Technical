package arrays;

import java.util.Arrays;

/**
 * -------------------------------------------------------------------* IFSP -
 * Instituto Federal de Sao Paulo * Tecnico Integrado em Informatica * Projeto
 * Integrado - Turma 213 *
 * --------------------------------------------------------------------* Autor:
 * Lucas Viana S. de Souza * data:04/09/2017 * * Id da Classe: MultiGradeNotas *
 * Descricao: * Classe que executa os requisitos da atividade *
 * --------------------------------------------------------------------
 */
public class MultiGradeNotas {
	private String nomeCurso;
	private int[][] notas;

	public MultiGradeNotas(String nomeCurso, int[][] notas) {
		this.nomeCurso = nomeCurso;
		this.notas = notas;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void exibeBoasVindasCurso() {
		System.out.printf("Bem-vindo ao aplicativo 'Notas dos Alunos' para a turma: \n%s\n", nomeCurso);
	}

	public void processaGradeNotas() {
		exibeBoasVindasCurso();
		for (int i = 0; i < notas.length; i++) {
			imprimeNotas(i, notas[i]);
		}
		for (int i = 0; i < notas.length; i++) {
			geraGraficoBarras(i, notas[i]);
		}
		System.out.printf("\nMédia do Curso: %.2f\nMenor Nota do Curso: %d\nMaior Nota do Curso: %d\n",
				obtemMediaCurso(), obtemMenorNotaCurso(), obtemMaiorNotaCurso());
	}

	private void geraGraficoBarras(int i, int[] js) {
		System.out.println("\nDistribuição das Notas na Turma " + (i + 1) + ":");
		for (int j = 0; j <= 10; j++) {
			if(j == 10) {
				System.out.printf("%7d: ", j * 10);
				for(int nota : js)
					if(nota == j * 10)
						System.out.print("*");
				System.out.println();
			}
			else {
				System.out.printf("%02d - %02d: ", j * 10, j * 10 + 9);
				for(int nota : js)
					if(nota >= j * 10 && nota <= j * 10 + 9)
						System.out.print("*");
				System.out.println();
			}
		}
	}

	private int obtemMaiorNotaClasse(int[] js) {
		int maior = js[0];
		for (int nota : js)
			if (nota > maior)
				maior = nota;
		return maior;
	}

	private int obtemMenorNotaClasse(int[] js) {
		int menor = js[0];
		for (int nota : js)
			if (nota < menor)
				menor = nota;
		return menor;
	}

	private float obtemMediaClasse(int[] js) {
		float soma = 0;
		for (int nota : js)
			soma += nota;
		return soma / js.length;
	}

	private float obtemMediaCurso() {
		float soma = 0;
		int quantidade = 0;
		for (int[] turma : notas)
			for (int nota : turma) {
				soma += nota;
				quantidade++;
			}
		return soma / quantidade;
	}
	
	private int obtemMaiorNotaCurso() {
		int maior = notas[0][0];
		for (int[] turma : notas)
			for (int nota : turma)
				if(nota > maior)
					maior = nota;
		return maior;
	}
	
	private int obtemMenorNotaCurso() {
		int menor = notas[0][0];
		for (int[] turma : notas)
			for (int nota : turma)
				if(nota < menor)
					menor = nota;
		return menor;
	}

	private void imprimeNotas(int i, int[] js) {
		System.out.println("\nAs notas são:\n\tTurma #" + (i + 1) + ":\n");
		for (int j = 0; j < js.length; j++) {
			System.out.printf("Aluno #%02d: %3d\n", j + 1, js[j]);
		}
		System.out.printf("\nMédia da Classe: %3.2f\nMenor Nota: %3d\nMaior Nota: %3d\n", obtemMediaClasse(js),
				obtemMenorNotaClasse(js), obtemMaiorNotaClasse(js));
	}
}