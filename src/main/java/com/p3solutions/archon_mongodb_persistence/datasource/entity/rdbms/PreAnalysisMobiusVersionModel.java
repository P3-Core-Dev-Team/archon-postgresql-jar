package com.p3solutions.archon_mongodb_persistence.datasource.entity.rdbms;

import com.p3solutions.archon_mongodb_persistence.common_beans.BaseModel;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by gobi
 */
@Data
@Entity
@Table(name = "preanalysis_mobius_version")
public class PreAnalysisMobiusVersionModel extends BaseModel {
    @Column(columnDefinition = "jsonb",name = "preanalysismobiusversion_data")
    private String PreAnalysisMobiusVersionData;

}
