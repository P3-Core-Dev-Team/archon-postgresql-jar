package com.p3solutions.archon_mongodb_persistence.mapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.p3solutions.common_beans_dto.global_groups_roles.mapper_beans.GlobalGroupMapperBean;
import com.p3solutions.common_beans_dto.global_groups_roles.mapper_beans.GlobalRoleMapperBean;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserModelMapperBean  {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String modifiedBy;
    @JsonIgnore
    private String password;
    private List<GlobalGroupMapperBean> globalGroups;
    private List<GlobalRoleMapperBean> globalRoles;
    private String businessJustification;
    private Boolean accessRevoked;
    private long lockedDuration;
    private Boolean accountLocked;
    private Integer attemptCount;
    @Builder.Default
    private String type = "ARCHON_DATABASE";
    @JsonIgnore
    private ArrayList<String> oldPasswords;
}
