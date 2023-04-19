package jojo.shop.object.Object;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long objectId;

    @Column
    private String name;

    @Column
    private int ea;

    @Column
    private String category;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime modifiedAt;
}
