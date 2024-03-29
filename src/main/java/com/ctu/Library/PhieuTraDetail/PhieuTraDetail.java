package com.ctu.Library.PhieuTraDetail;

import com.ctu.Library.BookItem.BookItem;
import com.ctu.Library.Enum.TinhTrang;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PhieuTraDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TinhTrang tinhTrang;
    @ManyToOne
    private BookItem bookItem;
}
