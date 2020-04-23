package pacote;

public interface InterfaceArvoresBinariasInt {
	public void inserirNosInt(); // Digita e Insere Nós em uma árvore binária no Percurso Pré-Ordenado;

	public void inserirNoFolha(NoArvoreInt naNoAnt, NoArvoreInt naNo);// Insere Nó Folha em uma árvore binária;

	public void apresentarNosIntPreOrdenados(); // Apresenta todos os Nós de uma árvore binária no Percurso
												// Pré-Ordenado;

	public void apresentarNosIntOrdenados(); // Apresenta todos os Nós de uma árvore binária no Percurso Ordenado;

	public void apresentarNosIntPosOrdenados(); // Apresenta todos os Nós de uma árvore binária no Percurso
												// Pós-Ordenado;

	public void apresentaPercursoInt(char cTipo, NoArvoreInt naNo); // Apresenta o próximo Nó de uma árvore binária no
																	// Percurso Pós-Ordenado;

	public void apresentarArvoreInt(); // Apresenta Árvore Binária deslocada de 90 graus em tela;

	public void apresentaNivelInt(char iNivel, NoArvoreInt naNo); // Apresenta Nós do Nível iNivel da árvore binária;

	public void buscarNoInt(); // Executa a busca de um determinado nó na árvore binária;

	public boolean estahNaArvore(char iNo, NoArvoreInt naNo); // Retorna flag informando se o nó iNo está na árvore
																// binária;

	public void eliminarNoInt(); // Elimina Nó a ser especicado da Árvore Binária;

	public NoArvoreInt excluiNoInt(char iNo, NoArvoreInt naNo); // Elimina Nó especificado da Árvore Binária e faz os
																// devidos ajustes;

	public boolean ehVazia(); // Retorna flag informando se a árvore binária está vazia ou não;

	public boolean ehArvoreBinaria(NoArvoreInt no);

	public int obterAlturaArvore(NoArvoreInt no, int l);

	public void mostrarAlturaArvore();

	public void mostrarOrdenado();
	
	public void mostrarPreOrdenado();
	
	public void mostrarPosOrdenado();

}
