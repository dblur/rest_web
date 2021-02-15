package org.dblur.JarSoftTest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "banner_id", referencedColumnName = "id")
    private Banner banner;

    @Column(name = "user_agent")
    private String user_agent;

    @Column(name = "ip_address")
    private String ip_address;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
}
