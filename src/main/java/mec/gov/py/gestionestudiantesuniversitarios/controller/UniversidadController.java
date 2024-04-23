package mec.gov.py.gestionestudiantesuniversitarios.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mec.gov.py.gestionestudiantesuniversitarios.dto.exception.RequestExceptionDTO;
import mec.gov.py.gestionestudiantesuniversitarios.entity.Universidad;
import mec.gov.py.gestionestudiantesuniversitarios.service.UniversidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.url}"+"${api.universidad.url}")
@RequiredArgsConstructor
public class UniversidadController {

    private final UniversidadService universidadService;

    /**
     * Agregar nueva universidad
     */
    @ResponseBody
    @PostMapping()
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "Algún campo está mal proveído. Se listarán esos campos",
            content = @Content(schema = @Schema(implementation = RequestExceptionDTO.class))
    )
    public Universidad savePersona(@RequestBody @Valid Universidad universidad) {
        return universidadService.save(universidad);
    }

    /**
     * Listar todas las personas
     */
    @ResponseBody
    @GetMapping()
    public List<Universidad> getAllPersonas() {
        return universidadService.fetchAll();
    }

    /**
     * Actualizar universidad
     */
    @ResponseBody
    @PutMapping("/{identificador}")
    public Universidad updatePersona(@PathVariable(value = "identificador") Long identificador, @RequestBody Universidad universidad) {
        return universidadService.update(identificador, universidad);
    }

    /**
     * Eliminar universidad
     */
    @DeleteMapping( "/{identificador}")
    public ResponseEntity<String> deletePersona(@PathVariable(value = "identificador") Long identificador) {
        return universidadService.delete(identificador);
    }

    /**
     * Obtener universidad por identificador
     */
    @GetMapping("/{identificador}")
    public Universidad getPersonaByCedula(@PathVariable(value = "identificador") Long identificador){
        return universidadService.getById(identificador);
    }

}