package io.maxiplux.spa.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "POST")
@Data

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "POST_COMMENTS", joinColumns = @JoinColumn(name = "POST_ID"),
            inverseJoinColumns = @JoinColumn(name = "COMMENT_ID")
            , uniqueConstraints = {@UniqueConstraint(columnNames = {"POST_ID", "COMMENT_ID"})}
    )
    private List<Comments> comments;
 }
