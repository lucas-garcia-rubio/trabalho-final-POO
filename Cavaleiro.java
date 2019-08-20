//classe do cavaleiro
public class Cavaleiro extends Personagem
{
	public final String tipo = "C";

	public String getTipo()
	{
		return tipo;
	}

	//método construtor
	public Cavaleiro(int identificacao, int horizontal, int vertical)
	{
		super(identificacao, horizontal, vertical);
	}

	//método construtor sobrecarregado
	public Cavaleiro(int identificacao, int horizontal, int vertical, int aux)
	{
		super(identificacao, horizontal, vertical, aux);
	}

	public void Mover(char direcao)
	{
		if(direcao == 'l')
		{
			setX(getX()+4);
			if(getX() > 9)
				setX(9);
			setFrente('l');
		}
		else if(direcao == 's')
		{
			setY(getY()+4);
			if(getY()>9)
				setY(9);
			setFrente('s');
		}
		else if(direcao == 'o')
		{
			setX(getX()-4);
			if(getX()<0)
				setX(0);
			setFrente('o'); 
		}
		else if(direcao == 'n')
		{
			setY(getY()-4);
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
					//verifica a frente do cavaleiro
					if(army[i].getX() == getX()
						&& army[i].getY() < getY() && army[i].getY() >= getY() - 5
						&& !(army[i] instanceof Navio))
						army[i] = null;

					//verifica o lado direito do cavaleiro
					else if(army[i].getY() == getY()
						&& army[i].getX() > getX() && army[i].getX() <= getX() + 5
						&& !(army[i] instanceof Navio))
						army[i] = null;

					//verifica o lado esquerdo
					else if(army[i].getY() == getY()
						&& army[i].getX() < getX() && army[i].getX() >= getX() - 5
						&& !(army[i] instanceof Navio))
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
					if(army[i].getX() == getX()
						&& army[i].getY() > getY() && army[i].getY() <= getY() + 5
						&& !(army[i] instanceof Navio))
						army[i] = null;

					else if(army[i].getY() == getY()
						&& army[i].getX() < getX() && army[i].getX() >= getX() - 5
						&& !(army[i] instanceof Navio))
						army[i] = null;

					else if(army[i].getY() == getY()
						&& army[i].getX() > getX() && army[i].getX() <= getX() + 5
						&& !(army[i] instanceof Navio))
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
					if(army[i].getY() == getY()
						&& army[i].getX() > getX() && army[i].getX() <= getX() + 5
						&& !(army[i] instanceof Navio))
						army[i] = null;

					else if(army[i].getX() == getX()
						&& army[i].getY() > getY() && army[i].getY() <= getY() + 5
						&& !(army[i] instanceof Navio))
						army[i] = null;

					else if(army[i].getX() == getX()
						&& army[i].getY() < getY() && army[i].getY() >= getY() - 5
						&& !(army[i] instanceof Navio))
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
					if(army[i].getY() == getY()
						&& army[i].getX() < getX() && army[i].getX() >= getX() - 5
						&& !(army[i] instanceof Navio))
						army[i] = null;

					else if(army[i].getX() == getX()
						&& army[i].getY() < getY() && army[i].getY() >= getY() - 5
						&& !(army[i] instanceof Navio))
						army[i] = null;

					else if(army[i].getX() == getX()
						&& army[i].getY() > getY() && army[i].getY() <= getY() + 5
						&& !(army[i] instanceof Navio))
						army[i] = null;
				}
			}
		}
	}
}