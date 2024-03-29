package com.ctu.Library.PhieuTra.DTO;

import com.ctu.Library.Librarian.Librarian;
import com.ctu.Library.PhieuMuonDetail.PhieuMuonDetail;
import com.ctu.Library.PhieuTraDetail.PhieuTraDetail;
import com.ctu.Library.Reader.Reader;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class PhieuTraDTO {
    private Date ngayTra;
    private String note = "";
    private Librarian librarian;
    private Reader reader;
    private Set<PhieuTraDetail> chitiets;
    private boolean isChecked = false;
}
