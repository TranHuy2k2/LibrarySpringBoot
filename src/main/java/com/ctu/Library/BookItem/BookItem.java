package com.ctu.Library.BookItem;

import com.ctu.Library.Book.Book;
import com.ctu.Library.Enum.TinhTrang;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name="bookItem")
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = "book")
@ToString(exclude = "book")
public class BookItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean trangThai;

    @Column(nullable = false)
    private Integer soLanMuon;

    @Enumerated(EnumType.STRING)
    private TinhTrang tinhTrang;

}