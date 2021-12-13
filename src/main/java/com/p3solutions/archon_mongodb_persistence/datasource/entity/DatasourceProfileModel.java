package com.p3solutions.archon_mongodb_persistence.datasource.entity;

import com.p3solutions.archon_mongodb_persistence.common_beans.BaseModel;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author gobi
 */@Data
@Entity
@Table(name = "datasource_profile")
public class DatasourceProfileModel extends BaseModel {
    @Column(columnDefinition = "jsonb",name = "datasourceprofile_data")
    private String datasourceProfileData;
}
