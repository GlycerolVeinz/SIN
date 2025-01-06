package priv.sin.librarylabsproject.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import priv.sin.librarylabsproject.dto.AuthorResponse;
import priv.sin.librarylabsproject.model.Author;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "surname", target = "surname")
    AuthorResponse toDTO(Author author);
}

// This type of class is just a "decorative" way instead of POJO
// to map the fields of the Author class to the AuthorResponse class.