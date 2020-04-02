package ru.relex.library.services.mapstruct;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.library.db.mappers.BookMapper;
import ru.relex.library.db.mappers.UserMapper;
import ru.relex.library.db.model.Progress;
import ru.relex.library.services.dto.user.ProgressDto;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProgressStruct {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookStruct bookStruct;

    @Autowired
    private UserStruct userStruct;

    @AfterMapping
    protected void updateBook(Progress progress, @MappingTarget ProgressDto progressDto) {
        progressDto.setBookDto(
                bookStruct.toDto(
                        bookMapper.findById(progress.getBooksId())));
    }

    @AfterMapping
    protected void updateUser(Progress progress, @MappingTarget ProgressDto progressDto) {
        progressDto.setUserDto(
                userStruct.toDto(
                        userMapper.findById(progress.getUserId())));
    }


    public abstract ProgressDto toDto(Progress progress);

    public abstract Progress fromDto(ProgressDto progressDto);

    public abstract List<ProgressDto> toDto(List<Progress> progresses);

    public abstract List<Progress> fromDto(List<ProgressDto> progressDtos);
}
