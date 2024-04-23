package mec.gov.py.gestionestudiantesuniversitarios.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mec.gov.py.gestionestudiantesuniversitarios.dto.exception.RequestExceptionDTO;
import mec.gov.py.gestionestudiantesuniversitarios.entity.Persona;
import mec.gov.py.gestionestudiantesuniversitarios.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.url}"+"${api.persona.url}")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    /**
     * Agregar nueva persona
     */
    @ResponseBody
    @PostMapping()
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "Algún campo está mal proveído. Se listarán esos campos",
            content = @Content(schema = @Schema(implementation = RequestExceptionDTO.class))
    )
    public Persona savePersona(@RequestBody @Valid Persona persona) {
        return personaService.save(persona);
    }

    /**
     * Listar todas las personas
     */
    @ResponseBody
    @GetMapping()
    public List<Persona> getAllPersonas() {
        return personaService.fetchAll();
    }

    /**
     * Actualizar persona
     */
    @ResponseBody
    @PutMapping("/{cedula}")
    public Persona updatePersona(@PathVariable(value = "cedula") Long cedula, @RequestBody Persona persona) {
        return personaService.update(cedula, persona);
    }

    /**
     * Eliminar persona
     */
    @DeleteMapping("/{cedula}")
    public ResponseEntity<String> deletePersona(@PathVariable(value = "cedula") Long cedula) {
        return personaService.delete(cedula);
    }

    /**
     * Obtener persona por cedula
     */
    @GetMapping("/{cedula}")
    public Persona getPersonaByCedula(@PathVariable(value = "cedula") Long cedula){
        return personaService.getByCedula(cedula);
    }

}