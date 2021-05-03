package cm.belrose.stockserveur.dto;

import cm.belrose.stockserveur.model.Roles;
import cm.belrose.stockserveur.model.RoleEnum;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RolesDto {
    private Long id;
    private RoleEnum name;

    public static RolesDto fromEntity(Roles entity){
        if(entity==null){
            return null;
        }
        return RolesDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();

    }
    public static Roles toEntity(RolesDto dto){
        if(dto==null){
            return null;
        }
        Roles roles =new Roles();
        roles.setId(dto.getId());
        roles.setName(dto.getName());
        return roles;

    }
}
