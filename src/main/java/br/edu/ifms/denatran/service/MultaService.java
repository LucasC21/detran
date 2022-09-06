package br.edu.ifms.denatran.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.denatran.dto.MultaDto;
import br.edu.ifms.denatran.model.Multa;
import br.edu.ifms.denatran.repository.MultaRepository;
import br.edu.ifms.denatran.service.exception.DataIntegrityException;
import br.edu.ifms.denatran.service.exception.ObjectNotFoundException;

@Service
public class MultaService {

	@Autowired
	private MultaRepository multaRepo;
	
	public Multa buscarPorId(Integer id) {
		Optional<Multa> obj = multaRepo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Multa.class.getName()));		
	}
	
	public Multa insert (Multa obj) {
		obj.setId(null);
		return multaRepo.save(obj);
	}

	public Multa update(Multa obj) {
		Multa newObj = buscarPorId(obj.getId());
		updateData(newObj, obj);
		return multaRepo.save(newObj);
	}

	public void delete(Integer id) {
		buscarPorId(id);
		try {
			multaRepo.deleteById(id);	
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível remover. Verifique a integridade referencial.");
		}
	}

	public List<Multa> findAll() {
		return multaRepo.findAll();
	}
	
	public Multa fromDto(MultaDto objDto) {
		return new Multa(objDto.getId(), objDto.getCidade(), null, objDto.getAno(), null);
	}
	
	private void updateData(Multa newObj, Multa obj) {
		newObj.setCarro(obj.getCarro());
		newObj.setAno(obj.getAno());
		newObj.setCidade(obj.getCidade());
	}
}
