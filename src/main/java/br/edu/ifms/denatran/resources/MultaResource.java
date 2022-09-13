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

import br.edu.ifms.denatran.dto.MultaDto;
import br.edu.ifms.denatran.model.Multa;
import br.edu.ifms.denatran.service.MultaService;

@RestController
@RequestMapping(value = "/multa")
public class MultaResource {

	@Autowired
	private MultaService multaServ;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody MultaDto objDto) {
		
		Multa obj= multaServ.fromDto(objDto);
		obj= multaServ.insert(obj);
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Multa> find(@PathVariable Integer id) {
		
		Multa obj= multaServ.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody MultaDto objDto, @PathVariable Integer id) {
		
		Multa obj= multaServ.fromDto(objDto);
		obj.setId(id);
		obj= multaServ.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id) {
		
		multaServ.delete(id);
		return ResponseEntity.noContent().build();
	}
	public ResponseEntity<Void> delete(@RequestBody Multa obj, @PathVariable Integer id) {
		multaServ.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MultaDto>> findAll() {
		
		List<Multa> list= multaServ.findAll();
		List<MultaDto> listDto= list.stream().map(obj->new MultaDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
