package com.fsofter.home.service;




import java.util.List;
import java.util.Optional;


public class UserService {
//
//    @Autowired
//    UserRepository userRepository ;
//
//    public List<User> getAll(){
//        List<User> results = userRepository.findAll();
//        return results;
//    }
//
//    public Page<User> searchUsers(String keyword, int page, int size) {
//        if (keyword == null || keyword.isEmpty()) {
//            return userRepository.findAll(PageRequest.of(page, size));
//        }
//        return userRepository.findByEmailContainingOrFirstNameContainingOrLastNameContaining(
//                keyword, keyword, keyword, PageRequest.of(page, size));
//    }
//
//    public User getUserById(Integer id) throws UserNotFoundException {
//        Optional<User> result = userRepository.findById(id);
//        if(result.isPresent()){
//            return result.get();
//        }
//        throw new UserNotFoundException("Could not find any users with id: "+id);
//    }
//
//    public void saveUser(@Valid User user){
//        userRepository.save(user);
//    }
//    public void updateUser(User user) throws UserNotFoundException {
//        User existingUser = getUserById(user.getId());
//        existingUser.setEmail(user.getEmail());
//        existingUser.setFirstName(user.getFirstName());
//        existingUser.setLastName(user.getLastName());
//        existingUser.setPassword(user.getPassword());
//        existingUser.setEnabled(user.isEnabled());
//
//        userRepository.save(existingUser);
//    }
//
//    public void deleteUser(Integer id) throws UserNotFoundException {
//        if (!userRepository.existsById(id)) {
//            throw new UserNotFoundException("Could not find any users with id: "+id);
//        }
//        userRepository.deleteById(id);
//    }

}
