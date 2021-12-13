package com.p3solutions.archon_mongodb_persistence.datasource.entity.rdbms;

import com.p3solutions.archon_mongodb_persistence.common_beans.BaseModel;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author gobi
 **/
@Data
@Entity
@Table(name = "preanalysis_relations")
public class PreAnalysisRelationModel extends BaseModel {
    @Column(columnDefinition = "jsonb",name = "preanalysisrelation_data")
    private String PreAnalysisRelationData;
}
