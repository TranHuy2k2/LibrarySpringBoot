package com.ctu.Library.BookItem.DTO;

import com.ctu.Library.Book.Book;
import com.ctu.Library.Enum.TinhTrang;
import com.ctu.Library.Reader.Reader;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class AddBookItemDTO {
    private Boolean trangThai;
    private Integer soLanMuon;
    @Enumerated(EnumType.STRING)
    private TinhTrang tinhTrang;
    private Reader reader;
    private Date hanTra;
    private Long bookId;
}
