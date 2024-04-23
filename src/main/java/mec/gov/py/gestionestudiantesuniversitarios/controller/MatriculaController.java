package mec.gov.py.gestionestudiantesuniversitarios.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mec.gov.py.gestionestudiantesuniversitarios.dto.exception.RequestExceptionDTO;
import mec.gov.py.gestionestudiantesuniversitarios.entity.Matricula;
import mec.gov.py.gestionestudiantesuniversitarios.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.url}" + "${api.matricula.url}")
@RequiredArgsConstructor
public class MatriculaController {

    private final MatriculaService matriculaService;

    /**
     * Agregar nuevo
     */
    @ResponseBody
    @PostMapping()
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "Algún campo está mal proveído. Se listarán esos campos",
            content = @Content(schema = @Schema(implementation = RequestExceptionDTO.class))
    )
    public Matricula save(@RequestBody @Valid Matricula matricula) {
        return matriculaService.save(matricula);
    }

    /**
     * Listar
     */
    @ResponseBody
    @GetMapping()
    public List<Matricula> getAll(
            @RequestParam(required = false) Long persona,
            @RequestParam(required = false) Long universidad ) {

        // devolver dependiendo de si hay query params especificados
        if(persona != null && universidad != null){
            return matriculaService.findByPersonaAndUniversidad(persona, universidad);
        } else if (persona != null) {
            return matriculaService.findByPersona(persona);
        } else if (universidad != null) {
            return matriculaService.findByUniversidad(universidad);
        }

        // devolver all
        return matriculaService.fetchAll();
    }

    /**
     * Actualizar
     */
    @ResponseBody
    @PutMapping(path = "/{id}")
    public Matricula update(
            @PathVariable(value = "id") Long id,
            @RequestBody Matricula matricula
    ) {
        return matriculaService.update(id, matricula);
    }

    /**
     * Eliminar
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(
            @PathVariable(value = "id") Long id
    ) {
        return matriculaService.delete(id);
    }

    /**
     * Obtener por Id
     */
    @GetMapping("/{id}")
    public Matricula getById(
            @PathVariable(value = "id") Long id
    ){
        return matriculaService.getById(id);
    }

}