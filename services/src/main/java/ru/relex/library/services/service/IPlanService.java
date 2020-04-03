package ru.relex.library.services.service;

import ru.relex.library.services.dto.user.PlanDto;

import javax.validation.Valid;
import java.util.List;

public interface IPlanService {

    List<PlanDto> findPlans(String search);

    PlanDto findById(int id);

    PlanDto create(@Valid PlanDto planDto);

    PlanDto update(@Valid PlanDto planDto);

    void remove(int planId);
}
