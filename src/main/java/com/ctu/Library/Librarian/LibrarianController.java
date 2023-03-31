package com.ctu.Library.Librarian;


import com.ctu.Library.Librarian.DTO.LibrarianDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/librarian")
@RequiredArgsConstructor
public class LibrarianController {
    private final LibrarianService librarianService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LibrarianDTO> getAllLibrarians(){
        return librarianService.getAllLibrarians();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LibrarianDTO addLibrarian(@RequestBody Librarian librarian){
        return librarianService.addLibrarian(librarian);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LibrarianDTO updateLibrarian(@PathVariable Long id, @RequestBody Librarian newLibrarian){
        return librarianService.updateLibrarian(id, newLibrarian);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LibrarianDTO deleteLibrarian(@PathVariable Long id) {
        return librarianService.deleteLibrarian(id);
    }
}