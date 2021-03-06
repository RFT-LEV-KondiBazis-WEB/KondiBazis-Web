package hu.unideb.fitbase.service.api.converter;

import hu.unideb.fitbase.commons.pojo.enumeration.UserRole;
import hu.unideb.fitbase.persistence.entity.UserEntity;
import hu.unideb.fitbase.persistence.entity.UserRoleEntity;
import hu.unideb.fitbase.service.api.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserEntityConverter implements Converter<User, UserEntity> {

    @Override
    public UserEntity convert(User source) {
        return UserEntity.builder()
                .id(source.getId())
                .username(source.getUsername())
                .email(source.getEmail())
                .password(source.getPassword())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .createdDate(source.getCreatedDate())
                .userRoleEntity(convertRole(source.getUserRole()))
                .build();
    }

    private UserRoleEntity convertRole(UserRole role) {
        return UserRoleEntity.valueOf(role.toString());
    }

}
