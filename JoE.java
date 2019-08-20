//classe aplicativa do jogo
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

class JoE
{
	public static void main(String args[])
	{
		int opcao, i;
		Scanner teclado = new Scanner(System.in);
		Random gerador = new Random();
		Personagem army[] = new Personagem[30];
		boolean sucesso;

		inicializa(army);

		// Menu
		do
		{
			System.out.println("1) Incluir personagem");
			System.out.println("2) Movimentar personagem");
			System.out.println("3) Remover personagem");
			System.out.println("4) Atacar");
			System.out.println("5) Gravar jogo no arquivo");
			System.out.println("6) Ler jogo do arquivo");
			System.out.println("7) Imprimir Arena");
			System.out.println("8) Sair do programa");

			opcao = teclado.nextInt();

			switch(opcao)
			{
				case 1:
					if(Personagem.n < 30)
					{	sucesso = inserirPersonagem(army);
						if(sucesso == false)
							System.out.println("Personagem não inserido");
						else
							Personagem.n += 1;
					}
					else
						System.out.println("Limite máximo atingido");

					break;
				case 2:
					sucesso = movimentarPersonagem(army);
					break;
				case 3:
					sucesso = removerPersonagem(army);
					if(sucesso == false)
						System.out.println("Esse personagem não existe");
					else
						Personagem.n -= 1;
					break;
				case 4:
					atacar(army);
					break;
				case 5:
					gravar(army);
					break;
				case 6:
					army = ler(army);
					break;
				case 7:
					imprimirArena(army);
					break;
				case 8:
					break;
			}
		}while(opcao != 8);
	}

	//True para inseriu, False para impossível
	public static boolean inserirPersonagem(Personagem[] army) 
	{
		int tipo, x, y;
		Scanner teclado = new Scanner(System.in);

		System.out.println("Tipo: ");
		System.out.println("1) Aldeao");
		System.out.println("2) Arqueiro");
		System.out.println("3) Guerreiro");
		System.out.println("4) Cavaleiro");
		System.out.println("5) Navio");
		
		tipo = teclado.nextInt();
		System.out.println("Posicao x: ");
		x = teclado.nextInt();
		System.out.println("Posicao y: ");
		y = teclado.nextInt();

		if(comparaPos(army, x, y) == false)
			return false;

		int i=0;
		while(army[i] != null)
			i++;

		switch(tipo)
		{
			case 1:
				army[i] = new Aldeao(i+1, x, y);
				break;
			case 2:
				army[i] = new Arqueiro(i+1, x, y);
				break;
			case 4:
				army[i] = new Cavaleiro(i+1, x, y);
				break;
			case 3:
				army[i] = new Guerreiro(i+1, x, y);
				break;
			case 5:
				army[i] = new Navio(i+1, x, y);
				break;
		}

		return true;
	}

	//True para não existe ninguém na pos xy, false para existe
	public static boolean comparaPos(Personagem[] army, int x, int y) 
	{
		int i;

		for(i=0; i<30; i++)
		{
			if(army[i] != null)
				if(army[i].getX() == x && army[i].getY() == y)
					return false;
		}

		return true;
	}

	//função que inicializa os personagens, usada uma única vez
	public static void inicializa(Personagem[] army) 
	{
		int x1, y1;
		Random gerador = new Random();
		boolean entrou = false;

		army[0] = new Aldeao(1, gerador.nextInt(10), gerador.nextInt(10));
		
		do
		{
			x1 = gerador.nextInt(10);
			y1 = gerador.nextInt(10);
			if(comparaPos(army, x1, y1) == true)
			{
				army[1] = new Aldeao(2, x1, y1, gerador.nextInt(4));
				entrou = true;
			}
		}while(entrou == false);
		entrou = false;

		do
		{
			x1 = gerador.nextInt(10);
			y1 = gerador.nextInt(10);
			if(comparaPos(army, x1, y1) == true)
			{
				army[2] = new Arqueiro(3, x1, y1, gerador.nextInt(4));
				entrou = true;
			}
		}while(entrou == false);
		entrou = false;

		do
		{
			x1 = gerador.nextInt(10);
			y1 = gerador.nextInt(10);
			if(comparaPos(army, x1, y1) == true)
			{
				army[3] = new Arqueiro(4, x1, y1, gerador.nextInt(4));
				entrou = true;
			}
		}while(entrou == false);
		entrou = false;

		do
		{
			x1 = gerador.nextInt(10);
			y1 = gerador.nextInt(10);
			if(comparaPos(army, x1, y1) == true)
			{
				army[4] = new Guerreiro(5, x1, y1, gerador.nextInt(4));
				entrou = true;
			}
		}while(entrou == false);
		entrou = false;

		do
		{
			x1 = gerador.nextInt(10);
			y1 = gerador.nextInt(10);
			if(comparaPos(army, x1, y1) == true)
			{
				army[5] = new Guerreiro(6, x1, y1, gerador.nextInt(4));
				entrou = true;
			}
		}while(entrou == false);
		entrou = false;

		do
		{
			x1 = gerador.nextInt(10);
			y1 = gerador.nextInt(10);
			if(comparaPos(army, x1, y1) == true)
			{
				army[6] = new Cavaleiro(7, x1, y1, gerador.nextInt(4));
				entrou = true;
			}
		}while(entrou == false);
		entrou = false;

		do
		{
			x1 = gerador.nextInt(10);
			y1 = gerador.nextInt(10);
			if(comparaPos(army, x1, y1) == true)
			{
				army[7] = new Cavaleiro(8, x1, y1, gerador.nextInt(4));
				entrou = true;
			}
		}while(entrou == false);
		entrou = false;

		do
		{
			x1 = gerador.nextInt(10);
			y1 = gerador.nextInt(10);
			if(comparaPos(army, x1, y1) == true)
			{
				army[8] = new Navio(9, x1, y1, gerador.nextInt(4));
				entrou = true;
			}
		}while(entrou == false);
		entrou = false;

		do
		{
			x1 = gerador.nextInt(10);
			y1 = gerador.nextInt(10);
			if(comparaPos(army, x1, y1) == true)
			{
				army[9] = new Navio(10, x1, y1, gerador.nextInt(4));
				entrou = true;
			}
		}while(entrou == false);
		entrou = false;

		Personagem.n = 10;	
	}

	//função para imprimir a arena
	public static void imprimirArena(Personagem[] army)
	{
		int i, j, k;
		boolean entrou = false;

		//j = coluna, i = linha, k = posição no vetor
		for(i=0; i<10; i++)
		{
			for(j=0; j<10; j++)
			{
				for(k=0; k<30; k++)
				{
					if(army[k] != null)
						if(army[k].getX() == j && army[k].getY() == i)
						{
							String abc = army[k].getID() + army[k].getTipo() + army[k].getFrente();
							System.out.printf("%5s", abc);
							entrou = true;
							break;
						}
				}
				if(entrou == false)
					System.out.printf("  .  ");
				entrou = false;
									
			}
			System.out.println();
		}
	}

	//função para remoção do personagem. False para não existe, true para removido
	public static boolean removerPersonagem(Personagem[] army)
	{
		int id;
		Scanner teclado = new Scanner(System.in);

		System.out.println("ID do personagem a ser removido: ");
		id = teclado.nextInt();

		if(army[id-1] == null)
			return false;

		army[id-1] = null;
		return true;
	}

	//false para não conseguiu movimentar, true para movimentado com sucesso
	public static boolean movimentarPersonagem(Personagem[] army)
	{
		int direcao, id, i;
		Scanner teclado = new Scanner(System.in);

		System.out.println("ID: ");
		id = teclado.nextInt();
		String tipo = army[id-1].getTipo();

		System.out.println("Direcao: ");
		System.out.println("1) Norte");
		System.out.println("2) Sul");
		System.out.println("3) Leste");
		System.out.println("4) Oeste");
		direcao = teclado.nextInt();

		//criar função para verificar se ultrapassa os limites da arena ou não para então verificar se existe personagem no limite
		boolean sucesso = ultrapassa(army, tipo, direcao, id);
		if(sucesso == false)
			return false;
		//criar a função de tratamento para verificar se pode movimentar ou não
		sucesso = podeMovimentar(army, tipo, direcao, id);
		if(sucesso == false)
			return false;

		if(direcao == 1)
			army[id-1].Mover('n');
		else if(direcao == 2)
			army[id-1].Mover('s');
		else if(direcao == 3)
			army[id-1].Mover('l');
		else
			army[id-1].Mover('o');

		return true;
	}

	//função auxiliar da movimentação para verificar qual o tipo de personagem no ponto em que ele quer movimentar
	public static boolean podeMovimentar(Personagem[] army, String tipo, int direcao, int id)
	{
		int i;
		if(tipo == "A")
		{
			if(direcao == 1)
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getY() == army[id-1].getY() - 1 && army[i].getX() == army[id-1].getX())
						{
							if(army[i] instanceof Aldeao)
							{
								System.out.println("Não foi possível movimentar");
							}
							else
							{
								System.out.println("O personagem foi excluído");
								army[id-1] = null;
							}
							return false;
						}
			}
			else if(direcao == 2)
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getY() == army[id-1].getY() + 1 && army[i].getX() == army[id-1].getX())
							if(army[i].getY() == army[id-1].getY() - 1 && army[i].getX() == army[id-1].getX())
							{
								if(army[i] instanceof Aldeao)
								{
									System.out.println("Não foi possível movimentar");
								}
								else
								{
									System.out.println("O personagem foi excluído");
									army[id-1] = null;
								}
								return false;
							}
			}
			else if(direcao == 3)
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getX() == army[id-1].getX() + 1 && army[i].getY() == army[id-1].getY())
						{
							if(army[i] instanceof Aldeao)
							{
								System.out.println("Não foi possível movimentar");
							}
							else
							{
								System.out.println("O personagem foi excluído");
								army[id-1] = null;
							}
							return false;
						}
			}
			else
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getX() == army[id-1].getX() - 1 && army[i].getY() == army[id-1].getY())				
						{
							if(army[i] instanceof Aldeao)
							{
								System.out.println("Não foi possível movimentar");
							}
							else
							{
								System.out.println("O personagem foi excluído");
								army[id-1] = null;
							}
							return false;
						}
			}
		}

		else if(tipo == "Q")
		{
			if(direcao == 1)
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getY() == army[id-1].getY() - 2 && army[i].getX() == army[id-1].getX())
						{
							if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro)
							{
								System.out.println("Não foi possível movimentar");
							}
							else
							{
								System.out.println("O personagem foi excluído");
								army[id-1] = null;
							}
							return false;
						}
			}
			else if(direcao == 2)
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getY() == army[id-1].getY() + 2 && army[i].getX() == army[id-1].getX())
						{
							if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro)
							{
								System.out.println("Não foi possível movimentar");
							}
							else
							{
								System.out.println("O personagem foi excluído");
								army[id-1] = null;
							}
							return false;
						}
			}
			else if(direcao == 3)
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getX() == army[id-1].getX() + 2 && army[i].getY() == army[id-1].getY())
						{
							if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro)
							{
								System.out.println("Não foi possível movimentar");
							}
							else
							{
								System.out.println("O personagem foi excluído");
								army[id-1] = null;
							}
							return false;
						}
			}
			else
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getX() == army[id-1].getX() - 2 && army[i].getY() == army[id-1].getY())				
						{
							if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro)
							{
								System.out.println("Não foi possível movimentar");
							}
							else
							{
								System.out.println("O personagem foi excluído");
								army[id-1] = null;
							}
							return false;
						}
			}	
		}

		else if(tipo == "C")
		{
			if(direcao == 1)
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getY() == army[id-1].getY() - 4 && army[i].getX() == army[id-1].getX())
						{
							if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro || army[i] instanceof Cavaleiro)
							{
								System.out.println("Não foi possível movimentar");
							}
							else
							{
								System.out.println("O personagem foi excluído");
								army[id-1] = null;
							}
							return false;
						}
			}
			else if(direcao == 2)
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getY() == army[id-1].getY() + 4 && army[i].getX() == army[id-1].getX())
						{
							if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro || army[i] instanceof Cavaleiro)
							{
								System.out.println("Não foi possível movimentar");
							}
							else
							{
								System.out.println("O personagem foi excluído");
								army[id-1] = null;
							}
							return false;
						}
			}
			else if(direcao == 3)
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getX() == army[id-1].getX() + 4 && army[i].getY() == army[id-1].getY())
						{
							if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro || army[i] instanceof Cavaleiro)
							{
								System.out.println("Não foi possível movimentar");
							}
							else
							{
								System.out.println("O personagem foi excluído");
								army[id-1] = null;
							}
							return false;
						}
			}
			else
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getX() == army[id-1].getX() - 4 && army[i].getY() == army[id-1].getY())				
						{
							if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro || army[i] instanceof Cavaleiro)
							{
								System.out.println("Não foi possível movimentar");
							}
							else
							{
								System.out.println("O personagem foi excluído");
								army[id-1] = null;
							}
							return false;
						}
			}
		}

		else if(tipo == "G")
		{
			if(direcao == 1)
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getY() == army[id-1].getY() - 3 && army[i].getX() == army[id-1].getX())
						{
							if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro || army[i] instanceof Cavaleiro ||
								army[i] instanceof Guerreiro)
							{
								System.out.println("Não foi possível movimentar");
							}
							else
							{
								System.out.println("O personagem foi excluído");
								army[id-1] = null;
							}
							return false;
						}
			}
			else if(direcao == 2)
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getY() == army[id-1].getY() + 3 && army[i].getX() == army[id-1].getX())
						{
							if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro || army[i] instanceof Cavaleiro ||
								army[i] instanceof Guerreiro)
							{
								System.out.println("Não foi possível movimentar");
							}
							else
							{
								System.out.println("O personagem foi excluído");
								army[id-1] = null;
							}
							return false;
						}
			}
			else if(direcao == 3)
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getX() == army[id-1].getX() + 3 && army[i].getY() == army[id-1].getY())
						{
							if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro || army[i] instanceof Cavaleiro ||
								army[i] instanceof Guerreiro)
							{
								System.out.println("Não foi possível movimentar");
							}
							else
							{
								System.out.println("O personagem foi excluído");
								army[id-1] = null;
							}
							return false;
						}
			}
			else
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getX() == army[id-1].getX() - 3 && army[i].getY() == army[id-1].getY())				
						{
							if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro || army[i] instanceof Cavaleiro ||
								army[i] instanceof Guerreiro)
							{
								System.out.println("Não foi possível movimentar");
							}
							else
							{
								System.out.println("O personagem foi excluído");
								army[id-1] = null;
							}
							return false;
						}
			}
		}

		else if(tipo == "N")
		{
			if(direcao == 1)
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getY() == army[id-1].getY() - 5 && army[i].getX() == army[id-1].getX())
						{
							System.out.println("Não foi possível movimentar");
							return false;
						}
			}
			else if(direcao == 2)
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getY() == army[id-1].getY() + 5 && army[i].getX() == army[id-1].getX())
						{
							System.out.println("Não foi possível movimentar");
							return false;
						}
			}
			else if(direcao == 3)
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getX() == army[id-1].getX() + 5 && army[i].getY() == army[id-1].getY())
						{
							System.out.println("Não foi possível movimentar");
							return false;
						}
			}
			else
			{
				for(i=0; i<30; i++)
					if(army[i] != null && i != id-1)
						if(army[i].getX() == army[id-1].getX() - 5 && army[i].getY() == army[id-1].getY())				
						{
							System.out.println("Não foi possível movimentar");
							return false;
						}
			}
		}
		return true;
	}

	//true para não está na borda e vai para o próximo tratamento, false para alguma coisa aconteceu
	//função auxiliar que trata as bordas da arena
	//se ultrapassa, verifica se há alguém na borda: se há, ele testa se pode eliminar. Se não há, ele vai para a borda
	public static boolean ultrapassa(Personagem[] army, String tipo, int direcao, int id)
	{
		int i;
		if(tipo == "Q")
		{
			if(direcao == 1)
			{
				if(army[id-1].getY() == 1)
				{
					for(i=0; i<30; i++)
						if(army[i] != null && i != id-1)
						{
							if(army[i].getY() == 0 && army[i].getX() == army[id-1].getX())
							{
								if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro)
								{
									System.out.println("Não pode movimentar");
								}
								else
								{
									System.out.println("O personagem foi excluído");
									army[id-1] = null;
								}
								return false;
							}
						}
				}
			}
			else if(direcao == 2)
			{
				if(army[id-1].getY() == 8)
				{
					for(i=0; i<30; i++)
						if(army[i] != null && i != id-1)
						{
							if(army[i].getY() == 9 && army[i].getX() == army[id-1].getX())
							{
								if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro)
								{
									System.out.println("Não pode movimentar");
								}
								else
								{
									System.out.println("O personagem foi excluído");
									army[id-1] = null;
								}
								return false;
							}
						}
				}
			}
			else if(direcao == 3)
			{
				if(army[id-1].getX() == 8)
				{
					for(i=0; i<30; i++)
						if(army[i] != null && i != id-1)
						{
							if(army[i].getX() == 9 && army[i].getY() == army[id-1].getY())
							{
								if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro)
								{
									System.out.println("Não pode movimentar");
								}
								else
								{
									System.out.println("O personagem foi excluído");
									army[id-1] = null;
								}
								return false;
							}
						}
				}
			}
			else if(direcao == 4)
			{
				if(army[id-1].getX() == 1)
				{
					for(i=0; i<30; i++)
						if(army[i] != null && i != id-1)
						{
							if(army[i].getX() == 0 && army[i].getY() == army[id-1].getY())
							{
								if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro)
								{
									System.out.println("Não pode movimentar");
								}
								else
								{
									System.out.println("O personagem foi excluído");
									army[id-1] = null;
								}
								return false;
							}
						}
				}
			}
		}
		else if(tipo == "G")
		{
			if(direcao == 1)
			{
				if(army[id-1].getY() == 1 || army[id-1].getY() == 2)
				{
					for(i=0; i<30; i++)
						if(army[i] != null && i != id-1)
						{
							if(army[i].getY() == 0 && army[i].getX() == army[id-1].getX())
							{
								if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro || army[i] instanceof Guerreiro)
								{
									System.out.println("Não pode movimentar");
								}
								else
								{
									System.out.println("O personagem foi excluído");
									army[id-1] = null;
								}
								return false;
							}
						}
				}
			}
			else if(direcao == 2)
			{
				if(army[id-1].getY() == 8 || army[id-1].getY() == 7)
				{
					for(i=0; i<30; i++)
						if(army[i] != null && i != id-1)
						{
							if(army[i].getY() == 9 && army[i].getX() == army[id-1].getX())
							{
								if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro || army[i] instanceof Guerreiro)
								{
									System.out.println("Não pode movimentar");
								}
								else
								{
									System.out.println("O personagem foi excluído");
									army[id-1] = null;
								}
								return false;
							}
						}
				}
			}
			else if(direcao == 3)
			{
				if(army[id-1].getX() == 8 || army[id-1].getX() == 7)
				{
					for(i=0; i<30; i++)
						if(army[i] != null && i != id-1)
						{
							if(army[i].getX() == 9 && army[i].getY() == army[id-1].getY())
							{
								if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro || army[i] instanceof Guerreiro)
								{
									System.out.println("Não pode movimentar");
								}
								else
								{
									System.out.println("O personagem foi excluído");
									army[id-1] = null;
								}
								return false;
							}
						}
				}
			}
			else if(direcao == 4)
			{
				if(army[id-1].getX() == 1 || army[id-1].getX() == 2)
				{
					for(i=0; i<30; i++)
						if(army[i] != null && i != id-1)
						{
							if(army[i].getX() == 0 && army[i].getY() == army[id-1].getY())
							{
								if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro || army[i] instanceof Guerreiro)
								{
									System.out.println("Não pode movimentar");
								}
								else
								{
									System.out.println("O personagem foi excluído");
									army[id-1] = null;
								}
								return false;
							}
						}
				}
			}
		}
		else if(tipo == "C")
		{
			if(direcao == 1)
			{
				if(army[id-1].getY() == 1 || army[id-1].getY() == 2 || army[id-1].getY() == 3)
				{
					for(i=0; i<30; i++)
						if(army[i] != null && i != id-1)
						{
							if(army[i].getY() == 0 && army[i].getX() == army[id-1].getX())
							{
								if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro || army[i] instanceof Guerreiro
									|| army[i] instanceof Cavaleiro)
								{
									System.out.println("Não pode movimentar");
								}
								else
								{
									System.out.println("O personagem foi excluído");
									army[id-1] = null;
								}
								return false;
							}
						}
				}
			}
			else if(direcao == 2)
			{
				if(army[id-1].getY() == 8 || army[id-1].getY() == 7 || army[id-1].getY() == 6)
				{
					for(i=0; i<30; i++)
						if(army[i] != null && i != id-1)
						{
							if(army[i].getY() == 9 && army[i].getX() == army[id-1].getX())
							{
								if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro || army[i] instanceof Guerreiro
									|| army[i] instanceof Cavaleiro)
								{
									System.out.println("Não pode movimentar");
								}
								else
								{
									System.out.println("O personagem foi excluído");
									army[id-1] = null;
								}
								return false;
							}
						}
				}
			}
			else if(direcao == 3)
			{
				if(army[id-1].getX() == 8 || army[id-1].getX() == 7 || army[id-1].getX() == 6)
				{
					for(i=0; i<30; i++)
						if(army[i] != null && i != id-1)
						{
							if(army[i].getX() == 9 && army[i].getY() == army[id-1].getY())
							{
								if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro || army[i] instanceof Guerreiro
									|| army[i] instanceof Cavaleiro)
								{
									System.out.println("Não pode movimentar");
								}
								else
								{
									System.out.println("O personagem foi excluído");
									army[id-1] = null;
								}
								return false;
							}
						}
				}
			}
			else if(direcao == 4)
			{
				if(army[id-1].getX() == 1 || army[id-1].getX() == 2 || army[id-1].getX() == 3)
				{
					for(i=0; i<30; i++)
						if(army[i] != null && i != id-1)
						{
							if(army[i].getX() == 0 && army[i].getY() == army[id-1].getY())
							{
								if(army[i] instanceof Aldeao || army[i] instanceof Arqueiro || army[i] instanceof Guerreiro
									|| army[i] instanceof Cavaleiro)
								{
									System.out.println("Não pode movimentar");
								}
								else
								{
									System.out.println("O personagem foi excluído");
									army[id-1] = null;
								}
								return false;
							}
						}
				}
			}
		}
		else if(tipo == "N")
		{
			if(direcao == 1)
			{
				if(army[id-1].getY() == 1 || army[id-1].getY() == 2 || army[id-1].getY() == 3 || army[id-1].getY() == 4 )
				{
					for(i=0; i<30; i++)
						if(army[i] != null && i != id-1)
						{
							if(army[i].getY() == 0 && army[i].getX() == army[id-1].getX())
							{
								System.out.println("Não pode movimentar");
								return false;
							}
						}
				}
			}
			else if(direcao == 2)
			{
				if(army[id-1].getY() == 8 || army[id-1].getY() == 7 || army[id-1].getY() == 6 || army[id-1].getY() == 5)
				{
					for(i=0; i<30; i++)
						if(army[i] != null && i != id-1)
						{
							if(army[i].getY() == 9 && army[i].getX() == army[id-1].getX())
							{
								System.out.println("Não pode movimentar");
								return false;
							}
						}
				}
			}
			else if(direcao == 3)
			{
				if(army[id-1].getX() == 8 || army[id-1].getX() == 7 || army[id-1].getX() == 6 || army[id-1].getX() == 5)
				{
					for(i=0; i<30; i++)
						if(army[i] != null && i != id-1)
						{
							if(army[i].getX() == 9 && army[i].getY() == army[id-1].getY())
							{
								System.out.println("Não pode movimentar");
								return false;
							}
						}
				}
			}
			else if(direcao == 4)
			{
				if(army[id-1].getX() == 1 || army[id-1].getX() == 2 || army[id-1].getX() == 3 || army[id-1].getX() == 4)
				{
					for(i=0; i<30; i++)
						if(army[i] != null && i != id-1)
						{
							if(army[i].getX() == 0 && army[i].getY() == army[id-1].getY())
							{
								System.out.println("Não pode movimentar");
								return false;
							}
						}
				}
			}
		}
		return true;
	}

	//função que chama o atacar do personagem
	public static void atacar(Personagem[] army)
	{
		int id, i;
		Scanner teclado = new Scanner(System.in);

		System.out.println("ID: ");
		id = teclado.nextInt();

		army[id-1].Atacar(army);
	}

	//grava o jogo em um arquivo
	public static void gravar(Personagem[] army)
	{
		File arquivo = new File("gameSaved.dat");
		try
		{
			FileOutputStream fout = new FileOutputStream(arquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fout);

			oos.writeObject(army);

			oos.flush();
			oos.close();
			fout.close();

		}
		catch(Exception ex)
		{
			System.err.println("Erro: " + ex.toString());
		}
	}

	//lê um jogo anteriormente salvo
	public static Personagem[] ler(Personagem[] army)
	{
		File arquivo = new File("gameSaved.dat");

		try
		{
			FileInputStream fin = new FileInputStream(arquivo);
			ObjectInputStream oin = new ObjectInputStream(fin);

			army = (Personagem[]) oin.readObject();
			oin.close();
			fin.close();
		}
		catch(Exception ex)
		{
			System.err.println("Erro: " + ex.toString());
		}
		int contador = 0;
		for(Personagem p: army)
			if(p != null)
				contador++;
		Personagem.n = contador;
		return army;
	}
}
