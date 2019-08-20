//classe abstrata do personagem
import java.io.Serializable;

public abstract class Personagem implements Serializable
{
	private final int id;
	private char frente;
	private int x,y;
	public static int n = 0;

	public int getID()
	{
		return this.id;
	}

	public char getFrente()
	{
		return this.frente;
	}

	public void setFrente(char frente)
	{
		this.frente = frente;
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	//método construtor
	public Personagem(int identificacao, int horizontal, int vertical) 
	{
		frente = 'l';
		id = identificacao;
		x = horizontal;
		y = vertical;
	}

	//método construtor sobrecarregado
	public Personagem(int identificacao, int horizontal, int vertical, int aux) 
	{
		if(aux == 0)
			frente = 'n';
		else if(aux == 1)
			frente = 's';
		else if(aux == 2)
			frente = 'l';
		else
			frente = 'o';
		id = identificacao;
		x = horizontal;
		y = vertical;
	}

	public abstract String getTipo();
	public abstract void Mover(char direcao);
	public abstract void Atacar(Personagem[] army);
}
