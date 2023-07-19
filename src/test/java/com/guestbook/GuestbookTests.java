package com.guestbook;

import com.guestbook.dto.GuestbookDTO;
import com.guestbook.entiry.Guestbook;
import com.guestbook.repository.GuestbookRepository;
import com.guestbook.service.GuestbookService;
import com.guestbook.service.GuestbookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.h2.util.IntArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
//@RequiredArgsConstructor // final 쓰려면 넣어줘야함.
public class GuestbookTests {

    @Autowired
    GuestbookService service;

    @Autowired
    GuestbookRepository repo;

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

    @Test
    public void inputData() {
        String []title = {"날씨", "전달", "spring", "jpa"};
        String []content = {"날씨 좋습니다.", "전달사항 없음요", "spring 교육 어떤가요?", "jap 어렵네요"};
        String []writer = {"kang", "park", "lee", "oh"};

        for (int i = 0; i < 100; i++) {
            Guestbook guestbook = Guestbook.builder()
                    .title(title[i%3])
                    .content(content[i%3])
                    .writer(writer[i%3])
                    .build();
            System.out.println(repo.save(guestbook));
        }
    }


}
