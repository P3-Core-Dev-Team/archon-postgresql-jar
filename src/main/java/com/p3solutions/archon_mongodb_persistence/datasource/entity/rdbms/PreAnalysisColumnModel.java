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
@Table(name = "preanalysis_column")
public class PreAnalysisColumnModel extends BaseModel {
    @Column(columnDefinition = "jsonb",name = "preanalysiscolumn_data")
    private String PreAnalysisColumnData;
}
