package br.edu.ifms.denatran.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifms.denatran.dto.InfracaoDto;
import br.edu.ifms.denatran.model.Infracao;
import br.edu.ifms.denatran.service.InfracaoService;

@RestController
@RequestMapping(value = "/infracao")
public class InfracaoResource {

	@Autowired
	private InfracaoService infraServ;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody InfracaoDto objDto) {
		
		Infracao obj= infraServ.fromDto(objDto);
		obj= infraServ.insert(obj);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Infracao> find(@PathVariable Integer id) {
		
		Infracao obj= infraServ.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody InfracaoDto objDto, @PathVariable Integer id) {
		
		Infracao obj= infraServ.fromDto(objDto);
		obj.setId(id);
		obj= infraServ.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
		
		infraServ.delete(id);
		return ResponseEntity.noContent().build();
	}
	public ResponseEntity<Void> delete(@RequestBody Infracao obj, @PathVariable Integer id) {
		
		infraServ.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<InfracaoDto>> findAll() {
		
		List<Infracao> list= infraServ.findAll();
		List<InfracaoDto> listDto= list.stream().map(obj->new InfracaoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
