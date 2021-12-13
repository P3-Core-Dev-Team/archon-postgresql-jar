package com.p3solutions.archon_mongodb_persistence.datasource.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.p3solutions.common_beans_dto.datasource.enums.FileFormat;
import com.p3solutions.common_beans_dto.datasource.enums.FileConnectionType;
import com.p3solutions.common_beans_dto.datasource.enums.GlobaDateFormat;
import com.p3solutions.common_beans_dto.datasource.enums.GlobalDateTimeFormat;
import com.p3solutions.common_beans_dto.datasource.mapper_beans.ConnectionCredentialsMapperBean;
import com.p3solutions.common_beans_dto.datasource.mapper_beans.KERBROSEConnectionCredentialsMapperBean;
import lombok.*;


/**
 * Created by syedsirajuddin..❤
 * on 14/09/20 12:36 PM
 **/
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class FlatFileConnectionInfoModel {
    private FileFormat fileFormat;
    private Boolean isHeaderAvailable;
    private Boolean isDelimited = true;
    private String delimiter;
    private FileConnectionType connectionType;
    private String host;
    private Integer port = 21;
    private String filePath;
    private GlobaDateFormat dateFormat;
    private GlobalDateTimeFormat timeFormat;
    private Boolean isMetaInfoAvaiable = false;
    @JsonProperty(required = false)
    private String metadataFilePath;
    private Boolean restrictMetaDataMode = false;
    @JsonProperty(required = false)
    private ConnectionCredentialsMapperBean ConnectionCredentials;
    @JsonProperty(required = false)
    private KERBROSEConnectionCredentialsMapperBean kerberosConnectionCredentials;
    private String connectionUrl;
    private Boolean ignoreQuotations; //newly added
    private char quoteCharacter; //newly added
//    private Charset encoding = StandardCharsets.UTF_8;
//    private EncodingString encoding = StandardCharsets.UTF_8;
}
