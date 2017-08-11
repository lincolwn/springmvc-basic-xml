package br.com.sisman.domain.model;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class AreaManutencaoTest 
{
	private Validator validator;

	@Before
	public void setup()
	{
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		this.validator = factory.getValidator();
	}
	
	@Test
	public void CodigoMenorQue6() 
	{
		AreaManutencao area = new AreaManutencao();
		area.setCodigo("abcde");

		Set<ConstraintViolation<AreaManutencao>> restricao = validator.validate(area);
		assertThat(restricao, hasSize(1));
		
	}

	@Test
	public void CodigoMaiorQue6()
	{
		AreaManutencao area = new AreaManutencao();
		area.setCodigo("abcdefg");
		

		Set<ConstraintViolation<AreaManutencao>> restricao = validator.validate(area);
		assertThat(restricao, hasSize(1));
	}
	
	@Test
	public void CodigoIgualA6()
	{
		AreaManutencao area = new AreaManutencao();
		area.setCodigo("abcdef");
		

		Set<ConstraintViolation<AreaManutencao>> restricao = validator.validate(area);
		assertThat(restricao, hasSize(0));
	}
	
	@Test
	public void CodigoNulo()
	{
		AreaManutencao area = new AreaManutencao();
		//area.setCodigo(null);
		

		Set<ConstraintViolation<AreaManutencao>> restricao = validator.validate(area);
		assertThat(restricao, hasSize(1));
	}
	
	@Test
	public void CodigoVazio()
	{
		AreaManutencao area = new AreaManutencao();
		area.setCodigo("");
		

		Set<ConstraintViolation<AreaManutencao>> restricao = validator.validate(area);
		assertThat(restricao, hasSize(1));
	}
	
	@Test
	public void DescricaoMaiorQue50()
	{
		AreaManutencao area = new AreaManutencao();
		area.setCodigo("abcdef");
		area.setDescricao("012345678910111213141516171819202122232425262728293031323334353637383940");
		

		Set<ConstraintViolation<AreaManutencao>> restricao = validator.validate(area);
		assertThat(restricao, hasSize(1));
		
	}
}
