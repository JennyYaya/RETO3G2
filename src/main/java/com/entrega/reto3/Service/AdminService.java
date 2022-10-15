package com.entrega.reto3.Service;



import com.entrega.reto3.Model.Admin;
import com.entrega.reto3.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return (List<Admin>) adminRepository.getAll();
    }
    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin()==null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> adminEncontrado = getAdmin(admin.getIdAdmin());
            if(adminEncontrado.isPresent()){
                return admin;
            } else {
                return adminRepository.save(admin);
            }
        }

    }

    public Admin update(Admin admin) {
        if (admin.getIdAdmin()!=null) {
            Optional<Admin> adminEncontrado = adminRepository.getAdmin(admin.getIdAdmin());
            if (adminEncontrado.isPresent()) {
                if (admin.getPassword() != null) {
                    adminEncontrado.get().setPassword(admin.getPassword());
                }
                if (admin.getName() != null) {
                    adminEncontrado.get().setName(admin.getName());
                }
                adminRepository.save(adminEncontrado.get());
                return adminEncontrado.get();
            } else {
                return admin;
            }
        }else {
            return admin;

        }
    }

    public boolean delete(int id) {
        boolean respuesta = false;
        Optional<Admin> adminEncontrado = adminRepository.getAdmin(id);
        if (adminEncontrado.isPresent()){
            adminRepository.delete(adminEncontrado.get());
    }
        return respuesta;

}
}

