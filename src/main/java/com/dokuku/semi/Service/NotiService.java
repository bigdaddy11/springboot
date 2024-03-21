package com.dokuku.semi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dokuku.semi.Entity.NotiEntity;
import com.dokuku.semi.Repository.NotiRepository;

@Service
public class NotiService {
    @Autowired(required = true)
    private NotiRepository NotiRepository;

    public List<NotiEntity> findAll() {
        List<NotiEntity> Notis = new ArrayList<>();
        NotiRepository.findAll().forEach(e -> Notis.add(e));
        return Notis;
    }

    // public List<NotiEntity> findByuserId(Long id) {
    //     List<NotiEntity> Noti = NotiRepository.findByuserId(id);
    //     return Noti;
    // }

    public void deleteById(Long id) {
        NotiRepository.deleteById(id);
    }

    public NotiEntity save(NotiEntity Noti) {
        NotiRepository.save(Noti);
        return Noti;
    }

    public void updateById(Long id, NotiEntity Noti) {
        Optional<NotiEntity> e = NotiRepository.findById(id);

        if (e.isPresent()) {
            //e.get().setId(Noti.toString());
            NotiRepository.save(Noti);
        }
    }
}


