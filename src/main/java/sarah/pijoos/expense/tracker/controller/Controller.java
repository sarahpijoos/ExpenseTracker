package sarah.pijoos.expense.tracker.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sarah.pijoos.expense.tracker.dtos.HelloDTO;

@RestController
public class Controller {

    @Operation(summary = "Greeting test endpoint", description = "Returns a greeting with the entered name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully executed"),
    })
    @GetMapping(value = "/hello/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HelloDTO> hello(@PathVariable String name) {
        HelloDTO response = new HelloDTO();
        response.setName(name);
        return ResponseEntity.ok(response);
    }
}
