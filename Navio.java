//classe do navio
public class Navio extends Personagem
{
	public final String tipo = "N";

	public String getTipo()
	{
		return tipo;
	}

	//método construtor
	public Navio(int identificacao, int horizontal, int vertical)
	{
		super(identificacao, horizontal, vertical);
	}

	//método construtor sobrecarregado
	public Navio(int identificacao, int horizontal, int vertical, int aux)
	{
		super(identificacao, horizontal, vertical, aux);
	}

	public void Mover(char direcao)
	{
		if(direcao == 'l')
		{
			setX(getX()+5);
			if(getX() > 9)
				setX(9);
			setFrente('l');
		}
		else if(direcao == 's')
		{
			setY(getY()+5);
			if(getY()>9)
				setY(9);
			setFrente('s');
		}
		else if(direcao == 'o')
		{
			setX(getX()-5);
			if(getX()<0)
				setX(0);
			setFrente('o'); 
		}
		else if(direcao == 'n')
		{
			setY(getY()-5);
			if(getY()<0)
				setY(0);
			setFrente('n');
		}
	}

	public void Atacar(Personagem[] army)
	{
		int i;

		for(i=0; i<30; i++)
		{
			if(army[i] != null)
			{
				if((army[i].getX() == getX() || army[i].getY() == getY())
					&& !(army[i].getX() == getX() && army[i].getY() == getY()))
					army[i] = null;
			}
		}
	}
}