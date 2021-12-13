package com.p3solutions.archon_mongodb_persistence.user.entity;
import com.p3solutions.archon_mongodb_persistence.common_beans.BaseModel;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User Details for all users
 *
 * @author gobi
 */
@Table(name = "users")
@Entity
@Data
public class UserModel extends BaseModel {
    private String userData;

}
