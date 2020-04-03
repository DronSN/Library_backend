package ru.relex.library.services.mapstruct;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.library.db.mappers.BookMapper;
import ru.relex.library.db.mappers.UserMapper;
import ru.relex.library.db.model.Plan;
import ru.relex.library.services.dto.user.PlanDto;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PlanStruct {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookStruct bookStruct;

    @Autowired
    private UserStruct userStruct;

    @AfterMapping
    protected void updateBook(Plan plan, @MappingTarget PlanDto planDto) {
        planDto.setBookDto(
                bookStruct.toDto(
                        bookMapper.findById(plan.getBooksId())));
    }

    @AfterMapping
    protected void updateUser(Plan plan, @MappingTarget PlanDto planDto) {
        planDto.setUserDto(
                userStruct.toDto(
                        userMapper.findById(plan.getUserId())));
    }


    public abstract PlanDto toDto(Plan plan);

    public abstract Plan fromDto(PlanDto planDto);

    public abstract List<PlanDto> toDto(List<Plan> plans);

    public abstract List<Plan> fromDto(List<PlanDto> planDtos);
}
