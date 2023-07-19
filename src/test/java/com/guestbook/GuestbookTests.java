package com.guestbook;

import com.guestbook.dto.GuestbookDTO;
import com.guestbook.entiry.Guestbook;
import com.guestbook.repository.GuestbookRepository;
import com.guestbook.service.GuestbookService;
import com.guestbook.service.GuestbookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
@RequiredArgsConstructor // final 쓰려면 넣어줘야함.
public class GuestbookTests {

    @Autowired
    private final GuestbookService service;

    //@Autowired
    private final GuestbookRepository repo;

    @Test
    public void registTest() {

        for (int i = 0; i < 100; i++) {

            GuestbookDTO dto = GuestbookDTO.builder()
                    .title("title " + i)
                    .writer("writer " + i)
                    .content("content " + i)
                    .build();
            System.out.println(dto.getGno());
            service.register(dto);

            /*
            Guestbook entity = Guestbook.builder()
                    .title("title " + i)
                    .writer("writer " + i)
                    .content("content " + i)
                    .build();
            repo.save(entity);
            */
        }
    }


}
