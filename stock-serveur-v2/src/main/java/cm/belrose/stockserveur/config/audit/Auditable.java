package cm.belrose.stockserveur.config.audit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Ngnawen Samuel
 * @since 17/11/2020 18:20
 *
 * In this we use Spring Data JPA approch audit. It is read for integration with spring security
 * by the delete operation can not be audit
 * This is the Generic class which will be extends by all audited entities. She contain all the audited properties
 * @param
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {
    @CreatedBy
    @Column(name = "created_by",nullable = false,updatable = false) //update=false specifie à spring que ce champ ne doit pas etre mis à jour
    protected U createdBy;
    @LastModifiedBy
    @Column(name = "update_by")
    protected U updatedBy;
    @CreatedDate
    @Column(name = "create_date", nullable = false,updatable = false)
    protected LocalDateTime createdDate;
    @LastModifiedDate
    @Column(name = "update_date")
    protected  LocalDateTime updateDate;
}
