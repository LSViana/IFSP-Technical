package arrays;

/**
 * -------------------------------------------------------------------* IFSP -
 * Instituto Federal de Sao Paulo * Tecnico Integrado em Informatica * Projeto
 * Integrado - Turma 213 *
 * --------------------------------------------------------------------* Autor:
 * Lucas Viana S. de Souza * data:04/09/2017 * * Id da Classe:
 * StartMultiGradeNotas * Descricao: * Classe que inicia a execucao dos
 * requisitos da atividade *
 * --------------------------------------------------------------------
 */
public class StartMultiGradeNotas {
	public static void main(String[] args) {
		MultiGradeNotas multigrade = new MultiGradeNotas("PJI - Projeto Integrador",
				new int[][] { new int[] { 87, 68, 94, 100, 83, 78, 85, 91, 76, 87 },
						new int[] { 20, 68, 40, 25, 88, 79, 05, 70, 26, 17 },
						new int[] { 34, 18, 99, 30, 100, 28, 45, 97, 66, 67 },
						new int[] { 47, 58, 14, 10, 37, 100, 35, 41, 44, 55 } });
		multigrade.processaGradeNotas();
	}
}