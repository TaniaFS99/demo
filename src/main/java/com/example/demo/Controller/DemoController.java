package com.example.demo.Controller;

import com.example.demo.Services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api")
public class DemoController {

    @Autowired
    public DemoService demoService;

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity handleMissingParam(MissingServletRequestParameterException e) {
        String name = e.getParameterName();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ codigo:g268, error: Parámetros inválidos }");
    }

    @GetMapping(value = "/consulta", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity retornaConsulta(
            @RequestParam(value = "q") String q
    ) {

        if (q.isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ codigo:g268, error: Parámetros inválidos }");
        }
        else{
            try {
                return ResponseEntity.status(HttpStatus.OK).body(demoService.retornaConsulta(q));
            }
            catch (Error e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ codigo: g267, error: No se encuentran noticias para el texto: " + q + " }");
            }
            catch (Exception e) {
                System.out.println(e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{ codigo: g100, error: Error interno del servidor }");

            }
        }
    }

}
