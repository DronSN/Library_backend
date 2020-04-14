package ru.relex.library.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.library.services.dto.user.PlanDto;
import ru.relex.library.services.service.IPlanService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(
        path = "/api/plans",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class PlanController {

    private final IPlanService planService;

    @Autowired
    public PlanController(IPlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    List<PlanDto> getPlans(@RequestParam(name = "search", required = false) String search) {
        return planService.findPlans(search);
    }

    @GetMapping("/{id}")
    PlanDto findById(@PathVariable("id") int id) {
        return planService.findById(id);
    }

    @PutMapping("/{id}")
    @RolesAllowed("ROLE_USER")
    PlanDto update(@PathVariable("id") int id, @RequestBody PlanDto planDto) {
        planDto.setId(id);
        return planService.update(planDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed("ROLE_USER")
    PlanDto create(@RequestBody PlanDto planDto) {
        return planService.create(planDto);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("ROLE_USER")
    void delete(@PathVariable("id") int id){
        planService.remove(id);
    }
}
