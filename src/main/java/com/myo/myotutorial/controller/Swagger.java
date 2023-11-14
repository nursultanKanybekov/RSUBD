package com.myo.myotutorial.controller;

import com.myo.myotutorial.repo.RepoGetValues;
import com.myo.myotutorial.model.GetValues;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Swagger {
    @Autowired
    private RepoGetValues repoGetValues;

    @GetMapping("/get")
//    @ApiOperation(value = "Get a greeting message", response = String.class)

    public String value() {
        return "nursKanyb";
    }

    @PostMapping("/nurs")
    @Operation(summary = "Create a new resource")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Resource created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<String> myPostEndpoint(@RequestParam String request, @RequestParam String surname) {
        // Access request properties like request.getName() and request.getAge()
        // Process the request and return a response
        repoGetValues.save(new GetValues(request, surname));
        return ResponseEntity.ok("Received: " + request/*.getName() + ", " + request.getSurname()*/);
    }

    @GetMapping("/getName")
    @Operation(summary = "get by SQL code")
    public List<GetValues> name(@RequestParam String name) {
        return repoGetValues.findByName(name);
    }

    @GetMapping("/getSurname")
    @Operation(summary = "get by SQL code")
    public List<GetValues> surname(@RequestParam String surname) {
        return repoGetValues.findByYourColumn(surname);
    }
}
