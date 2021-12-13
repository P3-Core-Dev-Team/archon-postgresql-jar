package com.p3solutions.archon_mongodb_persistence.datasource.entity;

import com.p3solutions.archon_mongodb_persistence.common_beans.BaseModel;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "datasource_profile_access")
public class DatasourceProfileAccessModel extends BaseModel {
    @Column(columnDefinition = "jsonb",name = "datasourceprofileaccess_data")
    private String datasourceProfileAccessData;
}

