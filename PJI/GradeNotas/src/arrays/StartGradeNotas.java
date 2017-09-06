package arrays;

/**
 * -------------------------------------------------------------------* IFSP -
 * Instituto Federal de Sao Paulo * Tecnico Integrado em Informatica * Projeto
 * Integrado - Turma 213 *
 * --------------------------------------------------------------------* Autor:
 * Lucas Viana S. de Souza * data:04/09/2017 * * Id da Classe:
 * StartGradeNotas * Descricao: * Classe que inicia a execucao dos
 * requisitos da atividade *
 * --------------------------------------------------------------------
 */
public class StartGradeNotas {
	public static void main(String[] args) {
		GradeNotas multigrade = new GradeNotas("PJI - Projeto Integrador",
				new int[] { 87, 68, 94, 100, 83, 78, 85, 91, 76, 87 });
		multigrade.processaGradeNotas();
	}
}
