//classe do aldeão
class Aldeao extends Personagem
{
	private final String tipo = "A";

	public String getTipo()
	{
		return tipo;
	}

	//método construtor
	public Aldeao(int identificacao, int horizontal, int vertical)
	{
		super(identificacao, horizontal, vertical);
	}

	//método construtor sobrecarregado
	public Aldeao(int identificacao, int horizontal, int vertical, int aux)
	{
		super(identificacao, horizontal, vertical, aux);
	}

	public void Mover(char direcao)
	{
		if(direcao == 'l')
		{
			setX(getX()+1);
			if(getX() > 9)
				setX(9);
			setFrente('l');
		}
		else if(direcao == 's')
		{
			setY(getY()+1);
			if(getY()>9)
				setY(9);
			setFrente('s');
		}
		else if(direcao == 'o')
		{
			setX(getX()-1);
			if(getX()<0)
				setX(0);
			setFrente('o'); 
		}
		else if(direcao == 'n')
		{
			setY(getY()-1);
			if(getY()<0)
				setY(0);
			setFrente('n');
		}
	}

	public void Atacar(Personagem[] army)
	{
		int i;
		if(getFrente() == 'n')
			{
				for(i=0; i<30; i++)
				{
					if(army[i] != null)
					{
						if(army[i].getY() == getY() - 1 && army[i].getX() == getX() 
							&& army[i] instanceof Aldeao)
							army[i] = null;
					}
				}
			}
			else if(getFrente() == 's')
			{
				for(i=0; i<30; i++)
				{
					if(army[i] != null)
					{
						if(army[i].getY() == getY() + 1 && army[i].getX() == getX()
							&& army[i] instanceof Aldeao)
							army[i] = null;
					}
				}
			}
			else if(getFrente() == 'l')
			{
				for(i=0; i<30; i++)
				{
					if(army[i] != null)
					{
						if(army[i].getX() == getX() + 1 && army[i].getY() == getY()
							&& army[i] instanceof Aldeao)
							army[i] = null;
					}
				}
			}
			else
			{
				for(i=0; i<30; i++)
				{
					if(army[i] != null)
					{
						if(army[i].getX() == getX() - 1 && army[i].getY() == getY()
							&& army[i] instanceof Aldeao)
							army[i] = null;
					}
				}
			}
	}
}