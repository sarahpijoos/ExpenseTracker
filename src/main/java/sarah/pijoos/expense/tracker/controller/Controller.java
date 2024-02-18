package sarah.pijoos.expense.tracker.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sarah.pijoos.expense.tracker.dtos.HelloDto;

/**
 * This is controller is responsible for testing the endpoint connection during the initial project
 * set up.
 */
@RestController
public class Controller {

  /**
   * Sends a greeting response with the entered name.
   *
   * @param name The name you want to include in the greeting.
   * @return ResponseEntity with the greeting with the specified name.
   */
  @Operation(
      summary = "Greeting test endpoint",
      description = "Returns a greeting with the entered name")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Successfully executed"),
      })
  @GetMapping(value = "/v1/hello/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HelloDto> hello(@PathVariable String name) {
    HelloDto response = new HelloDto();
    response.setName(name);
    return ResponseEntity.ok(response);
  }
}
