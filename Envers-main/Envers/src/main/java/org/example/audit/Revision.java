package org.example.audit;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.config.CustomRevisionListener;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

@RevisionEntity(CustomRevisionListener.class)
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "REVISION_INFO")
public class Revision implements Serializable {
    private static final long serialVersionID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revision_seq")
    @SequenceGenerator(name = "revision_seq", sequenceName = "revision_sequence", allocationSize = 1)
    @RevisionNumber
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @RevisionTimestamp
    @Column(name = "REVISION_DATE")
    private Date date;
}
