package com.ctu.Library.User;


import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.User.DTO.UserListResponseDTO;
import com.ctu.Library.User.Mapper.UserListResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserListResponseMapper userListResponseMapper;
    Page<UserListResponseDTO> getAll(String name, Integer pageNo, Integer pageSize, String sortBy, Boolean reverse){
       if (Objects.equals(name, "")){
           Pageable pageAndSortingRequest = PageRequest.of(pageNo, pageSize, Sort.by(reverse? Sort.Direction.DESC : Sort.Direction. ASC, sortBy));
           Page<User> pageUser = userRepository.findAll(pageAndSortingRequest);
           return pageUser.map(userListResponseMapper::modelToDTO);
       }
        Pageable pageAndSortingRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        Page<User> pageUser = userRepository.findByNameContaining(name, pageAndSortingRequest);
        return pageUser.map(userListResponseMapper::modelToDTO);
    }
    UserListResponseDTO delete(Long id){
        User currentUser = userRepository.findById(id).orElseThrow(
                () -> new CustomException("Không tìm thấy user với mã " + id, HttpStatus.NOT_FOUND)
        );
        userRepository.delete(currentUser);
        return userListResponseMapper.modelToDTO(currentUser);
    }
    UserListResponseDTO update(Long id, User newUser){
        User currentUser = userRepository.findById(id).orElseThrow(
                () -> new CustomException("Không tìm thấy user với mã " + id, HttpStatus.NOT_FOUND)
        );
        currentUser.setRole(newUser.getRole());
        currentUser.setName(newUser.getName());
        currentUser.setPhone(newUser.getPhone());
        currentUser.setGender(newUser.getGender());
        currentUser.setEmail(newUser.getEmail());
        userRepository.save(currentUser);
        return userListResponseMapper.modelToDTO(currentUser);
    }
}
