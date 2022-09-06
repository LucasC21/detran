package br.edu.ifms.denatran.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.denatran.dto.InfracaoDto;
import br.edu.ifms.denatran.model.Infracao;
import br.edu.ifms.denatran.repository.InfracaoRepository;
import br.edu.ifms.denatran.service.exception.DataIntegrityException;
import br.edu.ifms.denatran.service.exception.ObjectNotFoundException;

@Service
public class InfracaoService {

	@Autowired
	private InfracaoRepository infraRepo;
	
	public Infracao buscarPorId(Integer id) {
		Optional<Infracao> obj = infraRepo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Infracao.class.getName()));		
	}
	
	public Infracao insert (Infracao obj) {
		obj.setId(null);
		return infraRepo.save(obj);
	}

	public Infracao update(Infracao obj) {
		Infracao newObj = buscarPorId(obj.getId());
		updateData(newObj, obj);
		return infraRepo.save(newObj);
	}

	public void delete(Integer id) {
		buscarPorId(id);
		try {
			infraRepo.deleteById(id);	
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível remover. Verifique a integridade referencial.");
		}
	}

	public List<Infracao> findAll() {
		return infraRepo.findAll();
	}
	
	public Infracao fromDto(InfracaoDto objDto) {
		return new Infracao(objDto.getId(), objDto.getDescricao(), objDto.getPontos(), objDto.getValor());
	}
	
	private void updateData(Infracao newObj, Infracao obj) {
		newObj.setPontos(obj.getPontos());
		newObj.setValor(obj.getValor());
		newObj.setDescricao(obj.getDescricao());
	}
}
