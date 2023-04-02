package com.ctu.Library.Librarian.DTO;

import com.ctu.Library.User.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class LibrarianDTO {
    private Long id;
    private String name;
    private Date dob;
    private String contact;
    private User user;
}
