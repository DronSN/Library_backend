package ru.relex.library.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.library.db.mappers.PlanMapper;
import ru.relex.library.services.dto.user.PlanDto;
import ru.relex.library.services.mapstruct.PlanStruct;
import ru.relex.library.services.service.IPlanService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class PlanServiceImpl implements IPlanService{

    private final PlanMapper planMapper;
    private final PlanStruct planStruct;

    @Autowired
    public PlanServiceImpl(PlanMapper planMapper, PlanStruct planStruct) {
        this.planMapper = planMapper;
        this.planStruct = planStruct;
    }

    @Override
    public List<PlanDto> findPlans(final String search) {
        var plans = planMapper.getPlans(search);
        return planStruct.toDto(plans);
    }

    @Override
    public PlanDto findById(int id) {
        var plan = planMapper.findById(id);
        return planStruct.toDto(plan);
    }

    @Override
    public PlanDto create(@Valid final PlanDto planDto) {
        var plan = planStruct.fromDto(planDto);
        planMapper.insert(plan);
        return planStruct.toDto(plan);
    }

    @Override
    public PlanDto update(@Valid final PlanDto planDto) {
        var plan = planStruct.fromDto(planDto);
        planMapper.update(plan);
        return planStruct.toDto(plan);
    }

    @Override
    public void remove(final int planId) {
        planMapper.delete(planId);
    }
}
