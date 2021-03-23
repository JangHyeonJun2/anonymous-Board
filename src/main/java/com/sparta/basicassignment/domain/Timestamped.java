package com.sparta.basicassignment.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass // 상속했을 때, 컬럼으로 인식하게 합니다. 즉 이 timestamped 추상클래스를 상속한 클래스가 자동으로 생성시간과 수정 시간을 컬럼으로 잡도록 도와주는 녀석이다.
@EntityListeners(AuditingEntityListener.class) // 생성/수정 시간을 자동으로 반영하도록 설정. memo class가 변화하는 거를 항상 이렇게 듣는다. 생성시간과 수정시간이 변화가 있으면 자동으로 업데이트 해주겠다는 뜻.
public abstract class Timestamped {

    @CreatedDate // 생성일자임을 나타냅니다.
    private LocalDateTime createdAt;

    @LastModifiedDate // 마지막 수정일자임을 나타냅니다.
    private LocalDateTime modifiedAt;


}