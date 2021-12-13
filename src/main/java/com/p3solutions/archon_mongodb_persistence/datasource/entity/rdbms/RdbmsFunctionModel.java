package com.p3solutions.archon_mongodb_persistence.datasource.entity.rdbms;

import com.p3solutions.archon_mongodb_persistence.common_beans.BaseModel;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Created by gobi
 **/
@Data
@Entity
@Table(name = "rdbms_functions")
public class RdbmsFunctionModel extends BaseModel {
    @Column(columnDefinition = "jsonb",name = "rdbmsfunction_data")
    private String rdbmsFunctionData ;
}
