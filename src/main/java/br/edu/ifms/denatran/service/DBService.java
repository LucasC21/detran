package br.edu.ifms.denatran.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.denatran.model.Carro;
import br.edu.ifms.denatran.model.Infracao;
import br.edu.ifms.denatran.model.Multa;
import br.edu.ifms.denatran.repository.CarroRepository;
import br.edu.ifms.denatran.repository.InfracaoRepository;
import br.edu.ifms.denatran.repository.MultaRepository;

@Service
public class DBService {

	@Autowired
	private CarroRepository carro;
	@Autowired
	private InfracaoRepository infracao;
	@Autowired
	private MultaRepository multa;
	
	public void instantiateTestDatabase() throws ParseException{

		Carro car1= new Carro(null, "fusca", "Volks", "AAA-1111");
		Carro car2= new Carro(null, "civic", "Honda", "AAA-2222");
		Carro car3= new Carro(null, "etios", "Toyota", "AAA-3333");
		Carro car4= new Carro(null, "compass", "Jeep", "AAA-4444");
		Carro car5= new Carro(null, "Sandero", "Renault", "AAA-5555");
		
		Infracao infra1= new Infracao(null, "ultrapassagem em faixa contínua", 10, 199.9);
		Infracao infra2= new Infracao(null, "faixa amarela", 5, 180.9);
		Infracao infra3= new Infracao(null, "velocidade acima do permitido", 7, 199.9);
		Infracao infra4= new Infracao(null, "estacionamento proibido", 3, 199.9);
		Infracao infra5= new Infracao(null, "faixa de pedestre", 5, 199.9);
		Infracao infra6= new Infracao(null, "dirigir com celular", 10, 199.9);
		Infracao infra7= new Infracao(null, "fila dupla", 10, 199.9);
		Infracao infra8= new Infracao(null, "sinal vermelho", 10, 199.9);
		Infracao infra9= new Infracao(null, "dirigir alcoolizado", 10, 199.9);
		
		Multa multa1= new Multa(null, "Corumba", car2, 2022, infra9);
		Multa multa2= new Multa(null, "Corumba", car2, 2022, infra9);
		Multa multa3= new Multa(null, "Corumba", car3, 2022, infra4);
		Multa multa4= new Multa(null, "Corumba", car1, 2022, infra7);
		Multa multa5= new Multa(null, "Corumba", car5, 2022, infra8);
		Multa multa6= new Multa(null, "Corumba", car4, 2022, infra7);
		Multa multa7= new Multa(null, "Corumba", car5, 2022, infra1);
		Multa multa8= new Multa(null, "Corumba", car3, 2022, infra2);
		Multa multa9= new Multa(null, "Corumba", car1, 2022, infra3);
		Multa multa10= new Multa(null, "Corumba", car1, 2022, infra6);
		
		infra1.getMultas().addAll(Arrays.asList(multa9));
		infra2.getMultas().addAll(Arrays.asList(multa8));
		infra3.getMultas().addAll(Arrays.asList(multa4));
		infra4.getMultas().addAll(Arrays.asList(multa1, multa3));
		infra5.getMultas().addAll(Arrays.asList(multa5, multa10));
		infra6.getMultas().addAll(Arrays.asList(multa7));
		infra7.getMultas().addAll(Arrays.asList(multa2, multa5));
		infra8.getMultas().addAll(Arrays.asList(multa9));
		infra9.getMultas().addAll(Arrays.asList(multa9));
		
		carro.saveAll(Arrays.asList(car1, car2, car3, car4, car5));
		infracao.saveAll(Arrays.asList(infra1, infra2, infra3, infra4, infra5, infra6, infra7, infra8, infra9));
		multa.saveAll(Arrays.asList(multa1, multa2, multa3, multa4, multa5, multa6, multa7, multa8, multa9, multa10));
	}
}
