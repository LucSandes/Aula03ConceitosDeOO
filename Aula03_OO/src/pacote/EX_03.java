package pacote;

import javax.swing.JOptionPane;


public class EX_03 {
	public static ArvoresBinariasInt arvore = new ArvoresBinariasInt();

	public static String mensagem, titulo;
	public static String[] simNao = { "Sim", "N�o" };
	public static int iSimNao;
	public static String[] opcoes = { "Inserir", "Consultar", "Excluir", "Alterar", "Mostrar �rvore", "Ordenado",
			"Altura da �rvore", "Verificar se �rvore � Bin�ria","Pr�-Ordenado", "P�s-ordenado", "Sair" };
	public static int opcao;



	public static void main(String Args[]) {
		titulo = "D3";
		mensagem = "�rvore Bin�ria";
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE);

		do {
			mensagem = "Selecione a op��o desejada:";
			opcao = JOptionPane.showOptionDialog(null, mensagem, titulo, 1, JOptionPane.QUESTION_MESSAGE, null, opcoes,
					null);
			switch (opcao) {
			case 0:
				arvore.inserirNoCaractere();
				break;
			case 1:
				arvore.buscarNo();
				break;
			case 2:
				arvore.destruirNo();
				break;
			case 3:
				arvore.atualizarNo();
				break;
			case 4:
				arvore.mostrarArvore();
				break;
			case 5:
				arvore.mostrarOrdenado();
				break;
			case 6:
				arvore.mostrarAlturaArvore();
				break;
			case 7:
				arvore.mostrarSeArvoreEhBinaria();
				break;
			case 8:
				arvore.mostrarPreOrdenado();
				break;
			case 9:
				arvore.mostrarPosOrdenado();
				break;
			case 10:
				mensagem = "Deseja realmente sair?";
				iSimNao = JOptionPane.showOptionDialog(null, mensagem, titulo, 1, JOptionPane.QUESTION_MESSAGE, null,
						simNao, null);
				if (iSimNao == 1)
					opcao = -1;
				break;
			}
		} while (opcao != 10);

		System.exit(0);
	}
}
