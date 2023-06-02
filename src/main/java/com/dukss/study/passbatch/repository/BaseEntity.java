package com.dukss.study.passbatch.repository;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass // 상송받으면 인식하게끔
@EntityListeners(AuditingEntityListener.class)
// 하이버네이트에서는, jpa entity에 이벤트가 발생시 콜백 처리하고 코드를 실행하는 방법
// 인자로 커스텀 콜백 클래스를 넘겨주면 된다.
// 현재는 auditing 을 사용하므로 AuditingEntityListener를 넘겨준다.
public abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @LastModifiedBy
    private LocalDateTime modifiedAt;

}
