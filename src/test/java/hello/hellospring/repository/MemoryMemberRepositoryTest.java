package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach  // 특정 동작이 완료될 때 마다 아래의 명령이 시행되도록 해줌
    public void afterEach(){
        repository.clearStore();
    }
    // 이를 통해서 전체적인 테스트를 진행할 때도 오류가 발생하지 않음



    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result  =repository.findById(member.getId()).get();


        //Assertions.assertEquals(member, result);
        //Assertions.assertEquals(member, null);

        //결과값이 참일 경우, 아무것도 뜨지 않고 초록색 체크만 뜸
        //결과값이 거짓일 경우, 실행 오류가 발생

        assertThat(member).isEqualTo(result);
        //결과값은 위의 Assertion.asserEquals(member, result)와 같음
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);


        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }


}
