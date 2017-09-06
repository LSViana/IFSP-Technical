package arrays;

/**
 * -------------------------------------------------------------------* IFSP -
 * Instituto Federal de Sao Paulo * Tecnico Integrado em Informatica * Projeto
 * Integrado - Turma 213 *
 * --------------------------------------------------------------------* Autor:
 * Lucas Viana S. de Souza * data:04/09/2017 * * Id da Classe: GradeNotas *
 * Descricao: * Classe que executa os requisitos da atividade *
 * --------------------------------------------------------------------
 */
public class GradeNotas {
	private String nomeCurso;
	private int[] notas;

	public GradeNotas(String nomeCurso, int[] notas) {
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
		imprimeNotas();
		geraGraficoBarras();
	}

	private void geraGraficoBarras() {
		System.out.println("\nDistribuição das Notas na Turma:");
		for (int j = 0; j <= 10; j++) {
			if (j == 10) {
				System.out.printf("%7d: ", j * 10);
				for (int nota : notas)
					if (nota == j * 10)
						System.out.print("*");
				System.out.println();
			} else {
				System.out.printf("%02d - %02d: ", j * 10, j * 10 + 9);
				for (int nota : notas)
					if (nota >= j * 10 && nota <= j * 10 + 9)
						System.out.print("*");
				System.out.println();
			}
		}
	}

	private int obtemMaiorNotaClasse() {
		int maior = notas[0];
		for (int nota : notas)
			if (nota > maior)
				maior = nota;
		return maior;
	}

	private int obtemMenorNotaClasse() {
		int menor = notas[0];
		for (int nota : notas)
			if (nota < menor)
				menor = nota;
		return menor;
	}

	private float obtemMediaClasse() {
		float soma = 0;
		for (int nota : notas)
			soma += nota;
		return soma / notas.length;
	}

	private void imprimeNotas() {
		System.out.println("\nAs notas são:\n");
		for (int j = 0; j < notas.length; j++) {
			System.out.printf("Aluno #%02d: %3d\n", j + 1, notas[j]);
		}
		System.out.printf("\nMédia da Classe: %3.2f\nMenor Nota: %3d\nMaior Nota: %3d\n", obtemMediaClasse(),
				obtemMenorNotaClasse(), obtemMaiorNotaClasse());
	}
}
